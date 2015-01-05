package main;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import model.PlayerModel;
import controller.Controller;

public class AppStart {
	
	public static void main(String[] args) {
		
		final PlayerModel model = new PlayerModel();
		model.loadData();
		
		final Controller controller = new Controller(model);		
		Controller.setLookAndFeel();
		controller.initializeView();		
	}

}


// faklefökjaweökf
