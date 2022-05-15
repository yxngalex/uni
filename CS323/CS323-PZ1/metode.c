#include <stdlib.h>
#include <time.h>
#include "metode.h"

int lyckySix(int* pokazivacNaNiz) {
	int i, j, brojPogodaka = 0;
	srand(time(0));
	for (i = 0; i < 6; i++)
	{
		int broj = rand() % 50;
		
		for (j = 0; j < 6; j++) {
			if (*(pokazivacNaNiz + j) == broj) {
				brojPogodaka++;
				*(pokazivacNaNiz + j) = 51;
			}
		}
	}

	return brojPogodaka;
}

void blackJack(Igrac* igrac1, Igrac* igrac2, int ulogPrvogIgraca, int ulogDrugogIgraca) {
	int i, j, trenutniZbir = 0;
	srand(time(0));
	for (i = 0; i < 21; i++) {

		int broj = rand() % 14 + 1;
		trenutniZbir += broj;
		if (trenutniZbir >= 21 && i % 2 == 0) {
			igrac1->brojTokena += ulogPrvogIgraca * 3;
			igrac2->brojTokena -= ulogDrugogIgraca * 3;
			break;
		}
		else if (trenutniZbir >= 21 && i % 2 != 0) {
			igrac2->brojTokena += ulogPrvogIgraca * 3;
			igrac1->brojTokena -= ulogPrvogIgraca * 3;
			break;
		}
	}
}

void blackJackSolo(Igrac* igrac1, int ulogIgraca) {
	int i, j, trenutniZbir = 0;
	srand(time(0));
	for (i = 0; i < 21; i++) {

		int broj = rand() % 14 + 1;
		trenutniZbir += broj;
		
		if (trenutniZbir >= 21 && i % 2 == 0) {
			igrac1->brojTokena += ulogIgraca * 3;
			break;
		}
		else if (trenutniZbir >= 21 && i % 2 != 0) {
			igrac1->brojTokena -= ulogIgraca * 3;
			break;
		}
	}
}