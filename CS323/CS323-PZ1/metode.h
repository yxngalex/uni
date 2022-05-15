#pragma once

typedef struct {
	char ime[20];
	char sifra[20];
	int brojTokena;
} Igrac;

int lyckySix(int* pokazivacNaNiz);

void blackJack(Igrac* igrac1, Igrac* igrac2, int ulogPrvogIgraca, int ulogDrugogIgraca);

void blackJackSolo(Igrac* igrac1, int ulogIgraca); 


