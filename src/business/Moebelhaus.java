package business;

public class Moebelhaus {
	

	
    private String name;
    private String wohnraum;
    private String stil;
    private double preis;
    private String[] materilien;

    
	public Moebelhaus(String name, String wohnraum, String stil, double preis, String[] materilien) {
		super();
		this.name = name;
		this.wohnraum = wohnraum;
		this.stil = stil;
		this.preis = preis;
		this.materilien = materilien;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getWohnraum() {
		return wohnraum;
	}


	public void setWohnraum(String wohnraum) {
		this.wohnraum = wohnraum;
	}


	public String getStil() {
		return stil;
	}


	public void setStil(String stil) {
		this.stil = stil;
	}



	public double getPreis() {
		return preis;
	}


	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String[] getMaterilien() {
		return materilien;
	}




	public void setMaterilien(String[] materilien) {
		this.materilien = materilien;
	}


	public String getMaterialAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getMaterilien().length - 1; i++) {
			ergebnis = ergebnis + this.getMaterilien()[i] + trenner; 
		}
		return ergebnis	+ this.getMaterilien()[i];
	}
	
	public String gibMoebelhausZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getWohnraum() + trenner
  		    + this.getStil() + trenner
  		    + this.getPreis() + trenner 
  		    + this.getMaterialAlsString(trenner) + "\n";
  	}
}
