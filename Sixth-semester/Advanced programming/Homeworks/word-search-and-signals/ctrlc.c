#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>

short end = 0;

void ctrl_c(int signum) {
  alarm(0);

  if(end) {
    exit(signum);
  }
  printf("\nPress ctrl + c again to end the program\n");
  end = 1;

  sleep(5);
}

int main() {
  signal(SIGINT, ctrl_c);

  while(1) {
    end = 0;
    printf("Program Running\n");
    sleep(1);
  }
  return 0;
}