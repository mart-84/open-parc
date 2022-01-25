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
        /** @var BilletRepository $billetRepository */
        $billetRepository=$doctrine->getRepository(Billet::class);
        $billet=$billetRepository->find($billetId);
        
        $rows=[];
        foreach($billet as $un_billet) {
            $rows[] = [
                'billetid' => (int)$un_billet['billet']->getBilletId(),
                'jouriD' => (int)$un_billet['billet']->getJourId(),
                'courtid' => (int)$un_billet['billet']->getCourtId(),
                'prix' => (int)$un_billet['billet']->getPrix(),
                'place' => (int)$un_billet['billet']->getPlace(),
            ];
        }
        echo json_encode($rows);
        return new Response("ok");


    }
    

    
  
}