package UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClienteUDP {
	int puerto;
	InetAddress servidorDestino;
	DatagramSocket socketUDP;
	DatagramPacket paqueteRecibido;
	DatagramPacket paqueteAEnviar;
	private Scanner sc;
	
	public ClienteUDP(String h,int p) throws UnknownHostException {
		servidorDestino = InetAddress.getByName(h);
		puerto = p;
	}
	
	public void CSaludo(){
		try {
			sc = new Scanner(System.in);
			socketUDP = new DatagramSocket();//creamos el socket UDP 
			
			System.out.println("*********CONEXION INICIADA************");

			////////////////////////ENVIAMOS EL PRIMER DATAGRAMA///////////////////////////////////////////
			System.out.print("Ingresa tu nombre: ");
			String a = sc.nextLine()+"#"; //Cualquier cadena que mandemos al servidor debe tener '#' al final 
			
			byte mensajeE[] = new byte[1024];// Creamos el vector de bytes donde guardaremos nuestro mensaje
			mensajeE = a.getBytes();//Convertimos la cadena en byte  
			DatagramPacket numero1 = new DatagramPacket(mensajeE,mensajeE.length,servidorDestino,puerto);//Creamos el datagrama con nuestro mensaje y datos del servidor
			socketUDP.send(numero1);//enviamos el datagrama
			//////////////////////////////////////////////////////////////////////////////////////////////
			
			
			//////////////////////////ENVIAMOS EL SEGUNDO DATAGRAMA/////////////////////////////////////////
			System.out.print("Ingresa tu apellido :");
			String b = sc.nextLine()+"#";
			
			byte mensajeE2[] = new byte[1024]; //Creamos el vector de byte para el segundo mensaje a enviar
			mensajeE2 = b.getBytes();//Convertimos la cadena en bytes
			DatagramPacket numero2 = new DatagramPacket(mensajeE2,mensajeE2.length,servidorDestino,puerto);//Creamos el datagrama con nuestro mensaje y datos del servidor 
			socketUDP.send(numero2);//Enviamos el segundo mensaje al servidor
			///////////////////////////////////////////////////////////////////////////////////////////////
			
			
			////////////////////////RECIBIMOS EL DATAGRAMA ENVIADO POR EL SERVIDOR/////////////////////////
			byte mensajeR[] = new byte[1024];//Creamos el vector de bytes donde recibiremos la respuesta del servidor
			paqueteRecibido = new DatagramPacket(mensajeR,mensajeR.length);//Creamos el datagrama
			socketUDP.receive(paqueteRecibido);//Recibimos el datagrama del servidor
			
			String mensajeRecibido = new String(paqueteRecibido.getData());//Convertimos el datagrama en cadena    
			//////////////////////////////////////////////////////////////////////////

			//////////////////////////IMPRIMIMOS EL MENSAJE DEL SERVIDOR///////////////////////////////////
			System.out.println(recorte(mensajeRecibido));//La cadena que recibimos de parte del servidor tiene un '#' al final asi que lo recortamos con el metodo 'recorte()'
			///////////////////////////////////////////////////////////////////////////////////////////////
			
			finalizar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Cmayor(){
		try {
			sc = new Scanner(System.in);
			socketUDP = new DatagramSocket();
			
			System.out.println("*********CONEXION INICIADA************");
			
			/////////////////////////ENVIAMOS EL PRIMER DATAGRAMA///////////////////////////
			System.out.print("NUMERO 1: ");
			String a = sc.nextLine()+"#";

			byte mensajeE[] = new byte[1024];
			mensajeE = a.getBytes();
			DatagramPacket numero1 = new DatagramPacket(mensajeE,mensajeE.length,servidorDestino,puerto);
			socketUDP.send(numero1);
			/////////////////////////////////////////////////////////////////////////////////

			/////////////////////////ENVIAMOS EL SEGUNDO DATAGRAMA//////////////////////////
			System.out.print("NUMERO 2: ");
			String b = sc.nextLine()+"#";
			
			byte mensajeE2[] = new byte[1024];
			mensajeE2 = b.getBytes();
			DatagramPacket numero2 = new DatagramPacket(mensajeE2,mensajeE2.length,servidorDestino,puerto);
			socketUDP.send(numero2);
			/////////////////////////////////////////////////////////////////////////////////
			
			///////////////////////RECIBIMOS EL DATAGRAMA DEL SERVIDOR///////////////////////////////
			byte mensajeR[] = new byte[1024];
			paqueteRecibido = new DatagramPacket(mensajeR,mensajeR.length);
			socketUDP.receive(paqueteRecibido);
			String mensajeRecibido = new String(paqueteRecibido.getData());
			//////////////////////////////////////////////////////////////////////////////////////////
			
			//////////////////////IMPRIMIMOS EL MENSAJE DEL SERVIDOR//////////////////////////////////
			System.out.println(recorte(mensajeRecibido));
			
			finalizar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void finalizar(){
		try {
			socketUDP.close();
			System.out.println("Conexion Finalizada...!!!");
		} catch (Exception e) {
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
