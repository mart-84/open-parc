<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Equipederamasseur
 *
 * @ORM\Table(name="equipederamasseur")
 * @ORM\Entity(repositoryClass="App\Repository\EquipederamasseurRepository")
 */
class Equipederamasseur
{
    /**
     * @var int
     *
     * @ORM\Column(name="equipeRamasseursId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $equiperamasseursid;

    public function getEquiperamasseursid(): ?int
    {
        return $this->equiperamasseursid;
    }


}
