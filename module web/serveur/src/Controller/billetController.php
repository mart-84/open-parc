<?php

namespace App\Controller;

use App\Entity\Billet;
use App\Entity\Matchs;
use App\Entity\Jouer;
use App\Entity\Joueur;
use App\Repository\BilletRepository;
use App\Repository\MatchsRepository;
use App\Repository\JouerRepository;
use App\Repository\JoueurRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class billetController extends AbstractController
{
    public function decreaseQuantity(ManagerRegistry $doctrine, int $billetId) : Response
    {
        /** @var BilletRepository $billetRepository */
        $billetRepository=$doctrine->getRepository(Billet::class);
        $billet=$billetRepository->findByJourCourt($billetId);
        
        $billet[0]->setQuantite($billet[0]->getQuantite()-1);
        $entityManager = $doctrine->getManager();
        $entityManager->persist($billet[0]);
        $entityManager->flush();

        return new Response("Done");
    }

    public function getById(ManagerRegistry $doctrine, int $billetId) : Response
    {
        /** @var JouerRepository $jouerRepository */
        $jouerRepository=$doctrine->getRepository(Jouer::class);
        
        /** @var JoueurRepository $joueurRepository */
        $joueurRepository=$doctrine->getRepository(Joueur::class);
        
        /** @var BilletRepository $billetRepository */
        $billetRepository=$doctrine->getRepository(Billet::class);
        $billet=$billetRepository->findById($billetId);
        
        /** @var MatchsRepository $matchRepository */
        $matchRepository=$doctrine->getRepository(Matchs::class);
        $day=$billet[0]->getJourId();
        $court=$billet[0]->getCourtId();
        $matchs=$matchRepository->findByDayCourt($day,$court);
        $liste_matchs=[];
        $i=0;
        foreach($matchs as $match){
            $liste_matchs[$i]=[
                'matchid'=>(int)$match->getMatchId(),
                'matchtype'=>(int)$match->getTypetournoiid(),
                'matchcourtid'=>(int)$match->getCourtId(),
                'matchtrancheid'=>(int)$match->getTrancheid(),
                'matchcourt'=>(string)'',
                'joueursId'=>[],
                'joueursNoms'=>[],
            ];
            $i++;
        }
        
        $liste_matchs2=[];
        foreach($liste_matchs as $un_match){
            $jouers=$jouerRepository->findByMatch($un_match['matchid']);
            foreach($jouers as $jouer){
                $id=$jouer->getJoueurId();
                $un_match['joueursId'][]=$id;
            }
            $liste_matchs2[]=$un_match;
        }

        $liste_matchs3=[];
        foreach($liste_matchs2 as $un_match){
            foreach($un_match['joueursId'] as $un_jId){
                // var_dump($un_jId);die;
                if($un_jId==NULL){
                    $un_match['joueursNoms'][]='indefini';
                }else {
                    $joueur=$joueurRepository->find($un_jId);                
                    $nom=$joueur->getNomjoueur();
                    $un_match['joueursNoms'][]=$nom;
                }
            }
            $liste_matchs3[]=$un_match;
        }
        
        $le_billet[]=['billet'=>$billet[0],'matchs'=>$liste_matchs3fix];
        $rows=[];
        foreach($le_billet as $un_billet) {
            $rows[] = [
                'billetid' => (int)$un_billet['billet']->getBilletId(),
                'jouriD' => (int)$un_billet['billet']->getJourId(),
                'courtid' => (int)$un_billet['billet']->getCourtId(),
                'prix' => (int)$un_billet['billet']->getPrix(),
                'place' => (int)$un_billet['billet']->getPlace(),
                'liste_match' => $un_billet['matchs'],
            ];
        }
        return new Response(json_encode($rows));
    }
}