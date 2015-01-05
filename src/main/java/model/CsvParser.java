package model;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CsvParser {

	public static ArrayList<Player> fileImport() {
		ArrayList<Player> allPlayer = new ArrayList<>();
		
		try
		{
			String path = "src/main/java/model/PlayerWithCountry.csv";
			FileInputStream fis = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			String stringRead = br.readLine();

			while (stringRead != null) {
				String[] elements = stringRead.split(";", -1);
				String rank = elements[0];
				String name = elements[1];
				String birthYear = elements[2];
				String country = elements[3];
				String association = elements[4];
				String position = elements[5];
				String match100 = elements[6];
				String match100Against = elements[7];
				String numberOfMatchesFIFA = elements[8];
				String numberOfMatchesRSSSF = elements[9];
				String firstMatch = elements[9];
				String lastMatch = elements[10];

				allPlayer.add(new Player(rank, name, country, birthYear, association, position, match100,
						match100Against, numberOfMatchesFIFA, numberOfMatchesRSSSF, firstMatch, lastMatch));
				// read the next line
				stringRead = br.readLine();
			}
			br.close();			
		} catch (IOException e) {
			e.printStackTrace();
		} return allPlayer;
	}

	public static void fileExport(ArrayList<Player> allPlayer, String file) {

		FileOutputStream fos;
		try {

			// String path = "src/football/model/PlayerWithCountry.csv";
			fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			bw.append("#Platz;Name;Geboren;Land;Verband;Position;100. Spiel;Gegner;Spiele(FIFA);Spiele(RSSSF);Von;Bis;\r\n");
			for (Player p : allPlayer) {
				bw.append(p.getRank() + ";" + p.getName() + ";" + p.getBirthYear() + ";" + p.getCountry() + ";"
						+ p.getPosition() + ";" + p.getAssociation() + ";" + p.getNumberOfMatchesFIFA() + ";"
						+ p.getNumberOfMatchesRSSSF() + ";" + p.getMatch100() + ";" + p.getMatch100Against() + ";"
						+ p.getFirstMatch() + ";" + p.getLastMatch() + ";\r\n");
			}

			bw.flush();
			bw.close();

			System.out.println(allPlayer.get(1).getName());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
