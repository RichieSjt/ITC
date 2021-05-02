#include<stdio.h>
#include <pthread.h>
#include <string.h>
#include <unistd.h>

#define n 5
pthread_mutex_t stick = PTHREAD_MUTEX_INITIALIZER;

typedef struct philospher{
  char* name;
  int food;
	pthread_mutex_t left;
	pthread_mutex_t right;
}philospher;

void *goForDinner(void *arg){
  struct philospher *ph = arg;

  while(ph->food != 0) {
    pthread_mutex_lock(&ph->left);
    pthread_mutex_lock(&ph->right);
    
    ph->food--;
    sleep(1);
    printf("%s está comiendo...\n" , ph->name);

    pthread_mutex_unlock(&ph->left);
    pthread_mutex_unlock(&ph->right);
    printf("El filósofo %s soltó los palillos\n", ph->name);
  }
  printf("El filósofo %s acabó de comer\n", ph->name);

  return NULL;
}


int main(){
  pthread_t threads_arr[n];

  /* Initializing thread attributes */
  pthread_attr_t attr;
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
  pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);

  philospher p1;
  p1.name = "Platon";
  p1.food = 5;
  p1.left = stick;
  p1.right = stick;

  pthread_create(&threads_arr[0], &attr, goForDinner,(void *) &p1);

  philospher p2;
  p2.name = "Aristóteles";
  p2.food = 7;
  p2.left = stick;
  p2.right = stick;

  pthread_create(&threads_arr[1], &attr, goForDinner,(void *) &p2);

  philospher p3;
  p3.name = "Sócrates";
  p3.food = 3;
  p3.left = stick;
  p3.right = stick;

  pthread_create(&threads_arr[2], &attr, goForDinner,(void *) &p3);

  philospher p4;
  p4.name = "Nietzsche";
  p4.food = 4;
  p4.left = stick;
  p4.right = stick;

  pthread_create(&threads_arr[3], &attr, goForDinner,(void *) &p4);

  philospher p5;
  p5.name = "Marx";
  p5.food = 9;
  p5.left = stick;
  p5.right = stick;

  pthread_create(&threads_arr[4], &attr, goForDinner,(void *) &p5);

  pthread_join(threads_arr[0], NULL);
  pthread_join(threads_arr[1], NULL);
  pthread_join(threads_arr[2], NULL);
  pthread_join(threads_arr[3], NULL);
  pthread_join(threads_arr[4], NULL);
}