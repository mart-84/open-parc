<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Typebillet
 *
 * @ORM\Table(name="typebillet")
 * @ORM\Entity(repositoryClass="App\Repository\TypebilletRepository")
 * 
 */
class Typebillet
{
    /**
     * @var int
     *
     * @ORM\Column(name="typeBilletId", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $typebilletid;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomType", type="string", length=254, nullable=true)
     */
    private $nomtype;

    public function getTypebilletid(): ?int
    {
        return $this->typebilletid;
    }

    public function getNomtype(): ?string
    {
        return $this->nomtype;
    }

    public function setNomtype(?string $nomtype): self
    {
        $this->nomtype = $nomtype;

        return $this;
    }


}
