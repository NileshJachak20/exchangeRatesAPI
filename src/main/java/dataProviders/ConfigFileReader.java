package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configurations//config.properties";

	
	//ConfigfileReader is created to read the data from the configurations file
	 
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getBaseUrl() {
		
		// This will return the base URL from config file
		
		String url = properties.getProperty("BASE_URL");
		if(url != null) return url;
		else throw new RuntimeException("BASE_URL not specified in the Config.properties file.");
	}

}