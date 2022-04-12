package io.angel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import org.mariadb.jdbc.MariaDbDataSource;

public class DBDemo {

    private static Connection createConnection(
            String url,
            String username,
            String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    private static Connection createDataSource(
            String url,
            String username,
            String password) throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource.getConnection();
    }

    private static HikariDataSource createConnectionPool(
            String url,
            String username,
            String password) throws SQLException {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);

        return hikariDataSource;
    }

    public static void main(String[] args) {
        try (Connection connection = createConnection(
                "jdbc:mariadb://localhost:3306/cars",
                "angel",
                "angel")) {
            System.out.println("Connection created!");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        try (Connection connection = createDataSource(
                "jdbc:mariadb://localhost:3306/cars",
                "angel",
                "angel")) {
            System.out.println("Connection created!");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        try (HikariDataSource dataSource = createConnectionPool(
                "jdbc:mariadb://localhost:3306/cars",
                "angel",
                "angel"); Connection connection = dataSource.getConnection()) {
            System.out.println("Connection created!");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}