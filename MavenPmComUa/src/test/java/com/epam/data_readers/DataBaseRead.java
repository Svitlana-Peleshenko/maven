package com.epam.data_readers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRead  {

	public List<String> read() throws IOException {
		Statement statement = null;
		List<String> cities = new ArrayList<String>();
		try {
			new PropertiesReader("properties.txt");
			Connection con = DriverManager.getConnection(PropertiesReader.getUrl(),PropertiesReader.getName(),PropertiesReader.getPassword());
			statement = con.createStatement();
			String query = "select * from words";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				cities.add(rs.getString("word"));
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cities;

	}

}
