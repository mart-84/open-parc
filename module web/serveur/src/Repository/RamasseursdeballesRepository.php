<?php

namespace App\Repository;

use App\Entity\Ramasseursdeballes;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Ramasseursdeballes|null find($id, $lockMode = null, $lockVersion = null)
 * @method Ramasseursdeballes|null findOneBy(array $criteria, array $orderBy = null)
 * @method Ramasseursdeballes[]    findAll()
 * @method Ramasseursdeballes[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class RamasseursdeballesRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Ramasseursdeballes::class);
    }

    // /**
    //  * @return Ramasseursdeballes[] Returns an array of Ramasseursdeballes objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('r.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Ramasseursdeballes
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
