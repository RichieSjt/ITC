#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
int counter = 0;

typedef struct search_args {
  char** words;
  char* toSearch;
  int start;
  int end;
} search_args;

void *search(void *arg) {
  // The parameters we passed previously
  struct search_args *sa = arg;
  int id = *((int *)(arg));

  pthread_mutex_lock(&mutex);

  for(int i = sa->start; i < sa->end; i++) {
    if(strcmp(sa->toSearch, sa->words[i]) == 0) {
      counter++;
    }
  }
  
  pthread_mutex_unlock(&mutex); 
  return NULL;
}

int main(int argc, const char * argv[]) {
  pthread_attr_t attr;
  /* Initializing thread attributes */
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
  pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);
  pthread_t t1, t2;

  char *words[] = {"hola", "adios","no-se", "hola", "hola", "hola","aa", "hola"};
  int w_size = sizeof(words)/sizeof(char*);
  int mid = w_size/2;

  // Parameters to pass to the threads
  search_args sa1, sa2;
  sa1.words = words;
  sa1.toSearch = "hola";
  sa1.start = 0;
  sa1.end = mid;

  sa2.words = words;
  sa2.toSearch = "hola";
  sa2.start = mid;
  sa2.end = w_size;

  pthread_create(&t1, &attr, search, (void *) &sa1);
  pthread_create(&t2, &attr, search, (void *) &sa2);

  /* Waiting for the child threads to finish */
  pthread_join(t1, NULL);
  pthread_join(t2, NULL);

  printf("The word was found %d times in the array.\n", counter);
  return 0;
}