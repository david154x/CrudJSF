package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private static final String jdbc = "jdbc:mariadb://";
	private static final String host = "localhost";
	private static final int port = 3306;
	private static final String database = "library";
	private static final String username = "DRR";
	private static final String password = "123";
	private static final String url = jdbc + host + ":" + port + "/" + database;

	public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
}
