#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
    Napisati program koji slučajno bira 100.000 celih brojeva iz intervala 0 - 9, prebrojava
    koliko puta je izabran uzastopno isti broj. Npr: ..., 2, 3, 7, 7, 5, 9, 0, 0, 2, 1, 6, 3, 8, 8, ....
    Koristiti funkciju rand() iz biblioteke stdlib.h.
 */


int *getRandomElements() {
    static int arr[100000];
    int i;

    srand(time(0));

    for (i = 0; i < 100000; ++i) {
        arr[i] = (rand() % 9 + 1);
    }

    return arr;
}

int count(const int a[], const char exists[], int num_elements, int value) {
    int i, count = 0;

    for (i = 0; i < num_elements; ++i) {
        if (a[i] == value) {
            if (exists[i] != 0) return 0;
            ++count;
        }
    }
    return (count);
}

/*
    Napisati program koji za unete vrednosti x i y, racuna vrednost funkcije
    z=min(x,y) za y>=0
    z=max(x,y) za y<0
 */

int max(int x, int y);

int min(int x, int y);

int main() {

    // Zadatak 16

    int *p;
    int i, num_occ;
    char exists[100000] = {0};

    p = getRandomElements();

    for (i = 0; i < sizeof p; ++i) {
        num_occ = count(p, exists, 100000, p[i]);
        if (num_occ) {
            exists[i] = 1;
            printf("The value %d was found %d times. \n", p[i], num_occ);
        }
    }

    // Zadatak 37

    int x, y;
    int z;

    printf("Enter X :");
    scanf("%d", &x);

    printf("Enter Y :");
    scanf("%d", &y);

    if (y >= 0) {
        z = min(x, y);
        printf("Min: %d", z);
    } else if (y < 0) {
        z = max(x, y);
        printf("Max: %d", z);
    }

    return 0;
}

int max(int x, int y) {
    return (x > y) ? x : y;
}

int min(int x, int y) {
    return (x > y) ? y : x;
}
