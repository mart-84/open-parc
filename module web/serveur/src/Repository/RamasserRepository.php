<?php

namespace App\Repository;

use App\Entity\Ramasser;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Ramasser|null find($id, $lockMode = null, $lockVersion = null)
 * @method Ramasser|null findOneBy(array $criteria, array $orderBy = null)
 * @method Ramasser[]    findAll()
 * @method Ramasser[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class RamasserRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Ramasser::class);
    }

    // /**
    //  * @return Ramasser[] Returns an array of Ramasser objects
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
    public function findOneBySomeField($value): ?Ramasser
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
