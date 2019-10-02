package TCP;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteIMAP {
	Socket sCliente;
	Scanner entrada;
	PrintStream salida;
	String host;
	int puerto;
	String mensajeSolicitud = "";
	String mensajeRespuesta= "";
	private Scanner lectura;
	
	public ClienteIMAP(String h,int p) {
		host = h;
		puerto = p;
	}
	public void correo(){
		try {
			sCliente = new Socket(host,puerto);
			
			////////////////ACA RECIBIREMOS EL MENSAJE DE BIENVENIDA DEL SERVIDOR//////////
			Scanner mensajeb = new Scanner(sCliente.getInputStream());
			String respuesta = mensajeb.nextLine();
			System.out.println(respuesta);
			///////////////////////////////////////////////////////////////////////
			
			PrintStream salida = new PrintStream(sCliente.getOutputStream());  
			
			Scanner entrada = new Scanner(sCliente.getInputStream());
			
			lectura = new Scanner(System.in);
			
			while(true){
				
				
				String mensaje = lectura.nextLine();
				salida.println(mensaje);
				System.out.println(entrada.nextLine());
				
				
				String inbox = lectura.nextLine();
				salida.println(inbox);
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				
				String leerbuzon = lectura.nextLine();
				salida.println(leerbuzon);
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				System.out.println(entrada.nextLine());
				//. FETCH 2 rfc822.text
				
			}
				
			
			
			
			
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