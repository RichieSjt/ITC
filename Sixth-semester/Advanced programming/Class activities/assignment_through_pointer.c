#include <stdio.h>

void div(int a, int b, int *res, int *remainder){
    *res = a / b;
    *remainder = a - (*res) * b;
}

int main() {
    int a  = 10;
    int b = 3;
    int res;
    int remainder;

    div(a, b, &res, &remainder);
    printf("The division result and remainder is %i, %i", res, remainder);

    return 0;
}