# Zadatak #1

Napisati funkciju sa dva ulazna parametra: <b>ime</b> i <b>br_indeks</b>

Vrednost br_indeks (četvorocifrena promenljiva) određuje broj elemenata u nizu koji se kreira unutar funkcije.

Elementi niza jesu sledeći:

- Ukoliko je broj slova u promenljivoj ime paran, generisati cele brojeve od 0 do br_indeks sa uniformnom raspodelom
- Ukoliko je broj sloba u promenljivoj ime neparan, generisati razlomljene brojeve u opsegu od negativne vrednosti prve
  dve cifre, to pozitivne vrednosti druge dve cifre u br_indeks.

Koristiti random biblioteku za generisanje brojeva.

Sortirati niz korišćenjem for petlje i privremene promenljive.

Kao povratnu vrednost vratiti sortirani niz.

U glavnom programu uneti promenljive ime i br_indeks, pozvati funkciju sa tim promenljivima i odštampati sortirani niz.

# Zadatak #2

Napisati rekurzivnu funkciju za računanje Fibonačijevog niza do elementa n.

Napisati iterativnu funkciju za računanje Fibonačijevog niza do elementa n.

Opisati sličnosti i razlike u ova dva pristupa.

### Opis sličnosti i razlika

Sličnosti su u tome što je rezultat potpuno isti.

Razlike između ova dva pristupa za prikaz fibonačijevog niza jesu u tome što kod rekurzivnog pristupa
kod je manji i čitljiviji, ali zato zauzima više memorije i vremena procesora zbog čestih poziva funkcija
nego kod iterativnog pristupa.