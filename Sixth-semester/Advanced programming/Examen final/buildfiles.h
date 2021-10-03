#ifndef BUILDFILES_H
#define BUILDFILES_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#include "nodes.h"

void writeFile1(node1 *root, FILE *file1) {
  // Replacing node1 struct with nodeFile1 struct to write into file1 without the reference to the next node
  node1* w = root;
  
  while(w != NULL) {
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
    // printf("Writing first entry: %d, for word: %s\n", toInsert->first_entry, toInsert->word);
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

    // Finding the last written entry of the word
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

int getLineOccurr(char* line) {
  // Splitting the string "word, lineOccur" to only return the line ocurrency of the word 
  char* occurr;
  int occurrInt;

  strtok(line, ",");
  occurr = strtok(NULL, ",");

  // Verifying that the string is not NULL or empty
  if(occurr != NULL && strcmp(occurr, "") != 0){
    occurrInt = atoi(occurr);
  }

  return occurrInt;
}

#endif