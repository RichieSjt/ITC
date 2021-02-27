#include <stdio.h>

int main(void) {
  int n = -1;

  while(n != 42){
    scanf("%i", &n); 
    if(n != 42){
      printf("%d\n", n);
    }
  }
  return 0;
}