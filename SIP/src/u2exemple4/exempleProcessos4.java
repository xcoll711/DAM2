package u2exemple4;

import java.io.BufferedReader;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class exempleProcessos4 {
	public static void main(String[] args) throws IOException {

		// Creamos un objeto File al directorio donde está Ejemplo2
		File directorio = new File("C:\\Users\\ciclesgs.EAAULA211W-024\\eclipse-workspace\\SIP\\src\\exemple4");

		Scanner sc = new Scanner(System.in);
		System.out.println("---- Nombre: ");
		String nombre = sc.nextLine();

		// Creamos el proceso añadiendo "nombre" que irá a args[0] en este caso
		ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre.java",nombre);

		pb.directory(directorio);
		System.out.println("a");
		System.out.printf("Directorio de trabajo: %s%n", pb.directory());



		Process p = pb.start();
		System.out.println("Se ejecuta el proceso");

		try {
			InputStream is = p.getInputStream();
			
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);

			int codiError = p.waitFor();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		/*
		 * 
		 */
		
	}
}
