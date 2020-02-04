package UDP;

import java.io.IOException;

public class MainClienteUDP {
	public static void main(String[] args) throws IOException {
		ClienteUDP C = new ClienteUDP("127.0.0.1",7777);
		
		//El cliente manda 2 cadenas, su nombre y apellido, el servidor responde con un saludo
		//C.CSaludo();
		
		//Inicia el cliente el cual recibe 2 numeros, el servidor responde con el numero mayor de esos 2 numeros
		C.Cmayor();
		
	}
}
