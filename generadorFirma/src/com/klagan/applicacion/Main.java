package com.klagan.applicacion;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Formulario.fxml"));
//			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("Generador de Firmas de K-lagan");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setWidth(715);
			primaryStage.setHeight(350);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
