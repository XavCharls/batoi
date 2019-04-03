package tema7_composicion_pluviometro;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatosPluviometro ficha = new DatosPluviometro(20, 0);
		
		for (int i = 0; i < 20; i++) {
			//ficha.getArray()[i] = new MedidaPrecip((Math.round(Math.random()*450)/10.0), 9, 1, 2018, i, (Math.round(Math.random()*450)/10.0));
			ficha.agregarPrecip((Math.round(Math.random()*450)/10.0), 9, 1, 2018, i, (Math.round(Math.random()*450)/10.0));
			//ficha.agregarPrecip(precipHora, dia, mes, any, hora, temp);
		}

		System.out.println("Precipitaciones del 9 de enreo 2018: " + ficha.precipitacionDia(9, 1, 2018));
		ficha.listarMes(1, 2018);
	}

}
