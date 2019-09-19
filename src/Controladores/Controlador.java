package Controladores;

public class Controlador {

	protected static void Excepcion(Boolean comparar, Exception ex) throws Exception {
		if (! comparar) throw ex;
	}
}
