#include <iostream>
#include <algorithm> //Ordenador
using namespace std;

int binarySearch(int* arr, int n, int k);

int main(){
    int pos, k;
    int *up, *low;
    int arr[] = {5, 3, 1, 4, 2};

    sort(arr, arr+5);

    for(int i = 0; i < 5; i++){
        cout << arr[i] << " ";
    cout << endl; 
    }
    k = 3;
    pos = binarySearch(arr, 5, k);
    cout <<"Number 3 index: " << pos << endl;

    up = upper_bound(arr, arr+5, k);
    low = lower_bound(arr, arr+5, k);

    cout << "Upper bound: " << up-arr << endl;
    cout << "Lower bound: " << low-arr << endl;
}

int binarySearch(int* arr, int n, int k){
    int izq, der, mid;
    izq = 0;
    der = n-1;

    while(izq < der){
        mid = (izq+der)/2;
        if(arr[mid] == k){
            return mid;
        }else if (arr[mid] < k){
            izq = mid+1;
        }else{
            der = mid +1;
        }
    }
    return -1;
}