public class Canvas{
    public static void main(String[] args) {
        Element[] elements = new Element[10];

        Element b1 = new BasicElement("red", "2, 3", "4, 1");
        System.out.println("Basic element 1 area: " + b1.calculateArea());

        Element b2 = new BasicElement("green", "3, 5", "5, 4");
        System.out.println("Basic element 2 area: " + b2.calculateArea());

        Element ge1 = new GroupElement();
        ge1.setBasicElement(b1);
        ge1.setBasicElement(b2);

        System.out.println("Group element area: " + ge1.calculateArea());
        System.out.println("The group element color is: " + ge1.determineColor());

        elements[1] = b1;
        elements[2] = b2;
        elements[3] = ge1;
    }
}