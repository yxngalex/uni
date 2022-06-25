/*
        9. Napisati program koji učitava n strukturnih promenljivih ucenik (ime, adresa, razred, odeljenje)
        i zapisuje podatke u datoteku ucenik.txt. Podaci jednog učenika su u jednom redu. Slika ispod
        ilustruje način upisivanja u datoteci.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
    char name[30];
    char address[50];
    int year;
    int class;
};

int main() {

    const char *fname = "ucenik.txt";
    int st;
    struct student *students;
    struct student *s;
    FILE *f = NULL;
    int c;

    printf("Please enter the number of students: ");
    scanf("%d", &st);

    students = (struct student *) calloc(st, sizeof(struct student));
    for (int i = 0; i < st; i++, students++) {
        char name[30], address[50];
        int year, class;

        memset(name, 0, 30);
        memset(address, 0, 50);

        getchar();

        printf("Enter address: ");
        fgets(address, 50, stdin);
        strtok(address, "\n");

        printf("Enter year: ");
        scanf("%d", &year);

        printf("Enter class: ");
        scanf("%d", &class);

        strcpy(students->name, name);
        strcpy(students->address, address);
        students->year = year;
        students->class = class;

    }
    students -= st;
    f = fopen(fname, "w+");
    if (f == NULL) {
        perror("Error opening file");
        exit(-1);
    }
    for (int j = 0; j < st; j++, students++) {
        printf("0x%x name: %s\n", &students->name, students->name);
        printf("0x%x addr: %s\n", &students->address, students->address);
        printf("0x%x year: %d\n", &students->year, students->year);
        printf("0x%x clss: %d\n\n", &students->class, students->class);
        fprintf(f, "%35s %50s %3d%3d\n", students->name, students->address, students->year, students->class);
    }
    students -= st;

    if (f != NULL) {
        fclose(f);
    }

    free(students);
    return 0;
}
