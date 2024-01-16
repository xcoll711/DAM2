package u3e01AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class create_table {
    public static void main(String[] args) {
        // Datos de conexión para localhost
        String urlConnection = "jdbc:mysql://localhost:3306/ad";
        String user = "root";
        String pwd = "";

        try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
             Statement s = c.createStatement()) {
            s.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY (DNI))");
            // Otros comandos SQL que desees ejecutar...
        } catch (SQLException e) {
            muestraErrorSQL(e);
        }
    }

    private static void muestraErrorSQL(SQLException e) {
        // Método para manejar errores SQL, puedes personalizarlo según tus necesidades.
        e.printStackTrace();
    }
}