<?php

namespace App\Repository;

use App\Entity\Matchs;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\ORM\Mapping\OrderBy;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Matchs|null find($id, $lockMode = null, $lockVersion = null)
 * @method Matchs|null findOneBy(array $criteria, array $orderBy = null)
 * @method Matchs[]    findAll()
 * @method Matchs[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class MatchsRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Matchs::class);
    }

    // /**
    //  * @return Matchs[] Returns an array of Matchs objects
    //  */
    public function findByDay($value)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.jourid = :val')
            ->setParameter('val', $value)
            ->orderBy('b.matchid','ASC')
            ->setMaxResults(100)
            ->getQuery()
            ->getResult()
        ;
    }

    public function findByplayerId($value)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.jourid = :val')
            ->setParameter('val', $value)
            ->orderBy('b.matchid','ASC')
            ->setMaxResults(100)
            ->getQuery()
            ->getResult()
        ;
    }

    

    /*
    public function findOneBySomeField($value): ?Matchs
    {
        return $this->createQueryBuilder('m')
            ->andWhere('m.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
