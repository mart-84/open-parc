<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Billet
 *
 * @ORM\Table(name="billet", indexes={@ORM\Index(name="FK_etre", columns={"typeBilletId"}), @ORM\Index(name="FK_couvrir", columns={"jourId"}), @ORM\Index(name="FK_viser", columns={"courtId"})})
 * @ORM\Entity(repositoryClass="App\Repository\BilletRepository")
 * 
 */
class Billet
{
    /**
     * @var int
     *
     * @ORM\Column(name="billetId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $billetid;

    /**
     * @var int
     *
     * @ORM\Column(name="jourId", type="integer", nullable=false)
     */
    private $jourid;

    /**
     * @var int
     *
     * @ORM\Column(name="courtId", type="integer", nullable=false)
     */
    private $courtid;

    /**
     * @var int
     *
     * @ORM\Column(name="typeBilletId", type="integer", nullable=false)
     */
    private $typebilletid;

    /**
     * @var int|null
     *
     * @ORM\Column(name="prix", type="integer", nullable=true)
     */
    private $prix;

    /**
     * @var int|null
     *
     * @ORM\Column(name="place", type="integer", nullable=true)
     */
    private $place;

    public function getBilletid(): ?int
    {
        return $this->billetid;
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

    public function getCourtid(): ?int
    {
        return $this->courtid;
    }

    public function setCourtid(int $courtid): self
    {
        $this->courtid = $courtid;

        return $this;
    }

    public function getTypebilletid(): ?int
    {
        return $this->typebilletid;
    }

    public function setTypebilletid(int $typebilletid): self
    {
        $this->typebilletid = $typebilletid;

        return $this;
    }

    public function getPrix(): ?int
    {
        return $this->prix;
    }

    public function setPrix(?int $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getPlace(): ?int
    {
        return $this->place;
    }

    public function setPlace(?int $place): self
    {
        $this->place = $place;

        return $this;
    }


}
