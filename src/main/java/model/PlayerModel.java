package model;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.util.ArrayList;
import java.util.List;

public class PlayerModel {
	
	private static ArrayList<Player> allPlayer;
	private Player currentPlayer;

	// Constructor
	public PlayerModel() {
		allPlayer = new ArrayList<Player>();
	}

	// getter and setter
	public ArrayList<Player> getAllPlayer() {
		return allPlayer;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player setCurrentPlayer(Player p) {
		return currentPlayer = p;
	}

	public void setCurrentPlayerName(String name) {
		currentPlayer.setName(name);
	}

	public Player getPlayer(int rowIndexModel) {
		return allPlayer.get(rowIndexModel);
	}

	public void setNewPlayer() {
		allPlayer.add(new Player());
	}

	public void removeCurrentPlayer() {
		allPlayer.remove(currentPlayer);
	}

	public void addPlayer() {
		allPlayer.add(new Player());
	}
	
	public void loadData(){
		allPlayer = CsvParser.fileImport();
	}
	
	public void saveData(){
		CsvParser.fileExport(allPlayer, "src/main/java/model/PlayerWithCountry.csv");
	}
}
