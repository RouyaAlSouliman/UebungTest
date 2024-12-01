package business;

import java.io.BufferedReader;




import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import factory.ConcreteCreatorA;
import factory.ConcreteCreatorB;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;



public class MoebelModel  implements Observable{
 	
	LinkedList<Observer> liste = new LinkedList<Observer>();

	private static MoebelModel theInstance;
	
	private MoebelModel() {
		
	}
	
	
	public static MoebelModel getInstance() {
		if(theInstance == null) {
			theInstance=new MoebelModel() ;
			
		}
		return theInstance;
	}
	
	
	
	private Moebelhaus moebel;
	
	
	

	public Moebelhaus getMoebel() {
		return moebel;
	}

	public void setMoebel(Moebelhaus moebel) {
		this.moebel = moebel;
		notifyObservers();
	}
	
	
	
	
	  public void leseAusDatei(String typ) throws IOException{
		
		
		  
		  Creator creator=null;
		  if(typ.equals("csv")) {
				creator=new ConcreteCreatorA();
		  }
		  else {
			  creator=new ConcreteCreatorB();
		  }
		  Product reader=creator.factoryMethod(); 
		  String[] zeile = reader.leseAusDatei();
			this.moebel = new Moebelhaus(zeile[0], 
				zeile[1], 
				zeile[2], 
				Double.parseDouble(zeile[3]), zeile[4].split("_"));
			reader.schliessDatei();
		  
	
		  
		
	/*  if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("MoebelhausAusgabe.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.moebel = new Moebelhaus(zeile[0], 
	      				zeile[1], 
	      				zeile[2], 
	      				Double.parseDouble(zeile[3]), zeile[4].split("_"));
	      				ein.close();
	
	      		}*/
	  }
	 
	      		public void schreibeMoebelhausnCsvDatei() throws IOException {
	      			
	      				BufferedWriter aus 
	      					= new BufferedWriter(new FileWriter("MoebelhausAusgabe.csv"));
	      				aus.write(moebel.gibMoebelhausZurueck(';'));
	      				
	      				aus.close();
	      			}

				@Override
				public void addObserver(Observer obs) {
					// TODO Auto-generated method stub
					liste.add(obs);

				}

				@Override
				public void removeObserver(Observer obs) {
					// TODO Auto-generated method stub
					liste.remove(obs);

				}

				@Override
				public void notifyObservers() {
					// TODO Auto-generated method stub
					for(Observer o:liste) {
						o.update();
					}
					
				}
	
	      		
}

