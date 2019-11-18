import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import java.io.*;

public class ResourceManagement extends Scene {
    private Main main;
    private TextField language, region, responsible, wordsDuration, pagesPath;
    private ChoiceBox<String> statusBox, resourceTypeBox;
    private ObservableList<Text> dataText;
    private ListView<Text> lvText;
    private ObservableList<Recording> dataRecording;
    private ListView<Recording> lvRecording;
    private TextArea textContent;

    public ResourceManagement(Main main) {
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

        GridPane pane = new GridPane();
        FlowPane wrapper = new FlowPane();
        FlowPane buttons = new FlowPane();
        VBox listViewsBox = new VBox(10);
        VBox vbox = new VBox(40);
        VBox mainContent = new VBox(20);

        Label lblLanguage = new Label("Language:");
        Label lblStatus = new Label("Status:");
        Label lblRegion = new Label("Region:");
        Label lblResponsible = new Label("Responsible:");
        Label lblWordsDuration = new Label("");
        Label lblPagesPath = new Label("");
        Label lblResourceType = new Label("Resource type:");
        Label lblTexts = new Label("Texts");
        Label lblRecordings = new Label("Recordings");

        language = new TextField();
        region = new TextField();
        responsible = new TextField();
        wordsDuration = new TextField();
        pagesPath = new TextField();
        textContent = new TextArea();
        statusBox = new ChoiceBox<>();
        /*
         * if(main.getCurrentUser().getPrivilege().equals("Information manager"))
         * statusBox.getItems().addAll("Finding", "Translation", "To amend", "Free");
         * else if(main.getCurrentUser().getPrivilege().equals("Information manager"))
         * statusBox.getItems().addAll("Translation", "Free"); else
         * statusBox.getItems().addAll("To amend");
         */
        statusBox.getItems().addAll("Finding", "Translation", "To amend", "Free");
        resourceTypeBox = new ChoiceBox<>();
        resourceTypeBox.getItems().addAll("Text", "Recording");

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button updateButton = new Button("Update");

        pane.add(lblResourceType, 0, 0);
        pane.add(resourceTypeBox, 1, 0);
        pane.add(lblLanguage, 0, 1);
        pane.add(language, 1, 1);
        pane.add(lblRegion, 0, 2);
        pane.add(region, 1, 2);
        pane.add(lblResponsible, 0, 3);
        pane.add(responsible, 1, 3);
        pane.add(lblStatus, 0, 4);
        pane.add(statusBox, 1, 4);
        pane.add(lblWordsDuration, 2, 1);
        pane.add(wordsDuration, 3, 1);
        pane.add(lblPagesPath, 2, 2);
        pane.add(pagesPath, 3, 2);

        dataText = FXCollections.observableArrayList();
        lvText = new ListView<>(dataText);
        dataRecording = FXCollections.observableArrayList();
        lvRecording = new ListView<>(dataRecording);
        getResourceListRecording();
        getResourceListText();

        lvText.setPrefHeight(175);
        lvText.setMaxHeight(175);

        lvRecording.setPrefHeight(175);
        lvRecording.setMaxHeight(175);

        listViewsBox.setAlignment(Pos.CENTER);

        textContent.setWrapText(true);
        textContent.setPrefWidth(755);
        textContent.setMaxWidth(755);
        textContent.setPrefHeight(200);
        textContent.setMaxHeight(200);

        pane.setHgap(15);
        pane.setVgap(27);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        wrapper.setHgap(15);
        wrapper.setVgap(15);
        wrapper.setAlignment(Pos.CENTER);
        wrapper.setPadding(new Insets(10, 10, 10, 10));

        buttons.setHgap(15);
        buttons.setVgap(15);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10, 10, 10, 10));

        logoutOption.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                main.setLoginScene();
            }
        });

        exitOption.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                main.closeStage();
            }
        });

        saveOption.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                main.saveResourceArray();
                main.saveResourceCounter();
                saveResourceListText();
                saveResourceListRecording();
            }
        });

        registerOption.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                try {
                    if (main.getCurrentUser().getPrivilege().equals("Manager"))
                        main.setUserCreationScene();
                    else {
                        throw new PrivilegeException("You don't have the privileges to perform this action");
                    }
                } catch (PrivilegeException privE) {
                    error.setTitle("Privilege exception");
                    error.setHeaderText(privE.getMessage());
                    error.showAndWait();
                }
            }
        });

        resourceTypeBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String resource = (String) resourceTypeBox.getValue();
                if (resource.equals("Text")) {
                    lblWordsDuration.setText("# Of words:");
                    lblPagesPath.setText("# Of pages:");
                } else {
                    lblWordsDuration.setText("Duration:");
                    lblPagesPath.setText("Path:");
                }

            }
        });
        lvText.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                textData();
            }
        });
        lvRecording.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                recordingData();
            }
        });
        addButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                try {
                    String resourceType = (String) resourceTypeBox.getValue();
                    if (resourceType.equals("Text"))
                        createText();
                    else
                        createRecording();
                } catch (Exception exception) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Empty field");
                    alert.setHeaderText("Please select a resource type");
                    alert.showAndWait();
                }
            }
        });

        listViewsBox.getChildren().addAll(lblTexts, lvText, lblRecordings, lvRecording);
        wrapper.getChildren().addAll(pane, listViewsBox);
        buttons.getChildren().addAll(addButton, deleteButton, updateButton);
        vbox.getChildren().addAll(wrapper, textContent, buttons);
        vbox.setAlignment(Pos.CENTER);

        mainContent.getChildren().addAll(menuBar, vbox);
        super.setRoot(mainContent);

    }

    public void createText() {
        Text text = new Text();
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("Text created succesfully");

        try {
            text.setLanguage(language.getText());
            text.setRegion(region.getText());
            text.setResponsible(responsible.getText());
            text.setStatus((String) statusBox.getValue());
            text.setNumberOfWords(wordsDuration.getText());
            text.setNumberOfPages(pagesPath.getText());
            text.setTextualContent(textContent.getText());
            text.setResourceType((String) resourceTypeBox.getValue());

            clearFields();
            main.setResource(text);
            dataText.add(text);

            success.showAndWait();

        } catch (EmptyFieldException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty field");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void createRecording() {
        Recording recording = new Recording();
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("Recording created succesfully");

        try {
            recording.setLanguage(language.getText());
            recording.setRegion(region.getText());
            recording.setResponsible(responsible.getText());
            recording.setStatus((String) statusBox.getValue());
            recording.setTextualContent(textContent.getText());
            recording.setDuration(wordsDuration.getText());
            recording.setPath(pagesPath.getText());
            recording.setResourceType((String) resourceTypeBox.getValue());

            clearFields();
            main.setResource(recording);
            dataRecording.add(recording);
            success.showAndWait();

        } catch (EmptyFieldException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty field");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void textData() {
        Text t = lvText.getSelectionModel().getSelectedItem();
        language.setText(t.getLanguage());
        region.setText(t.getRegion());
        responsible.setText(t.getResponsible());
        textContent.setText(t.getTextualContent());
        statusBox.setValue(t.getStatus());
        resourceTypeBox.setValue(t.getResourceType());
        wordsDuration.setText(t.getNumberOfWords());
        pagesPath.setText(t.getNumberOfPages());

    }

    private void recordingData() {
        Recording r = lvRecording.getSelectionModel().getSelectedItem();
        language.setText(r.getLanguage());
        region.setText(r.getRegion());
        responsible.setText(r.getResponsible());
        textContent.setText(r.getTextualContent());
        statusBox.setValue(r.getStatus());
        resourceTypeBox.setValue(r.getResourceType());
        wordsDuration.setText(r.getDuration());
        pagesPath.setText(r.getPath());
    }

    private void deleteResource() {
        // TODO: Delete the resource from listview and main array
    }

    private void updateResorce() {
        // TODO: Update the selected resource
    }

    public void clearFields() {
        language.setText("");
        region.setText("");
        responsible.setText("");
        wordsDuration.setText("");
        pagesPath.setText("");
        statusBox.setValue(null);
        textContent.setText("");
    }

    /*
     * private void classifyStatusText(String s){ if(status.equals("Translation")){
     * } }
     */

    private void saveResourceListText() {
        try {
            Text[] texts = new Text[lvText.getItems().size()];
            int i = 0;
            for (Text t : lvText.getItems()) {
                texts[i] = t;
                i++;
            }
            FileOutputStream fos = new FileOutputStream("ResourcesTextListRM.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(texts);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void getResourceListRecording() {
        try {
            FileInputStream fis = new FileInputStream("ResourcesTextListRM.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Text[] texts = (Text[]) ois.readObject();
            for (int i = 0; i < texts.length; i++) {
                dataText.add(texts[i]);
            }
            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveResourceListRecording() {
        try {
            Recording[] recordings = new Recording[lvRecording.getItems().size()];
            int i = 0;
            for (Recording r : lvRecording.getItems()) {
                recordings[i] = r;
                i++;
            }
            FileOutputStream fos = new FileOutputStream("ResourcesRecordingListRM.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(recordings);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void getResourceListText() {
        try {
            FileInputStream fis = new FileInputStream("ResourcesRecordingListRM.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Recording[] recordings = (Recording[]) ois.readObject();
            for (int i = 0; i < recordings.length; i++) {
                dataRecording.add(recordings[i]);
            }
            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
