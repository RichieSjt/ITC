public class Prime{
    public static void main(String[] args) {
        int[] prime = new int[20];
        
        //Sieve of Eratosthenes
        for(int p = 2; p*p <= prime.length; p++){
            if(prime[p-1] == 0){
                for(int i = p*p; i <= prime.length; i += p) 
                    prime[i-1] += 1;
            }
        }

        //We start at index 1 to exclude number 1 from the sieve
        for(int i = 1; i < prime.length; i++){
            if (prime[i] == 0){
                System.out.println(i+1);
            }
        }
    }
}