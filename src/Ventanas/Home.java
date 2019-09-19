package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Interfaces.Cabecera;

@SuppressWarnings("serial")
public class Home extends JFrame implements Cabecera{
	
	
	
	private JMenuBar menuBar;
	private JMenu mnHabitaciones ;
	private JMenuItem mnAgregarReserva;
	private JMenuItem mnListadoReservas;
	
	public Home() {
		Cabecera.Head();
		dibujarComponentes();
	}
	
public void dibujarComponentes() {
		
		setBounds(500, 500, 533, 486);

		setSize(608, 241);		
		getContentPane().setLayout(null);
		
		
			
		menuBar = new JMenuBar();
		menuBar.setToolTipText("Habitaciones");
		menuBar.setBounds(0, 3, 97, 21);
		getContentPane().add(menuBar);
		
		mnHabitaciones = new JMenu("Habitaciones");
		menuBar.add(mnHabitaciones);
		
		mnAgregarReserva = new JMenuItem("Agregar Reserva");
		mnAgregarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AgregarReserva();
			}
		});
		mnHabitaciones.add(mnAgregarReserva);
		
		mnListadoReservas = new JMenuItem("Listado Reservas");
		mnListadoReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarReservas();

			}
		});
		mnHabitaciones.add(mnListadoReservas);
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
	}



public static void main(String[] args) {
	new Home();
}
}
