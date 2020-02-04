package TCP;

public class MainServidorTCP {

	public static void main(String[] args) {
		ServidorTCP S = new ServidorTCP(9999);
		
		//Recibe 2 numeros de cualquier cliente conectado y responde con el mayor de esos 2 numeros
		S.Smayor();
	}

}

