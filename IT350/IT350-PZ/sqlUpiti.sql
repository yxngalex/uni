-- a. Sve trenutno aktivne poslove na kojima se radi građevina

SELECT *
FROM poslovi AS P
WHERE KLJUCNA_REC LIKE "Aktivan" AND NAZIV LIKE "Gradjevina";

-- b. Poslodavce, uređene rastući po broju projekata koji su postavili ili po imenu poslodavca (moguće je selektovati koje uređenje želimo – da li po imenu ili broju poslova)

-- 1.
SELECT ID_POSLODAVCA, COUNT(*) AS brojProjekata
FROM poslovi
GROUP BY ID_POSLODAVCA
ASC;

-- 2.
SELECT K.ime
FROM poslovi
JOIN poslodavac AS P ON P.ID_POSLODAVCA = poslovi.ID_POSLODAVCA
JOIN korisnik as K ON K.ID_KORISNIKA = P.ID_KORISNIKA
ORDER BY K.ime
ASC;

-- c. Izveštaj o poslodavcima sa poslovima u svim stanjima, aktivnim poslovima, poslovima u pregovorima, poslovima u toku I završenim poslovima (moguće je kroz aplikaciju selektovati sve ili jedno stanje).

SELECT *
FROM poslovi
JOIN poslodavac AS P ON P.ID_POSLODAVCA = poslovi.ID_POSLODAVCA
JOIN korisnik AS K ON K.ID_KORISNIKA = P.ID_KORISNIKA

-- d. Radnike, uređene po broju poslova koje su završili ili po imenu (moguće je selektovati koje uređenje želimo).

-- 1.
SELECT K.ime, K.prezime, K.godine, COUNT(*) AS brojPoslova
FROM radnik
JOIN poslovi AS POS ON POS.ID_POSLA = radnik.ID_POSLA
JOIN korisnik AS K ON K.ID_KORISNIKA = radnik.ID_KORISNIKA
GROUP BY POS.kljucna_rec
ORDER BY brojPoslova DESC;

-- 2.
SELECT K.ime
FROM radnik
JOIN korisnik AS K ON K.ID_KORISNIKA = radnik.ID_KORISNIKA
ORDER BY K.ime;

-- e. Sve radnike koje koji trenutno nisu angažovani, ali I radnike koji rade na nekom poslu (selektovati kroz aplikaciju šta želimo da prikažemo)

-- 1.
SELECT *
FROM radnik
WHERE ID_POSLA IS NULL;

-- 2.
SELECT *
FROM radnik
WHERE ID_POSLA IS NOT NULL;

-- Oko poruke razgovarati sa profesorkom!
-- f. Projekte poređane po broju poruka koji su na njima razmenjeni

-- g. Radnike sa najvećom zaradom u svakom mesecu u godini 

SELECT MESEC,MAX(VREDNOST) AS maxVal
FROM zarada
JOIN radnik ON radnik.ID_RADNIKA = zarada.ID_RADNIKA
GROUP BY MESEC ASC;

-- h. Radnike sa najvećom ocenom od strane poslodavaca

SELECT korisnik.ime, korisnik.prezime, MAX(ocena)
FROM ocena
JOIN radnik ON radnik.ID_RADNIKA = OCENA.ID_RADNIKA
JOIN korisnik ON korisnik.ID_KORISNIKA = radnik.ID_KORISNIKA
GROUP BY OCENA desc;