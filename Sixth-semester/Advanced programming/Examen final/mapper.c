// To run the program: ./mapper | sort | ./reducer

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>

int main() {
  const int LINE_SIZE = 100;
  char line[LINE_SIZE];
  int line_counter = 1;
  char *word;
  const char *delimiters = "\n\t'`?-!:;*[],.\"() ";

  FILE *alice_file;

  // Creating a fork to work with the two parts of the alice script
  int id = fork();
  if(id == 0) {
    // Child process
    alice_file = fopen("alice1.txt", "r");
    line_counter = 1;
  } else {
    // Parent process
    alice_file = fopen("alice2.txt", "r");
    line_counter = 1801;
  }

  while(fgets(line, LINE_SIZE, alice_file)) {
    word = strtok(line, delimiters);

    while(word != NULL) {
      // Converting the word to lower case
      for(int i = 0; word[i]; i++) {
        word[i] = tolower(word[i]);
      }

      printf("%s, %d\n", word, line_counter);
      
      // We continue tokenizing the initial line
      word = strtok(NULL, delimiters);
    }
    line_counter++;
  }

  fclose(alice_file);
}