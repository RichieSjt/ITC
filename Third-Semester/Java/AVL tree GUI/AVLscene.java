import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class AVLscene extends Scene {
    private Main main;
    private TextField input;
    private Tree<Integer> arbol = new Tree<>();
    private ArrayList<StackPane> circles = new ArrayList<>();
    private double vGap = 60;
    private double radius = 20;
    private Pane avl;

    
    public AVLscene(Main main) {
        super(new VBox());
        this.main = main;

        /*************** 
        * GUI Elements *
        ****************/
        VBox mainContent = new VBox(20);
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options    ");
        MenuItem randomTree = new MenuItem("Random tree");
        MenuItem clear = new MenuItem("Clear");
        MenuItem exitOption = new MenuItem("Exit");
        avl = new Pane();
        FlowPane bottom = new FlowPane();
        
        Label lblinput = new Label("Elemento:");
        input = new TextField();
        Button insert = new Button("Insertar");
        Button delete = new Button("Borrar");

        /*********** 
        *  Styles  *
        ************/
        avl.setMinSize(900, 450);
        avl.setPadding(new Insets(20, 20, 20, 20));

        bottom.setHgap(15);
        bottom.setVgap(15);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10, 10, 10, 10));
        
        /************************* 
        * Main content structure *
        **************************/
        menu.getItems().addAll(randomTree, clear, exitOption);
        menuBar.getMenus().add(menu);
        bottom.getChildren().addAll(lblinput, input, insert, delete);
        mainContent.getChildren().addAll(menuBar, avl, bottom);
        super.setRoot(mainContent);

        /***************** 
        * Event handlers *
        ******************/
        exitOption.setOnAction(e -> {
            main.closeStage();
        });
        insert.setOnAction(e -> {
            try{
                int toInsert = Integer.parseInt(input.getText());
                try{
                    arbol.insertElement(toInsert);
                    displayAVLTree();
                }catch(DuplicateException de){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Duplicate");
                    alert.setHeaderText(de.getMessage());
                    alert.showAndWait();
                }
            }catch(Exception empty){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Empty field");
                alert.setHeaderText("Please introduce an element");
                alert.showAndWait();
            }
            
            input.setText("");
        });
        delete.setOnAction(e -> {
            arbol.deleteNode(Integer.parseInt(input.getText()));
            displayAVLTree();
            input.setText("");
        });
    }
    
    /******************** 
    * Recursive display *
    *********************/
    public void displayAVLTree() {
        avl.getChildren().clear(); // Clear the pane
        if (arbol.getOrigin() != null) {
            // Display tree recursively
            displayAVLTree(arbol.getOrigin(), avl.getWidth() / 2, vGap, avl.getWidth() / 4);
        }
    }

    private void displayAVLTree(Node root, double x, double y, double hGap) {
        if (root.getLeft() != null) {
            // Draw a line to the left node
            avl.getChildren().add(new Line(x - hGap, y + vGap, x, y));
            // Draw the left subtree recursively
            displayAVLTree(root.getLeft(), x - hGap, y + vGap, hGap / 2);
        }

        if (root.getRight() != null) {
            // Draw a line to the right node
            avl.getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the right subtree recursively
            displayAVLTree(root.getRight(), x + hGap, y + vGap, hGap / 2);
        }
        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setId("circle");
        circle.setStroke(Color.GRAY);
        circle.setStrokeWidth(1);
        //circle.setFill(Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        circle.setFill(Color.CYAN);
        avl.getChildren().addAll(circle, new Text(x - 4, y + 4, root.getElement() + ""));
    }

}