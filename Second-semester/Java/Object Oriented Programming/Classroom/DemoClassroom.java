public class DemoClassroom{
    public static void main(String[] args) {

        Student s1 = new Student(); 
        s1.ID = "A01650943";
        s1.age = 16; 
        s1.major = "Computer science";

        Student s2 = new Student(); 
        s2.ID = "A01651153";
        s2.age = 18; 
        s2.major = "Computer science";

        Student s3 = new Student(); 
        s3.ID = "A01652876";
        s3.age = 17; 
        s3.major = "Computer science";

        Classroom c = new Classroom(30);
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);

        System.out.print("Adults: ");
        System.out.println(c.countAdults());

    }
}