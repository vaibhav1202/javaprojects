package hotel_menu.dao;

import ECUtils.BaseDAO;
import hotel_menu.bean.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author amit
 */
public class MenuDAO extends BaseDAO{
    
    public static void insert(Menu p1){
	Connection con=null;
	try {
		con =getCon();
		String sql = "insert into hotel_menu " +
				" (f_name, price , quantity) " +
				" values (?, ? , ?)";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, p1.getF_name());
		st.setString(i++, p1.getPrice());
                st.setString(i++, p1.getQuantity());
		st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
    
    public static void update(Menu p1){
	Connection con=null;
	try {
		con =getCon();
		String sql = "update hotel_menu " +
		" set price = ?, f_name =?, quantity = ? " +
		" where id = ?  ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, p1.getPrice());
		st.setString(i++, p1.getF_name());
		st.setString(i++, p1.getQuantity());
		st.setString(i++, p1.getId());
		st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
public static void delete(String id){
	Connection con=null;
	try {
		con =getCon();
		String sql = "delete from hotel_menu " +
		" where id =? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}

    public static LinkedList<Menu> search(String sc, String si){
	LinkedList<Menu> res = new LinkedList<Menu>();
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from hotel_menu where " + sc + " like ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, "%"+si+"%");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Menu p1 = new Menu();
			p1.setF_name(rs.getString("f_name"));
			p1.setPrice(rs.getString("price"));
			p1.setQuantity(rs.getString("quantity"));                        
			p1.setId(rs.getString("id"));
			res.add(p1);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
	return res;
}

public static Menu findById(String id){
        Menu res = null;
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from hotel_menu where id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			Menu p1 = new Menu();
			p1.setF_name(rs.getString("f_name"));
			p1.setQuantity(rs.getString("quantity"));
                        p1.setPrice(rs.getString("price"));
			p1.setId(rs.getString("id"));
			res=p1;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
	return res;
}
    
}
