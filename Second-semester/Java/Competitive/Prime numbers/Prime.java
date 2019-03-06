public class Prime{
    public static void main(String[] args) {
        int[] counter = new int[10000];
        int i, j;
        
        for(i = 1; i < 10000; i++){
            if(counter[i] == 0){
                int f = i+1;
                for(j = 10000; j >= 2; j--){
                    if(j%f == 0){
                        counter[j-1] = counter[j-1]++;
                    }
                }
            }
        }
        for(i = 0; i < counter.length; i++){
            if (counter[i] == 3){
                System.out.print(i+1);
            }
        }
    }
}