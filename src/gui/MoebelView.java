package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.MoebelModel;
import business.Moebelhaus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class MoebelView {
	
	
	
	
	
	
	 private Pane pane     					= new  Pane();
	    private Label lblEingabe    	 		= new Label("Eingabe");
	    private Label lblAnzeige   	 	    	= new Label("Anzeige");
	    private Label lblName 					= new Label("Name:");
	    private Label lblWohnraum   		= new Label("Wohnraum:");
	    private Label lblStil  	 		= new Label("Stil:");
	    private Label lblPreis   			= new Label("Preis:");
	    private Label lblMaterial  		= new Label("Material:");
	    private TextField txtName 	 			= new TextField();
	    private TextField txtWohnraum		= new TextField();
	    private TextField txtStil		= new TextField();
	    private TextField txtSPreis			= new TextField();
	    private TextField txtMaterial	= new TextField();
	    private TextArea txtAnzeige  			= new TextArea();
	    private Button btnEingabe 		 		= new Button("Eingabe");
	    private Button btnAnzeige 		 		= new Button("Anzeige");
	    private MenuBar mnbrMenuLeiste  		= new MenuBar();
	    private Menu mnDatei             		= new Menu("Datei");
	    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
	   
	    private MoebelModel moebelmodel;
	    private MoebelControl moebelcontrol;
	    
	    public MoebelView(MoebelControl moebelcontrol,MoebelModel moebelmodel,Stage primaryStage){
	    	this.moebelcontrol=moebelcontrol;
	    	this.moebelmodel=moebelmodel;
	    	Scene scene = new Scene(this.pane, 700, 340);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Verwaltung von Bürgerämtern");
	    	primaryStage.show();
	    	this.initKomponenten();
			this.initListener();
	    }
	    
	    private void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblWohnraum.setLayoutX(20);
	    	lblWohnraum.setLayoutY(130);
	    	lblStil.setLayoutX(20);
	    	lblStil.setLayoutY(170);
	    	lblPreis.setLayoutX(20);
	    	lblPreis.setLayoutY(210);
	    	lblMaterial.setLayoutX(20);
	    	lblMaterial.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblWohnraum, lblStil,
	       		lblPreis, lblMaterial);
	    
	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtWohnraum.setLayoutX(170);
	    	txtWohnraum.setLayoutY(130);
	    	txtWohnraum.setPrefWidth(200);
	    	txtStil.setLayoutX(170);
	    	txtStil.setLayoutY(170);
	    	txtStil.setPrefWidth(200);
	      	txtSPreis.setLayoutX(170);
	    	txtSPreis.setLayoutY(210);
	    	txtSPreis.setPrefWidth(200);
	    	txtMaterial.setLayoutX(170);
	    	txtMaterial.setLayoutY(250);
	    	txtMaterial.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtName, txtWohnraum, txtStil,
	     		txtSPreis, txtMaterial);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }
	   
	   private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	 moebelcontrol.nehmeMoebelhausAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeMoebelhausAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		    		 moebelcontrol.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			    	 moebelcontrol.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					 moebelcontrol.schreibeMoebelhausnCsvDatei();
				}	
		    });
	    }
	    
	   
	   
	    private void zeigeMoebelhausAn(){
	    	if(this.moebelmodel.getMoebel() != null){
	    		txtAnzeige.setText(
	    				this.moebelmodel.getMoebel().gibMoebelhausZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde kein Moebel aufgenommen!");
	    	}
	    }    
			  
	    

	    public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    
	    void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn();
	    }

		public TextField getTxtName() {
			return txtName;
		}

		public void setTxtName(TextField txtName) {
			this.txtName = txtName;
		}

		public TextField getTxtWohnraum() {
			return txtWohnraum;
		}

		public void setTxtWohnraum(TextField txtWohnraum) {
			this.txtWohnraum = txtWohnraum;
		}

		public TextField getTxtStil() {
			return txtStil;
		}

		public void setTxtStil(TextField txtStil) {
			this.txtStil = txtStil;
		}

		public TextField getTxtSPreis() {
			return txtSPreis;
		}

		public void setTxtSPreis(TextField txtSPreis) {
			this.txtSPreis = txtSPreis;
		}

		public TextField getTxtMaterial() {
			return txtMaterial;
		}

		public void setTxtMaterial(TextField txtMaterial) {
			this.txtMaterial = txtMaterial;
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
