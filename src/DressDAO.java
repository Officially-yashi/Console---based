import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DressDAO {
		
		private String user="root";
		private String password="Yashi@6420";
		private String url="jdbc:mysql://localhost:3306/showoffcollection";
        private Connection connection;
        private Statement statement;
		
		public DressDAO()
		{
			try
			{    Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,user,password);
				statement =con.createStatement();
                
        String createTable = "CREATE TABLE IF NOT EXISTS users ("
        + "id INT AUTO_INCREMENT PRIMARY KEY, "
        + "firstname VARCHAR(20), "
        + "lastname VARCHAR(20), "
        + "email VARCHAR(50) UNIQUE NOT NULL, "
        + "phone VARCHAR(15), "
        + "password VARCHAR(255) NOT NULL, "
        + "accType INT NOT NULL"
        + ")";
        statement.executeUpdate(createTable);
        System.out.println("Database and table verified.");
			}
			catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found! Make sure it's added to the classpath.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Database connection error! Check your credentials and database URL.");
                e.printStackTrace();
            }
		}
		
		public Statement getStatement()
		{
			if (statement == null) {
                try {
                    // If the statement is null, try reconnecting
                    connection = DriverManager.getConnection(url, user, password);
                    statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return statement;
			
		}
        public Connection getConnection() {
            return connection;
        }
        public void closeConnection() {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		
	}
}


