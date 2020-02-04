package TCP;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	Socket sCliente;
	Scanner entrada;
	PrintStream salida;
	String host;
	int puerto;
	String mensajeSolicitud = "";
	String mensajeRespuesta= "";
	private Scanner lectura;
	
	public ClienteTCP(String h,int p) {
		host = h;
		puerto = p;
	}
	public void Cmayor(){
		try {
			sCliente = new Socket(host,puerto);
			
			////////////////ACA RECIBIREMOS EL MENSAJE DE BIENVENIDA DEL SERVIDOR//////////
			Scanner mensajeb = new Scanner(sCliente.getInputStream());
			System.out.println(mensajeb.nextLine());
			///////////////////////////////////////////////////////////////////////
			
			PrintStream numero1 = new PrintStream(sCliente.getOutputStream());  
			PrintStream numero2 = new PrintStream(sCliente.getOutputStream()); 
			
			Scanner entrada = new Scanner(sCliente.getInputStream());
			
			
			lectura = new Scanner(System.in);
			
			System.out.print("NUMERO 1 :");
			String u =  lectura.nextLine();
			numero1.println(u); //Se envia el primer numero al servidor
			
			System.out.print("NUMERO 2 :");
			String c = lectura.nextLine();
			numero2.println(c); //Se envia el segundo numero al servidor
			
			//Aca imprimimos la respuesta del servidor
			System.out.println(entrada.nextLine());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		}
	}
	
	public void finalizar(){
		try {
			salida.close();
			entrada.close();
			sCliente.close();
			System.out.println("conexion finalizada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
