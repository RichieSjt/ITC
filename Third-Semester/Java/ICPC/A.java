import java.util.Scanner;

	public class A{
		public static void main(String[] args) {
            int sumDiam = 0;
            int xSens, ySens, radius = 0;
            boolean interseccionX;
            boolean interseccionY;

            Scanner sc = new Scanner(System.in);
            int xMin = Integer.MAX_VALUE;
            int xMax = Integer.MIN_VALUE;
            int yMin = Integer.MAX_VALUE;
            int yMax = Integer.MIN_VALUE;

            int x = sc.nextInt();
            int y = sc.nextInt();
            int sensors = sc.nextInt();
            sc.nextLine();

            for(int i = 0; i < sensors; i++){
                xSens = sc.nextInt();
                ySens = sc.nextInt();
                radius = sc.nextInt();
                sc.nextLine();

                sumDiam += (radius*2);
                
                if(xSens-radius < xMin)
                    xMin = xSens-radius;
                
                if(xSens+radius > xMax)
                    xMax = xSens+radius;

                if(ySens-radius < yMin)
                    yMin = ySens-radius;

                if(ySens+radius > yMax)
                    yMax = ySens+radius;
                   
            }
            
            int xLen = Math.abs(xMax)-Math.abs(xMin);
            int yLen = Math.abs(yMax)-Math.abs(yMin);
            
            if(xLen <= sumDiam)
                interseccionX = true;
            else
                interseccionX = false;
                    
            if(yLen <= sumDiam)
                interseccionY = true;
            else
                interseccionY = false;
            
            if(interseccionX && interseccionY){
                if( (xMin <= 0 && xMax >= x) || (yMin <= 0 && yMax >= y) )
                    System.out.println("N");
                else
                    System.out.println("S");
            }else{
                System.out.println("S");
            }

            sc.close();
        }
    }