#include <stdlib.h>
#include <stdio.h>

void dynamicArr(int **arr, int size) {
    *arr = calloc(size, sizeof(int));
}

int main() {
    int arr[] = {10, 8, 5, -12};
    int arraySize;
    
    printf("Number of elements in the array: \n");
    scanf("%d", &arraySize);

    int len = sizeof(arr) / sizeof(int);
    int *ptr = arr;
    dynamicArr(&ptr, arraySize);

    free(ptr);
}