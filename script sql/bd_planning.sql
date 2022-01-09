/*==============================================================*/
/* DBMS name:      MySQL 4.0                                    */
/* Created on:     09/01/2022 12:34:36                          */
/*==============================================================*/


drop table if exists Arbitre;

drop table if exists Court;

drop table if exists EquipeDeRamasseur;

drop table if exists Joueur;

drop table if exists Jour;

drop table if exists Matchs;

drop table if exists RamasseursDeBalles;

drop table if exists Reservation;

drop table if exists TrancheHorraire;

drop table if exists TypeDeTournoi;

drop table if exists appartenir;

drop table if exists arbitrer;

drop table if exists jouer;

drop table if exists ramasser;

/*==============================================================*/
/* Table: Arbitre                                               */
/*==============================================================*/
create table Arbitre
(
   arbitreId                      int                            not null,
   nomArbitre                     varchar(254),
   prenomArbitre                  varchar(254),
   categorie                      varchar(254),
   primary key (arbitreId)
);

/*==============================================================*/
/* Table: Court                                                 */
/*==============================================================*/
create table Court
(
   courtId                        int                            not null,
   nomCourt                       varchar(254),
   primary key (courtId)
);

/*==============================================================*/
/* Table: EquipeDeRamasseur                                     */
/*==============================================================*/
create table EquipeDeRamasseur
(
   equipeRamasseursId             int                            not null,
   primary key (equipeRamasseursId)
);

/*==============================================================*/
/* Table: Joueur                                                */
/*==============================================================*/
create table Joueur
(
   joueurId                       int                            not null,
   nomJoueur                      varchar(254),
   prenomJoueur                   varchar(254),
   primary key (joueurId)
);

/*==============================================================*/
/* Table: Jour                                                  */
/*==============================================================*/
create table Jour
(
   jourId                         int                            not null,
   date                           datetime,
   primary key (jourId)
);

/*==============================================================*/
/* Table: Matchs                                                */
/*==============================================================*/
create table Matchs
(
   matchId                        int                            not null,
   courtId                        int                            not null,
   jourId                         int,
   typeTournoiId                  int                            not null,
   trancheId                      int                            not null,
   primary key (matchId)
);

/*==============================================================*/
/* Table: RamasseursDeBalles                                    */
/*==============================================================*/
create table RamasseursDeBalles
(
   ramasseurBalleId               int                            not null,
   nomRamasseur                   varchar(254),
   prenomRamasseur                varchar(254),
   primary key (ramasseurBalleId)
);

/*==============================================================*/
/* Table: Reservation                                           */
/*==============================================================*/
create table Reservation
(
   reservationId                  int                            not null,
   courtId                        int                            not null,
   jourId                         int                            not null,
   trancheId                      int                            not null,
   joueurId                       int                            not null,
   primary key (reservationId)
);

/*==============================================================*/
/* Table: TrancheHorraire                                       */
/*==============================================================*/
create table TrancheHorraire
(
   trancheId                      int                            not null,
   heureDebut                     int,
   primary key (trancheId)
);

/*==============================================================*/
/* Table: TypeDeTournoi                                         */
/*==============================================================*/
create table TypeDeTournoi
(
   typeTournoiId                  int                            not null,
   nomTournoi                     varchar(254),
   primary key (typeTournoiId)
);

/*==============================================================*/
/* Table: appartenir                                            */
/*==============================================================*/
create table appartenir
(
   equipeRamasseursId             int                            not null,
   ramasseurBalleId               int                            not null,
   primary key (equipeRamasseursId, ramasseurBalleId)
);

/*==============================================================*/
/* Table: arbitrer                                              */
/*==============================================================*/
create table arbitrer
(
   matchId                        int                            not null,
   arbitreId                      int                            not null,
   primary key (matchId, arbitreId)
);

/*==============================================================*/
/* Table: jouer                                                 */
/*==============================================================*/
create table jouer
(
   matchId                        int                            not null,
   joueurId                       int                            not null,
   primary key (joueurId, matchId)
);

/*==============================================================*/
/* Table: ramasser                                              */
/*==============================================================*/
create table ramasser
(
   equipeRamasseursId             int                            not null,
   matchId                        int                            not null,
   primary key (equipeRamasseursId, matchId)
);

alter table Matchs add constraint FK_association10 foreign key (jourId)
      references Jour (jourId) on delete cascade on update cascade;

alter table Matchs add constraint FK_association6 foreign key (trancheId)
      references TrancheHorraire (trancheId) on delete cascade on update cascade;

alter table Matchs add constraint FK_association8 foreign key (courtId)
      references Court (courtId) on delete cascade on update cascade;

alter table Matchs add constraint FK_association9 foreign key (typeTournoiId)
      references TypeDeTournoi (typeTournoiId) on delete cascade on update cascade;

alter table Reservation add constraint FK_association11 foreign key (joueurId)
      references Joueur (joueurId) on delete cascade on update cascade;

alter table Reservation add constraint FK_association12 foreign key (courtId)
      references Court (courtId) on delete cascade on update cascade;

alter table Reservation add constraint FK_association13 foreign key (jourId)
      references Jour (jourId) on delete cascade on update cascade;

alter table Reservation add constraint FK_association14 foreign key (trancheId)
      references TrancheHorraire (trancheId) on delete cascade on update cascade;

alter table appartenir add constraint FK_association2_equipe foreign key (equipeRamasseursId)
      references EquipeDeRamasseur (equipeRamasseursId) on delete cascade on update cascade;

alter table appartenir add constraint FK_association2_ramasseur foreign key (ramasseurBalleId)
      references RamasseursDeBalles (ramasseurBalleId) on delete cascade on update cascade;

alter table arbitrer add constraint FK_arbitrer_arbitre foreign key (arbitreId)
      references Arbitre (arbitreId) on delete cascade on update cascade;

alter table arbitrer add constraint FK_arbitrer_matchs foreign key (matchId)
      references Matchs (matchId) on delete cascade on update cascade;

alter table jouer add constraint FK_jouer_joueur foreign key (joueurId)
      references Joueur (joueurId) on delete cascade on update cascade;

alter table jouer add constraint FK_jouer_match foreign key (matchId)
      references Matchs (matchId) on delete cascade on update cascade;

alter table ramasser add constraint FK_association3_equipe foreign key (equipeRamasseursId)
      references EquipeDeRamasseur (equipeRamasseursId) on delete cascade on update cascade;

alter table ramasser add constraint FK_association3_match foreign key (matchId)
      references Matchs (matchId) on delete cascade on update cascade;

