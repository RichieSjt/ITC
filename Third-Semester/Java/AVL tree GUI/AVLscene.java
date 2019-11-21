import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class AVLscene extends Scene {
    private Main main;
    private TextField input;
    private Tree<Integer> arbol = new Tree<>();
    ArrayList<StackPane> circles = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public AVLscene(Main main) {
        super(new VBox());
        this.main = main;

        /*************** 
        * GUI Elements *
        ****************/
        VBox mainContent = new VBox(20);
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");
        MenuItem exitOption = new MenuItem("Exit     ");
        Pane avl = new Pane();
        FlowPane bottom = new FlowPane();
        
        Label lblinput = new Label("Elemento a insertar:");
        input = new TextField();
        Button insert = new Button("Insertar");
        Button delete = new Button("Borrar");

        /*********** 
        *  Styles  *
        ************/
        avl.prefHeight(300);
        avl.prefWidth(400);
        avl.setPadding(new Insets(10, 10, 10, 10));

        bottom.setHgap(15);
        bottom.setVgap(15);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10, 10, 10, 10));
        
        /************************* 
        * Main content structure *
        **************************/
        menu.getItems().add(exitOption);
        menuBar.getMenus().add(menu);
        bottom.getChildren().addAll(lblinput, input, insert, delete);
        mainContent.getChildren().addAll(menuBar, avl, bottom);
        super.setRoot(mainContent);

        /***************** 
        * Event handlers *
        ******************/
        exitOption.setOnAction(e -> {
            main.closeStage();
        });
        insert.setOnAction(e -> {
            int toInsert = Integer.parseInt(input.getText());
            arbol.insertElement(toInsert);
            avl.getChildren().add(displayCircle(toInsert));
            
            input.setText("");
            if(circles.size()>2 && circles.size()%2==0)
                displayLines();
        });
        delete.setOnAction(e -> {
            //arbol.deleteNode(Integer.parseInt(input.getText()));
            input.setText("");
        });
    }
    public StackPane displayCircle(int element){
        StackPane stackPane = new StackPane();
        //For text
        Text text = new Text(element+"");
        text.setFont(new Font(30));
        text.setBoundsType(TextBoundsType.VISUAL);
        //FOr circles
        Circle circle = new Circle(150.0f, 150.0f, 30.f);
        circle.setId("circle");
        circle.setStroke(Color.GRAY);
        circle.setStrokeWidth(1);
        circle.setStrokeType(StrokeType.INSIDE);
        circle.setFill(Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        stackPane.relocate(x, y);
        stackPane.getChildren().addAll(circle,text);

        circles.add(stackPane);
        return stackPane;
    }
    public void displayLines(){
        for(int i = 0; i < circles.size(); i+=2){
            connect(circles.get(i), circles.get(i+1));
        }
    }

    public void connect(StackPane stack1, StackPane stack2){
        Line line = new Line();
        Circle circle1 = (Circle)stack1.lookup("circle");
        Circle circle2 = (Circle)stack2.lookup("circle");

        
        //TODO:  conseguir las posiciones de x y y de los dos circulos
        line.setStrokeWidth(2);
        line.setStartX(circle1.getCenterX());
        line.setStartY(circle1.getCenterY());
        line.setEndX(circle2.getCenterX());
        line.setEndY(circle2.getCenterY());
        
    }


}