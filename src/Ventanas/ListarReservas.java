package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controladores.ControladorReserva;
import Controladores.Reserva;
import Interfaces.Cabecera;

@SuppressWarnings("serial")
public class ListarReservas extends JFrame implements Cabecera{
	
	private JTextField txtCantPersonas;
	private JComboBox<String> cmbTipo = new JComboBox<String>();
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblId ;
	private JLabel lblListadoDeHabitaciones;
	private JLabel lblCantpersonas;
	private JLabel lblTipoHabitacion;
	private JCheckBox chckbxWifi ;
	private JCheckBox chckbxGimnacio;
	private JCheckBox chckbxSalaJuego;
	private JCheckBox chckbxDesayuno;
	public static JList <Reserva> listaReservas;
	public static  DefaultListModel<Reserva> dlModel;

	
	
	public ListarReservas()
	{
		Cabecera.Head();
		setBounds(500, 500, 533, 900);
		

		setSize(672, 480);
		getContentPane().setLayout(null);
		

			listaReservas = new JList();
			listaReservas.setBounds(39, 76, 594, 216);
			dlModel = new DefaultListModel<Reserva>();
			listaReservas.setModel(dlModel);
			getContentPane().add(listaReservas);
			listaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		

		DibujarComponentes();

	}
	
	
	
	
	private ListSelectionListener onElementSelected() {
		return new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				Reserva res =  listaReservas.getSelectedValue();
						
				
				
				
				if(listaReservas.getSelectedIndex()!=-1)
				{
					lblId.setText(Integer.toString(res.getID()));
					txtCantPersonas.setText(Integer.toString(res.getCantidadPersonas()));
					cmbTipo.setSelectedItem(res.getTipoHabitacion());
					chckbxWifi.setSelected(res.getAdicionales().get(0));
					chckbxDesayuno.setSelected(res.getAdicionales().get(1));
					chckbxGimnacio.setSelected(res.getAdicionales().get(2));
					chckbxSalaJuego.setSelected(res.getAdicionales().get(3));
				}
				
				
				

			}
		};
	}
	
	

	


	private void DibujarComponentes() {
		// TODO Auto-generated method stub
		
		 lblListadoDeHabitaciones = new JLabel("Listado de habitaciones reservadas");
		lblListadoDeHabitaciones.setBounds(39, 51, 278, 14);
		getContentPane().add(lblListadoDeHabitaciones);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(39, 304, 29, 14);
		getContentPane().add(lblID);
		


		listaReservas.addListSelectionListener(this.onElementSelected());	
		
		lblId = new JLabel("0");
		lblId.setBounds(39, 330, 29, 14);
		getContentPane().add(lblId);
		
		lblCantpersonas = new JLabel("Cant.Personas");
		lblCantpersonas.setBounds(94, 303, 104, 14);
		getContentPane().add(lblCantpersonas);
		
		 lblTipoHabitacion = new JLabel("Tipo Habitacion");
		lblTipoHabitacion.setBounds(218, 303, 86, 14);
		getContentPane().add(lblTipoHabitacion);
		
		txtCantPersonas = new JTextField();
		txtCantPersonas.setBounds(94, 328, 86, 20);
		getContentPane().add(txtCantPersonas);
		txtCantPersonas.setColumns(10);
		
		cmbTipo.setBounds(218, 328, 99, 20);
		cmbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Triple", "Doble", "Cuadruple", "Suite "}));
		cmbTipo.setSelectedIndex(0);
		getContentPane().add(cmbTipo);
		
		 btnModificar = new JButton("Modificar");
		 btnModificar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ControladorReserva.Validar(txtCantPersonas, "[1-5]+");
		 		
		 		
		 		if(!ControladorReserva.isError())
		 		{
		 			ControladorReserva.editarReserva(
		 					listaReservas.getSelectedValue(),
		 					Integer.parseInt(txtCantPersonas.getText().trim()),
		 					cmbTipo.getSelectedItem().toString(), 
		 					chckbxWifi.isSelected(),
		 					chckbxDesayuno.isSelected(),
		 					chckbxGimnacio.isSelected(), 
		 					chckbxSalaJuego.isSelected());
		 		}
		 		
		 		listaReservas.repaint();
		 	}
		 });
		btnModificar.setBounds(354, 327, 128, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlModel.remove(listaReservas.getSelectedIndex());				
			}
		});
		btnEliminar.setBounds(505, 326, 128, 23);
		getContentPane().add(btnEliminar);
		
		chckbxWifi = new JCheckBox("Wifi");
		chckbxWifi.setBounds(34, 387, 97, 23);
		getContentPane().add(chckbxWifi);
		
		 chckbxDesayuno = new JCheckBox("Desayuno");
		chckbxDesayuno.setBounds(169, 387, 97, 23);
		getContentPane().add(chckbxDesayuno);
		
		chckbxGimnacio = new JCheckBox("Gimnacio");
		chckbxGimnacio.setBounds(340, 387, 97, 23);
		getContentPane().add(chckbxGimnacio);
		
		chckbxSalaJuego = new JCheckBox("Sala de juegos");
		chckbxSalaJuego.setBounds(503, 387, 130, 23);
		getContentPane().add(chckbxSalaJuego);
		
		
		
		setVisible(true);
	}


}
