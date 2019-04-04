public class GroupElement extends Element{
    private BasicElement[] basicElements;
    private int counter;
    
    public GroupElement(){
        basicElements= new BasicElement[10];
    }
    public int calculateArea(){
        int i, result = 0;
        for(i = 0; i < counter; i++){
            result += basicElements[i].calculateArea();
        }
        return result;
    }
    public String determineColor(){
        int i, j;
        String color;
        String[] colors = new String[counter];

        for(i = 0; i < counter; i++){
            colors[i] = basicElements[i].getColor();
        }
        for(i = 0; i < colors.length; i++){
            if(!colors[0].equals(colors[i]))
                color = "multiple";
            else
                color = colors[0];
        }
        return color;
    }
    public void setBasicElement(BasicElement be){
        basicElements[counter] = be;
        counter++;
    }

}