package u2exemple3;

import java.io.*;

public class exempleProcessos3 {
	public static void main(String[] args) throws IOException {

		// Creamos un objeto File al directorio donde está Ejemplo2
		File directorio = new File("C:\\Users\\ciclesgs.EAAULA211W-024\\eclipse-workspace\\SIP\\src\\exemple2");

		// E1 proceso a ejecutar es "java" para ejecutar el archivo compilado "exempleProcessos2"
		ProcessBuilder pb = new ProcessBuilder("java", "exempleProcessos2.java");

		// Se establece el directorio donde se encuentra el ejecutable
		pb.directory(directorio);
		System.out.println("a");
		System.out.printf("Directorio de trabajo: %s%n", pb.directory());

		// Se ejecuta el proceso
		Process p = pb.start();

		try {
			System.out.println("b");

			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}
