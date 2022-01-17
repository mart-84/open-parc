<?php

namespace App\Repository; // Declare the namespace with your bundle path and "/Repository" in the end

use Doctrine\ORM\EntityRepository; // We need the Entity Repository

/**
 * RegisterRepository
 * This class was generated by the Doctrine ORM. Add your own custom
 * repository methods below.
 */
class BilletCustomRepository extends EntityRepository // Give a name to your class
{
    // A simple count method that we will call in the controller like this : $total = $em->getRepository('mybundle:Something')->countSomething();
    public function findByDay($value)
    {
        return $this->createQueryBuilder('b')
            ->andWhere('b.jourId = :val')
            ->setParameter('val', $value)
            ->orderBy('b.id', 'ASC')
            ->setMaxResults(100)
            ->getQuery()
            ->getResult()
        ;
    }
}