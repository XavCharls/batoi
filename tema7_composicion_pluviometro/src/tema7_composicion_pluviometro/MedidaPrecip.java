package tema7_composicion_pluviometro;

public class MedidaPrecip {
	private double precipHora;
	private int dia, mes, any, hora;
	private double temperatura;
	
	public MedidaPrecip() {
		this.precipHora = 0.0;
		this.dia = 0;
		this.mes = 0;
		this.any = 0;
		this.hora = 0;
		this.temperatura = 0.0;
	}
	
	public MedidaPrecip(double precipHora, int dia, int mes, int any, int hora, double temp) {
		this.precipHora = precipHora;
		this.dia = dia;
		this.mes = mes;
		this.any = any;
		this.hora = hora;
		this.temperatura = temp;
	}

	public MedidaPrecip(MedidaPrecip m) {
		this(m.precipHora, m.dia, m.mes, m.any, m.hora, m.temperatura);
	}
	
	public MedidaPrecip clonar() {
		return new MedidaPrecip(this);
	}
	
	@Override
	public String toString() {
		return "MedidaPrecip [precipHora=" + precipHora + ", dia=" + dia + ", mes=" + mes + ", any=" + any + ", hora="
				+ hora + ", temperatura=" + temperatura + "]";
	}
	
	

	public double getPrecipHora() {
		return precipHora;
	}

	public void setPrecipHora(double precipHora) {
		this.precipHora = precipHora;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	
	
}

