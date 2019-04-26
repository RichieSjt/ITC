import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MovieManager extends Application{
	private ObservableList<Movie> data;
    private ListView<Movie> lvMovie;
    private TextField title, duration, director, year, classification;
    
    public void start(Stage stage) throws Exception{

        //Stage settings
        stage.setTitle("Movie manager");
        stage.setWidth(800);
        stage.setHeight(600);

        BorderPane mainPane = new BorderPane();
        FlowPane contentPane = new FlowPane();
        FlowPane controlsPane = new FlowPane();
        GridPane moviePane = new GridPane();
        mainPane.setCenter(contentPane);
        mainPane.setBottom(controlsPane);        
        contentPane.getChildren().add(moviePane);

        title = new TextField();
        director = new TextField();
        duration = new TextField();
        year = new TextField();
        classification = new TextField();
        
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

        //List
		data = FXCollections.observableArrayList();
		lvMovie = new ListView<>(data);
		contentPane.getChildren().add(lvMovie);

        //Bottom content
        controlsPane.getChildren().add(add); 
        controlsPane.getChildren().add(delete);
        controlsPane.getChildren().add(save);

        add.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                addMovie();
            }
        });

        delete.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                deleteMovie();
            }
        });

        lvMovie.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                movieData();
            }
        });
        
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
    private void addMovie(){
        try {
            Movie m = new Movie();
            //Set attributes
            m.setTitle(title.getText());
            m.setDirector(director.getText());
            m.setDuration(duration.getText()); 
            m.setYear(year.getText());
            m.setClassification(classification.getText());
            //Add object to list
            data.add(m);
            //Clear form
            title.setText("");
            director.setText("");
            duration.setText("");
            year.setText("");
            classification.setText("");
        }catch (EmptyFieldException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add a movie");
            alert.setHeaderText("Error while adding a movie");
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }
    private void deleteMovie(){
        Movie m = lvMovie.getSelectionModel().getSelectedItem();
        data.remove(m);
        title.setText("");
        director.setText("");
        duration.setText("");
        year.setText("");
        classification.setText("");
    }
    private void movieData(){
        Movie m = lvMovie.getSelectionModel().getSelectedItem();
        title.setText(m.getTitle());
        duration.setText(m.getDuration());
        director.setText(m.getDirector());
        year.setText(m.getYear());
        classification.setText(m.getClassification());
    }
}