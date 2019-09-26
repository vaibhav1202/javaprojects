package ECUtils;
public class ECConst {
	public static String DB_NAME ="h_menu";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{
	"create table hotel_menu (id INT NOT NULL AUTO_INCREMENT, f_name varchar(100), price double, quantity varchar(20), PRIMARY KEY (id))",	
	"insert into hotel_menu (f_name , price , quantity) values ('xyz', '12' , '5')",	
	};
}
