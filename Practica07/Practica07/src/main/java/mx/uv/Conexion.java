package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url="jdbc:mysql://localhost:3306/database";
    private static String nameDriver = "mysql-connector-java-8.0.27 .jar"; //com.mysql.jdbc.Driver
    private static String user="root";
    private static String password="123456789";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(nameDriver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            // TODO: handle exception
        } catch (ClassNotFoundException e){
            System.out.println("no se encontro");
        }
    return connection;
    }
}
