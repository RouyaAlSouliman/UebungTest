package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.MoebelModel;
import business.Moebelhaus;
import javafx.stage.Stage;

public class MoebelControl {

	
	private MoebelModel moebelmodel;
	private MoebelView moebelview;
	
	
	
	

	 public MoebelControl(Stage primaryStage) {
		super();
		this.moebelmodel=new MoebelModel();
		this.moebelview=new MoebelView(this,moebelmodel, primaryStage );
		
	}


	 
	 public void leseAusDatei(String typ){
	    	try {
	    		this.moebelmodel.leseAusDatei(typ);
	    	}
			catch(IOException exc){
				this.moebelview.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				this.moebelview.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!"+ exc.getMessage());
			}
		}
	 
	 
	 
	 public void schreibeMoebelhausnCsvDatei() {
			try {
				this.moebelmodel.schreibeMoebelhausnCsvDatei();
	   			this.moebelview.zeigeInformationsfensterAn(
		   			"Die Moebelhaueser wurden gespeichert!");
			}	
			catch(IOException exc){
				this.moebelview.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				this.moebelview.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}

	 
	 
 

	public void nehmeMoebelhausAuf(){
	    	try{
	    		moebelmodel.setMoebel( new Moebelhaus(
	    			this.moebelview.getTxtName().getText(), 
	    			this.moebelview.getTxtWohnraum().getText(),
	    			this.moebelview.getTxtStil().getText(),
	    		   Double.parseDouble(this.moebelview.getTxtSPreis().getText()),
	    		   this.moebelview.getTxtMaterial().getText().split(";")));
	    		this.moebelview.zeigeInformationsfensterAn("Das Moebel wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		this.moebelview.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	
	
	
}
