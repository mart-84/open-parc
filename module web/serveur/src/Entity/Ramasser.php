<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Ramasser
 *
 * @ORM\Table(name="ramasser", indexes={@ORM\Index(name="FK_association3_match", columns={"matchId"})})
 * @ORM\Entity(repositoryClass="App\Repository\RamasserRepository")
 */
class Ramasser
{
    /**
     * @var int
     *
     * @ORM\Column(name="equipeRamasseursId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $equiperamasseursid;

    /**
     * @var int
     *
     * @ORM\Column(name="matchId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $matchid;

    public function getEquiperamasseursid(): ?int
    {
        return $this->equiperamasseursid;
    }

    public function getMatchid(): ?int
    {
        return $this->matchid;
    }


}
