#include <iostream>
using namespace std;

int gcd(int n, int m){
    if(m==0){
        return n;
    }else{
        return gcd(m, n%m);
    }
}

int main(){
    int i, input, counter = 1;

    do {
        cin >> input;

        for (i = 1; i <= input; i++)
        {
            if (gcd(i, input) == 1) {
                counter++;
            }
        }
        cout << counter;
        counter = 0;
    } while (input != 0);

    return 0;
}