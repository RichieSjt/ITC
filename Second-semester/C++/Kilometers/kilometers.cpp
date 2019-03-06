#include <iostream>
using namespace std;

int main(){

    long long int x, d, n;
    int t, i;
    int r = -1;

    cout << "Number of test cases: ";
    cin >> t;

    for (i = 0; i < t; i++){ 
        cout << "Enter x: ";
        cin >> x;
        for(n = 2; r != 0; n++){
            r = (x - ((n * (n - 1)) / 2)) % n; //Comprueba si es entero cuando r = 0; 
            d = (x - ((n * (n - 1)) / 2)) / n; //Guarda el valor de d
        }
        cout << "Result: " << d << endl;
        d = 0;
    }
}