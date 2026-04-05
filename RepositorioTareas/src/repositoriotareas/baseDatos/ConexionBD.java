
package repositoriotareas.baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
        "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?sslmode=require";

    private static final String USER = "postgres.rjnmvpiwwtlaaxuoawse";
    private static final String PASSWORD = "dfd7bpqWCa6VPGQi";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
            return conn;
            
        } catch (Exception e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
            return null;
        }
    }
}



