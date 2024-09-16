package zone_fit.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    public static Connection getDBConnection() {
        Connection conex = null;
        var Database = "zone_fit";
        var url = "jdbc:mysql://localhost:3306/"+Database;
        var user = "root";
        var password = "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conex = DriverManager.getConnection(url,user,password);            
        } catch (Exception e) {
            System.out.println("Error al conectarse a BBDD: " + e.getMessage());
        }

        return conex;
    }

    public static void main(String[] args) {
        var conex = ConnectionDB.getDBConnection();
        if (conex != null) {
            System.out.println("Conexion exitosa " + conex);
        }else{
            System.out.println("Error al conectarse ");
        }
    }
}
