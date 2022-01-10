<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Ramasseursdeballes
 *
 * @ORM\Table(name="ramasseursdeballes")
 * @ORM\Entity(repositoryClass="App\Repository\RamasseursdeballesRepository")
 */
class Ramasseursdeballes
{
    /**
     * @var int
     *
     * @ORM\Column(name="ramasseurBalleId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ramasseurballeid;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomRamasseur", type="string", length=254, nullable=true)
     */
    private $nomramasseur;

    /**
     * @var string|null
     *
     * @ORM\Column(name="prenomRamasseur", type="string", length=254, nullable=true)
     */
    private $prenomramasseur;

    public function getRamasseurballeid(): ?int
    {
        return $this->ramasseurballeid;
    }

    public function getNomramasseur(): ?string
    {
        return $this->nomramasseur;
    }

    public function setNomramasseur(?string $nomramasseur): self
    {
        $this->nomramasseur = $nomramasseur;

        return $this;
    }

    public function getPrenomramasseur(): ?string
    {
        return $this->prenomramasseur;
    }

    public function setPrenomramasseur(?string $prenomramasseur): self
    {
        $this->prenomramasseur = $prenomramasseur;

        return $this;
    }


}
