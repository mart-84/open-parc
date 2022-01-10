<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Typedetournoi
 *
 * @ORM\Table(name="typedetournoi")
 * @ORM\Entity(repositoryClass="App\Repository\TypedetournoiRepository")
 */
class Typedetournoi
{
    /**
     * @var int
     *
     * @ORM\Column(name="typeTournoiId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $typetournoiid;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomTournoi", type="string", length=254, nullable=true)
     */
    private $nomtournoi;

    public function getTypetournoiid(): ?int
    {
        return $this->typetournoiid;
    }

    public function getNomtournoi(): ?string
    {
        return $this->nomtournoi;
    }

    public function setNomtournoi(?string $nomtournoi): self
    {
        $this->nomtournoi = $nomtournoi;

        return $this;
    }


}
