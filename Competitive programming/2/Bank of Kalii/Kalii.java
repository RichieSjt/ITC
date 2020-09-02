 import java.util.Scanner;

public class Kalii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases, m, d, a, m2, d2;
        String input, in1, in2, clientDate;

        testCases = Integer.parseInt(sc.nextLine());

        for (i = 0; i < testCases; i++) {
            input = sc.nextLine();

            in1 = input.substring(0, input.indexOf(" "));
            in2 = input.substring(input.indexOf(" ") + 1);

            m = Integer.parseInt(in1.substring(0, in1.indexOf("/")));
            d = Integer.parseInt(in1.substring(in1.indexOf("/")+1, in1.lastIndexOf("/")));
            a = Integer.parseInt(in1.substring(in1.lastIndexOf("/")+1));

            m2 = Integer.parseInt(in2.substring(0, in2.indexOf("/")));
            d2 = Integer.parseInt(in2.substring(in2.indexOf("/")+1));            
            
            clientDate = m2 + "/" + d2 +"/" + a;
            System.out.println(checkDate(clientDate, m, d, m2, d2));

        }
    }
    public static String checkDate(String clientDate, int m, int d, int m2, int d2){
        String result = "";
        
        if(m == m2 && d > d2 && d-d2 <= 7 ){
            result = clientDate + " IS" + " " + (d-d2) + " " + "DAY" + (d-d2 > 1 ? "S " : " ") + "PRIOR";
        }else if(m == m2 && d < d2 && d2-d <= 7 ){
            result = clientDate + " IS" + " " + (d2-d) + " " + "DAY" + (d2-d > 1 ? "S " : " ") + "AFTER";
        }else if(m == m2 && d == d2){
            result = "SAME DAY";
        }
        return result; 
    }

    public static boolean dateIsCorrect(int m, int d, int a){
        boolean correct = true;

        switch(m) {
            case 1: if(d <= 31){correct &= true;}else{correct &= false;} break;
            case 2: if(d <= 28 || isLeapYear(a)==true){correct &= true;}else{correct &= false;} break;
            case 3: if(d <= 31){correct &= true;}else{correct &= false;} break;
            case 4: if(d <= 30){correct &= true;}else{correct &= false;} break;
            case 5: if(d <= 31){correct &= true;}else{correct &= false;} break;
            case 6: if(d <= 30){correct &= true;}else{correct &= false;} break;
            case 7: if(d <= 31){correct &= true;}else{correct &= false;} break;
            case 8: if(d <= 31){correct &= true;}else{correct &= false;} break;
            case 9: if(d <= 30){correct &= true;}else{correct &= false;} break;
            case 10: if(d <= 31){correct &= true;}else{correct &= false;} break;
            case 11: if(d <= 30){correct &= true;}else{correct &= false;} break;
            case 12: if(d <= 31){correct &= true;}else{correct &= false;} break;
            default: System.out.println("Illigal Operation");
        }
        return correct;
    } 
    public static boolean isLeapYear(int a){
        if ((a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0)))
            return true;
        else
            return false;
    }
}   