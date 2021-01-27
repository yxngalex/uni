CREATE DATABASE bolnica_db;

CREATE TABLE Bolnica (
ID int PRIMARY KEY,
ImeZemlje varchar(100) NOT NULL,
ImeZaposlenog varchar(100) NOT NULL,
prezimeZaposlenog varchar(100) NOT NULL,
glavniNaOdeljenju varchar(150) NOT NULL,
kolikoZaposleniImaGodina int NOT NULL,
imePacijenta varchar(100) NOT NULL,
datumPregleda DATE NOT NULL
)

INSERT INTO Bolnica
VALUES(1, "Srbija", "Ivan", "Ivkovic","C3",  21, "Michael", #03/04/2020#);

INSERT INTO Bolnica
VALUES(2, "Nemacka", "Ibrahim", "Meliodas","A2",  42, "Nemanja", #05/01/2020#);

INSERT INTO Bolnica
VALUES(3, "Turska", "Mustafa", "Ibrahimovic","D26",  102, "Mila", #22/12/2020#);

INSERT INTO Bolnica
VALUES(4, "Srbija", "Nikola", "Popovic","E11",  18, "Predrag", #29/02/2020#);

INSERT INTO Bolnica
VALUES(5, "SAD", "Eve", "Smith","F1",  32, "Lenka", #15/06/2021#);

INSERT INTO Bolnica
VALUES(6, "Srbija", "Dragoslava", "Mitrovic","C4",  45, "Levi", #25/12/2020#);

INSERT INTO Bolnica
VALUES(7, "Francuska", "Mihel", "Bernard","V12",  55, "Legolas", #01/01/2021#);

INSERT INTO Bolnica
VALUES(8, "Meksiko", "Pedro", "Cruz","A3",  50, "Ivko", #19/09/2020#);

INSERT INTO Bolnica
VALUES(9, "Hrvatska", "Jelica", "Hor","E4",  71, "Ivan", #15/06/2021#);

INSERT INTO Bolnica
VALUES(10, "Spanija", "Antonio", "Banderas","A2",  53, "Lenin", #10/03/2020#);

SELECT *
FROM Bolnica
WHERE ImeZemlje NOT LIKE("Srbija");

SELECT *
FROM Bolnica
WHERE glavniNaOdeljenju LIKE ("A2");

SELECT *
FROM Bolnica
WHERE glavniNaOdeljenju LIKE ("A3");

SELECT *
FROM Bolnica
WHERE glavniNaOdeljenju LIKE ("C3");

SELECT imePacijenta
FROM Bolnica
WHERE datumPregleda LIKE (#10/03/2020#);

SELECT prezimeZaposlenog
FROM Bolnica
WHERE imePacijenta LIKE ("L*");

SELECT *
FROM Bolnica
WHERE kolikoZaposleniImaGodina > 27 AND kolikoZaposleniImaGodina < 35;