package model;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvParser {

	private static final String path = "src/main/java/model/PlayerWithCountry.csv";

	private static final int COLUMN_RANK = 0;
	private static final int COLUMN_NAME = 1;
	private static final int COLUMN_BIRTHYEAR = 2;
	private static final int COLUMN_COUNTRY = 3;
	private static final int COLUMN_ASSOCIATION = 4;
	private static final int COLUMN_POSITION = 5;
	private static final int COLUMN_MATCH100 = 6;
	private static final int COLUMN_MATCH100AGAINST = 7;
	private static final int COLUMN_NUMBEROFMATCHESFIFA = 8;
	private static final int COLUMN_NUMBEROFMATCHESRSSSF = 9;
	private static final int COLUMN_FIRSTMATCH = 10;
	private static final int COLUMN_LASTMATCH = 11;

	public static List<Player> parseCsvFile() {
		List<Player> players = new LinkedList<>();

		try (BufferedReader buf = new BufferedReader(new FileReader(new File(path)))) {
			
			String line;
			
			while ((line = buf.readLine()) != null) {
				String[] values = line.split(";");
				String rank = values[COLUMN_RANK];
				String name = values[COLUMN_NAME];
				String birthYear = values[COLUMN_BIRTHYEAR];
				String country = values[COLUMN_COUNTRY];
				String association = values[COLUMN_ASSOCIATION];
				String position = values[COLUMN_POSITION];
				String match100 = values[COLUMN_MATCH100];
				String match100Against = values[COLUMN_MATCH100AGAINST];
				String numberOfMatchesFIFA = values[COLUMN_NUMBEROFMATCHESFIFA];
				String numberOfMatchesRSSSF = values[COLUMN_NUMBEROFMATCHESRSSSF];
				String firstMatch = values[COLUMN_FIRSTMATCH];
				String lastMatch = values[COLUMN_LASTMATCH];

				players.add(new Player(rank, name, country, birthYear, association, position, match100,
						match100Against, numberOfMatchesFIFA, numberOfMatchesRSSSF, firstMatch, lastMatch));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return players;
	}

	public static List<Player> writeCsvFile() {
		List<Player> players = new LinkedList<Player>();

		try (BufferedWriter buf = new BufferedWriter(new FileWriter(new File(path)))) {
			
			
			buf.append("#Platz;Name;Geboren;Land;Verband;Position;100. Spiel;Gegner;Spiele(FIFA);Spiele(RSSSF);Von;Bis;\r\n");
			for (Player p : players) {
				buf.append(p.getRank() + ";" + p.getName() + ";" + p.getBirthYear() + ";" + p.getCountry() + ";"
						+ p.getPosition() + ";" + p.getAssociation() + ";" + p.getNumberOfMatchesFIFA() + ";"
						+ p.getNumberOfMatchesRSSSF() + ";" + p.getMatch100() + ";" + p.getMatch100Against() + ";"
						+ p.getFirstMatch() + ";" + p.getLastMatch() + ";\r\n");
			}
			
			buf.flush();
			buf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return players;
	}

}
