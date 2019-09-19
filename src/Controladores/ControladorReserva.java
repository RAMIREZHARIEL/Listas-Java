package Controladores;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import Ventanas.ListarReservas;

public class ControladorReserva extends Controlador {
	
	private static boolean error = false;


	


	public static boolean isError() {
		return error;
	}

	public static void setError(boolean error) {
		ControladorReserva.error = error;
	}
	
	public static void Validar(JTextField comparar, String regex)  {
		
		try {
			setError(false);
			comparar.setBackground(Color.white);
			Controlador.Excepcion(comparar.getText().trim().matches(regex), new Exception());

		} catch (Exception e) {
			// TODO: handle exception
			setError(true);
			comparar.setBackground(Color.red);			
		}
		
	}
	
	public static final void guardarReserva(int cantidad, String tipo, Boolean wifi, Boolean desayuno, Boolean gym, Boolean sala) {

		
		try {
			Reserva res = new Reserva(cantidad, tipo);
			res.AgregarAdicional(wifi);
			res.AgregarAdicional(gym);
			res.AgregarAdicional(desayuno);
			res.AgregarAdicional(sala);
			
			
			
			ListarReservas.dlModel.addElement(res);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}
	
	public static final void editarReserva(Reserva res, int cantidad, String tipo, Boolean wifi, Boolean desayuno, Boolean gym, Boolean sala) {
		res.setCantidadPersonas(cantidad);
		res.setTipoHabitacion(tipo);
		res.getAdicionales().set(0,wifi);
		res.getAdicionales().set(1,gym);
		res.getAdicionales().set(2,desayuno);
		res.getAdicionales().set(3,sala);
		
		
		
	}
	


}
