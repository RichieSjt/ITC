public class NewPlanet {
    public static void main (String[] args){
        String s1, s2, nsn;
        int mid1, mid2, r1, r2, n, a1, a2;
        String[] Animals = {"Spider", "Jellyfish", "Lion", "Rabbit", "Wolf", };

        r1 = (int)(Math.random()*Animals.length);
        r2 = (int)(Math.random()*Animals.length);

        while(r1==r2){
            r1 = (int)(Math.random()*Animals.length);
        }
        
        System.out.print("Enter 1 for a random name, or 2 to choose: " );
        n = Integer.parseInt(System.console().readLine());

        if(n==1){
            s1= Animals[r1];
            s2= Animals[r2];
            
            mid1 = s1.length() / 2;
            mid2 = s2.length() / 2;

            nsn = s1.substring(0, mid1) + s2.substring(mid2);

            System.out.print("New specie name: " + nsn);
        }else if(n==2){
            
            System.out.println("Animals list;" );

            for (int i = 0; i < Animals.length ; i++){    
                System.out.println((i+1) + ". " + Animals[i]);
            }
            System.out.println("----Enter a number to select the animal name----");
            System.out.print("Animal 1: ");
            a1 = Integer.parseInt(System.console().readLine());
            s1 = Animals[a1-1];

            System.out.print("Animal 2: ");
            a2 = Integer.parseInt(System.console().readLine());
            s2 = Animals[a2-1];
            
            mid1 = s1.length() / 2;
            mid2 = s2.length() / 2;
            nsn = s1.substring(0, mid1) + s2.substring(mid2);
            System.out.print("New specie name: " + nsn);
            
        }else{
            System.out.println("Selection not in range");
        }
        /*
        mid = s1.length() / 2;
        String[] parts = {s1.substring(0, mid),s1.substring(mid)};

        System.out.println(parts[0]);
        System.out.println(parts[1]);
        */
    }
}