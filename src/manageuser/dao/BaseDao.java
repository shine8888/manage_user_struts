package manageuser.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class BaseDao extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8094961032874256041L;
	
	protected Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void openConnect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(getText("urlMySQL"), getText("user"), getText("pass"));
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		}
	}

	public void closeConnect() throws SQLException {
		try {
			if (conn != null || conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void rollBack() throws SQLException {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void setAutoComit(boolean name) throws SQLException {
		try {
			if (conn != null) {
				conn.setAutoCommit(name);
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void commit() throws SQLException {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}
