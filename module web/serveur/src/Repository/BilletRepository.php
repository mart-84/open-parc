<?php

namespace App\Repository;

use App\Entity\Billet;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\ORM\EntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Billet|null find($id, $lockMode = null, $lockVersion = null)
 * @method Billet|null findOneBy(array $criteria, array $orderBy = null)
 * @method Billet[]    findAll()
 * @method Billet[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 * 
 */
class BilletRepository extends ServiceEntityRepository
{
    
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Billet::class);
    }

    // /**
    //  * @return Billet[] Returns an array of Billet objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('b.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */
    /**
    * @return Billet[] Returns an array of Billet objects
    */
    public function findByDay($value)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.jourid = :val')
            ->setParameter('val', $value)
            ->setMaxResults(100)
            ->getQuery()
            ->getResult()
        ;
    }

    public function findById($value)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.billetid = :val')
            ->setParameter('val', $value)
            ->setMaxResults(100)
            ->getQuery()
            ->getResult()
        ;
    }

    public function findByJourCourt($id)
    {
        return $this->createQueryBuilder('b')
            
            ->andWhere('b.billetid = :val2')
  
            ->setParameter('val2', $id)
            ->setMaxResults(1)
            ->getQuery()
            ->getResult()
        ;
    }

    public function decreaseQuantity($id,$quantity)
    {
        $queryBuilder = $this->createQueryBuilder('b');
        $query = $queryBuilder
            ->set('b.quantite', ':quantity')
            ->where('b.billetid = :val')
            ->setParameter('quantity', $quantity)
            ->setParameter('val', $id)
            ->getQuery();
        $query->execute();
    }
    
    

    /*
    public function findOneBySomeField($value): ?Billet
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
    
}
