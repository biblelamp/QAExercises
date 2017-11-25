package learning.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import learning.model.Person;

public class PersonDialogController {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField cityField;

    @FXML
    private DatePicker dateField;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private Stage dialogStage;
    private Person person;
    private boolean okButtonClicked = false;


    @FXML
    private void initialize(){}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName().getValue());
        lastNameField.setText(person.getLastName().getValue());
        cityField.setText(person.getCity().getValue());
    }

    public boolean isOkButtonClicked() {return okButtonClicked;}

    @FXML
    private void handleOk() {
        person.setFirstName(firstNameField.getText());
        person.setLastName(lastNameField.getText());
        person.setCity(cityField.getText());
        person.setBithdate(dateField.getValue());
        okButtonClicked = true;
        dialogStage.close();

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
