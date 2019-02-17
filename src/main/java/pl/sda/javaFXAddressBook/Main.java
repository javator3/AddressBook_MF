package pl.sda.javaFXAddressBook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.javaFXAddressBook.model.Person;
import pl.sda.javaFXAddressBook.view.PersonView;

public class Main extends Application {

    public static void main(String[] args) {
            launch(args);
        }

        public void start(Stage primaryStage) throws Exception {

            //wywolanie metody loadview z klasy zklasy personView

            PersonView personView = new PersonView(primaryStage);
            personView.loadView();
            personView.loadNewPersonView();

        }

}
