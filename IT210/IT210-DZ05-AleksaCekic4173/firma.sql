CREATE DATABASE firma;

CREATE TABLE Radnik(
ID integer PRIMARY KEY;
ime varchar(255) NOT NULL;
prezime varchar(255) NOT NULL;
odeljenje varchar(255) NOT NULL;
plata int NOT NULL;
grs int
);

SELECT AVG(plata) AS Ukupno
FROM Radnik;

SELECT MIN(plata) AS NajmanjaPlata
FROM Radnik;

SELECT MAX(plata) AS NajvecaPlata
FROM Radnik;

SELECT * FROM Radnik ORDER BY grs ASC;


