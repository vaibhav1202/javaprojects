package fit_club.dao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import fit_club.bean.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAO extends BaseDAO{
    public static login validate(String email, String pass){
	login res = null;
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from login_p where user_name = ? and password = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, email);
		st.setString(i++, pass);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			login p1 = new login();
			p1.setuser_name(rs.getString("user_name"));
			p1.setpassword(rs.getString("password"));
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
