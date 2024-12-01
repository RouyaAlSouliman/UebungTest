package gui.guiMoeblHausStaetten;


import business.MoebelModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class MoebelhausStaettenControll implements Observer{
	

	private MoebelhausStaettenView moebelhausStaettenView;
	private MoebelModel moebelModel;

	public MoebelhausStaettenControll(Stage primaryStage){
		this.moebelModel = MoebelModel.getInstance();
		this.moebelhausStaettenView= new MoebelhausStaettenView(this,primaryStage,moebelModel);
		moebelModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		moebelhausStaettenView.zeigeMoebelhausAn();
	}

	}
	

	

	
	
	


