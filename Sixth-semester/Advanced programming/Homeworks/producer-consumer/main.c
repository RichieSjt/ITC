#include "syncStack.h"
#include "producer.h"
#include "consumer.h"

int main(void) {  
  pthread_attr_t attr;
  /* Initializing thread attributes */
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
  pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);

  char syncStack[200] = "";
  pthread_t prodT1, prodT2, consT1, consT2;

  producer p1;
  p1.theStack = syncStack;
  
  producer p2;
  p2.theStack = syncStack;

  consumer c1;
  c1.theStack = syncStack;
  
  consumer c2;
  c2.theStack = syncStack;

  pthread_create(&prodT1, &attr, runProducer, (void *)&p1);
  pthread_create(&consT1, &attr, runConsumer, (void *)&c1);
  pthread_create(&prodT2, &attr, runProducer, (void *)&p2);
  pthread_create(&consT2, &attr, runConsumer, (void *)&c2);

  pthread_join(prodT1, NULL);
  pthread_join(prodT2, NULL);
  pthread_join(consT1, NULL);
  pthread_join(consT2, NULL);

  return 0;
}