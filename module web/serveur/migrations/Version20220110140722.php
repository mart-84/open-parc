<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220110140722 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('DROP TABLE appartenir');
        $this->addSql('DROP TABLE arbitre');
        $this->addSql('DROP TABLE arbitrer');
        $this->addSql('DROP TABLE court');
        $this->addSql('DROP TABLE equipederamasseur');
        $this->addSql('DROP TABLE jouer');
        $this->addSql('DROP TABLE joueur');
        $this->addSql('DROP TABLE jour');
        $this->addSql('DROP TABLE matchs');
        $this->addSql('DROP TABLE ramasser');
        $this->addSql('DROP TABLE ramasseursdeballes');
        $this->addSql('DROP TABLE reservation');
        $this->addSql('DROP TABLE tranchehorraire');
        $this->addSql('DROP TABLE typebillet');
        $this->addSql('DROP TABLE typedetournoi');
        $this->addSql('DROP INDEX FK_etre ON billet');
        $this->addSql('DROP INDEX FK_couvrir ON billet');
        $this->addSql('DROP INDEX FK_viser ON billet');
        $this->addSql('ALTER TABLE billet ADD id INT AUTO_INCREMENT NOT NULL, DROP billetId, DROP jourId, DROP courtId, DROP typeBilletId, DROP prix, DROP place, DROP PRIMARY KEY, ADD PRIMARY KEY (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE appartenir (equipeRamasseursId INT NOT NULL, ramasseurBalleId INT NOT NULL, INDEX FK_association2_ramasseur (ramasseurBalleId), PRIMARY KEY(equipeRamasseursId, ramasseurBalleId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE arbitre (arbitreId INT NOT NULL, nomArbitre VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, prenomArbitre VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, categorie VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, PRIMARY KEY(arbitreId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE arbitrer (matchId INT NOT NULL, arbitreId INT NOT NULL, INDEX FK_arbitrer_arbitre (arbitreId), PRIMARY KEY(matchId, arbitreId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE court (courtId INT NOT NULL, nomCourt VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, PRIMARY KEY(courtId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE equipederamasseur (equipeRamasseursId INT NOT NULL, PRIMARY KEY(equipeRamasseursId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE jouer (matchId INT NOT NULL, joueurId INT NOT NULL, INDEX FK_jouer_match (matchId), PRIMARY KEY(joueurId, matchId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE joueur (joueurId INT NOT NULL, nomJoueur VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, prenomJoueur VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, PRIMARY KEY(joueurId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE jour (jourId INT NOT NULL, date DATETIME DEFAULT NULL, PRIMARY KEY(jourId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE matchs (matchId INT NOT NULL, courtId INT NOT NULL, jourId INT DEFAULT NULL, typeTournoiId INT NOT NULL, trancheId INT NOT NULL, INDEX FK_association6 (trancheId), INDEX FK_association9 (typeTournoiId), INDEX FK_association10 (jourId), INDEX FK_association8 (courtId), PRIMARY KEY(matchId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE ramasser (equipeRamasseursId INT NOT NULL, matchId INT NOT NULL, INDEX FK_association3_match (matchId), PRIMARY KEY(equipeRamasseursId, matchId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE ramasseursdeballes (ramasseurBalleId INT NOT NULL, nomRamasseur VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, prenomRamasseur VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, PRIMARY KEY(ramasseurBalleId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE reservation (reservationId INT NOT NULL, courtId INT NOT NULL, jourId INT NOT NULL, trancheId INT NOT NULL, joueurId INT NOT NULL, INDEX FK_association14 (trancheId), INDEX FK_association12 (courtId), INDEX FK_association11 (joueurId), INDEX FK_association13 (jourId), PRIMARY KEY(reservationId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE tranchehorraire (trancheId INT NOT NULL, heureDebut INT DEFAULT NULL, PRIMARY KEY(trancheId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE typebillet (typeBilletId INT NOT NULL, nomType VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, PRIMARY KEY(typeBilletId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('CREATE TABLE typedetournoi (typeTournoiId INT NOT NULL, nomTournoi VARCHAR(254) CHARACTER SET latin1 DEFAULT NULL COLLATE `latin1_swedish_ci`, PRIMARY KEY(typeTournoiId)) DEFAULT CHARACTER SET latin1 COLLATE `latin1_unicode_ci` ENGINE = MyISAM COMMENT = \'\' ');
        $this->addSql('ALTER TABLE billet MODIFY id INT NOT NULL');
        $this->addSql('ALTER TABLE billet DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE billet ADD billetId INT NOT NULL, ADD jourId INT NOT NULL, ADD courtId INT NOT NULL, ADD typeBilletId INT NOT NULL, ADD prix INT DEFAULT NULL, ADD place INT DEFAULT NULL, DROP id');
        $this->addSql('CREATE INDEX FK_etre ON billet (typeBilletId)');
        $this->addSql('CREATE INDEX FK_couvrir ON billet (jourId)');
        $this->addSql('CREATE INDEX FK_viser ON billet (courtId)');
        $this->addSql('ALTER TABLE billet ADD PRIMARY KEY (billetId)');
    }
}
