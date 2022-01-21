<?php

namespace App\Controller;

use App\Entity\Joueur;
use App\Repository\JoueurRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class joueurController extends AbstractController
{
    public function recupJoueur(ManagerRegistry $doctrine) : Response
    {
        /** @var JoueurRepository $joueurRepository */
        $joueurRepository=$doctrine->getRepository(Joueur::class);
        $joueurs=$joueurRepository->findAll();
        
        $rows=[];
        foreach($joueurs as $un_joueur) {
            $rows[] = [
                'Prenom' => (string)$un_joueur->getPrenomjoueur(),
                'Nom' => (string)$un_joueur->getNomjoueur(),
                'Nationalite' => (string)$un_joueur->getNationaliteJoueur(),
            ];
        }
        echo json_encode($rows);
        return new Response("ok");
    }


    

    
  
}