/*==============================================================*/
/* DBMS name:      MySQL 4.0                                    */
/* Created on:     09/01/2022 12:34:26                          */
/*==============================================================*/


drop table if exists Billet;

drop table if exists Court;

drop table if exists Jouer;

drop table if exists Joueur;

drop table if exists Jour;

drop table if exists Matchs;

drop table if exists TypeBillet;

/*==============================================================*/
/* Table: Billet                                                */
/*==============================================================*/
create table Billet
(
   billetId                       int                            not null,
   jourId                         int                            not null,
   courtId                        int                            not null,
   typeBilletId                   int                            not null,
   prix                           int,
   place                          int,
   primary key (billetId)
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
/* Table: Jouer                                                 */
/*==============================================================*/
create table Jouer
(
   matchId                        int                            not null,
   joueurId                       int                            not null,
   primary key (matchId, joueurId)
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
   jourId                         int                            not null,
   primary key (matchId)
);

/*==============================================================*/
/* Table: TypeBillet                                            */
/*==============================================================*/
create table TypeBillet
(
   typeBilletId                   int                            not null,
   nomType                        varchar(254),
   primary key (typeBilletId)
);

alter table Billet add constraint FK_couvrir foreign key (jourId)
      references Jour (jourId) on delete cascade on update cascade;

alter table Billet add constraint FK_etre foreign key (typeBilletId)
      references TypeBillet (typeBilletId) on delete cascade on update cascade;

alter table Billet add constraint FK_viser foreign key (courtId)
      references Court (courtId) on delete cascade on update cascade;

alter table Jouer add constraint FK_jouer_joueur foreign key (joueurId)
      references Joueur (joueurId) on delete cascade on update cascade;

alter table Jouer add constraint FK_jouer_match foreign key (matchId)
      references Matchs (matchId) on delete cascade on update cascade;

alter table Matchs add constraint FK_se_derouler_sur foreign key (courtId)
      references Court (courtId) on delete cascade on update cascade;

alter table Matchs add constraint FK_se_tenir foreign key (jourId)
      references Jour (jourId) on delete cascade on update cascade;

