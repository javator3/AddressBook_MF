package pl.sda.javaFXAddressBook.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import pl.sda.javaFXAddressBook.model.Person;
import pl.sda.javaFXAddressBook.model.PersonString;
import pl.sda.javaFXAddressBook.view.PersonView;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class RootViewController implements Initializable {

    @FXML
    private Label Lastname;
    @FXML
    private Label Street;
    @FXML
    private Label City;
    @FXML
    private Label Postalcode;
    @FXML
    private Label Telephone;
    @FXML
    private Label Name;

    public PersonView personView;

    public void setPersonView(PersonView personView){
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastName.setCellValueFactory(c -> c.getValue().lastnameProperty());
    }

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastName;

    public void loadNewPerson(ActionEvent actionEvent) {
        personView.loadNewPersonView();
    }

    public void saveToJson(ActionEvent actionEvent) {

        ObservableList<Person> lista = personView.getPersonList();
        ObjectMapper mapper = new ObjectMapper();
        File files = new File("AddressBook.json");

        try {
            mapper.writeValue(files, lista);
            Person[] AddressList = mapper.readValue(files, Person[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectedPerson(MouseEvent mouseEvent) {
        Person person = personTableView.getSelectionModel().getSelectedItem();
        int index = personTableView.getSelectionModel().getFocusedIndex();

        Name.setText(person.getName());
        Lastname.setText(person.getLastname());
        City.setText(person.getCity());
        Street.setText(person.getStreet());
        Postalcode.setText(person.getPostalcode());
        Telephone.setText(person.getTelephone());
    }

    public void editPerson(ActionEvent actionEvent) {
        int index = personTableView.getSelectionModel().getFocusedIndex();
        Person person = personTableView.getSelectionModel().getSelectedItem();
        personView.loadPersonEdit(person, index);
    }

    public void deletePerson(ActionEvent actionEvent) {
        int index = personTableView.getSelectionModel().getFocusedIndex();
        // usuwanie osoby z listy o zadanym indeksie
        personView.getPersonList().remove(index);
    }
}
