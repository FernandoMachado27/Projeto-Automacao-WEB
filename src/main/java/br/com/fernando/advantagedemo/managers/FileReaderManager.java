package br.com.fernando.advantagedemo.managers;

import br.com.fernando.advantagedemo.dataProviders.ConfigFileReader;

public class FileReaderManager { // Gerenciador de leitores de arquivos 

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
}