package tw.com.tradevan.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class DBUtils {
	/**
	 * Close quiet.
	 * 
	 * @param conn
	 */
	public static final void close(Connection conn) {
		if (null == conn) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static final void close(Statement ps) {
		if (null == ps) {
			return;
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static final void close(ResultSet rs) {
		if (null == rs) {
			return;
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static final void close(ResultSet rs, Statement st, Connection conn) {
		close(rs);
		close(st);
		close(conn);
	}
	
}
