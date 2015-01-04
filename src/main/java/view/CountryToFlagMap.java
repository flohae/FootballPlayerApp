package view;

/**
 * @author Florian Haefliger & Juerg Steudler
 */

public enum CountryToFlagMap {
	
	SWITZERLAND("SWI", "Schweiz.png"),
	ENGLAND("ENG", "England.png");
	
	private String countryCode;
	private String path;

	private CountryToFlagMap(String countryCode, String path) {
		this.countryCode = countryCode;
		this.path = path;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public String getPath() {
		return path;
	}
	
	public static String getImagePathForCountry(String countryCode) {
		for (CountryToFlagMap country : values()) {
			if (countryCode.equalsIgnoreCase(country.getCountryCode().toUpperCase())) {
				return country.getPath();
			}
		}
		
		throw new IllegalArgumentException("There is no flag for the country code: " + countryCode);
	}

}
