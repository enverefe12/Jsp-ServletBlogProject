package DataAccess;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Category;
import util.DataConnection;
public class CategoryDao {
	
private ArrayList<Category> kgt=new ArrayList<Category>();
	
	public ArrayList<Category> getCategories(){
		DataConnection dt=new DataConnection();
		try {
			
            PreparedStatement psm=dt.getDataConnection().prepareStatement("select * from category");
            ResultSet rs=psm.executeQuery();
            if(!rs.next()) {
            	System.out.println("Liste Boş--------------");
            }
            while(rs.next()){
            	Category kg=new Category(rs.getInt("categoryId") , rs.getString("category"));
            	kgt.add(kg);
            }
			return kgt;
		}catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		
		
		
	}
}
