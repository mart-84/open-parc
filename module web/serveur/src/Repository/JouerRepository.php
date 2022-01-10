<?php

namespace App\Repository;

use App\Entity\Jouer;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Jouer|null find($id, $lockMode = null, $lockVersion = null)
 * @method Jouer|null findOneBy(array $criteria, array $orderBy = null)
 * @method Jouer[]    findAll()
 * @method Jouer[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class JouerRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Jouer::class);
    }

    
}
