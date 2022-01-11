<?php

namespace App\Controller;

use App\Entity\Billet;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use App\Repository\BilletRepository;
use Doctrine\Common\Collections\Criteria;
use Doctrine\Persistence\ManagerRegistry;

class triParJours extends AbstractController
{
    public function recupBillet(ManagerRegistry $doctrine, int $day) : Response
    {
       
       
        /** @var BilletRepository $billetRepository */
        $billetRepository=$doctrine->getRepository(Billet::class);
        $billets=$billetRepository->findByDay($day);
        foreach($billets as $billet) {
            echo "Prix du seul billet du jour 5: ".$billet->getPrix()."";
        }
        

        
        
        return new Response('<body>Bonjour '.$day.'</body>');
    }


    

    
  
}