package managers;

import dataProviders.ConfigFileReader;

public class FileReaderManager {
	
	// This class is used to return the object for the data provider classes
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance() {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
}