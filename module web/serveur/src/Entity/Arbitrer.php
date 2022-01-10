<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Arbitrer
 *
 * @ORM\Table(name="arbitrer", indexes={@ORM\Index(name="FK_arbitrer_arbitre", columns={"arbitreId"})})
 * @ORM\Entity(repositoryClass="App\Repository\ArbitrerRepository")
 */
class Arbitrer
{
    /**
     * @var int
     *
     * @ORM\Column(name="matchId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $matchid;

    /**
     * @var int
     *
     * @ORM\Column(name="arbitreId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $arbitreid;

    public function getMatchid(): ?int
    {
        return $this->matchid;
    }

    public function getArbitreid(): ?int
    {
        return $this->arbitreid;
    }


}
