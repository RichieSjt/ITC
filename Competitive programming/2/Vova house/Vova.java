import java.util.Scanner;

public class Vova {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements, i, heaterRange, heatLeft, heatRight, j, counter = 0;
        String[] heaters;
        String input, elements, check = "";

        input = sc.nextLine();

        numberOfElements = Integer.parseInt(input.substring(0, input.indexOf(" ")));
        heaterRange = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
        heaters = new String[numberOfElements];

        elements = sc.nextLine();
        heaters = elements.split(" ");

        for(i = 0; i < numberOfElements; i++) {
            if(heaters[i].equals("1")){
                heatLeft = i - heaterRange + 1;
                heatRight = i + heaterRange - 1;

                if(heatLeft < 0 && heaters[heatRight].equals("1")){
                    counter--;
                }else if(heatLeft < 0 && !heaters[heatRight].equals("1")){
                    for(j = 0; j <= heatRight; j++ ){
                        heaters[j] = "2";
                    }
                }else if(heatRight >= numberOfElements){
                    for(j = heatLeft; j < numberOfElements; j++ ){
                        heaters[j] = "2";
                    }
                }else{
                    for(j = heatLeft; j <= heatRight; j++){
                        heaters[j] = "2";
                    }
                }
                counter++;
            }
        }

        for(i = 0; i < numberOfElements; i++) {
            if (heaters[i].equals("0"))
                check = "-1";
        }

        if(check.equals("-1"))
            System.out.println("-1");
        else
            System.out.println(counter);
    }
}