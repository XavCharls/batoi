package tema10_escrituraBinario;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class escrituraBinaro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		FileOutputStream fos=null;
		DataOutputStream salida=null;
		int n=0;
		
		try {
			fos= new FileOutputStream("datos.dat");
			salida=new DataOutputStream(fos);
			System.out.println("Introduce -1 para terminar");
			n=input.nextInt();
			
			while(n!=-1) {
				salida.writeInt(n);
				n=input.nextInt();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			input.close();
			try {
				fos.close();
				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
