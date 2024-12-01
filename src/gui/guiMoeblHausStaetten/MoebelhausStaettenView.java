package gui.guiMoeblHausStaetten;

import business.MoebelModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class MoebelhausStaettenView {
	
	
	

	private MoebelModel moebelModel ;
	private MoebelhausStaettenControll moebelhausStaettenControll;


	
	private Pane pane = new  Pane();
	private Label lblAnzeigeMoebelhaus = new Label("Anzeige Moebelhaus");
	private TextArea txtAnzeigeMoebelhaus  = new TextArea();
	private Button btnAnzeigeMoebelhaus = new Button("Anzeige");
	

	public MoebelhausStaettenView(MoebelhausStaettenControll moebelhausStaettenControll,Stage primaryStage, 
			MoebelModel moebelModel){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Moebelhausstaetten ");
		primaryStage.show();
		this.moebelhausStaettenControll= moebelhausStaettenControll;
    	this. moebelModel =  moebelModel;
		this.initKomponenten();
		this.initListener();
    	}

    	private void initKomponenten(){
    		// Label
    		Font font = new Font("Arial", 20);
    		lblAnzeigeMoebelhaus.setLayoutX(310);
    		lblAnzeigeMoebelhaus.setLayoutY(40);
    		lblAnzeigeMoebelhaus.setFont(font);
    		lblAnzeigeMoebelhaus.setStyle("-fx-font-weight: bold;"); 
    		pane.getChildren().add(lblAnzeigeMoebelhaus);    
        	



    		txtAnzeigeMoebelhaus.setEditable(false);
    		txtAnzeigeMoebelhaus.setLayoutX(310);
    		txtAnzeigeMoebelhaus.setLayoutY(90);
    		txtAnzeigeMoebelhaus.setPrefWidth(220);
    		txtAnzeigeMoebelhaus.setPrefHeight(185);
    		pane.getChildren().add(txtAnzeigeMoebelhaus);        	
        	
	       	btnAnzeigeMoebelhaus.setLayoutX(310);
	       	btnAnzeigeMoebelhaus.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeMoebelhaus); 
   }
   
	   private void initListener() {
		   btnAnzeigeMoebelhaus.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	    			zeigeMoebelhausAn();
	        	} 
		    });
	}

	public void zeigeMoebelhausAn(){
			if( moebelModel.getMoebel() != null){
				txtAnzeigeMoebelhaus.setText(
						 moebelModel.getMoebel()
					.gibMoebelhausZurueck(' '));
			}
			else{
				zeigeInformationsfensterAn(
					"Bisher wurde kein Moebelhaus aufgenommen!");
			}
	}	
	
	
	
	

private void zeigeInformationsfensterAn(String meldung){
	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
}	


}
