#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int * getRandomElements()
{
    static int arr[100000];
    int i;

    srand(time(0));

    for (i = 0; i < 100000; ++i) {
        arr[i] = (rand() % 9 + 1);
    }

    return arr;
}

int count(const int a[], const char exists[], int num_elements, int value)
{
    int i, count = 0;

    for (i = 0; i < num_elements; ++i) {
        if (a[i] == value) {
            if (exists[i] != 0) return 0;
            ++count;
        }
    }
    return (count);
}

int main(void)
{

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

    return 0;
}