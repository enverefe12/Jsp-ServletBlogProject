package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Text;
import util.DataConnection;

public class TextDao {
	
	public static final int EXCEPTION=2;
	public static final int SUCCESS=1;
	public static final int TEXT_EXISTS=2;

	
	
	public List<Text> getTextByCategory(int id){
		
		try {
			DataConnection dt=new DataConnection();
			PreparedStatement psm=dt.getDataConnection().prepareStatement("Select*from texts where kategoriId=?");
			psm.setInt(1, id);
			ResultSet rs=psm.executeQuery();
			List<Text> list=new ArrayList<Text>();
			while(rs.next()) {
				Text txt=new Text(rs.getString("textName") , rs.getString("textPath"), rs.getInt("kategoriId"), rs.getInt("textId"));
				list.add(txt);
			}
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Text> getAll(){
		try {
			DataConnection dt=new DataConnection();
			PreparedStatement psm=dt.getDataConnection().prepareStatement("Select*from texts");
			ResultSet rs=psm.executeQuery();
			List<Text> list=new ArrayList<Text>();
			while(rs.next()) {
				Text txt=new Text(rs.getString("textName") , rs.getString("textPath"), rs.getInt("categoryId"), rs.getInt("textId"));
				list.add(txt);
			}
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int addText(String name, String path, int category) {
		if(!isTextHave(name)) {
			try {
				DataConnection dt=new DataConnection();
				PreparedStatement psm=dt.getDataConnection().prepareStatement("INSERT INTO texts (textName, textPath, categoryId) VALUES (?, ?, ?);");
				psm.setString(1, name);
				psm.setString(2, path);
				psm.setInt(3, category);
				psm.execute();
				return SUCCESS;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			return EXCEPTION;
		}
       }else {
   		return TEXT_EXISTS;
       }
	}
	public boolean deleteText(int id) {
	
			try {
				DataConnection dt=new DataConnection();
				PreparedStatement psm=dt.getDataConnection().prepareStatement("DELETE FROM texts WHERE textId=?;");
				psm.setInt(1, id);
				psm.execute();
				return true;
			}catch (Exception e) {
                 e.printStackTrace();
 			}
		
		return false;
	}

	public Text getText(String name) {
		
		try {
			DataConnection dt=new DataConnection();
			PreparedStatement psm=dt.getDataConnection().prepareStatement("select * from texts where textName=?");
			psm.setString(1, name);
			ResultSet rs=psm.executeQuery();
			if(!rs.next()) {
				return null;
			}else {
				while(rs.next()) {
					Text txt=new Text(name, rs.getString("textPath"), rs.getInt("categoryId"),  rs.getInt("textId"));
					return txt;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
public Text getTextById(int id) {
		
		try {
			DataConnection dt=new DataConnection();
			PreparedStatement psm=dt.getDataConnection().prepareStatement("select * from texts where textId=?");
			psm.setInt(1, id);
			ResultSet rs=psm.executeQuery();
				while(rs.next()) {
					Text txt=new Text(rs.getString("textName"), rs.getString("textPath"), rs.getInt("categoryId"),  rs.getInt("textId"));
					return txt;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean isTextHave(String name) {
		if(getText(name) == null) {
			return false;
		}else {
			return true;
		}
	}
}
