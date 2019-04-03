package controladores;

import java.util.ArrayList;

import contactos.ContactoDTO;

public class AgendaController {
	
	private ArrayList<ContactoDTO> contactos;
	
	public AgendaController() {
		contactos = new ArrayList<ContactoDTO>();
	}
	
	public AgendaController(ArrayList<ContactoDTO> x) {
		for (ContactoDTO c : x) {
			this.contactos.add(c.clonar());
		}
	}
	
	public AgendaController(AgendaController a) {
		this(a.getContactos());
	}
	
	public AgendaController clonar() {
		return new AgendaController(this);
	}
	
	public void agrgar(ContactoDTO c) {
		this.contactos.add(c);
	}
	
	public void eliminar(ContactoDTO c) {
		this.contactos.remove(buscar(c));
	}
	
	public ContactoDTO buscar(ContactoDTO c) {
		ContactoDTO aux= new ContactoDTO();
		for (ContactoDTO cDIO : contactos) {
			if(cDIO.getEmail().equals(c.getEmail())) {
				aux=cDIO;
			}
		}
		return aux;
	}
	
	public void listarTodos() {
		for (ContactoDTO contactoDTO : contactos) {
			System.out.println(contactoDTO.toString());
		}
	}

	public ArrayList<ContactoDTO> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<ContactoDTO> contactos) {
		this.contactos = contactos;
	}

	@Override
	public String toString() {
		return "AgendaController [contactos=" + contactos + "]";
	}
	
}
