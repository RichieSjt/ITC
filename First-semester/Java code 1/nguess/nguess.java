public class nguess {
    public static void main (String[]args){
        int number, guess, i;
        guess=-1;
    
        number =(int)(Math.random()*100);

        System.out.println("The number is between 1 and 100, you have 8 attempts.");
        
        for (i = 1; ((i <= 8)&(guess!=number)) ;i++ ){ //chances

                System.out.print("Attempt " + i + " ");
                System.out.print("Enter your guess: ");
                guess= Integer.parseInt(System.console().readLine());

                if(guess<number){   
                    System.out.println("Your guess is lower than the number");

                }else if(guess>number){
                    System.out.println("Your guess is higher than the number");
                     
                }

        }
        
        if (guess==number){
            System.out.println("You guessed!");
        }
        else {
            System.out.println("You lost, the number was " + number);   
        }
    }
}