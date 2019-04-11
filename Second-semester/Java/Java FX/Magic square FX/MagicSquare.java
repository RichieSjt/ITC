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
        int i;
        TextField[] textFields = new TextField[9];

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
        /*
        for(i = 0; i < 9; i++){
            textFields[i].setAlignment(Pos.CENTER);
        }*/

        Label result = new Label("Result");
        Button reset = new Button("Reset");
        Button check = new Button("Check");

        //Textfields to array
        textFields[0] = t1;
        textFields[1] = t2; 
        textFields[2] = t3;
        textFields[3] = t4;
        textFields[4] = t5;
        textFields[5] = t6;
        textFields[6] = t7;
        textFields[7] = t8;
        textFields[8] = t9;

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
                String r = "";
                boolean isMagic;
                int constant;

                int n1 = Integer.parseInt(t1.getText());
                int n2 = Integer.parseInt(t2.getText());
                int n3 = Integer.parseInt(t3.getText());
                int n4 = Integer.parseInt(t4.getText());
                int n5 = Integer.parseInt(t5.getText());
                int n6 = Integer.parseInt(t6.getText());
                int n7 = Integer.parseInt(t7.getText());
                int n8 = Integer.parseInt(t8.getText());
                int n9 = Integer.parseInt(t9.getText());
                
                //Rows check
                constant = n1 + n2 + n3;
                isMagic = constant == n4 + n5 + n6;
                isMagic &= constant == n7 + n8 + n9;
                //Columns check
                isMagic &= constant == n1 + n4 + n7;
                isMagic &= constant == n2 + n5 + n8;
                isMagic &= constant == n3 + n6 + n9;

                r = isMagic ? "It is a magic square" : "It is not a magic square"; 
                result.setText(r);
            }
        });

        reset.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
                int i; 
                for(i = 0; i < 9; i++)
                    textFields[i].setText("");
                result.setText("Result");
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
}