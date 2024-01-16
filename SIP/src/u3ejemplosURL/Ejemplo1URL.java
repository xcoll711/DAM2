package u3ejemplosURL;

import java.net.*;

public class Ejemplo1URL {
    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("Constructor simple para una URL:");
            url = new URL("http://docs.oracle.com/");
            visualizar(url);

            System.out.println("Otro constructor simple para una URL:");
            url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
            visualizar(url);

            System.out.println("Const. para protocolo +URL + directorio: ");
            url = new URL("http", "docs.oracle.com", "/javase/10");
            visualizar(url);

            System.out.println("Constructor para protocolo + URL + puerto + directorio:");
            url = new URL("http", "localhost", 8084, "/WebApp/Controlador?accion-modificar");
            visualizar(url);

            System.out.println("Constructor para un objeto URL en un contexto:");
            URL urlBase = new URL("https://docs.oracle.com/");
            url = new URL(urlBase, "/javase/10/docs/api/java/net/URL.html");
            visualizar(url);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }
    }

    private static void visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetUserInfo(): " + url.getUserInfo());
        System.out.println("\tgetPath(): " + url.getPath());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("\tgetDefaultPort(): " + url.getDefaultPort());
    }
}

