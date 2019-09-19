package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controladores.ControladorReserva;
import Interfaces.Cabecera;

@SuppressWarnings("serial")
public class AgregarReserva extends JFrame implements Cabecera{
	
	private JLabel lblCantidad;
	private JLabel lblTipo;
	private JLabel lblServiciosAdicionales;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JComboBox <String> cmbTipo = new JComboBox<String>();
	private JCheckBox chckbxWifi;
	private JCheckBox chckbxDesayuno;
	private JCheckBox chckbxGimnacio;
	private JCheckBox chckbxSalaDeJuegos;
	
	



	public AgregarReserva() {
		setBounds(500, 500, 533, 486);

		setSize(608, 241);		
		getContentPane().setLayout(null);
		
		Cabecera.Head();
		DibujarComponentes();
		
			
		
	}

	private void DibujarComponentes() {
		// TODO Auto-generated method stub
		 lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(38, 39, 106, 14);
			getContentPane().add(lblCantidad);
			
			 lblTipo = new JLabel("Tipo de Habitacion");
			lblTipo.setBounds(38, 85, 106, 14);
			getContentPane().add(lblTipo);
			
			 lblServiciosAdicionales = new JLabel("Servicios Adicionales");
			lblServiciosAdicionales.setBounds(38, 138, 123, 14);
			getContentPane().add(lblServiciosAdicionales);
			
			txtCantidad = new JTextField();
			txtCantidad.setBounds(222, 36, 355, 20);
			getContentPane().add(txtCantidad);
			txtCantidad.setColumns(10);
			
			cmbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Triple", "Doble", "Cuadruple", "Suite"}));
			cmbTipo.setBounds(222, 82, 355, 20);
			getContentPane().add(cmbTipo);
			
			 chckbxWifi = new JCheckBox("Wi-Fi");
			chckbxWifi.setBounds(206, 134, 67, 23);
			getContentPane().add(chckbxWifi);
			
			 chckbxDesayuno = new JCheckBox("Desayuno");
			chckbxDesayuno.setBounds(275, 134, 91, 23);
			getContentPane().add(chckbxDesayuno);
			
			 chckbxGimnacio = new JCheckBox("Gimnacio");
			chckbxGimnacio.setBounds(384, 134, 80, 23);
			getContentPane().add(chckbxGimnacio);
			
			chckbxSalaDeJuegos = new JCheckBox("Sala de juegos");
			chckbxSalaDeJuegos.setBounds(466, 134, 120, 23);
			getContentPane().add(chckbxSalaDeJuegos);
			
			 btnAceptar = new JButton("Aceptar");
			 btnAceptar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		ControladorReserva.Validar(txtCantidad, "[1-5]+");
			 		
			 		
			 		if(!ControladorReserva.isError())
			 		{
			 			ControladorReserva.guardarReserva(
			 					Integer.parseInt(txtCantidad.getText().trim()),
			 					cmbTipo.getSelectedItem().toString(), 
			 					chckbxWifi.isSelected(),
			 					chckbxDesayuno.isSelected(),
			 					chckbxGimnacio.isSelected(), 
			 					chckbxSalaDeJuegos.isSelected());
			 		}
			 		
			 		
			 				 		
			 		
			 	
			 	}
			 });
			btnAceptar.setBounds(277, 168, 89, 23);
			getContentPane().add(btnAceptar);

			setVisible(true);
		
	}

}
