package TCP;

public class MainClienteIMAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteIMAP C = new ClienteIMAP("192.168.11.100",143);
		
		//Envia 2 numeros, el servidor responde con el mayor de esos 2 numeros
		//C.Cmayor();
		C.correo();
	}

}
