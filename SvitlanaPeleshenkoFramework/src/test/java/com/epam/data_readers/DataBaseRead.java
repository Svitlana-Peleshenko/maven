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
		List<String> properties = new ArrayList<String>();
		try {
			new PropertiesReader("properties.txt");
			Connection con = DriverManager.getConnection(PropertiesReader.getUrl(),PropertiesReader.getName(),PropertiesReader.getPassword());
			statement = con.createStatement();
			String query = "select * from parameters";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				properties.add(rs.getString("parameters"));
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return properties;

	}

}
