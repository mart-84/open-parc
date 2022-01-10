<?php

namespace App\Repository;

use App\Entity\Typedetournoi;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Typedetournoi|null find($id, $lockMode = null, $lockVersion = null)
 * @method Typedetournoi|null findOneBy(array $criteria, array $orderBy = null)
 * @method Typedetournoi[]    findAll()
 * @method Typedetournoi[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class TypedetournoiRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Typedetournoi::class);
    }

    // /**
    //  * @return Typedetournoi[] Returns an array of Typedetournoi objects
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
    public function findOneBySomeField($value): ?Typedetournoi
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
