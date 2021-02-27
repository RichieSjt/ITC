#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void){
    srand(time(NULL));
    int machine = rand() % 100;
    int tries = 0;
    int user = -1;
    printf("%d\n", machine);
    printf("Guess a number between 0 and 99\n");
    while(user != machine){
        printf("Try a number: \n");
        scanf("%d", &user);
        tries++;
        
        if(user > machine){
            printf("Your number is bigger.\n");
        }
        else if(user < machine){
            printf("Your number is smaller.\n");
        }
    }
    printf("You got it in %d tries\n", tries);
    return 0;
}