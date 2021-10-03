#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>
#include <semaphore.h>

// Max number of threads
#define MAX_CUSTOMERS 200
sem_t chairs;
sem_t barberChair;
sem_t barberState;
sem_t seatBelt;

int hasFinished = 0, numChairs;

void waitRandomSeconds(int s) {
  time_t t;
  srand((unsigned) time(&t));
  int wait = rand()%s;
  sleep(wait);
}

void *customer(void *number) {
  int num = *(int *)number;

  // Wait a random amount of time to arrive
  waitRandomSeconds(5);
  // Wait for space to open up in the waiting room
  printf("Customer %d is outside the barber shop.\n", num);
  sem_wait(&chairs);
  printf("Customer %d entering waiting room.\n", num);

  // Wait for the barber chair to become free
  sem_wait(&barberChair);

  // The client frees its chair in the waiting room
  sem_post(&chairs);

  // Wake up the barber
  int value;
  sem_getvalue(&chairs, &value);
  if(value == numChairs){
      printf("Customer %d woke up the barber.\n", num);
    }
  
  sem_post(&barberState);
  // Wait for the barber to finish cutting your hair
  sem_wait(&seatBelt);

  // Free the barber chair
  sem_post(&barberChair);
  printf("Customer %d leaving barber shop.\n", num);
}

void *barber(void *args) {
  // While there are still customers
  while (!hasFinished) {
    // Sleep until a customer arrives
    int value;
    sem_getvalue(&chairs, &value);
    if(value == numChairs){
      printf("The barber is sleeping ZZZ... ZZZ... \n");
    }
    
    sem_wait(&barberState);

    if (!hasFinished) {
      // The barber takes a random amount of time to cut the hair
      printf("The barber is cutting hair\n");
      waitRandomSeconds(3);
      printf("The barber has finished cutting hair.\n");

      // Release the customer when done
      sem_post(&seatBelt);
    }
    else {
    printf("The barber has no more customers.\n");
    }
  }
}

int main(int argc, char *argv[]) {
  pthread_t barbertid;
  pthread_t tid[MAX_CUSTOMERS];
  int i, numCustomers;

  printf("Number of Customers: "); 
  scanf("%d", &numCustomers);
  printf("Number of Chairs: ");
  scanf("%d", &numChairs);

  // Initialize the semaphores
  sem_init(&chairs, 0, numChairs);
  sem_init(&barberChair, 0, 1);
  sem_init(&barberState, 0, 0);
  sem_init(&seatBelt, 0, 0);

  // Create the barber thread
  pthread_create(&barbertid, NULL, barber, NULL);

  // Create the customer threads
  for (i = 0; i < numCustomers; i++) {
    pthread_create(&tid[i], NULL, customer, (void *)&i);
    sleep(1);
  }

  for (i = 0; i < numCustomers; i++) {
    pthread_join(tid[i], NULL);
    sleep(1);
  }

  // When there are no more clients we end the barber thread
  hasFinished = 1;
  sem_post(&barberState);
  pthread_join(barbertid, NULL);
}