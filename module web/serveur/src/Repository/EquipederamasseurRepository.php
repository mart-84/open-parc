<?php

namespace App\Repository;

use App\Entity\Equipederamasseur;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Equipederamasseur|null find($id, $lockMode = null, $lockVersion = null)
 * @method Equipederamasseur|null findOneBy(array $criteria, array $orderBy = null)
 * @method Equipederamasseur[]    findAll()
 * @method Equipederamasseur[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class EquipederamasseurRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Equipederamasseur::class);
    }

    // /**
    //  * @return Equipederamasseur[] Returns an array of Equipederamasseur objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('e.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Equipederamasseur
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
