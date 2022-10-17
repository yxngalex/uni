#include <stdio.h>
#include <math.h>

int main() {
    int n;

    printf("Enter a number: ");
    scanf("%d", &n);

    printf((ceil(log2(n)) == floor(log2(n))) ? "Input number is a power of 2\n" : "Input number is not a power of 2\n");

    return 0;
}
