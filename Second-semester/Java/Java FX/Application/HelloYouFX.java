import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class HelloYouFX extends Application{
    public void start(Stage stage) throws Exception{
        stage.setTitle("Hello You");
        stage.setWidth(1000);
        stage.setHeight(500);

        GridPane pane=new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName=new Label("Name:");
        pane.add(lblName,0,0);
        TextField txtName=new TextField();
        pane.add(txtName,1,0);

        Label lblAge=new Label("Age:");
        pane.add(lblAge,0,1);
        TextField txtAge=new TextField();
        pane.add(txtAge,1,1);

        Button bttnClick=new Button("Click");
        pane.add(bttnClick,1,2);

        Scene scene=new Scene(pane);
        stage.setScene(scene);

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}