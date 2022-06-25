#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*

    Zadatak 4:
    Napisati program koji formira niz od 1000 slucajno odabranih elemenata iz intervala od 0 - 9999,
    i odredjuje najveci element niza.

 */

/*

    Zadatak 16:
    Napisati funkciju koja cita liniju po liniju iz konzole i za svaku ucitanu liniju ispisuje broj
    znakova koji su razliciti od praznine. Maksimalna duzina linije koje se cita neka bude 20 karaktera.

 */

int getMaxElement(int arr[]);

void readInput();

int main() {
    // Zadatak 4

    int arr[1000];
    int largestElement, i;

    srand(time(0));

    for (i = 0; i < 1000; ++i) {
        arr[i] = (rand() % 9999 + 1);
    }

    for (i = 0; i < 1000; ++i) {
        printf("%d\n", arr[i]);
    }

    largestElement = getMaxElement(arr);

    printf("Largest element in array is: %d\n", largestElement);

    // Zadatak 16

    readInput();

    return 0;
}

int getMaxElement(int arr[]) {
    int lElem = 0;
    int i;
    for (i = 0; i < 1000; ++i) {
        if (arr[0] < arr[i]) {
            arr[0] = arr[i];
            lElem = arr[0];
        }
    }
    return lElem;
}

void readInput() {
    char c[20];
    char randomletter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"[random() % 26];
    int i = 0;
    long l;

    printf("Type in a string: ");
    scanf("%19s", &c);

    printf("%2s", &randomletter);
}
