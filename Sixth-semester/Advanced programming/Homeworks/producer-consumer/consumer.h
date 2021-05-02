#ifndef CONSUMER_H
#define CONSUMER_H

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "mutexInit.h"

typedef struct consumer{
  int num;
  int counter;
  char* theStack;
} consumer;

void *runConsumer(void *arg) {
  pthread_mutex_lock(&mutex);
  struct consumer *c1 = arg;
  
  char c;
  time_t t;
  /* Intializes random number generator */
  srand((unsigned) time(&t));

  // Initializing the consumer data
  c1->counter = 1;
  c1->num = c1->counter++;

  for (int i = 0; i < 20; i++) {

    c = stackPop(c1->theStack);
    
    printf("Consumer %d: %c\n", c1->num, c);

    int ms = (rand()%300)*1000;

    int error = usleep(ms);
  }

  pthread_mutex_unlock(&mutex);
}

#endif