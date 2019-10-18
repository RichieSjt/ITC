import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;

public class FormularioScene extends Scene {
    public TextField nombre, matricula, calificacion;
    private ObservableList<Alumno> data;
    private ListView<Alumno> lvAlumnos;
    private ListaLigada<Integer> lista = new ListaLigada<>();
    private Alumno[] alumnos = new Alumno[100];
    private int counter = 0;

    public FormularioScene(){
        super(new FlowPane());

        data = FXCollections.observableArrayList();
        lvAlumnos = new ListView<>(data);

        //Contenedores donde se acomodarán todos los elementos
        FlowPane contenedorPrincipal = new FlowPane();
        VBox izquierda = new VBox(40);
        GridPane pane = new GridPane();

        //Elementos de la escena
        Label lblNombre = new Label("Nombre:");
        Label lblMatricula = new Label("Matricula:");
        Label lblCalificacion = new Label("Calificacion:");

        nombre = new TextField();
        matricula = new TextField();
        calificacion = new TextField();

        Button registrar = new Button("Registrar");
        Button ordenar = new Button("Ordenar");

        //Labels y textfields ordenados en un grid pane
        pane.add(lblNombre, 0, 0);
        pane.add(nombre, 1, 0);
        pane.add(lblMatricula, 0, 1);
        pane.add(matricula, 1, 1);
        pane.add(lblCalificacion, 0, 2);
        pane.add(calificacion, 1, 2);
        pane.setHgap(15);
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        //Elementos del lado izquierdo ordenados en una Vbox verticalmente
        izquierda.getChildren().add(pane);
        izquierda.getChildren().add(registrar);
        izquierda.getChildren().add(ordenar);
        izquierda.setAlignment(Pos.CENTER);

        //Agregamos todos nuestros contenedores al contenedor principal
        contenedorPrincipal.getChildren().add(izquierda);
        contenedorPrincipal.getChildren().add(lvAlumnos);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        super.setRoot(contenedorPrincipal);
        
        //Acciones que ejecutarán los botones al ser clickeados
        registrar.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                crearAlumno(); 
            }
        });

        ordenar.addEventFilter(MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e){
                lvAlumnos.getItems().clear();
                ordenarLista();
            }
        });

    }

    //Funciones

    private void crearAlumno(){

        try{
            Alumno a = new Alumno();
            a.setNombre(nombre.getText());
            a.setMatricula(matricula.getText());
            a.setCalificacion(calificacion.getText());
            nombre.setText("");
            matricula.setText("");
            calificacion.setText("");
            registrarAlumno(a); 
        }catch(EmptyFieldException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campo vacio");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }

    }

    private void registrarAlumno(Alumno a){
        Alert error = new Alert(Alert.AlertType.ERROR);
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Exito");
        success.setHeaderText("El alumno se ha registrado correctamente");
        
        alumnos[counter] = a;
        lista.insertarAlInicio(Integer.parseInt(a.getCalificacion()));
        data.add(a);
        success.showAndWait();
        counter++;
    }

    private void ordenarLista(){
        int calif = 0;

        lista.quickSort();

        for(int i = 0; i < lista.contarElementos(); i++){
            calif = lista.encontrarElementoEnIndice(i);
            for(int j = 0; j < lista.contarElementos() ; j++){
                if(calif == Integer.parseInt(alumnos[j].getCalificacion())){
                    data.add(alumnos[j]);
                }
            }
        }
        lvAlumnos.setItems(data);
    }
}