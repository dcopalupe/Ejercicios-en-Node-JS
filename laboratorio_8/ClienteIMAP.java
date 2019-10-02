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
			
			System.out.println("Ingresa tu usuario: ");
			String user = lectura.nextLine();
			System.out.println("Ingresa tu contraseña: ");
			String pass = lectura.nextLine();
			
			
			//String mensaje = lectura.nextLine();
			salida.println(". login "+user+" "+pass);
			System.out.println(entrada.nextLine());
			
			
			while(true){
			
				System.out.println("MENU");
				System.out.println("1.- select inbox");
				System.out.println("2.- ver mensaje");
				
				
				int n = lectura.nextInt();
				
				switch (n) {
				case 1:
					
					//String inbox = lectura.nextLine();
					salida.println(". select inbox");
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					
					break;
				
				case 2:
					System.out.println("Ingrese el numero de mensaje");
					int num = lectura.nextInt();
					
					//String leerbuzon = lectura.nextLine();
					salida.println(". fetch "+num+" rfc822.text");
					System.out.println(entrada.nextLine());
					System.out.println(entrada.nextLine());
					//. FETCH 2 rfc822.text
					
					break;
					
				default:
					System.out.println("Incorrecto");
					break;
				}
				
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