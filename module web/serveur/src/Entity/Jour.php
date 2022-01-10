<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Jour
 *
 * @ORM\Table(name="jour")
 * @ORM\Entity(repositoryClass="App\Repository\JourRepository")
 */
class Jour
{
    /**
     * @var int
     *
     * @ORM\Column(name="jourId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $jourid;

    /**
     * @var \DateTime|null
     *
     * @ORM\Column(name="date", type="datetime", nullable=true)
     */
    private $date;

    public function getJourid(): ?int
    {
        return $this->jourid;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(?\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }


}
