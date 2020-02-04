package UDP;

public class MainServidorUDP {

	public static void main(String[] args) {
		ServidorUDP S = new ServidorUDP(7777);
		
		//El servidor responde con un saludo
		//S.Ssaludo();
		
		//El servidor obtiene 2 numeros de algun cliente conectado y devuelve con el numero mayor de estos
		S.Smayor();
	}
}
