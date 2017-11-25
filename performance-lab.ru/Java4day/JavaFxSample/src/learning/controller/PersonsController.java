package learning.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import learning.model.Person;
import sample.Main;

import java.io.IOException;
import java.time.LocalDate;

public class PersonsController {
    @FXML
    private TableView<Person> personsTable;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label birthdateLabel;

    private Main main;

    public PersonsController(){}

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(c -> c.getValue().getFirstName());
        lastNameColumn.setCellValueFactory(c -> c.getValue().getLastName());

        showPerson(null);
        personsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPerson(newValue)
        );
    }

    public void setMainLink(Main mainLink) {
        this.main = mainLink;
        personsTable.setItems(main.getPersonList());
    }

    @FXML
    public void showPerson(Person person) {
        if (person == null) {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            cityLabel.setText("");
            birthdateLabel.setText("");
        } else {
            firstNameLabel.setText(person.getFirstName().getValue());
            lastNameLabel.setText(person.getLastName().getValue());
            cityLabel.setText(person.getLastName().getValue());
            LocalDate date = (LocalDate)person.getBithdate().getValue();
            String strDate = date.getDayOfMonth() +"."+date.getMonthValue()+"."+date.getYear();
            birthdateLabel.setText(strDate);
        }
    }

    @FXML
    private void handleNewButton() throws IOException {
        Person person = new Person();
        boolean okclicked = main.showPersonDialog(person);
        if (okclicked) {
            main.getPersonList().add(person);
        }
    }
}
