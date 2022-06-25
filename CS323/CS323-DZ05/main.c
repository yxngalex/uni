#include <stdio.h>
#include <string.h>

#define MAX 5

// 14
// Deklarisati strukturu Automobil koja ima podatke: model, godina proizvodnje, cena,
// pređena kilometraža. Učitati podatke o N automobila u glavnom programu. Napisati
// funkciju koja prikazuje podatak o automobilu čija je godina proizvodnje 2000., a cena
// najmanja.

// 34
// Napisati funkciju u kojoj se formira string s3 umetanjem stringa s2 u string s1 pocev
// od pozicije p. Novodobijeni string s3 formirati kao dinamicki niz u okviru funkcije, a
// zatim ga vratiti u glavni program. Testirati rad funkcije u glavnom programu.

typedef struct Car {
    char model[10];
    int maintenanceYear;
    float price;
    int mileage;
} car;

void getValues(struct Car car[]) {
    int i;
    struct Car c;
    float min = 100000;

    for (i = 0; i < MAX; i++) {
        if (car[i].maintenanceYear == 2000) {
            if (car[i].price < min) {
                min = car[i].price;
                c = car[i];
            }
        }
    }
    printf("The car with the lowest price is: %s \n", c.model);
    printf("And it costs: %f \n", c.price);
}

void embeddedStrings();

int main() {
    int i;
    struct Car car[MAX];

    strcpy((car[0].model), "Golf 4");
    strcpy((car[1].model), "Rx7 FD3s");
    strcpy((car[2].model), "M3 E46");
    strcpy((car[3].model), "R32");
    strcpy((car[4].model), "R34");


    car[0].price = (float) 452.23;
    car[1].price = (float) 1234.123;
    car[2].price = (float) 561.43;
    car[3].price = (float) 231.23;
    car[4].price = (float) 123.00;

    car[0].maintenanceYear = 2000;
    car[1].maintenanceYear = 2000;
    car[2].maintenanceYear = 2002;
    car[3].maintenanceYear = 1999;
    car[4].maintenanceYear = 1996;

    car[0].mileage = 23401;
    car[1].mileage = 12345;
    car[2].mileage = 56789;
    car[3].mileage = 54321;
    car[4].mileage = 98765;

    getValues(car);

    embeddedStrings();

    return 0;
}

void embeddedStrings() {

    int i, p = 4;
    char s1[p];
    char s2[] = {'A', 'l', '\0'};
    char s3[] = {'e', 'x', '\0'};


    printf("%s \n", strcat(s2, s3));

}
