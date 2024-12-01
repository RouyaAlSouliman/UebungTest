package main;

import gui.guiMoebelhaus.MoebelControl;
import gui.guiMoebelhaus.MoebelhausAnwendersystem;
import gui.guiMoeblHausStaetten.MoebelhausStaettenControll;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelControl(primaryStage);
		Stage fesnterMoebelhausSteatten=new Stage ();
		new MoebelhausStaettenControll(fesnterMoebelhausSteatten);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}






