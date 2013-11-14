package com.epam.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataBaseConfig {
	private static String url;
	private static String name;
	private static String password;
	private static String pathFile;
	private static String pathXml;
	private static String pathExcel;

	public DataBaseConfig(String propertiesPath) throws IOException {
		FileInputStream fileToReadProperties = new FileInputStream(
				propertiesPath);
		Properties propertiesForDb = new Properties();
		propertiesForDb.load(fileToReadProperties);

		this.url = propertiesForDb.getProperty("url");
		this.name = propertiesForDb.getProperty("name");
		this.password = propertiesForDb.getProperty("password");

	}

	public void PropertiesReaderPath(String propertiesPath) throws IOException {
		FileInputStream fileToReadProperties = new FileInputStream(
				propertiesPath);
		Properties properties = new Properties();
		properties.load(fileToReadProperties);

		this.pathFile = properties.getProperty("pathFile");
		this.pathExcel = properties.getProperty("pathExcel");
		this.pathXml = properties.getProperty("pathXml");

	}

	public static String getPathFile() {
		return pathFile;
	}

	public static void setPathFile(String pathFile) {
		DataBaseConfig.pathFile = pathFile;
	}

	public static String getPathXml() {
		return pathXml;
	}

	public static void setPathXml(String pathXml) {
		DataBaseConfig.pathXml = pathXml;
	}

	public static String getPathExel() {
		return pathExcel;
	}

	public static void setPathExel(String pathExel) {
		DataBaseConfig.pathExcel = pathExel;
	}

	public static String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

