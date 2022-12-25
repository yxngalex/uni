## Zadatak 1
Napisati python program koji beleži informacije o položenim ispitima:

Student upisuje sa konzole položeni ispit, najpre šifru predmeta, pa ocenu. Ova informacija se čuva u imeniku.

Iz imenika, preko pandas paketa napraviti CSV datoteku u kojoj je jedna kolona Predmet (vrednosti su šifre predmeta) a druga kolona Ocena (vrednosti su ocene).

Iz ovih podataka, računati:

- Broj ocena (koliko ima šestica, sedmica, itd).
- Broj položenih ispita po šifri predmeta (koliko ima CS predmeta, IT predmeta, SE predmeta, itd.)
- Promenu prosečne ocene (kako se menja prosečna ocena po položenom predmetu)
 
Na jednoj figuri iscrtati raspored ocena kao pie plot (gornji levi subplot), broj položenih predmeta kao horizontalni bar plot (gornji deni subplot) i promenu prosečne ocene kao linijski plot (donji subplot cele dužine).