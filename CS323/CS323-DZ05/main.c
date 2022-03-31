#include <stdio.h>

typedef struct Car {
    char model[10];
    int maintenanceYear;
    float price;
    int mileage;
} car;

struct car *setValues(struct Car *c);

void getValues(struct Car *c[]);

int main() {
    int n, i;
    struct Car car1;
    struct car *cList[5];

    printf("How many cars do you want: ");
    scanf("%d", &n);

    if (n > 5) {
        printf("Max amount of number to enter is 5");
    } else {

        for (i = 0; i < 5; ++i) {
            cList[i] = setValues(&car1);
        }

        getValues((struct Car **) cList);

    }
    return 0;
}

struct car *setValues(struct Car *c) {

    int i;
    struct car *cList[5];

    printf("Please enter model: ");
    scanf("%s", &c->model);
    printf("Please enter maintanance year: ");
    scanf("%d", &c->maintenanceYear);
    printf("Please enter price: ");
    scanf("%f", &c->price);
    printf("Please enter mileage: ");
    scanf("%d", &c->mileage);

    for (i = 0; i < 5; ++i) {
        cList[i] = (struct car *) c;
    }

    return cList;
}

void getValues(struct Car *c[]) {
    int i;
    struct Car *temp;

    for (i = 0; i < 5; ++i) {
        if (temp->price > c[i]->price) {
            temp = c[i];
            if (c[i]->maintenanceYear == 2000) {
                printf("Car model: %s\n", c[i]->model);
                printf("Car price: %d\n", c[i]->price);
                printf("Car mainteinence: %d\n", c[i]->maintenanceYear);
                printf("Car mileage: %d\n", c[i]->mileage);
            }
        }
    }
}