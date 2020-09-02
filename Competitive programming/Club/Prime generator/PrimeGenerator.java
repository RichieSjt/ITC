import java.util.Scanner;

public class PrimeGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, p, testCases, lowerBound, upperBound, arraySize;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            lowerBound = sc.nextInt();
            upperBound = sc.nextInt();
            arraySize = upperBound - lowerBound + 1;

            int prime[] = new int[arraySize];

            for(p = lowerBound; p*p <= prime.length; p++){
                if(prime[p-1] == 0){
                    for(j = p*p; j <= prime.length; j += p) 
                        prime[j-1] += 1;
                }
            }

            for(j = 0; j < prime.length ; j++){
                if (prime[i] == 0){
                    System.out.println(i+1);
                }
            }
        }
    }
}