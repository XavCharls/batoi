/**
 * 
 * @author Javier Llinares
 *
 */
public class Estudiante extends Persona{
	//private String curso;
	private String curso;
	
	public Estudiante() {
		super();
		this.curso="";
	}
	
	public Estudiante(String nom, String ape, String dni, String esta, String cur) {
		super(nom, ape, dni, esta);
		this.curso=cur;
	}
	
	public Estudiante(Estudiante e) {
		this(e.nombre, e.apellidos, e.dni, e.estadoCivil, e.curso);
	}
	
	public Estudiante clonar() {
		return new Estudiante(this);
	}
	
	public void matricularNuevo(String c) {
		this.curso = c;
	}

	@Override
	public String toString() {
		return super.toString() + " Estudiante [curso=" + curso + "]";
	}
	
	public void visualizar() {
		System.out.println(this.toString());
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
