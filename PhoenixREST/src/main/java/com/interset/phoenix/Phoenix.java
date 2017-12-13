package com.interset.phoenix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Phoenix {

	public List<String> getHbaseRows(long timestamp) throws IOException, SQLException {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		List<String> result = new ArrayList<String>();
		conn = DriverManager.getConnection("jdbc:phoenix:thin:url=http://172.16.100.130:8765;serialization=PROTOBUF");
		ps = conn.prepareStatement("SELECT * FROM syslog WHERE TIMESTAMP >= ?");
		ps.setLong(1, timestamp);
		rs = ps.executeQuery();
		while (rs.next()) {
			result.add(rs.getString("syslogvalue"));
		}
		rs.close();
		return result;
	}
}
