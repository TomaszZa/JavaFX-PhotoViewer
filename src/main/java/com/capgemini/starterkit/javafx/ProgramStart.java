package com.capgemini.starterkit.javafx;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramStart extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Image View");

		Parent root = FXMLLoader.load(getClass().getResource("/com/capgemini/starterkit/javafx/view/PictureShow.fxml"), //
				ResourceBundle.getBundle("com/capgemini/starterkit/javafx/bundle/bundle"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add("/com/capgemini/starterkit/javafx/css/standard.css");

		primaryStage.setScene(scene);

		primaryStage.show();

	}

}
