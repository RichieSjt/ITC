import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, L, v, l, r, queries, lantern, counter = 1, lanternsWatched = 0;
        String input;
        String[] data;

        queries = Integer.parseInt(sc.nextLine());

        for (i = 0; i < queries; i++) {
            input = sc.nextLine();
            data = input.split(" ");
            L = Integer.parseInt(data[0]);
            v = Integer.parseInt(data[1]);
            l = Integer.parseInt(data[2]);
            r = Integer.parseInt(data[3]);
            for(j = l; j <= L; j++){
                lantern = counter*v;
                if(lantern < l || lantern > r){
                    lanternsWatched++;
                }
                counter++;
                lantern = 0;
            }
            System.out.println(lanternsWatched);
            lanternsWatched = 0;
        }
    }
}

//Doesn't works