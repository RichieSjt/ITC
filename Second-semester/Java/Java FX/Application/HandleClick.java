import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class HandleClick implements EventHandler<MouseEvent> {
    private TextField txtName;

    public void handle(MouseEvent event) {
        System.out.println("Hello " + txtName.getText());
    }
    public void setTxtName(TextField txtName){
        this.txtName = txtName;
    }
}