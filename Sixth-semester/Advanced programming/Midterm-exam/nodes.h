#ifndef NODES_H
#define NODES_H

// Linked list of words
typedef struct node1{
  char word[50];
  int first_entry;
  struct node1 *next;
} node1;

// Struct to write into file 1 without the reference to next
typedef struct nodeFile1{
  char word[50];
  int first_entry;
} nodeFile1;

typedef struct nodeFile2{
  int entry;
  int next_entry;
} nodeFile2;

#endif