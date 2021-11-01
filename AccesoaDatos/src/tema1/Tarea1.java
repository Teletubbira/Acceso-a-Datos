package tema1;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String rutausuario = "i";
		File ruta = new File(rutausuario);
		boolean rutacorrecta = false;

		System.out.println("Escribe una ruta");
		rutausuario = sc.next();

		boolean ficheroexiste = false;

		File carpeta = new File(rutausuario);
		if (carpeta.isDirectory()) {
			System.out.println("Es un directorio");
			File[] listaFicheros = carpeta.listFiles();
			ArrayList<File> ficherostxt = new ArrayList<File>();

			for (int i = 0; listaFicheros.length > i; i++) {
				File fichero = listaFicheros[i];
				Path path = FileSystems.getDefault().getPath(fichero.getPath());

				System.out.println("Fichero " + i + ".");
				System.out.println("Nombre: " + fichero.getName());
				System.out.println("Se puede escribir? " + Files.isWritable(path));
				System.out.println("Esta oculto? " + fichero.isHidden());
				System.out.println("Tamaño " + fichero.length() + " bytes");
				System.out.println("-------------------------");

			}

		} else {
			System.out.println("No es un directorio");
		}

	}
}
