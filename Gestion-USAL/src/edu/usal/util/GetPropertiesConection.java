package edu.usal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesConection {
	
	private String userDB;
	private String passDB;
	
	public GetPropertiesConection() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("datos.properties");		
		properties.load(propertiesStream);
		this.userDB = properties.getProperty("userDB");
		this.passDB = properties.getProperty("passDB");
		System.out.println("userDB: " + this.userDB + " passDB: " + this.passDB);
	}

	public String getUserDB() {
		return userDB;
	}

	public String getPassDB() {
		return passDB;
	}	

}
