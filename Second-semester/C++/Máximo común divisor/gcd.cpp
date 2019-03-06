#include <iostream>
using namespace std;

int gcd(int n, int m){
    if(m == 0){
        return n; 
    }else{
        return gcd(m, n%m);
    }
}

int main(){
    int n, m, r = 0;
    cout << "Enter n: ";
    cin >> n;
    cout << "Enter m: ";
    cin >> m;

    r = gcd(n, m);
    cout << "Result: " << r << endl;
}