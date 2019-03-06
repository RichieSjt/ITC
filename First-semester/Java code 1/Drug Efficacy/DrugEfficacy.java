import java.util.Scanner;
import java.io.*;

public class DrugEfficacy{
    public static void main(String[] args) throws Exception{
        String[] groups; String[] results;
        String content1 ="", content2 = "";
        double g1pe = 0, g2pe = 0, g1ne = 0, g2ne = 0, g1noe = 0, g2noe = 0;
        int i;
        Scanner sc1 = new Scanner(new File("groups.txt"));
        Scanner sc2 = new Scanner(new File("results.txt"));

        while (sc1.hasNext()) {
			content1 += sc1.nextLine() + "\n";}
        groups = content1.split("\n");

        while (sc2.hasNext()) {
			content2 += sc2.nextLine() + "\n";}
        results = content2.split("\n");

        for (i = 0 ; i < groups.length ; i++){
            if(groups[i].equals("group 1")){
                if(results[i].equals("positive effect")){
                    g1pe ++;
                }else if(results[i].equals("negative effect")){
                    g1ne ++; 
                }else{
                    g1noe ++;
                }
            }else{
                if(results[i].equals("positive effect")){
                    g2pe ++;
                }else if(results[i].equals("negative effect")){
                    g2ne ++; 
                }else{
                    g2noe ++;
                }
            }
        }

        System.out.println("Patients percentage of group 1 with positive effect: %" + (g1pe * groups.length/100));
        System.out.println("Patients percentage of group 2 with positive effect: %" + (g2pe* groups.length/100));
        System.out.println("Patients percentage of group 1 with negative effect: %" + (g1ne * groups.length/100));
        System.out.println("Patients percentage of group 2 with negative effect: %" + (g2ne* groups.length/100));
        System.out.println("Patients percentage of group 1 with no effect: %" + (g1noe* groups.length/100));
        System.out.println("Patients percentage of group 2 with no effect: %" + (g2noe* groups.length/100));

    }
}