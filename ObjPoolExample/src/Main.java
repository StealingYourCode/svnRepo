import java.sql.Connection;



public class Main {

	public static void main(String[] args) {
		
		JDBCConnectionPool pool = new JDBCConnectionPool("jdbc:oracle:thin:@oracle.fdmgroup.com:1521:XE","louisyang","Oracle101");
		
		//Checks the instance of the connection pool out
		Connection conn = pool.checkOut();
		
		//Checks the connection back in
		pool.checkIn(conn);
	}
}
