import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnectionPool extends ObjectPool<Connection>{

	private String oracle, user, password;
	
	public JDBCConnectionPool( String oracle, String user, String password){
		super();
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.oracle = oracle;
		this.user = user;
		this.password =password;
	}
	
	@Override 
	protected Connection create(){
		try{
			return(DriverManager.getConnection(oracle,user,password));
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override 
	public void expire(Connection o){
		try{
			((Connection ) o).close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean validate(Connection o){
		try{
			return (!((Connection) o).isClosed());
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}
