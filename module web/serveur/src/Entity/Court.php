<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Court
 *
 * @ORM\Table(name="court")
 * @ORM\Entity(repositoryClass="App\Repository\CourtRepository")
 */
class Court
{
    /**
     * @var int
     *
     * @ORM\Column(name="courtId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $courtid;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomCourt", type="string", length=254, nullable=true)
     */
    private $nomcourt;

    public function getCourtid(): ?int
    {
        return $this->courtid;
    }

    public function getNomcourt(): ?string
    {
        return $this->nomcourt;
    }

    public function setNomcourt(?string $nomcourt): self
    {
        $this->nomcourt = $nomcourt;

        return $this;
    }


}
