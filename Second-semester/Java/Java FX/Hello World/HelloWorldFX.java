import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class HelloWorldFX extends Application{
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World");
        Group group = new Group();
        Scene scene = new Scene(group);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}