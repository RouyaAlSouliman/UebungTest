package main;

import gui.MoebelControl;
import gui.MoebelhausAnwendersystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
