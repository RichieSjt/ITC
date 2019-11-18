import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.event.ActionEvent;

public class Login extends Scene {
    private Main main;
    private TextField username;
    private PasswordField password;

    public Login(Main main){
        super(new VBox());
        this.main = main;

        Menu menu1 = new Menu("Options");
        MenuItem exitOption = new MenuItem(" Exit      ");
        menu1.getItems().add(exitOption);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu1);

        GridPane pane = new GridPane();
        VBox mainContent = new VBox(50);
        VBox vbox = new VBox(80);

        pane.setHgap(15);
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 80, 10));

        Label lblLogin = new Label("Login");
        lblLogin.setFont(Font.font(23));
        Label lblUsername = new Label("Username:");
        Label lblPassword = new Label("Password:");
        
        username = new TextField();
        password = new PasswordField();

        exitOption.setOnAction(new EventHandler
        <ActionEvent>() {
            public void handle(ActionEvent e){
                main.closeStage();
            }
        });

        Button loginButton = new Button("Login");
        loginButton.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                checkUser();
            }
        });

        pane.add(lblUsername, 0, 0);
        pane.add(username, 1, 0);
        pane.add(lblPassword, 0, 1);
        pane.add(password, 1, 1);
        pane.add(loginButton, 1, 2);
        
        mainContent.setAlignment(Pos.CENTER);
        mainContent.getChildren().addAll(lblLogin, pane); 

        vbox.getChildren().addAll(menuBar, mainContent);
        super.setRoot(vbox);
    }
    public void checkUser(){
        for(int i = 0; i < main.getCounter() ; i++){
            if(main.getUsers()[i].getUsername().equals(username.getText())){
                User u = main.getUsers()[i];
                main.setCurrentUser(u);
                if(u.getPassword().equals(password.getText())){
                    if(u.getPrivilege().equals("Manager")){
                        main.setUserCreationScene();
                    }else if(u.getPrivilege().equals("Information manager")
                    || u.getPrivilege().equals("Translator") 
                    || u.getPrivilege().equals("Consultant")){
                        main.setResourceScene();
                    }
                    username.setText("");
                    password.setText("");
                }
                break;
            }
        }
                
    }
}