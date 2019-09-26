package ECUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils2 {
     public static int getInt(String no){
	 int res = 0;
	 try {
		 Double d1 = Double.parseDouble(no);
		 res = d1.intValue();
	} catch (Exception e) {
	}
	 return res;
 } 

public static String doubleToStr(double d1){
    String res = "";
    res = new DecimalFormat("#.##").format(d1);
    return res;
}     
     
 public static double getDouble(String no){
	 double res = 0;
	 try {
		 res = Double.parseDouble(no);
	} catch (Exception e) {
	}
	 return res;
 } 
 public static boolean getBoolean(String no){
	 boolean res = false;
	 try {
		 res = Boolean.parseBoolean(no);
	} catch (Exception e) {
	}
	 return res;
 } 
public static java.sql.Date getDate(String datStr){
	 java.sql.Date res = null;
	 try {
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date  tDate = sdf.parse(datStr);
		 res = new java.sql.Date(tDate.getTime());
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return res;
 }    
 public static String dateToStr(Date d1){
		String res = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			res = sdf.format(d1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
