<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Joueur
 *
 * @ORM\Table(name="joueur")
 * @ORM\Entity(repositoryClass="App\Repository\JoueurRepository")
 */
class Joueur
{
    /**
     * @var int
     *
     * @ORM\Column(name="joueurId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $joueurid;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomJoueur", type="string", length=254, nullable=true)
     */
    private $nomjoueur;

    /**
     * @var string|null
     *
     * @ORM\Column(name="prenomJoueur", type="string", length=254, nullable=true)
     */
    private $prenomjoueur;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nationaliteJoueur", type="string", length=254, nullable=true)
     */
    private $nationaliteJoueur;

    public function getJoueurid(): ?int
    {
        return $this->joueurid;
    }

    public function getNomjoueur(): ?string
    {
        return $this->nomjoueur;
    }

    public function setNomjoueur(?string $nomjoueur): self
    {
        $this->nomjoueur = $nomjoueur;

        return $this;
    }

    public function getPrenomjoueur(): ?string
    {
        return $this->prenomjoueur;
    }

    public function setPrenomjoueur(?string $prenomjoueur): self
    {
        $this->prenomjoueur = $prenomjoueur;

        return $this;
    }

    public function getNationaliteJoueur(): ?string
    {
        return $this->nationaliteJoueur;
    }

    public function setNationaliteJoueur(?string $nationaliteJoueur): self
    {
        $this->nationaliteJoueur = $nationaliteJoueur;

        return $this;
    }
    

}
