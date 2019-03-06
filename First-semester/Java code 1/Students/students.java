public class students{
    public static void main(String[] args){
        int n, i;
        String[] student;
        String letter, compare;

        System.out.print("How many students are there? ");
        n = Integer.parseInt(System.console().readLine());

        student = new String [n];

        for(i = 0; i < n; i++){
            System.out.print("Student " + (i+1) + ": ");
            student[i] = System.console().readLine(); 
        }

        System.out.print("Letter to search: ");
        letter = String.valueOf(System.console().readLine().charAt(0));
        letter = letter.toLowerCase();

        System.out.println("Names that start with letter " + letter + ":");
        for(i = 0; i < n ; i++ ){
            compare = String.valueOf(student[i].charAt(0)); 
            compare = compare.toLowerCase();

            if(compare.equals(letter)){
                System.out.println(student[i]);
            }
        }
    }
}