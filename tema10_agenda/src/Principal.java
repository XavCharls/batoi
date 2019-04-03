
import java.io.IOException;
import java.util.Scanner;

import contactos.ContactoDTO;
import controladores.AgendaController;
import controladores.FicheroController;

public class Principal {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FicheroController FC = new FicheroController();		
		AgendaController AC = new AgendaController();
		boolean salir=false;
		Principal programa = new Principal();
		ContactoDTO auxCont=null;
		String auxApe="";
		
		while (!salir) {
			// sout de las opciones borrar buscar afegir etc
			// agregar eliminar buscar listarTodos obternerDelFichero guardarContactos salir
			System.out.println("1 agregar contactos");
			System.out.println("2 eliminar");
			System.out.println("3 buscar");
			System.out.println("4 listar Todos");
			System.out.println("5 obtener lista del fichero");
			System.out.println("6 guardar contactos");
			System.out.println("7 salir");
			switch (programa.comprobarEnteroA()) {
			case 1://agregar
				auxCont = new ContactoDTO();
				System.out.println("Introduce los datos del contacto:");
				System.out.println("Nombre:");
				auxCont.setNombre(sc.next());
				System.out.println("Apellido 1:");
				auxApe=sc.next();
				System.out.println("Apellido 2:");
				auxCont.setApellidos(auxApe+" "+sc.next());
				System.out.println("Telefono:");
				auxCont.setTelefono(sc.next());
				System.out.println("Movil");
				auxCont.setMovil(sc.next());
				System.out.println("Email:");
				auxCont.setEmail(sc.next());
				
				AC.agrgar(auxCont);
				break;

			case 2://eliminar
				auxCont = new ContactoDTO();
				System.out.println("Email del contacto a eliminar:");
				auxCont.setEmail(sc.next());
				AC.eliminar(auxCont);
				break;
			
			case 3://buscar
				auxCont = new ContactoDTO();
				System.out.println("Email del contacto a buscar");
				auxCont.setEmail(sc.next());
				System.out.println(AC.buscar(auxCont).toString());
				break;
			
			case 4://listarTodos
				AC.listarTodos();
				break;
				
			case 5://obtenerDelFichero
				try {
					AC.setContactos(FC.obtenerContactos());
					AC.listarTodos();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 6://guardarContactos
				try {
					FC.guardarContactos(AC.getContactos());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 7://salir
				salir=true;
				sc.close();
				break;
			}
		}
		
	}
	
	public int comprobarEnteroA() {
		int aux;
		while(!sc.hasNextInt()) {
			System.out.println("introduce un entero");
			sc.next();
		}
		aux=sc.nextInt();
		while(aux<1||aux>7) {
			System.out.println("introduce un numero del 1 al 7");
			while(!sc.hasNextInt()) {
				System.out.println("introduce un entero");
				sc.next();
			}
			aux=sc.nextInt();
		}
		return aux;
	}

}
