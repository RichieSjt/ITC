#include <stdio.h>

int residuo(int, int);

int main(void) {
  int a = 5;
  int b = 10;
  int res = residuo(a, b);
  printf("El residuo de los numeros %i y %i es %i\n", a, b, res);
  return 0;
}

//residuo de la división de a y b
int residuo(int a, int b){
  int c = a/b;
  int res = a - (c*b);
  return res; 
}