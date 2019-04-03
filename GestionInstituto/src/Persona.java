/**
 * 
 * @author Javier Llinares
 *
 */
public class Persona {
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected String estadoCivil;

	public Persona() {
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.estadoCivil = "";
	}

	public Persona(String nom, String ape, String dni, String esta) {
		this.nombre = nom;
		this.apellidos = ape;
		this.dni = dni;
		this.estadoCivil = esta;
	}

	public Persona(Persona p) {
		this(p.nombre, p.apellidos, p.dni, p.estadoCivil);
	}

	public Persona clonar() {
		return new Persona(this);
	}

	public void cambiarEstado(String nuevo) {
		if (nuevo.equals("soltero") || nuevo.equals("comprometido") || nuevo.equals("casado")
				|| nuevo.equals("separado") || nuevo.equals("divorciado") || nuevo.equals("viudo")
				|| nuevo.equals("soltera") || nuevo.equals("comprometida") || nuevo.equals("casada")
				|| nuevo.equals("separada") || nuevo.equals("divorciada") || nuevo.equals("viuda"))
			this.estadoCivil = nuevo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", estadoCivil="
				+ estadoCivil + "]";
	}

	public void visualizar() {
		System.out.println(this.toString());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}