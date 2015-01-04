package model;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.util.List;

public class PlayerModel {
	
	private static List<Player> players;
	
	public void loadData() {
		players = CsvParser.parseCsvFile();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public static void saveData() {
		players = CsvParser.writeCsvFile();
	}
}
