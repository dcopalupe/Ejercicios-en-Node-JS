package TCP;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP {
	ServerSocket sServidor;
	Socket sCliente;
	int puerto;
	PrintStream salida;
	Scanner entrada;
	String mensajeSolicitud = " ";
	String mensajeRespuesta = " ";
	
	public ServidorTCP(int p){
		puerto = p;
	}
	public void Smayor(){
		
		try {
			sServidor = new ServerSocket(puerto);
			System.out.println("- SERVIDOR TCP INICIADO -");
			System.out.println("- Esperando Cliente -");
			while(true){
				sCliente = sServidor.accept();
				
				///////////////ESTE ES EL MENSAJE DE BIENVENIDA AL SERVIDOR////////////////////
				PrintStream bienvenida = new PrintStream(sCliente.getOutputStream());
				bienvenida.println("***BIENVENIDO AL SERVIDOR : OBTIENE MAYOR DE 2 NUMEROS***");
				////////////////////////////////////////////////////////////////////////////////
				
				PrintStream salida = new PrintStream(sCliente.getOutputStream());

				Scanner entrada1 = new Scanner(sCliente.getInputStream());
				Scanner entrada2 = new Scanner(sCliente.getInputStream());

				int a = Integer.parseInt(entrada1.nextLine());
				int b = Integer.parseInt(entrada2.nextLine());

				if (a > b) {
					salida.println("Respuesta Del Servidor: EL MAYOR ES "+a);
				}else{
					if (a<b) {
						salida.println("Respuesta Del Servidor: EL MAYOR ES "+b);
					}else{
						salida.println("Respuesta Del Servidor: SON IGUALES");
					}
				}
				System.out.println("Numero escritos por el cliente: "+a+" "+b);
			}
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		}
		finally{
			finalizar();
		}
	}
	public void finalizar(){
		try {
			salida.close();
			entrada.close();
			sServidor.close();
			sCliente.close();
			System.out.println("Conexion Finalizada...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
