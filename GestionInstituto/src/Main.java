/**
 * 
 * @author Javier Llinares
 *
 */
import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Centro c1 = new Centro();
		Main programa = new Main();
		
		String nom="";
		String ape="";
		String dni="";
		String esta="";
		int year = 0;
		String dep="";
		float sal=0F;
		String cur="";
		String sec="";
		
		boolean bucle=true;
		while(bucle) {
			System.out.println("1 dar de alta");
			System.out.println("2 dar de baja");
			System.out.println("3 imprimir listado");
			System.out.println("4 imprimir nominas");
			System.out.println("5 salir");
			int opcion=programa.comprobarEnt();
			switch (opcion) {
			case 1:
				//Dar de alta
				System.out.println("1 profesor");
				System.out.println("2 estudiante");
				System.out.println("3 personal servicio");
				opcion=programa.comprobarEnt();
				switch (opcion) {
				case 1:
					System.out.println("Nombre:");
					nom = input.next();
					System.out.println("1 Apellido:");
					ape = input.next();
					System.out.println("2 Apellido:");
					ape += " "+ input.next();
					System.out.println("DNI:");
					dni = input.next();
					System.out.println("Estado:");
					esta = programa.checkEstado();
					System.out.println("year:");
					year = programa.comprobarEntBasico();
					System.out.println("Departamento:");
					dep = input.next();
					System.out.println("Salario:");
					sal = programa.comprobarFloatBasico();
					c1.altaPersona(new Profesor(nom, ape, dni, esta, year, dep, sal));
					System.out.println("profesor agregado");
					break;

				case 2:
					System.out.println("Nombre:");
					nom = input.next();
					System.out.println("1 Apellido:");
					ape = input.next();
					System.out.println("2 Apellido:");
					ape += " "+ input.next();
					System.out.println("DNI:");
					dni = input.next();
					System.out.println("Estado:");
					esta = programa.checkEstado();
					System.out.println("cursos");
					cur = input.next();
					c1.altaPersona(new Estudiante(nom, ape, dni, esta, cur));
					System.out.println("Estudiante agregado");
					break;
				
				case 3:
					System.out.println("Nombre:");
					nom = input.next();
					System.out.println("1 Apellido:");
					ape = input.next();
					System.out.println("2 Apellido:");
					ape += " "+ input.next();
					System.out.println("DNI:");
					dni = input.next();
					System.out.println("Estado:");
					esta = programa.checkEstado();
					System.out.println("year:");
					year = programa.comprobarEntBasico();
					System.out.println("Seccion");
					sec = input.next();
					System.out.println("Salario:");
					sal = programa.comprobarFloatBasico();
					c1.altaPersona(new Servicio(nom, ape, dni, esta, year, sec, sal));
					System.out.println("Personal agregado");
					break;
				}
				break;
			case 2:
				//Dar de baja
				System.out.println("Dni a dar de baja");
				dni = input.next();
				if(c1.bajaPersona(dni)) {
					System.out.println("Persona descartada");
				}else{
					System.out.println("No se ha encontrado la persona");
				};
				break;
			case 3:
				//Imprimir listado
				c1.visualizar();
				break;
			case 4:
				//Imprimir nominas
				c1.imprimSal();
				break;
			case 5:
				//salir
				input.close();
				bucle=false;
				break;
			}
		}
	}
	

	public int comprobarEnt() {
		int aux = 0;
		while(!input.hasNextInt()) {
			System.out.println("introduce un entero");
			input.next();
		}
		aux=input.nextInt();
		while (aux>5 || aux<1) {
			while(!input.hasNextInt()) {
				System.out.println("introduce un entero");
				input.next();
			}
			aux=input.nextInt();
		}
		return aux;
	}
	
	public int comprobarEntBasico() {

		while(!input.hasNextInt()) {
			System.out.println("introduce un entero");
			input.next();
		}
		return input.nextInt();

	}

	public float comprobarFloatBasico() {

		while(!input.hasNextFloat()) {
			System.out.println("introduce un float");
			input.next();
		}
		return input.nextFloat();

	}
	
	public String checkEstado() {
		String cEstado=input.next();
		while (!(cEstado.equals("soltero") || cEstado.equals("comprometido") || cEstado.equals("casado")
				|| cEstado.equals("separado") || cEstado.equals("divorciado") || cEstado.equals("viudo")
				|| cEstado.equals("soltera") || cEstado.equals("comprometida") || cEstado.equals("casada")
				|| cEstado.equals("separada") || cEstado.equals("divorciada") || cEstado.equals("viuda"))) {
			System.out.println("estado invalido introduce otra vez");
			cEstado=input.next();
		}
		return cEstado;
	}
	
}
