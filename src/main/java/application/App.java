package application;


import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
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
