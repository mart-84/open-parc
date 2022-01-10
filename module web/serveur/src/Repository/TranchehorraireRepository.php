<?php

namespace App\Repository;

use App\Entity\Tranchehorraire;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Tranchehorraire|null find($id, $lockMode = null, $lockVersion = null)
 * @method Tranchehorraire|null findOneBy(array $criteria, array $orderBy = null)
 * @method Tranchehorraire[]    findAll()
 * @method Tranchehorraire[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class TranchehorraireRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Tranchehorraire::class);
    }

    // /**
    //  * @return Tranchehorraire[] Returns an array of Tranchehorraire objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('t.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Tranchehorraire
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
