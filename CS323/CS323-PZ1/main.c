#include <stdio.h>
#include <string.h>
#include <malloc.h>
#include "metode.h"

int main() {
    FILE *in, *out;

    Igrac igraci[2];

    int bool = 1, izbor, brojBrojeva = 0, i, ulozeno, ulogDrugi;
    int *unetiNiz, brojPogodaka;

    char sifra[20];

    in = fopen("file/podaci.txt", "r");
    out = fopen("file/pobednik.txt", "w");

    if (in == NULL) {
        printf("Doslo je do greske prilikom ucitavanja podataka !!");
    }

    if (out == NULL) {
        printf("Doslo je do greske prilikom upisivanja podataka !!");
    }

    i = 0;

    while (fscanf(in, "%s %s %d", &igraci[i].ime, &igraci[i].sifra, &igraci[i].brojTokena) == 3) {
        i++;
    }

    printf("%s %s %d\n", igraci[0].ime, igraci[0].sifra, igraci[0].brojTokena);
    printf("%s %s %d\n", igraci[1].ime, igraci[1].sifra, igraci[1].brojTokena);

    while (bool) {
        printf("*******************\n");
        printf("Prikaz opcija : \n");
        printf("1. Izaberite ovu opciju ukoliko zelite da igrate igru lucky six.\n");
        printf("2. Izaberite ovu opciju ukoliko zelite da igrate igru Black Jack(solo igra).\n");
        printf("3. Izaberite ovu opciju ukoliko zelite da igrate igru Black Jack(igra sa 2 igraca).\n");
        printf("4. Izlaz iz aplikacije.\n");
        printf("Unesite Vas izbor : \n");
        scanf("%d", &izbor);

        switch (izbor) {
            case 1:
                printf("Kao koji igrac zelite da igrate (unesite broj 1 ili 2)\n");
                scanf("%d", &i);
                i--;
                int brIgraca = i;
                printf("Unesite Vasu sifru : ");
                scanf("%20s", sifra);

                int podudaranje = strcmp(sifra, igraci[i].sifra);

                if (podudaranje == 0) {
                    printf("Unesite broj koliko broja zelite da unesete (broj mora da bude između 3 i 7)\n");

                    scanf("%d", &brojBrojeva);

                    unetiNiz = malloc(brojBrojeva * sizeof(int));
                    if (brojBrojeva > 3 && brojBrojeva < 7) {
                        for (i = 0; i < brojBrojeva; i++) {
                            scanf("%d", &unetiNiz[i]);
                        }
                    } else {
                        printf("Unesite broj koji je veci od 3 i manji od 7.");
                        continue;
                    }

                    brojPogodaka = lyckySix(unetiNiz);

                    free(unetiNiz);

                    if (brojPogodaka > 3) {
                        printf("Imali ste vise od 3 pogodka i osvojili ste : %d tokena. \n", brojPogodaka * 100);
                        igraci[0].brojTokena += brojPogodaka * 100;
                        printf("%s %d\n", igraci[0].ime, igraci[0].brojTokena);
                        printf("%s %d\n", igraci[1].ime, igraci[1].brojTokena);
                    } else {
                        igraci[0].brojTokena -= (6 - brojPogodaka) * 100;
                        printf("Niste imali vise od 3 pogodka i izgubili ste %d tokena.\n", (6 - brojPogodaka) * 100);
                        printf("%s %d\n", igraci[0].ime, igraci[0].brojTokena);
                        printf("%s %d\n", igraci[1].ime, igraci[1].brojTokena);
                    }

                    if (igraci[0].brojTokena <= 0) {
                        printf("Igrac 2 je pobedio.\n");
                        fputs("Igrac 2 je pobedio", out);
                        bool = 0;
                    } else if (igraci[1].brojTokena <= 0) {
                        printf("Igrac 1 je pobedio.\n");
                        fputs("Igrac 1 je pobedio", out);
                        bool = 0;
                    }
                }
                break;
            case 2:

                printf("Kao koji igrac zelite da igrate (unesite broj 1 ili 2)\n");
                scanf("%d", &i);
                i--;

                printf("Unesite Vasu sifru : ");
                scanf("%20s", sifra);

                podudaranje = strcmp(sifra, igraci[i].sifra);

                if (podudaranje == 0) {
                    printf("Unesite broj tokena koliko zelite da ulozite u ovoj igri : ");
                    scanf("%d", &ulozeno);

                    if (ulozeno <= igraci[i].brojTokena) {
                        printf("Vase stanje pre igre je je : ime : %s, broj tokena : %d\n", igraci[i].ime,
                               igraci[i].brojTokena);
                        int pre = igraci[i].brojTokena;
                        blackJackSolo(&igraci[i], ulozeno);
                        printf("Vase stanje je : ime : %s, broj tokena : %d\n", igraci[i].ime, igraci[i].brojTokena);
                        if ((pre - igraci[i].brojTokena) < 0) {
                            printf("Vase stanje se povecalo za %d tokena. \n", igraci[i].brojTokena - pre);
                        } else {
                            printf("Vase stanje se smanjilo za %d tokena. \n", (pre - igraci[i].brojTokena));
                        }
                        if (igraci[0].brojTokena <= 0) {
                            printf("Igrac 2 je pobedio.\n");
                            fputs("Igrac 2 je pobedio", out);
                            bool = 0;
                        } else if (igraci[1].brojTokena <= 0) {
                            printf("Igrac 1 je pobedio.\n");
                            fputs("Igrac 1 je pobedio", out);
                            bool = 0;
                        }
                    } else {
                        printf("Uneli ste vise tokena nego sto imate, mozete da unesete najvise : %d !!",
                               igraci[i].brojTokena);
                        continue;
                    }
                } else {
                    printf("Nije uneta tacna sifra !!");
                }
                break;
            case 3:

                printf("Unesite sifru prvog igraca\n");

                printf("Unesite Vasu sifru : ");
                scanf("%20s", sifra);

                podudaranje = strcmp(sifra, igraci[0].sifra);

                if (podudaranje == 0) {

                    printf("Unesite sifru drugog igraca\n");

                    printf("Unesite Vasu sifru : ");
                    scanf("%20s", sifra);

                    podudaranje = strcmp(sifra, igraci[1].sifra);
                    if (podudaranje == 0) {
                        printf("Unesite broj tokena koliko zelite da ulozite u ovoj igri (prvi igrac) : ");
                        scanf("%d", &ulozeno);

                        printf("Unesite broj tokena koliko zelite da ulozite u ovoj igri (drugi igrac) : ");
                        scanf("%d", &ulogDrugi);

                        if (ulozeno <= igraci[0].brojTokena && ulogDrugi <= igraci[1].brojTokena) {

                            int pre = igraci[0].brojTokena;
                            int pre2 = igraci[1].brojTokena;

                            blackJack(&igraci[0], &igraci[1], ulozeno, ulogDrugi);
                            printf("%s %d\n", igraci[0].ime, igraci[0].brojTokena);
                            printf("%s %d\n", igraci[1].ime, igraci[1].brojTokena);

                            if (igraci[0].brojTokena <= 0) {
                                printf("Igrac 2 je pobedio.\n");
                                fputs("Igrac 2 je pobedio", out);
                                bool = 0;
                            } else if (igraci[1].brojTokena <= 0) {
                                printf("Igrac 1 je pobedio.\n");
                                fputs("Igrac 1 je pobedio", out);
                                bool = 0;
                            }

                            if ((pre - igraci[0].brojTokena) < 0) {
                                printf("Stanje prvog igraca se povecalo za %d tokena. \n", igraci[0].brojTokena - pre);
                            } else {
                                printf("Stanje prvog igraca se smanjilo za %d tokena. \n",
                                       (pre - igraci[0].brojTokena));
                            }

                            if ((pre2 - igraci[1].brojTokena) < 0) {
                                printf("Stanje drugog igraca se povecalo za %d tokena. \n",
                                       igraci[1].brojTokena - pre2);
                            } else {
                                printf("Stanje drugog igraca se smanjilo za %d tokena. \n",
                                       (pre2 - igraci[1].brojTokena));
                            }
                        } else {
                            printf("Uneli ste vise tokena nego sto imate !!\n");
                            continue;
                        }
                    } else {
                        printf("Nije uneta tacna sifra drugog igraca !!");
                    }
                } else {
                    printf("Nije uneta tacna sifra prvog igraca !!");
                }
                break;
            case 4:
                printf("Kraj aplikacije...\n");
                printf("*******************\n");
                bool = 0;
                break;
            default:
                printf("Uneta je vrednost koja nije validna, unesite ponovo !!");
                break;
        }
    }
    fclose(in);
    fclose(out);

    return 0;
}
