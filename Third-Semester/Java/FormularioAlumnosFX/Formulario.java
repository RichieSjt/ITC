import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Formulario extends Application{
    public void start(Stage stage) throws Exception{
        Scene formularioScene = new FormularioScene();

        stage.getIcons().add(new Image("Formulario.png"));
        stage.setTitle("Formulario alumnos");
        stage.setWidth(750);
        stage.setHeight(650);
        stage.setScene(formularioScene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
