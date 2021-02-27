#include <stdio.h>

int remainder(int, int);

int main(void) {
  int a = 5;
  int b = 10;
  int res = remainder(a, b);
  printf("The remainder of the numbers %i and %i is %i\n", a, b, res);
  return 0;
}

//Remainder of the division between a and b
int remainder(int a, int b){
  int c = a/b;
  int res = a - (c*b);
  return res; 
}