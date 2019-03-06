public class tweet {
	public static void main (String[] args) {
        int ts, tr, rt, tc, th;
        
        System.out.print("Number of Tweets sent: ");
		ts= Integer.parseInt(System.console().readLine());

        System.out.print("Number of Tweets read: ");
        tr= Integer.parseInt(System.console().readLine());

        System.out.print("Number of Retweets: ");
        rt= Integer.parseInt(System.console().readLine());

        System.out.print("Number of Tweets for contests: ");
        tc= Integer.parseInt(System.console().readLine());

        System.out.print("Number of Tweets with hashtag: ");
        th= Integer.parseInt(System.console().readLine());
    
        System.out.print("");

        if ((ts<0) | (tr<0) | (rt<0) | (tc<0) | (th<0)){
            System.out.println("Introduced an invalid number, check");
        }else{
            System.out.println("Categories where you fit:");
            
            if ((ts == 0)|(tr == 0)){
                System.out.println("Egg");
                }
            
            if ((tr > 0) & (ts==0)) {
                System.out.println("Marauder");
                }
    
            if ((ts > 0) & (ts == tc)) {
                System.out.println("Contestant");
                }
    
            if ((ts>0) & ((ts/2)<=(rt))) {
                System.out.println("Follower");
                }
    
            if ((ts>0) & ((ts/2)<=(th))) {
                System.out.println("Explorer");
                }
        
        }

    }

}