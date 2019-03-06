public class story {
    public static void main(String[]args) {
        int n1, n2, n3, n4, n5, n6, n7;

        String[] situations = {"eating ramen", "watching videos", "taking drugs", "making homework"};
        String[] descriptors = {"an antisocial", "a subnormal", "a stupid", "a smart"};
        String[] nationality = {"American", "Alien", "Arab", "Uranian"};
        String[] characters = {"warrior", "FBI agent", "pichito", "student"};
        String[] funnycharacter = {"a banana", "a racoon", "jesus", "hitler"};
        String[] interaction = {"kidnap", "slap", "stalk", "hug"};
        String[] places = {"Uranus", "the street", "job", "hell"};

        n1 =(int)(Math.random()*4);
        n2 =(int)(Math.random()*4);
        n3 =(int)(Math.random()*4);
        n4 =(int)(Math.random()*4);
        n5 =(int)(Math.random()*4);
        n6 =(int)(Math.random()*4);
        n7 =(int)(Math.random()*4);

        System.out.println("While " + situations[n1] + ", " + descriptors[n2] + " " + nationality[n3] + " " + characters[n4] + " had an idea: Why not dress as " + funnycharacter[n5] + " and " + interaction[n6] + " people in " + places[n7] +"?");

    }
}
    