/**
 * 
 * @author Javier Llinares
 *
 */
public class Servicio extends Empleado{
	private String seccion;
	
	public Servicio() {
		super();
		this.seccion="";
		salarioExtra();
	}
	
	public Servicio(String nom, String ape, String dni, String esta, int year, String sec, float sal) {
		super(nom, ape, dni, esta, year, sal);
		this.seccion=sec;
		salarioExtra();
	}
	
	public Servicio(Servicio s) {
		this(s.nombre, s.apellidos, s.dni, s.estadoCivil, s.yearIncor, s.seccion, s.salario);
	}
	
	public Servicio clonar() {
		return new Servicio(this);
	}
	
	public void cambiarSeccion(String nueva) {
		setSeccion(nueva);
	}

	@Override
	public void salarioExtra() {
		if(this.getEstadoCivil().equals("casado") || this.getEstadoCivil().equals("casada"))
			this.salario*=1.05;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Servicio [seccion=" + seccion + "]";
	}
	
	public void visualizar() {
		System.out.println(this.toString());
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}