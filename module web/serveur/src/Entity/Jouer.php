<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Jouer
 *
 * @ORM\Table(name="jouer", indexes={@ORM\Index(name="FK_jouer_match", columns={"matchId"})})
 * @ORM\Entity(repositoryClass="App\Repository\JouerRepository")
 */
class Jouer
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
     * @var int|null
     *
     * @ORM\Column(name="joueurId", type="integer", nullable=true)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $joueurid;

    public function getMatchid(): ?int
    {
        return $this->matchid;
    }

    public function getJoueurid(): ?int
    {
        return $this->joueurid;
    }


}
