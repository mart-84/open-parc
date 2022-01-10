<?php

namespace App\Repository;

use App\Entity\Arbitrer;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Arbitrer|null find($id, $lockMode = null, $lockVersion = null)
 * @method Arbitrer|null findOneBy(array $criteria, array $orderBy = null)
 * @method Arbitrer[]    findAll()
 * @method Arbitrer[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ArbitrerRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Arbitrer::class);
    }

    // /**
    //  * @return Arbitrer[] Returns an array of Arbitrer objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('a')
            ->andWhere('a.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('a.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Arbitrer
    {
        return $this->createQueryBuilder('a')
            ->andWhere('a.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
