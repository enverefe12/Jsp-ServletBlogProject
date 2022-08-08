package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;

public class UserDao {

	
	private DataConnection dt=new DataConnection();
	
	
	
	public User getUser(String username, String password) {
		
		try {
			PreparedStatement psm=dt.getDataConnection().prepareStatement("Select * from dbo.users where username=? and password=?");
			psm.setString(1,username);
			psm.setString(2, password);
			ResultSet rs=psm.executeQuery();
			
			if(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				return user;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public void addUser(String username, String password){
			try {
				PreparedStatement psm=dt.getDataConnection().prepareStatement("INSERT INTO dbo.users (username, password, role) VALUES (?, ?, 'member');");
				psm.setString(1, username);
				psm.setString(2, password);
				psm.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	public List<User> getAllUser(){
		try {
			PreparedStatement psm=dt.getDataConnection().prepareStatement("select*from dbo.users");
			ResultSet rs=psm.executeQuery();
			List<User> list=new ArrayList<User>();
			while(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}
