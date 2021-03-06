<?php

namespace App\Repository;

use App\Entity\Joueur;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Joueur|null find($id, $lockMode = null, $lockVersion = null)
 * @method Joueur|null findOneBy(array $criteria, array $orderBy = null)
 * @method Joueur[]    findAll()
 * @method Joueur[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class JoueurRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Joueur::class);
    }

    public function findByNomPrenom($nom, $prenom)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('UPPER(b.nomjoueur) = :name')
            ->andWhere('UPPER(b.prenomjoueur) = :last_name')
            ->setParameter('name', $nom)
            ->setParameter('last_name', $prenom)
            ->setMaxResults(100)
            ->getQuery()
            ->getResult()
        ;
    }

    public function findById($id)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.joueurId = :id')
            ->setParameter('id', $id)
            ->setMaxResults(100)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }


    // /**
    //  * @return Joueur[] Returns an array of Joueur objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('j')
            ->andWhere('j.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('j.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Joueur
    {
        return $this->createQueryBuilder('j')
            ->andWhere('j.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
