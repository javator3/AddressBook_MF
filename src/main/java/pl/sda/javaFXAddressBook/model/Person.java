package pl.sda.javaFXAddressBook.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

import java.util.Objects;

public class Person {

    private StringProperty name;
    private StringProperty lastname;
    private StringProperty street;
    private StringProperty city;
    private StringProperty postalcode;
    private StringProperty telephone;


    public Person(String name, String lastname,
                  String street, String city, String postalcode, String telephone) {
        this.name = new SimpleStringProperty(name);
        this.lastname =new SimpleStringProperty (lastname);
        this.street = new SimpleStringProperty (street);
        this.city = new SimpleStringProperty (city);
        this.postalcode = new SimpleStringProperty (postalcode);
        this.telephone = new SimpleStringProperty (telephone);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getPostalcode() {
        return postalcode.get();
    }

    public StringProperty postalcodeProperty() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode.set(postalcode);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(street, person.street) &&
                Objects.equals(city, person.city) &&
                Objects.equals(postalcode, person.postalcode) &&
                Objects.equals(telephone, person.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, street, city, postalcode, telephone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", lastname=" + lastname +
                ", street=" + street +
                ", city=" + city +
                ", postalcode=" + postalcode +
                ", telephone=" + telephone +
                '}';
    }
}
