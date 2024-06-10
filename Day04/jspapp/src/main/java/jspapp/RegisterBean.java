package jspapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterBean {

	private User user;
	
	
	public void save() {
		String DB_URL = "jdbc:mysql://localhost:3306/election";
				String DB_USER = "root";
				String DB_PASS = "manager";
				try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
					String sql = "INSERT INTO users (firstName,lastName, email, password, dob,) VALUES (?, ?, ?, ?, ?)";
					try(PreparedStatement stmt = con.prepareStatement(sql)) {
						stmt.setString(1, user.getFirstName());
						stmt.setString(2, user.getLastName());
						stmt.setString(3, user.getEmail());
						stmt.setString(4, user.getPassword());
						stmt.setString(5, user.getBirth());
						
						try(ResultSet rs = stmt.executeUpdate() {
							if(rs.next()) {
								int id = rs.getInt("id");
								String firstName = rs.getString("first_name");
								String lastName = rs.getString("last_name");
								String email = rs.getString("email");
								String password = rs.getString("password");
								Date dob = rs.getDate("dob");
								this.user = new User(id, firstName, lastName, email, password, dob);						
							}
							else
								this.user = null;
						} 
					}
				} 
				catch(Exception e) {
					e.printStackTrace();
				}		
			}
	}
}
