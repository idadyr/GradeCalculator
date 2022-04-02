package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import application.controller.Controller;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ui.fxml"));
        primaryStage.setTitle("MainMenu");
        primaryStage.setScene(new Scene(loader.load()));
        ((Controller) loader.getController()).setStage(primaryStage);
        primaryStage.show();

		

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		launch(args);
	}

}
