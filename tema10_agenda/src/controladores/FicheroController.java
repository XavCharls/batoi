package controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import contactos.ContactoDTO;

public class FicheroController {
	// obtener contac devuelve arrayList
	// guardarContacto recibe arratList

	//private File fichero;
	//private FileWriter salida;
	//private FileReader entrada;
	private BufferedWriter ficheroSalida;
	private BufferedReader ficheroEntrada;
	private static final String kNOMBRE = "fichero.txt";

	public FicheroController() {
/*		fichero = new File(kNOMBRE);

		try {
			salida = new FileWriter(fichero);
		} catch (IOException e) {
			TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			entrada = new FileReader(fichero);
		} catch (FileNotFoundException e) {
			TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ficheroSalida = new BufferedWriter(salida);
		ficheroEntrada = new BufferedReader(entrada); */
	}

	public ArrayList<ContactoDTO> obtenerContactos() throws IOException {
		File fichero = new File(kNOMBRE);
		ficheroEntrada = new BufferedReader(new FileReader(fichero));
		ArrayList<ContactoDTO> aux = new ArrayList<ContactoDTO>();
		
		String[] lineas = null;
		int objeto = 0;
		String dato = null;

		
		while ((dato = ficheroEntrada.readLine()) != null) {
			lineas = dato.split(" ");

			aux.add(new ContactoDTO());
			aux.get(objeto).setNombre(lineas[0]);
			aux.get(objeto).setApellidos(lineas[1] + " " + lineas[2]);
			aux.get(objeto).setTelefono(lineas[3]);
			aux.get(objeto).setMovil(lineas[4]);
			aux.get(objeto).setEmail(lineas[5]);
			
			objeto++;

		}
		ficheroEntrada.close();
		
		return aux;
	}

	public void guardarContactos(ArrayList<ContactoDTO> a) throws IOException {
		ficheroSalida = new BufferedWriter(new FileWriter(new File(kNOMBRE)));
		for (ContactoDTO c : a) {
			ficheroSalida.write(c.toString());
			ficheroSalida.newLine();
		}
		ficheroSalida.close();
	}

}
