import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import java.io.*;
import java.util.Scanner;

public class Main extends Application{
    private Stage mainStage;
    private Scene userCreationScene = new UserManagement(this);
    private Scene loginScene = new Login(this);
    private Scene resourceScene = new ResourceManagement(this);
    private User[] users = new User[10];
    private Resource[] resources = new Resource[15];
    private User currentUser;
    private int resourcesCounter = 0;
    private int counter = 1;

    //TODO: Implement privilege system
    public void start(Stage stage) throws Exception{
        mainStage = stage;
        stage.getIcons().add(new Image("eagle.png"));
        stage.setTitle("Mexico Languages");
        stage.setWidth(600);
        stage.setHeight(550);
        stage.setScene(loginScene);
        stage.show();

        retrieveCounter();
        retrieveResourceCounter();
        getUserArray();
        getResourceArray();

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPrivilege("Manager");
        users[0] = admin;
    }
    public static void main(String[] args) {
        launch(args);
    }

    //Users array methods
    public void setUser(User u){
        users[counter] = u;
        counter++;
    }
    public void deleteUserFromArray(String username){
        for(int i = 0; i < counter; i ++) {
            if(users[i].getUsername().equals(username)){
                try{
                    users[i].setUsername("default");
                    users[i].setPassword("F9Dcld7_sdE5Fvv%yUKlMn23#gvGK23");
                    users[i].setPrivilege("none");
                    break;
                }catch(EmptyFieldException ignore) {}
            }
        }
    }
    public void overwriteDeletedUser(User u, int index){
        users[index] = u;
    }
    public int getCounter(){
        return counter;
    }
    public void saveCounter(){
        try{
            String write = counter + "";
            System.out.println("Users counter: " + write);
            FileWriter fw = new FileWriter(new File("Ucounter.txt"));
            fw.write(write);
            fw.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing counter file");          
        }
    }
    public void retrieveCounter(){
        try {
            Scanner sc = new Scanner(new File("Ucounter.txt"));
            counter = Integer.parseInt(sc.nextLine());
            
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open counter file");                
        }
    }
    public User[] getUsers(){
        return users;
    }
    public void saveUserArray() {
        try {
            FileOutputStream fos = new FileOutputStream("UsersArrayM.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public void getUserArray() {
        try {
            FileInputStream fis = new FileInputStream("UsersArrayM.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (User[]) ois.readObject();
            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Resources array methods
    public int getResourceCounter(){
        return resourcesCounter;
    }
    public void saveResourceCounter(){
        try{
            String write = resourcesCounter + "";
            System.out.println("Resources counter: " + write);
            FileWriter fw = new FileWriter(new File("Rcounter.txt"));
            fw.write(write);
            fw.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing counter file");          
        }
    }
    public void retrieveResourceCounter(){
        try {
            Scanner sc = new Scanner(new File("Rcounter.txt"));
            resourcesCounter = Integer.parseInt(sc.nextLine());
            sc.close();
            
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open counter file");                
        }
    }
    public void setResource(Resource r){
        resources[resourcesCounter] = r;
        resourcesCounter++;
    }
    public void saveResourceArray() {
        try {
            FileOutputStream fos = new FileOutputStream("ResourcesArrayM.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(resources);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public void getResourceArray() {
        try {
            FileInputStream fis = new FileInputStream("ResourcesArrayM.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);
            resources = (Resource[]) ois.readObject();
            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Scenes methods
    public void setUserCreationScene(){
        mainStage.setWidth(600);
        mainStage.setHeight(600);
        mainStage.setScene(userCreationScene);
    }
    public void setLoginScene(){
        mainStage.setWidth(550);
        mainStage.setHeight(550);
        mainStage.setScene(loginScene);
    }
    public void setResourceScene(){
        mainStage.setWidth(850);
        mainStage.setHeight(700);
        mainStage.setScene(resourceScene);
    }
    public void closeStage(){
        mainStage.close();
    }
    public void setCurrentUser(User currentUser){
        this.currentUser = currentUser;
        System.out.println("Welcome back " + currentUser.getUsername());
    }
    public User getCurrentUser(){
        return currentUser;
    }

}