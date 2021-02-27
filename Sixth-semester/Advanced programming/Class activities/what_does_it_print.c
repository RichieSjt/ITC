#include <stdlib.h>
#include <stdio.h>
#define FUDGE(k) k + 3.14159
#define PR(a) printf("a = %d\t", (int)(a))
#define PRINT(a) PR(a); putchar('\n');
#define PRINT2(a,b) PR(a); PRINT(b)
#define PRINT3(a,b,c) PR(a); PRINT2(b,c)
#define MAX(a,b) (a<b? b: a)
int main() {
  int x = 2;
  PRINT(x*FUDGE(2));
  int cel;
  for(cel=0; cel <= 100; cel+=50)
    PRINT2(cel, 9.0/5*cel+32); /* 10 puntos */
  x = 1;
  int y = 2;
  PRINT3(MAX(x++,y),x,y);   /* 5 puntos */
  PRINT3(MAX(x++,y),x,y);    /* 5 puntos */
}