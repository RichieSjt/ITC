#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct person{
    char name[50];
    int age;
    struct next_person *next;
} person;

void insert(person *per, person** root){
    // Start of the list
    if(*root == NULL) {
        *root = per;
        return;
    }
    
    if(strcmp(per->name, (*root)->name < 0) {
        per->next = *root;
        *root = per;
        return;
    }

    person *per1 = *root;
    person *per2 = per1->next;

    while(strcmp(per->name, per1->name) < 0) {
        per2 = per1;
        per1 = per1->next;
    }
    per->next = per2;
    per1->next = per;

}

void print(person *root) {
    person * per = root;
    while(per != NULL) {
        printf("Name: %s, age: %d\n", per->name, per->age);
        per = per->next;
    }
}

int main(){
    person * root = NULL;
    person *per;
    per = (person *) malloc(sizeof(person));
    strcpy(person->name, "Juan");
    per->age = 25;
    per->next = NULL;
    insert(per, &root);

}