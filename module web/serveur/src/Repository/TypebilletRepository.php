<?php

namespace App\Repository;

use App\Entity\Typebillet;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Typebillet|null find($id, $lockMode = null, $lockVersion = null)
 * @method Typebillet|null findOneBy(array $criteria, array $orderBy = null)
 * @method Typebillet[]    findAll()
 * @method Typebillet[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class TypebilletRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Typebillet::class);
    }

    // /**
    //  * @return Typebillet[] Returns an array of Typebillet objects
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
    public function findOneBySomeField($value): ?Typebillet
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
