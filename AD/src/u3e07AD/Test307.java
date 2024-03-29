package u3e07AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test307 {
    public static void main(String[] args) {
        // Dades de connexió per a localhost
        String urlConnection = "jdbc:mysql://localhost:3306/ad?allowMultiQueries=true";
        String user = "root";
        String pwd = "";

        try (Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {

            // Dades per a la inserció
            String[][] clients = {
                    {"12345678A", "Gómez", "08001"},
                    {"87654321B", "Martínez", "08002"},
                    {"23456789C", "García", "08003"},
                    {"98765432D", "López", "08004"}
            };

            // Inserir els clients amb addBatch() i executeBatch()
            try (PreparedStatement sInsercio = c.prepareStatement(
                    "INSERT INTO clientes (dni, apellidos, cp) VALUES (?, ?, ?)"
            )) {
                // Recórrer l'array bidimensional i inserir les dades amb addBatch()
                for (String[] client : clients) {
                    sInsercio.setString(1, client[0]);
                    sInsercio.setString(2, client[1]);
                    sInsercio.setString(3, client[2]);
                    sInsercio.addBatch();
                }

                // Executar el lot amb executeBatch()
                sInsercio.executeBatch();

            } catch (SQLException e) {
                mostraErrorSQL(e);
                // Si hi ha algun error, es pot realitzar un rollback
                if (c != null) {
                    c.rollback();
                    System.err.println("Es fa ROLLBACK");
                }
            }

        } catch (SQLException e) {
            mostraErrorSQL(e);
        }
    }

    private static void mostraErrorSQL(SQLException e) {
        // Mètode per gestionar errors SQL, pots personalitzar-lo segons les teves necessitats.
        e.printStackTrace();
        e.getMessage();
    }
}
