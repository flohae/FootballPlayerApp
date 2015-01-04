package model;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

public class Player {
	
	private String rank;
	private String name;
	private String birthYear;
	private String country;
	private String association;
	private String position;
	private String match100;
	private String match100Against;
	private String numberOfMatchesFIFA;
	private String numberOfMatchesRSSSF;
	private String firstMatch;
	private String lastMatch;

	private String playerInfos;
	
	public Player(String rank, String name, String country, String birthYear, String association,
			String position, String match100, String match100Against, String numberOfMatchesFIFA,
			String numberOfMatchesRSSSF, String firstMatch, String lastMatch) {
		
		this.rank = rank;
		this.name = name;
		this.country = country;
		this.birthYear = birthYear;
		this.association = association;
		this.position = position;
		this.match100 = match100;
		this.match100Against = match100Against;
		this.numberOfMatchesFIFA = numberOfMatchesFIFA;
		this.numberOfMatchesRSSSF = numberOfMatchesRSSSF;
		this.firstMatch = firstMatch;
		this.lastMatch = lastMatch;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMatch100() {
		return match100;
	}

	public void setMatch100(String match100) {
		this.match100 = match100;
	}

	public String getMatch100Against() {
		return match100Against;
	}

	public void setMatch100Against(String match100Against) {
		this.match100Against = match100Against;
	}

	public String getNumberOfMatchesFIFA() {
		return numberOfMatchesFIFA;
	}

	public void setNumberOfMatchesFIFA(String numberOfMatchesFIFA) {
		this.numberOfMatchesFIFA = numberOfMatchesFIFA;
	}

	public String getNumberOfMatchesRSSSF() {
		return numberOfMatchesRSSSF;
	}

	public void setNumberOfMatchesRSSSF(String numberOfMatchesRSSSF) {
		this.numberOfMatchesRSSSF = numberOfMatchesRSSSF;
	}

	public String getFirstMatch() {
		return firstMatch;
	}

	public void setFirstMatch(String firstMatch) {
		this.firstMatch = firstMatch;
	}

	public String getLastMatch() {
		return lastMatch;
	}

	public void setLastMatch(String lastMatch) {
		this.lastMatch = lastMatch;
	}
	
	@Override
	public String toString() {
		playerInfos = this.rank +"/"+ this.name +"/"+ this.country +"/"+ this.birthYear +"/"+ 
				this.association +"/"+ this.position +"/"+ this.match100 +"/"+ this.match100Against +"/"+ 
				this.numberOfMatchesFIFA +"/"+ this.numberOfMatchesRSSSF +"/"+ this.firstMatch +"/"+ this.lastMatch;
		
		return playerInfos;
	}
	
}
