package tema7_composicion_pluviometro;

public class DatosPluviometro {
	private final static int kTAMANY = 8640;
	private MedidaPrecip[] array;
	private int contador;

	public DatosPluviometro() {
		this.array = new MedidaPrecip[kTAMANY];
		this.contador = 0;
	}

	public DatosPluviometro(int tam, int contador) {
		this.array = new MedidaPrecip[tam];
		this.contador = contador;
	}

	public double precipitacionDia(int dia, int mes, int any) {
		double total = 0.0;

		for (int i = 0; i < array.length; i++) {
			if (array[i].getAny() == any) {
				if (array[i].getMes() == mes) {
					if (array[i].getDia() == dia) {
						total += array[i].getPrecipHora();
					}
				}
			}
		}

		return total;
	}

	public void listarMes(int mes, int any) {
		System.out.println("Precipitacion del mes: " + mes + ", any: " + any);
		System.out.println("Dia  Precipitacion (l/m2)");
		for (int i = 0; i < 30; i++) {
			System.out.println(i + "     " + precipitacionDia(i, mes, any));
		}

	}

	public void agregarPrecip(double precipHora, int dia, int mes, int any, int hora, double temp) {
		if (this.contador < this.array.length) {
			this.array[contador] = new MedidaPrecip(precipHora, dia, mes, any, hora, temp);
			this.contador++;
		}
		
	}

	public void visualizar() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].toString());
		}
	}

	
	public DatosPluviometro(int contador, MedidaPrecip[] a) {
		this.contador = contador;
		for (int i = 0; i < a.length; i++) {
			a[i] = this.array[i];
		}
	}
	//copia
	public DatosPluviometro(DatosPluviometro m) {
		this(m.contador, m.array);
	}

	public DatosPluviometro clonar() {
		return new DatosPluviometro(this);
	}

	public MedidaPrecip[] getArray() {
		return array;
	}

	public void setArray(MedidaPrecip[] array) {
		this.array = array;
	}

}
