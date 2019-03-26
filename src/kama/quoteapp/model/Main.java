package kama.quoteapp.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/kama/quoteapp/view/MainPane.fxml"));
			Scene scene = new Scene(parent);
			primaryStage.setTitle("Zainspiruj się...");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
