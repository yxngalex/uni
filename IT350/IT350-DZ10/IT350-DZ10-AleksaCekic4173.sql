-- Zadatak 1. (4. zadatak)
SELECT *
FROM student AS S
JOIN smer AS SM ON SM.smer_id = S.smer_id 
WHERE S.grad_rodjenja NOT LIKE "Beograd" AND SM.smer_naziv LIKE "Informacione Tehnologije"

-- Zadatak 2. (7. zadatak)

SELECT P.predmet_id, naziv, COUNT(*) AS broj_polozenih_studenata
FROM predmet AS P
JOIN overa AS O ON O.predmet_id = P.predmet_id 
WHERE ocena > 5
GROUP BY P.predmet_id

-- Zadatak 3. (14. zadatak)

SELECT ime, prezime, COUNT(*) AS broj_polozenih_ispita
FROM student AS S
JOIN overa AS O ON O.indeks = S.indeks 
WHERE ocena > 5
GROUP BY ime