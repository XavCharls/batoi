/**
 * 
 * @author Javier Llinares
 *
 */
public abstract class Empleado extends Persona{
	protected int yearIncor;
	protected float salario;
	
	public Empleado() {
		super();
		this.yearIncor=0;
		this.salario=0F;
	}
	
	public Empleado(String nom, String ape, String dni, String esta, int year, float sal) {
		super(nom, ape, dni, esta);
		this.yearIncor=year;
		this.salario=sal;
	}
	
	public Empleado(Empleado e) {
		this(e.nombre, e.apellidos, e.dni, e.estadoCivil, e.yearIncor, e.salario);
	}
	
	public abstract void salarioExtra();

	@Override
	public String toString() {
		return super.toString() + " Empleado [yearIncor=" + yearIncor + " salario="+salario+"]";
	}
	
	public void visualizar() {
		System.out.println(this.toString());
	}

	public int getYearIncor() {
		return yearIncor;
	}

	public void setYearIncor(int yearIncor) {
		this.yearIncor = yearIncor;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}
