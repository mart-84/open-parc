<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Arbitre
 *
 * @ORM\Table(name="arbitre")
 * @ORM\Entity(repositoryClass="App\Repository\ArbitreRepository")
 */
class Arbitre
{
    /**
     * @var int
     *
     * @ORM\Column(name="arbitreId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $arbitreid;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomArbitre", type="string", length=254, nullable=true)
     */
    private $nomarbitre;

    /**
     * @var string|null
     *
     * @ORM\Column(name="prenomArbitre", type="string", length=254, nullable=true)
     */
    private $prenomarbitre;

    /**
     * @var string|null
     *
     * @ORM\Column(name="categorie", type="string", length=254, nullable=true)
     */
    private $categorie;

    public function getArbitreid(): ?int
    {
        return $this->arbitreid;
    }

    public function getNomarbitre(): ?string
    {
        return $this->nomarbitre;
    }

    public function setNomarbitre(?string $nomarbitre): self
    {
        $this->nomarbitre = $nomarbitre;

        return $this;
    }

    public function getPrenomarbitre(): ?string
    {
        return $this->prenomarbitre;
    }

    public function setPrenomarbitre(?string $prenomarbitre): self
    {
        $this->prenomarbitre = $prenomarbitre;

        return $this;
    }

    public function getCategorie(): ?string
    {
        return $this->categorie;
    }

    public function setCategorie(?string $categorie): self
    {
        $this->categorie = $categorie;

        return $this;
    }


}
