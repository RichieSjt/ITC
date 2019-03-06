public class Jaime{
    public static void main(String[] args){
        String in, z, nz;
        Double a, b, result;
        int Fresult = 1, start = 0, i, j, tc, n, m = 0, y;
        char[] ch;

        System.out.print("Number of test cases: " );
        tc = Integer.parseInt(System.console().readLine());

        for (j = 0 ; j < tc; j++ ){

            System.out.println(" ");
            System.out.println("Test case " + (j + 1));

            System.out.println("--Enter a b n separated by an space--");
            in = System.console().readLine();

            String store[] = in.split(" ");

            a = Double.parseDouble(store[0]);
            b = Double.parseDouble(store[1]);
            n = Integer.parseInt(store[2]);

            result = a/b;
            System.out.println("Result: " + result);

            z = String.valueOf(result).replaceAll("0", "1");
            System.out.println("Removing zeros: " + z);

            ch = z.toCharArray();

            for(i = 0; i < ch.length ; i++){
                if (ch[i] == '.'){
                    start = i + 1;
                    n = n + start; 
                }
            }

            nz = z.substring(start, n);

            for(y = 0; y < nz.length() ; y++){
                m = Integer.parseInt(nz.substring(y, y+1));
                Fresult *= m;
            }    
            System.out.println("Multiplying the first " + (n-start) + " decimals after the point: " + Fresult);
            
            Fresult = 1;        //Reset the final result
        }
    }
}