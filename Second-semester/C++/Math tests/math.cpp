#include <iostream>
#include <cmath>

using namespace std;

int main(){
    float n1;
    float n2;

    cout <<"Enter the first number: ";
    cin >> n1;
    cout <<"Enter the second number: ";
    cin >> n2;

    cout <<"Sum: "<< n1+n2 << endl;
    cout <<"Multiplication: " << n1*n2 <<endl; 
    cout <<"Division: " << n1/n2 << endl;
    cout <<"Module from 27/5: " << 27 % 5 << endl;
    cout <<"n1 elevated to n2: " << pow(n1, n2) << endl;
    cout <<"n1 square root: " << sqrt(n1) << endl;
    cout <<"Biggest number: " << fmax(n1, n2) << endl;
    // round(4.6); returns 5;
    // floor(4.6); returns 4;
    // ceil(4.2); returns 5;

    return 0;
}
