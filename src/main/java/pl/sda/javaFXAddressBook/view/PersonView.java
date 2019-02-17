package pl.sda.javaFXAddressBook.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.javaFXAddressBook.Controllers.NewPersonController;
import pl.sda.javaFXAddressBook.Controllers.RootViewController;
import pl.sda.javaFXAddressBook.model.Person;
import pl.sda.javaFXAddressBook.model.PersonString;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class PersonView {

    private ObservableList<Person> personList =
            FXCollections.observableArrayList();

    private Stage primaryStage;
    private Stage newPersonStage;

    public Stage getNewPersonStage() {
        return newPersonStage;
    }

    public PersonView(){}

    public PersonView(Stage primaryStage) {
        this.primaryStage = primaryStage;
//        personList.add(new Person("Juliusz", "Cezar", "Via Valentina", "Rzym", "77567", "0971678"));
//        personList.add(new Person("Marek", "Aureliusz", "Via Siciliana", "Verona", "36432", "67863"));
//        personList.add(new Person("Cyceron", "Młodszy", "Via Roma", "Naples", "3644532", "6787863"));


        ObjectMapper mapper = new ObjectMapper();
        File files = new File("AddressBook.json");

        try {
            PersonString[] AddressList = mapper.readValue(files, PersonString[].class);

            for (PersonString m: AddressList ) {
                personList.add(new Person(m.getName(), m.getLastname(), m.getStreet(), m.getCity(), m.getPostalcode(), m.getTelephone()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void loadView() {
    //zaladować i wyswietlic widok rootview

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/RootView.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        primaryStage.setScene(new Scene(parent,600, 400));
        RootViewController rootViewController = loader.getController();
        rootViewController.setPersonView(this);
            primaryStage.show();
    }
    public void loadNewPersonView(){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewPerson.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        newPersonStage = new Stage();
        newPersonStage.setScene(new Scene(parent, 800, 400));
        newPersonStage.show();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
    }

    public void loadPersonEdit(Person person, int index) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewPerson.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        newPersonStage = new Stage();
        newPersonStage.setScene(new Scene(parent, 800, 400));
        newPersonStage.show();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
        newPersonController.setPerson(person);
        newPersonController.setIndex(index);


    }


}

