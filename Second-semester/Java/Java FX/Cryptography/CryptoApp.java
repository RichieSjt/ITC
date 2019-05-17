import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class CryptoApp extends Application {
    private CaesarCode caesar = new Caesar();

    public void start(Stage stage) throws Exception{

        stage.setTitle("Cryptography");
        stage.setWidth(720);
        stage.setHeight(650);

        VBox vbox = new VBox(40);
        FlowPane fp = new FlowPane();
        fp.setHgap(10);
        fp.setVgap(10);
        fp.setAlignment(Pos.CENTER);
        fp.setPadding(new Insets(10, 10, 10, 10));
        
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(55, 10, 10, 10));

        Label offsetLbl = new Label("Gap offset:");
        pane.add(offsetLbl, 0, 0);
        TextField offset = new TextField();
        pane.add(offset, 1, 0);

        Label codeLbl = new Label("Code:");
        pane.add(codeLbl, 0, 1);
        TextArea codeArea = new TextArea();
        pane.add(codeArea, 1, 1);
        
        Label decodeLbl = new Label("Decode:");
        pane.add(decodeLbl, 0, 2);
        TextArea decodeArea = new TextArea();
        pane.add(decodeArea, 1, 2);

        Button codeButton = new Button("Code");
        fp.getChildren().add(codeButton);
        codeButton.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
            }
        });
        Button decodeButton = new Button("Decode");
        fp.getChildren().add(decodeButton);
        decodeButton.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event){
            }
        });

        vbox.getChildren().addAll(pane, fp);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}