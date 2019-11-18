import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import java.io.*;

public class UserManagement extends Scene {
    private Main main;
    private TextField username, password;
    private ObservableList<User> data;
    private ListView<User> lvUsers;
    private ChoiceBox<String> cb;

    public UserManagement(Main main){
        super(new VBox());
        this.main = main;

        Menu menu1 = new Menu("Options");
        Menu menu2 = new Menu("Menu");
        MenuItem saveOption = new MenuItem("Save");
        MenuItem logoutOption = new MenuItem("Logout");
        MenuItem exitOption = new MenuItem("Exit");
        MenuItem registerOption = new MenuItem("Edit users");
        MenuItem resourcesOption = new MenuItem("Resources");
        menu1.getItems().add(saveOption);
        menu1.getItems().add(logoutOption);
        menu1.getItems().add(exitOption);
        menu2.getItems().add(registerOption);
        menu2.getItems().add(resourcesOption);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        
        FlowPane wrapper = new FlowPane();
        GridPane pane = new GridPane();
        VBox mainContent = new VBox();
        FlowPane buttons = new FlowPane();
        VBox vbox = new VBox(40);

        Label lblUsername = new Label("Username:");
        Label lblPassword = new Label("Password:");
        Label lblPrivilege = new Label("Privilege");
        Button register = new Button("Register");
        Button delete = new Button("Delete");
        Button update = new Button("Update");
        
        username = new TextField();
        password = new TextField();

        cb = new ChoiceBox<>();
        cb.getItems().addAll("Manager", "Information manager", "Translator", "Consultant");

        //Users Listview
        data = FXCollections.observableArrayList();
        lvUsers = new ListView<>(data);
        getUserList();
        
        register.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                createUser();
            }
        });

        delete.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                deleteUser();
            }
        });

        update.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                updateUser();
            }
        });

        lvUsers.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                userData();
            }
        });

        saveOption.setOnAction(new EventHandler
        <ActionEvent>() {
            public void handle(ActionEvent e){
                main.saveUserArray();
                main.saveCounter();
                saveUserList();
            }
        });

        logoutOption.setOnAction(new EventHandler
        <ActionEvent>() {
            public void handle(ActionEvent e){
                main.setLoginScene();
            }
        });

        exitOption.setOnAction(new EventHandler
        <ActionEvent>() {
            public void handle(ActionEvent e){
                main.closeStage();
            }
        });

        resourcesOption.setOnAction(new EventHandler
        <ActionEvent>() {
            public void handle(ActionEvent e){    
                Alert error = new Alert(Alert.AlertType.ERROR);
                try{
                    if(main.getCurrentUser().getPrivilege().equals("Information manager")
                    || main.getCurrentUser().getPrivilege().equals("Translator")
                    || main.getCurrentUser().getPrivilege().equals("Consultant"))
                        main.setResourceScene();
                    else{
                        throw new PrivilegeException("You don't have the privileges to perform this action");
                    }
                }catch(PrivilegeException privE){   
                    error.setTitle("Privilege exception");
                    error.setHeaderText(privE.getMessage());
                    error.showAndWait();
                }
            }
        });

        buttons.setHgap(15);
        buttons.setVgap(15);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(25, 10, 10, 10));

        pane.setHgap(15);
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        wrapper.setHgap(15);
        wrapper.setVgap(15);
        wrapper.setAlignment(Pos.CENTER);
        wrapper.setPadding(new Insets(10, 10, 10, 10));

        mainContent.setAlignment(Pos.CENTER);

        //Adding elements to the pane
        pane.add(lblUsername, 0, 0);
        pane.add(username, 1, 0);
        pane.add(lblPassword, 0, 1);
        pane.add(password, 1, 1);
        pane.add(lblPrivilege, 0, 2);
        pane.add(cb, 1, 2);

        buttons.getChildren().add(register);
        buttons.getChildren().add(delete);
        buttons.getChildren().add(update);
        wrapper.getChildren().add(pane);
        wrapper.getChildren().add(lvUsers); 
        mainContent.getChildren().add(wrapper);
        mainContent.getChildren().add(buttons);
    
        vbox.getChildren().addAll(menuBar, mainContent);
        super.setRoot(vbox);
    }
    private void createUser() {
        try{
            User u = new User();
            u.setUsername(username.getText());
            u.setPassword(password.getText());
            u.setPrivilege((String)cb.getValue());
            username.setText("");
            password.setText("");
            cb.setValue(null);
            registerUser(u);
        }catch(EmptyFieldException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty field");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }
    private void registerUser(User u){
        int i, exist = 0, overwrite = 0;
        Alert error = new Alert(Alert.AlertType.ERROR);
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("User registered succesfully");

        try{
            if(main.getCounter() > 0){
                for(i = 0; i < main.getCounter() ; i++){
                    if(main.getUsers()[i].getUsername().equals(u.getUsername()))
                        exist++;
                    else if(main.getUsers()[i].getUsername().equals("default")){
                        main.overwriteDeletedUser(u, i);
                        data.add(u);
                        overwrite++;
                        break;
                    }
                }
                if(overwrite == 1)
                    success.showAndWait();
                else if(exist == 0){
                    main.setUser(u);
                    data.add(u);
                    success.showAndWait();
                }else
                    throw new ExistingUserException ("Username already exists");
            }else if(main.getCounter() == 0){
                main.setUser(u);
                data.add(u);
                success.showAndWait();
            }
        }catch (ExistingUserException e) {
            error.setTitle("Error while creating user");
            error.setHeaderText(e.getMessage());
            error.showAndWait();
        }  
    }
    private void deleteUser(){
        User u = lvUsers.getSelectionModel().getSelectedItem();
        
        //Deleting the user from the main array
        main.deleteUserFromArray(u.getUsername());
        //Deleting the user from the observable list
        data.remove(u);
        username.setText("");
        password.setText("");
        cb.setValue(null);
    }
    private void updateUser(){
        //TODO: Create temporal selectedUser, retrieve it and compare with the main
        //array and overwrite with the current text info.

        /*
        //Save changes users list
        saveUserList();
        */
    }
    private void userData(){
        User u = lvUsers.getSelectionModel().getSelectedItem();
        username.setText(u.getUsername());
        password.setText(u.getPassword());
        cb.setValue(u.getPrivilege());
    }

    private void saveUserList() {
        try {
            User[] users = new User[lvUsers.getItems().size()];
            int i = 0;
            for (User u : lvUsers.getItems()) {
                users[i] = u;
                i++;
            }
            FileOutputStream fos = new FileOutputStream("UsersListUM.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void getUserList() {
        try {
            FileInputStream fis = new FileInputStream("UsersListUM.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User[] users = (User[]) ois.readObject();
            for (int i = 0; i < users.length; i++) {
                data.add(users[i]);
            }
            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}