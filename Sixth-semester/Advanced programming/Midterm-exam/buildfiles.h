#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#include "nodes.h"


// void print(node1 *root) {
//   node1 * w = root;
//   while(w != NULL) {
//     printf("Name: %s, first_entry: %d, next: %s\n", w->word, w->first_entry, w->next->word);
//     w = w->next;
//   }
//   if(w == NULL){
//     printf("\n");
//   }
// }

void writeFile1(node1 *root, FILE *file1) {
  node1 * w = root;
  
  while(w != NULL) {
    //creating node file 1 structure
    nodeFile1 wf1;
    strcpy(wf1.word, w->word);
    wf1.first_entry = w->first_entry;

    fwrite(&wf1, sizeof(nodeFile1), 1, file1);

    w = w->next;
  }
}

void insert(node1 *toInsert, node1** root, FILE *file2, int line_counter){
  // If there are no elements in the list
  if(*root == NULL) {
    *root = toInsert;

    nodeFile2 nf2;
    nf2.entry = line_counter;
    nf2.next_entry = -1;

    fwrite(&nf2, sizeof(nodeFile2), 1, file2);
  
    return;
  }
  
  // If the words are the same 
  if(strcmp(toInsert->word, (*root)->word) == 0) {
    
    // Write the new line at which the word repeats with its next set to -1 
    // at the end of file 2
    
    nodeFile2 nf2;
    nf2.entry = line_counter;
    nf2.next_entry = -1;
    fwrite(&nf2, sizeof(nodeFile2), 1, file2);

    // Save the last inserted entry position
    unsigned long last_pos = ftell(file2)/sizeof(nodeFile2)-1;

    // Obtain the first entry from the word
    int fe = (*root)->first_entry;

    // Set the cursor to that first entry
    fseek(file2, sizeof(nodeFile2)*fe, SEEK_SET);
    
    // Read the element at the cursor
    fread(&nf2, sizeof(nodeFile2), 1, file2);
    // Bring the cursor one step back because it increments after reading
    fseek(file2, -1*sizeof(nodeFile2), SEEK_CUR);

    int next_pos = nf2.next_entry;

    while(next_pos != -1) {
      fseek(file2, sizeof(nodeFile2)*next_pos, SEEK_SET);
      fread(&nf2, sizeof(nodeFile2), 1, file2);
      fseek(file2, -1*sizeof(nodeFile2), SEEK_CUR);
      next_pos = nf2.next_entry;
    }

    // Assign the previously saved entry position to next entry of the first entry
    nf2.next_entry = last_pos;

    fwrite(&nf2, sizeof(nodeFile2), 1, file2);
    
    // Reset the cursor to its natural position
    fseek(file2,sizeof(nodeFile2)*(last_pos+1), SEEK_SET);

    return;
  }

  // If the inserted word alphabetical order is less we swap
  if(strcmp(toInsert->word, (*root)->word) < 0) {
    toInsert->next = *root;
    *root = toInsert;

    nodeFile2 nf2;
    nf2.entry = line_counter;
    nf2.next_entry = -1;

    fwrite(&nf2, sizeof(nodeFile2), 1, file2);
    
    return;
  }

  // If the inserted word alphabetical order is more we continue
  insert(toInsert, &((*root)->next), file2, line_counter);
}

void buildFiles() {
  const int LINE_SIZE = 100;
  char line[LINE_SIZE];
  int line_counter = 1;
  char *word;

  node1 *root = NULL;
  node1 *word_node;

  const char *delimiters = "\n\t'`?-!:;,.\"() ";

  FILE *file1 = fopen("file1", "r");
  FILE *file2 = fopen("file2", "r");

  // Checking if the files have already been built
  fseek(file1, 0, SEEK_END);
  int size = ftell(file1);
  fseek(file1, 0, SEEK_SET);

  fclose(file1);
  fclose(file2);
  
  // If the files are empty we build them
  if(size == 0){
    FILE *alice_file = fopen("alice.txt", "r");
    file1 = fopen("file1", "wb+");
    file2 = fopen("file2", "wb+");

    while(fgets(line, LINE_SIZE, alice_file)) {
      //printf("string is: %s\n", line);
      word = strtok(line, delimiters);

      while(word != NULL){
        // Converting the word to lower case
        for(int i = 0; word[i]; i++){
          word[i] = tolower(word[i]);
        }
        
        word_node = (node1 *) malloc(sizeof(node1));
        
        strcpy(word_node->word, word);
        word_node->first_entry = ftell(file2)/sizeof(nodeFile2);
        word_node->next = NULL;

        insert(word_node, &root, file2, line_counter);

        // We continue tokenizing the initial line
        word = strtok(NULL, delimiters);
      }
      line_counter++;
    }

    // print(root);
    writeFile1(root, file1);

    fclose(file1);
    fclose(file2);
    fclose(alice_file);
  }  
}