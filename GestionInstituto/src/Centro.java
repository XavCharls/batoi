import java.util.ArrayList;
/**
 * 
 * @author Javier Llinares
 *
 */
public class Centro {

	private ArrayList<Persona> personas;

	// Constructores

	public Centro() {
		this.personas = new ArrayList<Persona>();
	}

	public Centro(ArrayList<Persona> per) {
		this.personas = new ArrayList<Persona>(per.size());
		for (Persona p : per)
			this.personas.add((Persona) p.clonar());

	}

	public Centro(Centro c) {
		this(c.personas);
	}

	public Centro clonar() {
		return new Centro(this);
	}

	public void altaPersona(Persona p) {
		this.personas.add((Persona) p);
	}

	public boolean bajaPersona(String dni) {
		Persona pAux=null;
		boolean bAux=false;
		for (Persona p : personas) {
			if (p.getDni().equals(dni)) {
				pAux=p;
				bAux=true;
			}
		}
		personas.remove(pAux);
		return bAux;
	}

	public void imprimSal() {
		for (Persona p : personas) {
			if(p instanceof Empleado) {
			System.out.println(p.getNombre()+" "+p.getApellidos()+" "+((Empleado)p).getSalario());
			}
		}

	}

	@Override
	public String toString() {
		return "Centro [personas=" + personas + "]";
	}
	
	public void visualizar() {
		System.out.println(this.toString());
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

}
