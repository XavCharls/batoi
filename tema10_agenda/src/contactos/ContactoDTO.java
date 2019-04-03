package contactos;

public class ContactoDTO {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String movil;
	private String email;
	
	public ContactoDTO(){
		nombre="";
		apellidos="";
		telefono="";
		movil="";
		email="";
	}
	
	public ContactoDTO(String n, String a, String t, String m, String e) {
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
		this.movil=m;
		this.email=e;
	}
	
	public ContactoDTO(ContactoDTO DIO) {
		this(DIO.nombre, DIO.apellidos, DIO.telefono, DIO.movil, DIO.email);
	}
	
	public ContactoDTO clonar() {
		return new ContactoDTO(this);
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos + " " + telefono + " " + movil + " " + email;
	}
	
	public void visualizar() {
		System.out.println(this.toString());
	}
}
