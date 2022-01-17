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

//TODO NEXT : TRI PAR JOUEUR

class triParJoueur extends AbstractController
{
    public function recupBilletJoueur(ManagerRegistry $doctrine, string $player) : Response
    {
        

        /** @var BilletRepository $billetRepository */
        $billetRepository=$doctrine->getRepository(Billet::class);
        
        //jour => dans match je recup les matchs du bon jour
        /** @var MatchsRepository $matchRepository */
        $matchRepository=$doctrine->getRepository(Matchs::class);
        
        /** @var JouerRepository $jouerRepository */
        $jouerRepository=$doctrine->getRepository(Jouer::class);
        
        /** @var JoueurRepository $joueurRepository */
        $joueurRepository=$doctrine->getRepository(Joueur::class);
        
        //trouver l'ID du joueur avec le nom et prénom au format: nom_prenom
        $player=strtoupper($player);
        $player = explode('_',$player);
        $player_nom=$player[0];
        $player_prenom=$player[1];
        $joueur=$joueurRepository->findByNomPrenom($player_nom,$player_prenom);
        $jid=$joueur[0];
        //trouver l'id des matchs que joue le joueur recherché
        $matchsid=$jouerRepository->findByPlayer($jid);
        //récupérer les objets matchs que joue le joueur
        foreach($matchsid as $matchid){
            $matchs[]=$matchRepository->find($matchid);
        }
        
        $liste_matchs=[];
        $i=0;
        foreach($matchs as $match){
            $liste_matchs[$i]=[
                'matchid'=>(int)$match->getMatchId(),
                'matchtype'=>(int)$match->getTypetournoiid(),
                'matchcourtid'=>(int)$match->getCourtId(),
                'matchcourt'=>(string)'',
                'joueursId'=>[],
                'joueursNoms'=>[],
            ];
            $i++;
        }
        //récupération des id des joueurs qui participent aux matchs
        $liste_matchs2=[];
        foreach($liste_matchs as $un_match){
            $jouers=$jouerRepository->findByMatch($un_match['matchid']);
            foreach($jouers as $jouer){
                $id=$jouer->getJoueurId();
                $un_match['joueursId'][]=$id;
            }
            $liste_matchs2[]=$un_match;
        }
        // => avec les JoueurdID je recup leurs noms dans Joueur
        $liste_matchs3=[];
        foreach($liste_matchs2 as $un_match){
            foreach($un_match['joueursId'] as $un_jId){
                $joueur=$joueurRepository->find($un_jId);
                $nom=$joueur->getNomjoueur();
                $un_match['joueursNoms'][]=$nom;
            }
            $liste_matchs3[]=$un_match;
        }
        $matchsCourt1=[];
        $matchsCourt2=[];
        $matchsCourt3=[];
        $matchsCourt4=[];
        foreach($liste_matchs3 as $un_match){
            switch ($un_match['matchcourtid']) {
                case 1:
                    $matchsCourt1[]=$un_match;;
                    break;
                case 2:
                    $matchsCourt2[]=$un_match;
                    break;
                case 3:
                    $matchsCourt3[]=$un_match;
                    break;
                case 4:
                    $matchsCourt4[]=$un_match;
                    break;
            }
        }
        
        
        //recup tous les billets dont le jour/court correspond aux jours/court des matchs
        $billets=[];
        foreach($matchs as $un_match){
            if(!(in_array($billetRepository->findByJourCourt($un_match->getJourid(),$un_match->getCourtid()), $billets))){
                $billets=$billetRepository->findByJourCourt($un_match->getJourid(),$un_match->getCourtid());
            }
        }
        
        
        
        
        
        //var_dump($billets);die;
        
        foreach($billets as $billet){
            $tous_les_billets['billet']=$billet;
            $court=$billet->getCourtid();
            switch($court){
                case 1:
                    $tous_les_billets['matchs']=$matchsCourt1;
                    break;
                case 2:
                    $tous_les_billets['matchs']=$matchsCourt2;
                    break;
                case 3:
                    $tous_les_billets['matchs']=$matchsCourt3;
                    break;
                case 4:
                    $tous_les_billets['matchs']=$matchsCourt4;
                    break;
            }
            $tous_les_billets2[]=$tous_les_billets;
        }
        $rows=[];
        foreach($tous_les_billets2 as $un_billet) {
            $rows[] = [
                'billetid' => (int)$un_billet['billet']->getBilletId(),
                'jouriD' => (int)$un_billet['billet']->getJourId(),
                'courtid' => (int)$un_billet['billet']->getCourtId(),
                'typebilletid' => (int)$un_billet['billet']->getTypebilletid(),
                'prix' => (int)$un_billet['billet']->getPrix(),
                'place' => (int)$un_billet['billet']->getPlace(),
                'liste_match' => $un_billet['matchs'],
            ];
        }
        echo json_encode($rows);
        return new Response("ok");
    }


    

    
  
}