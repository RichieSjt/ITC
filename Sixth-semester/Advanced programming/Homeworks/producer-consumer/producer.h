#ifndef PRODUCER_H
#define PRODUCER_H

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "mutexInit.h"

typedef struct producer{
  int num;
  int counter;
  char* theStack;
} producer;

void *runProducer(void *arg) {
  pthread_mutex_lock(&mutex);
  // The parameters we passed previously
  struct producer *p1 = arg;

  char c;
  time_t t;
  /* Intializes random number generator */
  srand((unsigned) time(&t));

  // Initializing the producer data
  p1->counter = 1;
  p1->num = p1->counter++;

  for (int i = 0; i < 20; i++) {
    c = 'A' + (rand()%26);
    
    stackPush(c, p1->theStack);
    printf("Producer %d: %c\n", p1->num, c);

    int ms = (rand()%300)*1000;

    int error = usleep(ms);
  }
  pthread_mutex_unlock(&mutex);
}

#endif