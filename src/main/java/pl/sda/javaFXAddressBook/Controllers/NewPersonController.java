package pl.sda.javaFXAddressBook.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import pl.sda.javaFXAddressBook.model.Person;
import pl.sda.javaFXAddressBook.view.PersonView;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewPersonController implements Initializable {

    @FXML
    private TextField Imie;

    @FXML
    private TextField Nazwisko;

    @FXML
    private TextField Ulica;

    @FXML
    private TextField Miasto;

    @FXML
    private TextField KodPocztowy;

    @FXML
    private TextField NumerTelefonu;

    @FXML
    private Button Save;

    @FXML
    private Button Cancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void savePerson() {
        // personView.getPersonList().add(new Person("Hamon", "Serrano", "Mistral", "Barcelona", "808786", "124578"));
//        String name = Imie.getText();
//        String lastname = Nazwisko.getText();
//        String street = Ulica.getText();
//        String city = Miasto.getText();
//        String postalcode = KodPocztowy.getText();
//        String telephone = NumerTelefonu.getText();
//        personView.getPersonList().add(new Person(name, lastname, street, city, postalcode, telephone));
        Person person = personView.getPersonList().get(getIndex());
        person.setName(Imie.getText());
        person.setLastname(Nazwisko.getText());
        person.setStreet(Ulica.getText());
        person.setCity(Miasto.getText());
        person.setTelephone(NumerTelefonu.getText());
    }

    private PersonView personView;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    public void closeButton(ActionEvent actionEvent) {

        personView.getNewPersonStage().close();
        // Stage stage = (Stage) closeButton.getScene().getWindow();
        // stage.close();
    }

    public void setPerson(Person person) {
        Imie.setText(person.getName());
        Nazwisko.setText(person.getLastname());
        Ulica.setText(person.getStreet());
        Miasto.setText(person.getCity());
        KodPocztowy.setText(person.getPostalcode());
        NumerTelefonu.setText(person.getTelephone());
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
