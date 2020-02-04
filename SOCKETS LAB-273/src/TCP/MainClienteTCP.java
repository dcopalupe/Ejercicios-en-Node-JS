package TCP;

public class MainClienteTCP{
	public static void main(String[] args) {
		ClienteTCP C = new ClienteTCP("localhost",9999);
		
		//Envia 2 numeros, el servidor responde con el mayor de esos 2 numeros
		C.Cmayor();
	}
}
