<?php

namespace App\Controller;

use App\Entity\Billet;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use App\Repository\BilletRepository;
use Doctrine\Persistence\ManagerRegistry;

class triParJours extends AbstractController
{
    public function recupBillet(ManagerRegistry $doctrine, int $day) : Response
    {
        $jour="Lundi";
        //Il faudra get le jour
        $liste_billets=/*get_billet()*/["1","A",2,"E"];
        //Il faut get la liste de tous les billets
        

        /*
        return $this->render(
            'billets.html.twig', [
                'jour'=>$jour,
                'billet'=>$liste_billets
        ]);*/
        
        $billets=$doctrine->getRepository(Billet::class)->findAll();
        foreach($billets as $billet) {
            echo "Prix du seul billet du jour 5: ".$billet->getPrix()."";
        }
        


        return new Response('<body>Bonjour '.$day.'</body>');
    }


    

    
  
}