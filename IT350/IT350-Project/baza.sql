drop table if exists ADMINISTRATOR;

drop table if exists FAJLOVI;

drop table if exists KORISNIK;

drop table if exists OCENA;

drop table if exists PONUDA;

drop table if exists PORUKA;

drop table if exists POSLODAVAC;

drop table if exists POSLOVI;

drop table if exists RADNIK;

drop table if exists ZARADA;

/*==============================================================*/
/* Table: ADMINISTRATOR                                         */
/*==============================================================*/
create table ADMINISTRATOR
(
   ID_KORISNIKA         int not null,
   ID_ADMINISTARTORA    int not null AUTO_INCREMENT,
   primary key (ID_ADMINISTARTORA)
);

/*==============================================================*/
/* Table: FAJLOVI                                               */
/*==============================================================*/
create table FAJLOVI
(
   ID_FAJLA             int not null AUTO_INCREMENT,
   ID_RADNIKA           int not null,
   TIP_FAJLA            text,
   primary key (ID_FAJLA)
);

/*==============================================================*/
/* Table: KORISNIK                                              */
/*==============================================================*/
create table KORISNIK
(
   ID_KORISNIKA         int not null AUTO_INCREMENT,
   primary key (ID_KORISNIKA)
);

/*==============================================================*/
/* Table: OCENA                                                 */
/*==============================================================*/
create table OCENA
(
   ID_OCENE             int not null AUTO_INCREMENT,
   ID_POSLA             int not null,
   ID_RADNIKA           int not null,
   OCENA                int,
   primary key (ID_OCENE)
);

/*==============================================================*/
/* Table: PONUDA                                                */
/*==============================================================*/
create table PONUDA
(
   KRATAKOPIS           text,
   ID_PONUDE            int not null AUTO_INCREMENT,
   ID_POSLA             int not null,
   PREDLOZENACENA       decimal,
   primary key (ID_PONUDE)
);

/*==============================================================*/
/* Table: PORUKA                                                */
/*==============================================================*/
create table PORUKA
(
   ID_PORUKE            int not null AUTO_INCREMENT,
   PORUKA               text,
   primary key (ID_PORUKE)
);

/*==============================================================*/
/* Table: POSLODAVAC                                            */
/*==============================================================*/
create table POSLODAVAC
(
   ID_KORISNIKA         int not null,
   ID_POSLODAVCA        int not null AUTO_INCREMENT,
   ID_PORUKE            int not null,
   primary key (ID_POSLODAVCA)
);

/*==============================================================*/
/* Table: POSLOVI                                               */
/*==============================================================*/
create table POSLOVI
(
   ID_POSLA             int not null AUTO_INCREMENT,
   ID_POSLODAVCA        int not null,
   NAZIV                varchar(16),
   OPIS                 varchar(255),
   MAKS_BUDZET          decimal,
   DUZINA_TRAJANJA      int,
   BROJ_POTREBNIH_RADNIKA int,
   KLJUCNA_REC          varchar(16),
   primary key (ID_POSLA)
);

/*==============================================================*/
/* Table: RADNIK                                                */
/*==============================================================*/
create table RADNIK
(
   ID_KORISNIKA         int not null,
   ID_RADNIKA           int not null AUTO_INCREMENT,
   RAD_ID_RADNIKA       int,
   ID_PONUDE            int not null,
   ID_POSLA             int not null,
   ID_PORUKE            int not null,
   primary key (ID_RADNIKA)
);

/*==============================================================*/
/* Table: ZARADA                                                */
/*==============================================================*/
create table ZARADA
(
   ID_ZARADE            int not null AUTO_INCREMENT,
   ID_RADNIKA           int not null,
   VREDNOST             decimal,
   MESEC                varchar(16),
   primary key (ID_ZARADE)
);

alter table ADMINISTRATOR add constraint FK_PRIPADAJU3 foreign key (ID_KORISNIKA)
      references KORISNIK (ID_KORISNIKA) on delete restrict on update restrict;

alter table FAJLOVI add constraint FK_UPLOADUJE foreign key (ID_RADNIKA)
      references RADNIK (ID_RADNIKA) on delete restrict on update restrict;

alter table OCENA add constraint FK_RELATIONSHIP_6 foreign key (ID_POSLA)
      references POSLOVI (ID_POSLA) on delete restrict on update restrict;

alter table OCENA add constraint FK_RELATIONSHIP_7 foreign key (ID_RADNIKA)
      references RADNIK (ID_RADNIKA) on delete restrict on update restrict;

alter table PONUDA add constraint FK_IMA foreign key (ID_POSLA)
      references POSLOVI (ID_POSLA) on delete restrict on update restrict;

alter table POSLODAVAC add constraint FK_PRIPADAJU2 foreign key (ID_KORISNIKA)
      references KORISNIK (ID_KORISNIKA) on delete restrict on update restrict;

alter table POSLODAVAC add constraint FK_SALJE_PRIMA foreign key (ID_PORUKE)
      references PORUKA (ID_PORUKE) on delete restrict on update restrict;

alter table POSLOVI add constraint FK_KREIRA foreign key (ID_POSLODAVCA)
      references POSLODAVAC (ID_POSLODAVCA) on delete restrict on update restrict;

alter table RADNIK add constraint FK_ANGAZOVANJE foreign key (ID_POSLA)
      references POSLOVI (ID_POSLA) on delete restrict on update restrict;

alter table RADNIK add constraint FK_POSTAVLJA foreign key (ID_PONUDE)
      references PONUDA (ID_PONUDE) on delete restrict on update restrict;

alter table RADNIK add constraint FK_PRIMA_SALJE foreign key (ID_PORUKE)
      references PORUKA (ID_PORUKE) on delete restrict on update restrict;

alter table RADNIK add constraint FK_PRIPADAJU foreign key (ID_KORISNIKA)
      references KORISNIK (ID_KORISNIKA) on delete restrict on update restrict;

alter table RADNIK add constraint FK_VODJA_TIMA foreign key (RAD_ID_RADNIKA)
      references RADNIK (ID_RADNIKA) on delete restrict on update restrict;

alter table ZARADA add constraint FK_ZARADJUJE foreign key (ID_RADNIKA)
      references RADNIK (ID_RADNIKA) on delete restrict on update restrict;
