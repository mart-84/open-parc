<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Matchs
 *
 * @ORM\Table(name="matchs", indexes={@ORM\Index(name="FK_association6", columns={"trancheId"}), @ORM\Index(name="FK_association9", columns={"typeTournoiId"}), @ORM\Index(name="FK_association10", columns={"jourId"}), @ORM\Index(name="FK_association8", columns={"courtId"})})
 * @ORM\Entity(repositoryClass="App\Repository\MatchsRepository")
 */
class Matchs
{
    /**
     * @var int
     *
     * @ORM\Column(name="matchId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $matchid;

    /**
     * @var int
     *
     * @ORM\Column(name="courtId", type="integer", nullable=false)
     */
    private $courtid;

    /**
     * @var int|null
     *
     * @ORM\Column(name="jourId", type="integer", nullable=true)
     */
    private $jourid;

    /**
     * @var int
     *
     * @ORM\Column(name="typeTournoiId", type="integer", nullable=false)
     */
    private $typetournoiid;

    /**
     * @var int
     *
     * @ORM\Column(name="trancheId", type="integer", nullable=false)
     */
    private $trancheid;

    public function getMatchid(): ?int
    {
        return $this->matchid;
    }

    public function getCourtid(): ?int
    {
        return $this->courtid;
    }

    public function setCourtid(int $courtid): self
    {
        $this->courtid = $courtid;

        return $this;
    }

    public function getJourid(): ?int
    {
        return $this->jourid;
    }

    public function setJourid(?int $jourid): self
    {
        $this->jourid = $jourid;

        return $this;
    }

    public function getTypetournoiid(): ?int
    {
        return $this->typetournoiid;
    }

    public function setTypetournoiid(int $typetournoiid): self
    {
        $this->typetournoiid = $typetournoiid;

        return $this;
    }

    public function getTrancheid(): ?int
    {
        return $this->trancheid;
    }

    public function setTrancheid(int $trancheid): self
    {
        $this->trancheid = $trancheid;

        return $this;
    }


}
