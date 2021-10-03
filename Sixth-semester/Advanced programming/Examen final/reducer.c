// To run the program: ./mapper | sort | ./reducer

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "buildfiles.h"
#include "readfiles.h"

int main(void){
  int occurr;
  char line[BUFSIZ];
  char lineTemp[100];
  char *currentWord;
  char *wordToSearch= "alice";

  node1 *root = NULL;
  node1 *word_node;

  FILE *file1 = fopen("file1", "r");
  FILE *file2 = fopen("file2", "r");

  printf("Word to search: %s\n", wordToSearch);
  

  // Checking if the files have already been built
  fseek(file1, 0, SEEK_END);
  int size = ftell(file1);
  fseek(file1, 0, SEEK_SET);

  fclose(file1);
  fclose(file2);

  // If the files are empty we build them
  if(size == 0){
    file1 = fopen("file1", "wb+");
    file2 = fopen("file2", "wb+");

    // Reading the sorted output from the mapper
    while (fgets(line, BUFSIZ, stdin) != NULL){
      strcpy(lineTemp, line);

      // Verifying that the line is not empty
      if(strcmp(line, "") != 0) {
        
        if(strtok(line, ",") != NULL){
          currentWord = line;
        }else{
          currentWord = "";
        }

        occurr = getLineOccurr(lineTemp);

        // Inserting the obtained line and word into a node that will be written later
        word_node = (node1 *) malloc(sizeof(node1));
        strcpy(word_node->word, currentWord);
        word_node->first_entry = ftell(file2)/sizeof(nodeFile2);

        word_node->next = NULL;

        insert(word_node, &root, file2, occurr);
      }
    }

    // print(root);
    writeFile1(root, file1);

    fclose(file1);
    fclose(file2);
  }

  searchWordPositions(wordToSearch);

  return 0;
}