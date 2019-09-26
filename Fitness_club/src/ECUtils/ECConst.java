package ECUtils;
public class ECConst {
	public static String DB_NAME ="fit_club";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{
	"create table fit_club (id INT NOT NULL AUTO_INCREMENT, member_name varchar(100), fees double, PRIMARY KEY (id))",	
	"insert into fit_club (member_name , fees) values ('Vaibhav agrawal', '500')",	
        "create table login_p (user_name varchar(40), password varchar(50))",
        "insert into login_p(user_name, password) values ('admin','admin@123')"
        };
}
