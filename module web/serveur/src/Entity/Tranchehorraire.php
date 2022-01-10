<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tranchehorraire
 *
 * @ORM\Table(name="tranchehorraire")
 * @ORM\Entity(repositoryClass="App\Repository\TranchehorraireRepository")
 */
class Tranchehorraire
{
    /**
     * @var int
     *
     * @ORM\Column(name="trancheId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $trancheid;

    /**
     * @var int|null
     *
     * @ORM\Column(name="heureDebut", type="integer", nullable=true)
     */
    private $heuredebut;

    public function getTrancheid(): ?int
    {
        return $this->trancheid;
    }

    public function getHeuredebut(): ?int
    {
        return $this->heuredebut;
    }

    public function setHeuredebut(?int $heuredebut): self
    {
        $this->heuredebut = $heuredebut;

        return $this;
    }


}
