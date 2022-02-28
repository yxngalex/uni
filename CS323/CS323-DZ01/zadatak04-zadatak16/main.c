#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
    Zadatak 4. Napisati program koji simulira bacanje kocke, tj. daje slucajan broj iz intevala[1, 6].
    Koristiti funkciju rand() iz standardne biblioteke stdlib.h
  */

/*
    Zadatak 16. Napisati C program koji racuna sledeci zadatak:
        9.5 X 4.5 - 2.5 X 3
       ----------------------
            45.5 - 3.5
  */

int main()
{
    int r;
    float calc = ((9.5 * 4.5) - (2.5 * 3)) / (45.5 - 3.5);

    srand(time(0));
    r = (rand() % 6 + 1);

    printf("04: Generated number 1-6: %d \n", r);

    printf("16: Calculated number is: %.2f \n", calc);

    return 0;
}
