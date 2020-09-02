    import java.util.Scanner;

    public class Fractions {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int gcd, number, i, j, counter = 1;

            do{
            
            number = Integer.parseInt(sc.nextLine());
            if(number == 0)
                break;
            
            int[] nums = new int[number];
            
            for(i = 2; i < number; i++) {
                if (nums[i] == 1)
                    continue;

                gcd = gcd(i, number);
                if(gcd == 1)
                    counter++;
                else {
                    j = i; 
                    do{
                        nums[j] = 1;
                        j += i;
                    }while(j < number);
                }
            }
            System.out.println(counter);
            counter = 1;
            }while(number != 0);
        }
        public static int gcd(int n, int m){
            int tmp;
            while (m != 0) {
                tmp = m;
                m = n%m; 
                n = tmp;
            }
            return n;
        }
    }   