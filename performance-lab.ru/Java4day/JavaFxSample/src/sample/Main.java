package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import learning.controller.PersonDialogController;
import learning.controller.PersonsController;
import learning.model.Person;

import java.io.IOException;

public class Main extends Application {
    Stage stage;
    private AnchorPane root;

    ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        root = loader.load();
        PersonsController controller = loader.getController();
        controller.setMainLink(this);
        primaryStage.setTitle("Sample JavaFX application");
        primaryStage.show();
        primaryStage.setScene(new Scene(root, 1000, 700));
    }


    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStage() {return stage;}

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public boolean showPersonDialog(Person person) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("personDialog.fxml"));
        GridPane dialog = loader.load();

        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(stage);
        Scene scene = new Scene(dialog);
        dialogStage.setScene(scene);

        PersonDialogController pdc = loader.getController();
        pdc.setDialogStage(dialogStage);
        pdc.setPerson(person);

        dialogStage.showAndWait();
        return pdc.isOkButtonClicked();
    }
}
