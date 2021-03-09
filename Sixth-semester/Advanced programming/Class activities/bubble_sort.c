#include <stdio.h>

typedef int (*sortType)(int, int);

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp; 
}

void bubblesort(int arr, int size, sortType c) {
    int pairs = size;
    int swapped = 1;

    while (swapped && pairs > 1) {
        swapped = 0;
        pairs--;
        for(int i = 0; i < pairs; i++){
            if(c((arr+i), (arr+i+1)) > 0){
                swap((arr+i), (arr+i+1));
                swapped = 1;
            }
        }
    }

}

int ascendent(int n1, int n2){
    if(n1 < n2)
        return -1;
    return 1;
}

int descendent(int n1, int n2){
    return -1 * ascendent(n1, n2);
}

void printArr(int *p, int size){
    for(int i = 0; i < size; i++) {
        printf("%i\t", p[i]);
    }
    printf("\n");
}


int main() {
    int arr[] = {-1, 10, 5, 6, -2};
    int arrSize = sizeof(arr) / sizeof(int);

    bubblesort(arr, arrSize, ascendent)

    return 0;
}