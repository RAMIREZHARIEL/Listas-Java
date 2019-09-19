package Controladores;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
	
	private static int cont=0;
	private  int ID;
	private int CantidadPersonas;
	private String TipoHabitacion;
	private List<Boolean> Adicionales = new ArrayList<>();

	private String mostrar= "";
	
	
	public void AgregarAdicional(Boolean servicio)
	{
		Adicionales.add(servicio);
	}
	
	
	
	public List<Boolean> getAdicionales() {
		return Adicionales;
	}




	public void setAdicionales(List<Boolean> adicionales) {
		Adicionales = adicionales;
	}
	
	public Reserva() {}




	public Reserva(int Cant, String tipo)
	{
		cont++;
		this.ID=cont;
		mostrar="";
		this.setCantidadPersonas(Cant);
		this.setTipoHabitacion(tipo);

	}
	
	
	
	
	public  int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCantidadPersonas() {
		return CantidadPersonas;
	}
	public void setCantidadPersonas(int cantidadPersonas) {
		CantidadPersonas = cantidadPersonas;
	}
	public String getTipoHabitacion() {
		return TipoHabitacion;
	}
	public void setTipoHabitacion(String tipoHabitacion) {
		TipoHabitacion = tipoHabitacion;
	}

	
	public String wifi() {
		if(this.Adicionales.get(0)) {
			mostrar = "Wifi,";}
		else mostrar="";
		return mostrar;
		}
	
public String gym() {
	if(this.Adicionales.get(1)) {
		mostrar = "Gimnacio,";}
	else mostrar="";
	return mostrar;
	}

public String desayuno() {
	if(this.Adicionales.get(2)) {
		mostrar = "Desayuno,";}
	else mostrar="";
	return mostrar;
	}

public String sala() {
	if(this.Adicionales.get(3)) {
		mostrar = "sala,";}
	else mostrar="";
	return mostrar;
	}

	
	
		
	

	@Override
	public String toString() {
		return "ID=" + ID + ", CantidadPersonas=" + CantidadPersonas + ", TipoHabitacion=" + TipoHabitacion
				+", "+ wifi() + gym() + desayuno() + sala();
	}




}
