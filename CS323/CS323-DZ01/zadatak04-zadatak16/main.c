#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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
