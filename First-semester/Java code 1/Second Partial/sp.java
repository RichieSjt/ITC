public class sp{
    public static void main (String[]args){
        String[] songs;
        int[] duration;
        int ns, i, nofc, nofs, y, sn, price;
        price = 0;

        System.out.print("How many songs do we have?: ");
        ns = Integer.parseInt(System.console().readLine());

        songs = new String [ns];
        duration = new int [ns];

        for (i = 0 ; i < ns ; i++ ){
            System.out.print("Name of song " + (i+1) + ": ");
            songs[i]= System.console().readLine();

            System.out.print("Duration (in seconds): ");
            duration[i]= Integer.parseInt(System.console().readLine());
        }
        
        System.out.print("Number of contracts for this month: ");
        nofc= Integer.parseInt(System.console().readLine());
        System.out.println("");

        System.out.println("Songs available: ");
        for (i = 0 ; i < songs.length ; i++ ){
            System.out.println("Song number " + (i+1) + ": " + songs[i]);
        }
        System.out.println("");

        for (i = 0; i < nofc ; i++){
            System.out.println("Contract " + (i+1) + ": ");

            System.out.print("How many songs will be interpreted?: ");
            nofs= Integer.parseInt(System.console().readLine());

            for (y = 0; y < nofs ; y++){
                System.out.print("Introduce the song(s) number: ");
                sn= Integer.parseInt(System.console().readLine());
                price = price + (duration[sn-1] *10);

            }
            //for (j = 1; j <= ns ; j++){
                //if (j == sn ){

                //}
            //}
            
            System.out.println("Cost of contract " + (i+1) + ": " + price);
            System.out.println("");
            price = 0;
        }
    }
}