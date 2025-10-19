package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database configuration and connection management
 * Provides centralized database connection handling
 */
public class DatabaseConfig {

    private static Connection connection = null;
    private static DatabaseConfig instance = null;

    private DatabaseConfig() {
        // Private constructor for singleton
    }

    /**
     * Get singleton instance
     */
    public static DatabaseConfig getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfig.class) {
                if (instance == null) {
                    instance = new DatabaseConfig();
                }
            }
        }
        return instance;
    }

    /**
     * Get database connection (creates if not exists)
     */
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName(Constants.DB_DRIVER);
                connection = DriverManager.getConnection(Constants.DB_URL);
                System.out.println(Constants.MSG_DB_CONNECT_SUCCESS);
            } catch (ClassNotFoundException e) {
                System.err.println("SQLite JDBC driver not found");
                throw new SQLException("Database driver not found", e);
            }
        }
        return connection;
    }

    /**
     * Close database connection
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("데이터베이스 연결 해제");
            } catch (SQLException e) {
                System.err.println("Error closing database connection");
                e.printStackTrace();
            }
        }
    }

    /**
     * Test database connection
     */
    public boolean testConnection() {
        try {
            Connection conn = getConnection();
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println(Constants.MSG_DB_CONNECT_FAIL);
            e.printStackTrace();
            return false;
        }
    }
}
