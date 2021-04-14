#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct person{
  char name[50];
  int age;
  struct person *next;
} person;

void print(person *root) {
  person * per = root;
  while(per != NULL) {
    printf("Name: %s, age: %d, next: %s\n", per->name, per->age, per->next->name);
    per = per->next;
  }
  if(per == NULL){
    printf("\n");
  }
}

void insert(person *per, person** root){
  // If there are no elements in the list
  if(*root == NULL) {
    *root = per;
    printf("Inserted user succesfully\n");
    return;
  }

  // If the inserted person name alphabetical order is less we swap
  if(strcmp(per->name, (*root)->name) < 0) {
    per->next = *root;
    *root = per;
    printf("Inserted user succesfully\n");
    return;
  }

  // If the inserted person name alphabetical order is more we continue
  insert(per, &((*root)->next));
}

void delete(char* name, person* root, person* prev){
  // If the person is null it means we reached the end of the list
  if(root == NULL){
    printf("Person not found\n");
    return;
  }

  // If the current person name is equal to the param name, we delete
  if(strcmp((root)->name, name) == 0){
    // We need to set the previous person next's reference to NULL to avoid having the following inserted person next's reference point to itself
    if(root->next == NULL){
      prev->next = NULL;
      free(root);
    }else if(prev != NULL){
      prev->next = root->next;  
      free(root);
    }else{
      *root = *root->next;
    }

    printf("Deleted user succesfully\n");
    return;
  }

  // If the current person name is not equal to the param name, we continue searching
  delete(name, ((root)->next), root);
  
}


void updateAge(char* name, int new_age, person* root){
  // If the person is null it means we reached the end of the list
  if(root == NULL){
    printf("Person not found\n");
    return;
  }

  // If the current person name is equal to the param name, we update its age
  if(strcmp((root)->name, name) == 0){
    (root->age) = new_age;
    printf("Updated age succesfully\n");
    return;
  }
  updateAge(name, new_age, ((root)->next));
}

int main(){
  char name[500] = "";
  int age;
  person *root = NULL;
  person *per;
  int option = -1;
    
  while(option != 0){
    printf("Available operations:\n\n\t0. Exit\n\t1. Insert person\n\t2. Delete person\n\t3. Update a person's age\n\t4. Print the list\n\nSelect an operation: ");
    scanf("%i", &option);
    printf("\n");

    if(option == 0){
      printf("Exiting...\n");
    }else if (option == 1){
      //Insert
      printf("Name: ");
      scanf("%s", name);
      printf("Age: ");
      scanf("%i", &age);
      printf("\n");

      per = (person *) malloc(sizeof(person));
      strcpy(per->name, name);
      per->age = age;
      per->next = NULL;
      insert(per, &root);
      
      print(root);

    }else if (option == 2){
      //Delete
      printf("Name: ");
      scanf("%s", name);
      printf("\n");

      delete(name, root, NULL);

      print(root);
      
    }else if (option == 3){
      //update age
      printf("Name: ");
      scanf("%s", name);
      printf("Age: ");
      scanf("%i", &age);
      printf("\n");

      updateAge(name, age, root);
      
      print(root);
    
    }else if(option == 4){
      print(root);
    }else{
      printf("Select a valid option (0, 1, 2, 3)\n\n");
    }
    
  }
}