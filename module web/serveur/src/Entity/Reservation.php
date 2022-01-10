<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservation
 *
 * @ORM\Table(name="reservation", indexes={@ORM\Index(name="FK_association14", columns={"trancheId"}), @ORM\Index(name="FK_association12", columns={"courtId"}), @ORM\Index(name="FK_association13", columns={"jourId"}), @ORM\Index(name="FK_association11", columns={"joueurId"})})
 * @ORM\Entity(repositoryClass="App\Repository\ReservationRepository")
 */
class Reservation
{
    /**
     * @var int
     *
     * @ORM\Column(name="reservationId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $reservationid;

    /**
     * @var int
     *
     * @ORM\Column(name="courtId", type="integer", nullable=false)
     */
    private $courtid;

    /**
     * @var int
     *
     * @ORM\Column(name="jourId", type="integer", nullable=false)
     */
    private $jourid;

    /**
     * @var int
     *
     * @ORM\Column(name="trancheId", type="integer", nullable=false)
     */
    private $trancheid;

    /**
     * @var int
     *
     * @ORM\Column(name="joueurId", type="integer", nullable=false)
     */
    private $joueurid;

    public function getReservationid(): ?int
    {
        return $this->reservationid;
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

    public function setJourid(int $jourid): self
    {
        $this->jourid = $jourid;

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

    public function getJoueurid(): ?int
    {
        return $this->joueurid;
    }

    public function setJoueurid(int $joueurid): self
    {
        $this->joueurid = $joueurid;

        return $this;
    }


}
