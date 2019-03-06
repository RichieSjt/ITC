#include <iostream>
#include <new> // arreglos dinámicos
using namespace std;

//* Accede a los datos
//& Accede a la dirección en memoria
int main(){
    int x = 10;
    int *p;

    p = new int[x]; //arreglos dinámicos con apuntadores

    return 0;
}