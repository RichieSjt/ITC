import java.util.Scanner;
import java.io.*;

public class FinalExam{
    public static void main(String[] args){
        int i, n;

        System.out.print("Number of people: ");
        n = Integer.parseInt(System.console().readLine());
        
        for (i = 1; i <= n; i++){
            System.out.println("---Person " + i + "---");
            System.out.println("Enter the 11 questions answers separated by a space: ");
            String a = System.console().readLine();

            System.out.println("Results: ");
            System.out.println("Affective: " + AffectivePoints(a, i));
            System.out.println("Confidential: " + ConfidentialPoints(a, i));
            System.out.println("Social: " + SocialPoints(a, i));

        }
    }

    public static String AffectivePoints(String answer, int person){
        //1,4,6,7,8,10
        String data[] = answer.split(" ");
        int dataint[];
        dataint = new int [11];

        for (int i= 0; i < data.length; i++){
            int a = Integer.parseInt(data[i]);
            dataint[i] = a;
        }
        String affective;
        int result = dataint[0] + dataint[3] + dataint[5] + dataint[6] + dataint[7] + dataint[9]; 
        if (result >= 18){
            affective = "Appropriate affective support"; 
        }else{
            affective = "Inappropriate affective support"; 
        }
        return affective;
    }
    public static String ConfidentialPoints(String answer, int person){
        //2, 3, 5, 9, 11
        String data[] = answer.split(" ");
        int dataint[];
        dataint = new int [11];

        for (int i= 0; i < data.length; i++){
            int a = Integer.parseInt(data[i]);
            dataint[i] = a;
        }
        String confidential;
        int result = dataint[1] + dataint[2] + dataint[4] + dataint[8] + dataint[10]; 
        if (result >= 15){
            confidential = "Appropriate confidential support"; 
        }else{
            confidential = "Inappropriate confidential support"; 
        }
        return confidential;
    }
    public static String SocialPoints(String answer, int person){
        //all answers
        String data[] = answer.split(" ");
        int dataint[];
        dataint = new int [11];

        for (int i= 0; i < data.length; i++){
            int a = Integer.parseInt(data[i]);
            dataint[i] = a;
        }
        String social;
        int result = dataint[0] + dataint[1] + dataint[2] + dataint[3] + dataint[4] + dataint[5] + dataint[6] + dataint[7]
        + dataint[8] + dataint[9] + dataint[10]; 
        if (result >= 32){
            social = "Appropriate social support"; 
        }else{
            social = "Inappropriate social support"; 
        }
        return social;
    }

}