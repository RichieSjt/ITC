#ifndef SYNCSTACK_H
#define SYNCSTACK_H

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

char stackPop(char* stack) {
  char c;

  // Storing the poped char
  c = stack[(strlen(stack)-1)];
  // Deleting the poped char from the buffer
  stack[(strlen(stack)-1)] = 0;
  printf("Pop: %c\n", c);

  return c;
}

void stackPush(char c, char* stack) {
  strncat(stack, &c, 1);
  printf("Push: %c\n", c);
}

#endif