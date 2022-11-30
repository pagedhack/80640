package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url="jdbc:mysql://localhost:3306/ejemplo80640";
    private static String nameDriver = "com.mysql.jdbc.Driver";//"mysql-connector-java-8.0.27 .jar";
    private static String user= processBuilder.environment().get("USERDB") ;
    private static String password= processBuilder.environment().get("PASSDB");

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(nameDriver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("conexion exitosa");
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e);
            // TODO: handle exception
        } catch (ClassNotFoundException e){
            System.out.println("no se encontro");
        }
    return connection;
    }
}
