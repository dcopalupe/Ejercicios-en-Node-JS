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
	
	public void correo(){
		try {
			sCliente = new Socket(host,puerto);
			
			////////////////ACA RECIBIREMOS EL MENSAJE DE BIENVENIDA DEL SERVIDOR//////////
			Scanner mensajeb = new Scanner(sCliente.getInputStream());
			String respuesta = mensajeb.nextLine();
			System.out.println(respuesta);
			if (respuesta.substring(0, 3).equals("220")) {
				//System.out.println(respuesta);
				System.out.println("CONEXION EXITOSA CON EL SERVIDOR DE CORREO SMTP: "+respuesta.substring(4,28));
			}
			///////////////////////////////////////////////////////////////////////
			
			PrintStream numero1 = new PrintStream(sCliente.getOutputStream());  
			
			Scanner entrada = new Scanner(sCliente.getInputStream());
			
			lectura = new Scanner(System.in);
			
			boolean sw = true;
			
			while(sw){
				System.out.println("CORREO ORIGEN");
				String u =  lectura.nextLine();
				numero1.println("MAIL FROM:"+u);
				
				String ans = entrada.nextLine();
				if (ans.substring(0, 3).equals("250")) {
					
					System.out.println("USUARIO CORRECTO");
					System.out.println("CORREO DESTINO");
					String d =  lectura.nextLine();
					numero1.println("RCPT TO:"+d);
					System.out.println(entrada.nextLine());
					numero1.println("data");
					
					System.out.println("Escribe tu mensaje");
					System.out.println(entrada.nextLine());
						
					numero1.println(lectura.nextLine());
					numero1.println(".");
					System.out.println(entrada.nextLine());
					sw = false;
				}else{
					System.out.println("ESE USUARIO NO EXISTE");
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
