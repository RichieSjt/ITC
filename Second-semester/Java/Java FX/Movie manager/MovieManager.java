import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class MovieManager extends Application{
    public void start(Stage stage) throws Exception{

        //Stage settings
        stage.setTitle("Movie manager");
        stage.setWidth(800);
        stage.setHeight(600);

        BorderPane mainPane = new BorderPane();
        GridPane moviePane = new GridPane();
        FlowPane contentPane = new FlowPane();
        FlowPane controlsPane = new FlowPane();

        mainPane.setCenter(contentPane);
        mainPane.setBottom(controlsPane);

        TextField title = new TextField();
        TextField director = new TextField();
        TextField duration = new TextField();
        TextField year = new TextField();
        TextField classification = new TextField();
        
        Label lblTitle = new Label("Title:");
        Label lblDirector = new Label("Director:");
        Label lblDuration = new Label("Duration:");
        Label lblYear = new Label("Year:");
        Label lblClassification = new Label("Classification:");

        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button save = new Button("Save");

        //Movie pane content
        moviePane.add(lblTitle, 0, 0);
        moviePane.add(title, 1, 0);
        moviePane.add(lblDirector, 0, 1);
        moviePane.add(director, 1, 1);
        moviePane.add(lblDuration, 0, 2);
        moviePane.add(duration, 1, 2);
        moviePane.add(lblYear, 0, 3);
        moviePane.add(year, 1, 3);
        moviePane.add(lblClassification, 0, 4);
        moviePane.add(classification, 1, 4);

        //Bottom content
        controlsPane.getChildren().add(add); 
        controlsPane.getChildren().add(delete);
        controlsPane.getChildren().add(save);
        
        
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}