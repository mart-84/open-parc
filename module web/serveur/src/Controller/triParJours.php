<?php

namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


class triParJours extends AbstractController
{
    public function recupBillet(string $day) : Response
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

        return new Response('<body>Bonjour '.$day.'</body>');
    }


    

    
  
}