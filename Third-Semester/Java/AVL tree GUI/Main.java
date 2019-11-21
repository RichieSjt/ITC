import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import java.io.*;
import java.util.Scanner;

public class Main extends Application{
    private Stage mainStage;
    private Scene AVLscene = new AVLscene(this);

    public void start(Stage stage) throws Exception{
        mainStage = stage;
        stage.setTitle("AVL tree");
        stage.setWidth(600);
        stage.setHeight(550);
        stage.show();
        stage.setScene(AVLscene);
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void closeStage(){
        mainStage.close();
    }

}