import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class MagicSquare extends Application{
    public void start(Stage stage) throws Exception{

        //Stage settings
        stage.setTitle("Magic square");
        stage.setWidth(550);
        stage.setHeight(300);

        //Pane elements
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        TextField t5 = new TextField();
        TextField t6 = new TextField();
        TextField t7 = new TextField();
        TextField t8 = new TextField();
        TextField t9 = new TextField();
        Label result = new Label("Result");
        Button reset = new Button("Reset");
        Button check = new Button("Check");

        GridPane pane=new GridPane();
        //Vertical and horizontal gaps between columns
        pane.setHgap(10);
        pane.setVgap(10);
        //Grid alignment
        pane.setAlignment(Pos.CENTER);
        //Padding
        pane.setPadding(new Insets(10, 10, 10, 10));

        //Adding components to the grid
        pane.add(t1, 0, 0);
        pane.add(t2, 1, 0);
        pane.add(t3, 2, 0);
        pane.add(t4, 0, 1);
        pane.add(t5, 1, 1);
        pane.add(t6, 2, 1);
        pane.add(t7, 0, 2);
        pane.add(t8, 1, 2);
        pane.add(t9, 2, 2);
        pane.add(result, 0, 3);
        pane.add(reset, 1, 3);
        pane.add(check, 2, 3);

        check.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
                String r, numbers = "";

                numbers += t1.getText() + " ";
                numbers += t2.getText() + " ";
                numbers += t3.getText() + " ";
                numbers += t4.getText() + " ";
                numbers += t5.getText() + " ";
                numbers += t6.getText() + " ";
                numbers += t7.getText() + " ";
                numbers += t8.getText() + " ";
                numbers += t9.getText();

                r = magic(numbers);
                result.setText(r);
            }
        });

        reset.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
            }
        });
        
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(MagicSquare.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

    public static String magic(String numbers){
        String result;
        int constant, i;
        boolean isMagic;
        String[] num;
        int[] numInt = new int[9];
        if (numbers.equals("        "))
            result = "Please fill the square";
        else{
            num = numbers.split(" ");
            for (i = 0; i < num.length; i++){
                numInt[i] = Integer.parseInt(num[i]);
            }

            //Rows check
            constant = numInt[0] + numInt[1] + numInt[2];
            isMagic = constant == numInt[3] + numInt[4] + numInt[5];
            isMagic &= constant == numInt[6] + numInt[7] + numInt[8];

            //Columns check
            isMagic &= constant == numInt[0] + numInt[3] + numInt[6];
            isMagic &= constant == numInt[1] + numInt[4] + numInt[7];
            isMagic &= constant == numInt[2] + numInt[5] + numInt[8];

            result = isMagic ? "It is a magic square" : "It is not a magic square";
        }
        return result;
    }
}