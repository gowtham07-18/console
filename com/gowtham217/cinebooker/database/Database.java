package com.gowtham217.cinebooker.database;

import java.sql.*;

import com.gowtham217.cinebooker.dto.Theatre;


import com.gowtham217.cinebooker.dto.User;

public class Database {
	
	private static Database db;
	private Connection connection;
	
	private Database() {
		
	}
	
	public static Database getInstance() {
		if(db == null) {
			db = new Database();
		}
		db.connect();
		return db;
	}
	
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinebooker", "root", "Gowtham@217");
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed: " + e.getMessage());
        }
    }
    
    public boolean authenticateUser(String username, String password, boolean isAdmin) {
    	String query;
    	if(isAdmin) {
            query = "SELECT * FROM admins WHERE username ='"+username+"' AND password ='"+password+"';";

    	}
    	else {
            query = "SELECT * FROM users WHERE username ='"+username+"' AND password ='"+password+"';";
    	}
        try {
        	Statement st=connection.createStatement();
        	ResultSet rs=st.executeQuery(query);
        	while(rs.next())
        		return true;
        } catch (SQLException e) {
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
        return false;
    }
    
    public boolean registerUser(User user, boolean isAdmin) {
    	
        if (isEmailExists(user.getEmail())) {
            return false;
        }
        
        String query = "INSERT INTO " + (isAdmin ? "admins" : "users") + " (username, password, email, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPhoneNo());

            int rowsInserted = pst.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add user/admin: " + e.getMessage());
        }
    }
    
    public void addTheatre(Theatre theatre) {
        String query = "INSERT INTO theatres (name, location, capacity) VALUES (?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, theatre.getName());
            pst.setString(2, theatre.getLocation());
            pst.setInt(3, theatre.getCapacity());
            pst.executeUpdate();
            System.out.println("Theatre added successfully!");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add theatre: " + e.getMessage());
        }
    }

    
    private boolean isEmailExists(String email) {
        String query = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }


    public Theatre getTheatre(int theatreId) {
        String query = "SELECT * FROM theatres WHERE theatre_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, theatreId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Theatre theatre = new Theatre();
                theatre.setTheatreName(rs.getString("theatre_name"));
                theatre.setNoOfScreens(rs.getInt("no_of_screens"));
                theatre.setLocation(rs.getString("location"));
                return theatre;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch theatre: " + e.getMessage());
        }
        return null;
    }

	public int getTheatreId(String email) {
		int theatreId;
		String query = "SELECT theatreId FROM theatres JOIN admins ON theatres.theatreId = admins.theatreId WHERE email = ?";
		try(PreparedStatement pst = connection.prepareStatement(query)){
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				theatreId = rs.getInt("theatreId");
				return theatreId;
			}
		}catch (SQLException e) {
            throw new RuntimeException("Failed to fetch theatre: " + e.getMessage());
        }
        return 0;
	}




    
    

}
