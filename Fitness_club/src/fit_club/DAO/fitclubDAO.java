package fit_club.dao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import fit_club.bean.fit_club;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author amit
 */
public class fitclubDAO extends BaseDAO{
    
    public static void insert(fit_club p1){
	Connection con=null;
	try {
		con =getCon();
		String sql = "insert into fit_club " +
				" (member_name, fees) " +
				" values (? , ?)";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, p1.getMember_name());
		st.setString(i++, p1.getFees());
		st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
    
    public static void update(fit_club p1){
	Connection con=null;
	try {
		con =getCon();
		String sql = "update fit_club " +
		" set fees = ?, member_name =?" +
		" where id = ?  ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, p1.getFees());
		st.setString(i++, p1.getMember_name());
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
		String sql = "delete from fit_club " +
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

    public static LinkedList<fit_club> search(String sc, String si){
	LinkedList<fit_club> res = new LinkedList<fit_club>();
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from fit_club where " + sc + " like ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, "%"+si+"%");
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			fit_club p1 = new fit_club();
			p1.setMember_name(rs.getString("member_name"));
			p1.setFees(rs.getString("fees"));                        
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

public static fit_club findById(String id){
        fit_club res = null;
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from fit_club where id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			fit_club p1 = new fit_club();
			p1.setMember_name(rs.getString("member_name"));
			p1.setFees(rs.getString("fees"));
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
