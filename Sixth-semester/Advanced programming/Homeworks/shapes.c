#include <stdio.h>

void square(int n){

  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      printf("*");
    }
    printf("\n");
  }
}

void diamond(int n){
  int half = n/2;
  int spaces = half;
  int stars = 1;

  for(int i = 0; i < half; i++){ 
    for(int j = 0; j < spaces; j++){
      printf(" ");
    }
    for(int j = 0; j < stars; j++){
      printf("*");
    }
    spaces -= 1; 
    stars += 2; 
    printf("\n");
  }

  for(int i = 0; i<half+1;i++){
    for(int j = 0; j < spaces; j++){
      printf(" ");
    }
    for(int j = 0; j < stars; j++){
      printf("*");
    }
    spaces += 1; 
    stars -= 2; 
    printf("\n");
  }
}

void bow(int n){
  int stars = 1;
  int spaces = n-2;

  for(int i = 0; i < n/2; i++){
    for(int j = 0; j < stars; j++){
      printf("*");
    } 
    for(int j = 0; j < spaces; j++){
      printf(" ");
    }
    for(int j = 0; j < stars; j++){
      printf("*");
    } 
    spaces -= 2; 
    stars += 1; 
    printf("\n");
  }
  spaces += 4;
  stars -= 2; 

  for(int i = 0; i < n/2-1; i++){
    for(int j = 0; j < stars; j++){
      printf("*");
    } 
    for(int j = 0; j < spaces; j++){
      printf(" ");
    }
    for(int j = 0; j < stars; j++){
      printf("*");
    } 
    spaces += 2; 
    stars -= 1; 
    printf("\n");
  }
}

int main(){
  square(10);
  
  diamond(10);
  
  bow(10);

  return 0;
}