package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoebelModel {

	
	
	private Moebelhaus moebel;
	
	
	

	public Moebelhaus getMoebel() {
		return moebel;
	}

	public void setMoebel(Moebelhaus moebel) {
		this.moebel = moebel;
	}
	
	
	
	
	  public void leseAusDatei(String typ) throws IOException{
	    
	      		if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("Moebel.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.moebel = new Moebelhaus(zeile[0], 
	      				zeile[1], 
	      				zeile[2], 
	      				Double.parseDouble(zeile[3]), zeile[4].split("_"));
	      				ein.close();
	
	      		}
	  }
	
	      		public void schreibeMoebelhausnCsvDatei() throws IOException {
	      			
	      				BufferedWriter aus 
	      					= new BufferedWriter(new FileWriter("MoebelhausAusgabe.csv", true));
	      				aus.write(moebel.gibMoebelhausZurueck(';'));
	      				aus.close();
	      			}
	
}
