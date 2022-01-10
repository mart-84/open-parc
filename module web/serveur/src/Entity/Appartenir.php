<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Appartenir
 *
 * @ORM\Table(name="appartenir", indexes={@ORM\Index(name="FK_association2_ramasseur", columns={"ramasseurBalleId"})})
 * @ORM\Entity(repositoryClass="App\Repository\AppartenirRepository")
 */
class Appartenir
{
    /**
     * @var int
     *
     * @ORM\Column(name="equipeRamasseursId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $equiperamasseursid;

    /**
     * @var int
     *
     * @ORM\Column(name="ramasseurBalleId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $ramasseurballeid;

    public function getEquiperamasseursid(): ?int
    {
        return $this->equiperamasseursid;
    }

    public function getRamasseurballeid(): ?int
    {
        return $this->ramasseurballeid;
    }


}
