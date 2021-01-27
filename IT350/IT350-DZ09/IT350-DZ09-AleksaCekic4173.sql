-- Zadatak 1. ((4173 % 30) + 1 = 4, Zadatak 4): 
SELECT smer_naziv, smer_opis FROM smer;
-- Zadatak 2. ((4173 + 4) % 30 + 1, Zadatak 8): 
SELECT * FROM predmet WHERE espb in (5, 7, 9); 
-- Ne izbacuje nista zato sto u bazi nema predmeti koje vrede 5, 7 ili 9 espb poena.
-- Zadatak 3. ((4173 + 8) % 30 + 1, Zadatak 12)
SELECT * FROM predmet WHERE br_cas_vezbe > 2;