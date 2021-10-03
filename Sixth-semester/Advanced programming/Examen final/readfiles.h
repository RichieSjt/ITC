#ifndef READFILES_H
#define READFILES_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include "nodes.h"

int binarySearch(struct nodeFile1 arr[], int l, int r, char* x){
  if (r >= l) {
    int mid = l + (r - l) / 2;
  
    // Element found
    if (strcmp(arr[mid].word, x) == 0)
      return arr[mid].first_entry;
  
    // Search left subarray
    if (strcmp(arr[mid].word, x) > 0)
      return binarySearch(arr, l, mid - 1, x);
  
    // Search right subarray
    return binarySearch(arr, mid + 1, r, x);
  }
  
  // Element is not present in array
  return -1;
}
  
int numberOfElementsInFile1(FILE *file){
  fseek(file, sizeof(node1), SEEK_END);
  int size = ftell(file);
  fseek(file, 0, SEEK_SET);
  
  return size/sizeof(node1);
}
int numberOfElementsInFile2(FILE *file){
  fseek(file, sizeof(nodeFile2), SEEK_END);
  int size = ftell(file);
  fseek(file, 0, SEEK_SET);
  
  return size/sizeof(nodeFile2);
}

void readFile1(struct nodeFile1 nf1Array[], int numOfNodes, FILE *file1) {
  int i, counter = 0;

  for(i = 0; i < numOfNodes; i++) {
    fseek(file1, sizeof(nodeFile1)*i, SEEK_SET);
    nodeFile1 nf1;
    // printf("Word: %s, First entry: %d\n", nf1.word, nf1.first_entry);
    // sleep(2);
    fread(&nf1, sizeof(nodeFile1), 1, file1);
    nf1Array[counter++] = nf1;
  }

  // for(int i = 0; i < numOfNodes; i++) {
  //   printf("Word: %s, First entry: %d\n", nf1Array[i].word, nf1Array[i].first_entry);
  // }
}

void readFile2(struct nodeFile2 nf2Array[], int numOfNodes, FILE *file2) {
  int i, counter = 0;

  for(i = 0; i < numOfNodes; i++) {
    fseek(file2, sizeof(nodeFile2)*i, SEEK_SET);
    nodeFile2 nf2;
    fread(&nf2, sizeof(nodeFile2), 1, file2);
    nf2Array[counter++] = nf2;
  }

  // for(int i = 0; i < numOfNodes; i++) {
  //   printf("Entry: %d, Next entry: %d\n", nf2Array[i].entry, nf2Array[i].next_entry);
  // }
}

void searchWordPositions(char* word) {
  FILE *file1 = fopen("file1", "rb");
  FILE *file2 = fopen("file2", "rb");

  int numOfNodesF1 = numberOfElementsInFile1(file1);
  nodeFile1 nf1Array[numOfNodesF1];
  //printf("File 1 contents:\n");
  readFile1(nf1Array, numOfNodesF1, file1);

  int numOfNodesF2 = numberOfElementsInFile2(file2);
  nodeFile2 nf2Array[numOfNodesF2];
  //printf("\nFile 2 contents:\n");
  readFile2(nf2Array, numOfNodesF2, file2);

  int entry = binarySearch(nf1Array, 0, numOfNodesF1-1, word);

  int next_pos = entry;
  nodeFile2 nf2;

  printf("The word positions in the text are: ");

  while(next_pos != -1) {
    fseek(file2, sizeof(nodeFile2)*next_pos, SEEK_SET);
    fread(&nf2, sizeof(nodeFile2), 1, file2);
    fseek(file2, -1*sizeof(nodeFile2), SEEK_CUR);
    next_pos = nf2.next_entry;

    printf("%d ", nf2.entry);
  }
  printf("\n");


  fclose(file1);
  fclose(file2);
}

#endif