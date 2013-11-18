package com.epam.data_readers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.configuration.DataBaseConfig;

public class DataBaseReader  {

	public Object[][] read() throws IOException {
		Statement statement = null;
		Object[][] data = null;
		try {
		
			new DataBaseConfig("properties.txt");
			Connection con = DriverManager.getConnection(DataBaseConfig.getUrl(),DataBaseConfig.getName(),DataBaseConfig.getPassword());
			statement = con.createStatement();
			String query = "select * from parameters";
			ResultSet rs = statement.executeQuery(query);
			int resultSetColumn = rs.getMetaData().getColumnCount();
		    rs.last();
		    int resultSetRows = rs.getRow();
		    rs.beforeFirst();
			for(int i=0; i<resultSetRows;i++){
			for(int j=0; j<resultSetColumn;j++)	
		    while (rs.next()) {
				data[i][j]=rs.getString("parameters");
			}
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;

	}

}
