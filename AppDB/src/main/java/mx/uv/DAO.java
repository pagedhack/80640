package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    
    public static Conexion c = new Conexion();

    public static List<Usuario> regresaUsuarios() {
        Statement stm = null;
        ResultSet rs = null;
        List<Usuario> resutado = new ArrayList<>();
        Connection cc = null;
        
        cc = c.getConnection();
        try {
            String slq = "select * from usuarios";
            stm = cc.createStatement();
            rs = stm.executeQuery(slq);
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"),
                    rs.getString("password"));
                resutado.add(u); 
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                rs = null;
            }

            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return resutado;
    }


    public static String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection cc = null;
        String msj = "";

        cc = c.getConnection();
        try {
            String sql = "insert into usuarios (id, nombre, password) values (?,?,?)";
            stm = (PreparedStatement) cc.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "el usuario se agrego";
            else
                msj = "el usuario no se agrego";
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Conexion Cerrada!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return msj;
    }


}