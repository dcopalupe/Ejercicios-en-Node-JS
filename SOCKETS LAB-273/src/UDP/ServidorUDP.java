package UDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
	DatagramSocket socketUDP;
	int puerto;
	public ServidorUDP(int p) {
		puerto = p;
	}
	public void Smayor(){
		try {
			socketUDP = new DatagramSocket(puerto);
			System.out.println(" ----- SERVIDOR UDP INICIADO -----");
			System.out.println("---- Esperando Solicitudes ----");
			while(true){
				
				/////////////////////RECIBIMOS EL 1er DATAGRAMA DEL CLIENTE////////////////////////
				DatagramPacket paqueteRecibido = new DatagramPacket(new byte[1024],1024); //Creamos el datagrama, aqui recibiremos el datagrama del cliente
				socketUDP.receive(paqueteRecibido); //Recibimos el datagrama del cliente
				String mensajeRecibido =recorte( new String(paqueteRecibido.getData())); // Convertimos el datagrama en cadena, utilizamos el metodo recorte(). para eliminar '#' al final de la cadena
				int a = Integer.parseInt(mensajeRecibido); //convertimos la cadena en entero
				///////////////////////////////////////////////////////////////////////////////
				
				//////////////////////RECIBIMOS EL 2do DATAGRAMA DEL CLIENTE////////////////////////
				DatagramPacket paqueteRecibido2 = new DatagramPacket(new byte[1024],1024);//Creamos el datagrama, aqui recibiremos el 2do datagrama enviado por el cliente
				socketUDP.receive(paqueteRecibido2);//Recibimos el segundo datagrama
				String mensajeRecibido2 =recorte( new String(paqueteRecibido2.getData()));// convertimos el datagrama en cadena y eliminamos '#' con la funcion recorte()
				int b = Integer.parseInt(mensajeRecibido2);//convertimos la cadena en entero
				////////////////////////////////////////////////////////////////////////////////////
				
				
				if (a > b) {
					////////////////////////////ENVIAMOS LA RESPUESTA AL CLIENTE//////////////////////////
					byte mensajeEnviar[] = new byte[5]; //Creamos el byte donde guardaremos el mensaje
					String ans = "Respuesta del servidor: EL MAYOR ES "+a+"#"; // La cadena de respuesta del servidor.
					mensajeEnviar = ans.getBytes();//convertimos la cadena en bytes y lo guardamos en el vector de bytes
					DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeEnviar,mensajeEnviar.length,paqueteRecibido.getAddress(),paqueteRecibido.getPort());//Creamos el datagrama con nuestro mensaje
					socketUDP.send(paqueteAEnviar);//Enviamos el datagrama al cliente
					///////////////////////////////////////////////////////////////////////////////////////
				}else{
					if (b > a) {
						//////////////////////////ENVIAMOS LA RESPUESTA AL CLIENTE//////////////////////////
						byte mensajeEnviar[] = new byte[5];
						String ans = "Respuesta del servidor: EL MAYOR ES "+b+"#";
						mensajeEnviar = ans.getBytes();
						DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeEnviar,mensajeEnviar.length,paqueteRecibido.getAddress(),paqueteRecibido.getPort());
						socketUDP.send(paqueteAEnviar);
						////////////////////////////////////////////////////////////////////////////////////
					}else{
						//////////////////////////ENVIAMOS LA RESPUESTA AL CLIENTE//////////////////////////
						byte mensajeEnviar[] = new byte[5];
						String ans = "Respuesta del servidor: SON IGUALES#";
						mensajeEnviar = ans.getBytes();
						DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeEnviar,mensajeEnviar.length,paqueteRecibido.getAddress(),paqueteRecibido.getPort());
						socketUDP.send(paqueteAEnviar);
						/////////////////////////////////////////////////////////////////////////////////////
					}
				}
				
				/////////////IMPRIMOS EN CONSOLA DEL SERVIDOR////////////////////////
				System.out.println("Numeros introducidos por el cliente: "+a+" "+b);
			}
		}catch(Exception e){ 	
			e.printStackTrace();
		}
	}
	public void Ssaludo(){
		try {
			socketUDP = new DatagramSocket(puerto);
			System.out.println(" ----- SERVIDOR UDP INICIADO -----");
			System.out.println("---- Esperando Solicitudes ----");
			while(true){
				
				/////////////////////RECIBIMOS EL 1er DATAGRAMA DEL CLIENTE////////////////////////
				DatagramPacket paqueteRecibido = new DatagramPacket(new byte[1024],1024);
				socketUDP.receive(paqueteRecibido);
				String mensajeRecibido =recorte( new String(paqueteRecibido.getData()));
				///////////////////////////////////////////////////////////////////
				
				/////////////////////RECIBIMOS EL 1er DATAGRAMA DEL CLIENTE////////////////////////
				DatagramPacket paqueteRecibido2 = new DatagramPacket(new byte[1024],1024);
				socketUDP.receive(paqueteRecibido2);
				String mensajeRecibido2 =recorte( new String(paqueteRecibido2.getData()));
				///////////////////////////////////////////////////////////////////
				
				////////////////////////////ENVIAMOS EL DATAGRAMA DE RESPUESTA AL CLIENTE//////////////////////////
				byte mensajeEnviar[] = new byte[5];
				String respuestaaCliente = "Respuesta del servidor: HOLA "+mensajeRecibido.toUpperCase()+" "+mensajeRecibido2.toUpperCase()+"#";
				mensajeEnviar = respuestaaCliente.getBytes();
				DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeEnviar,mensajeEnviar.length,paqueteRecibido.getAddress(),paqueteRecibido.getPort());
				socketUDP.send(paqueteAEnviar);
				///////////////////////////////////////////////////////////////////////////////////////////////////
				
				////////////////////////////IMPRIMIMOS EN LA CONSOLA DEL SERVIDOR////////////////////////////////////
				System.out.println("Cliente conectado: "+mensajeRecibido+" "+mensajeRecibido2);
				
			}
		}catch(Exception e){ 	
			e.printStackTrace();
		}
	}
	public void finalizar(){
		try{
			socketUDP.close();
			System.out.println("Conexion Finalizada...!!!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String recorte(String s){
		String m="";
		char c[]=s.toCharArray();
		boolean sw=true;
		for(int i=0;i<s.length()&&sw;i++){
			if(c[i]!='#'){
				m=m+c[i];
			}else{
				sw=false;
			}
		}
		return m;
	}
}
