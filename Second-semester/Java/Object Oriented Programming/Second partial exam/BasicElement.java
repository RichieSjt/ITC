public class BasicElement extends Element{
    private String upperLeft;
    private String lowerRight;

    // uperLeft param example: // 23, 2
    public BasicElement(String color, String upperLeft, String lowerRight){
        super.color = color;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }   
    public int calculateArea(){
        int upX, upY, downX, downY, base, height;

        //Calculating the area based on the coordinates x, y for the lower and upper points
        upX = Integer.parseInt(upperLeft.substring(0, upperLeft.indexOf(",")));
        upY = Integer.parseInt(upperLeft.substring(upperLeft.indexOf(" ") + 1));
        downX = Integer.parseInt(lowerRight.substring(0, lowerRight.indexOf(",")));
        downY = Integer.parseInt(lowerRight.substring(lowerRight.indexOf(" ") + 1));
        
        base = downX - upX;
        height = upY - downY;

        super.area = Math.abs(base * height);
        return super.area;
    }
    public String getColor(){
        return color;
    }
}