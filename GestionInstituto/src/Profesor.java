/**
 * 
 * @author Javier Llinares
 *
 */
public class Profesor extends Empleado{
	private String departamento;
	private static final float kFECHAMIN = 2000;
	
	public Profesor() {
		super();
		this.departamento="";
		salarioExtra();
	}
	
	public Profesor(String nom, String ape, String dni, String esta, int year, String dep, float sal) {
		super(nom, ape, dni, esta, year, sal);
		this.departamento=dep;
		salarioExtra();
	}
	
	public Profesor(Profesor p) {
		this(p.nombre, p.apellidos, p.dni, p.estadoCivil, p.yearIncor, p.departamento, p.salario);
	}
	
	public Profesor clonar() {
		return new Profesor(this);
	}
	
	public void cambiarDpt(String nuevo) {
		setDepartamento(nuevo);
	}

	@Override
	public void salarioExtra() {
		if(this.yearIncor<kFECHAMIN)
			this.salario*=1.08;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Profesor [departamento=" + departamento + "]";
	}
	
	public void visualizar() {
		System.out.println(this.toString());
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}