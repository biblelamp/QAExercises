package learning.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Person {
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private ObjectProperty<LocalDate> bithdate = new SimpleObjectProperty<>();

    public Person(){}

    public Person(String firstName, String lastName) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public StringProperty getCity() {
        return city;
    }

    public ObjectProperty getBithdate() {
        return bithdate;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setBithdate(LocalDate bithdate) {
        this.bithdate.set(bithdate);
    }
}
