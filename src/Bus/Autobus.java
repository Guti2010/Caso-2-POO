package Bus;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Comparator;

import Trip.*;
 
import java.util.List; 
 
public class Autobus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placa;
    private String nombreConductor;
    private int capacidadMaxima;
    private Viaje ultimoViaje;
    private List<BusReport> busReports;
    private boolean Disponibilidad;

    // Constructor
    public Autobus() {
    	busReports = new ArrayList<>();
    }

    // Método para definir la placa del autubús
    public void setPlaca(String pPlaca) {
        this.placa = pPlaca;
    }

    // Método para definir el conductor del autubús
    public void setConductor(String pNombreConductor) {
        this.nombreConductor = pNombreConductor;
    }
    
    public void setAverias(List<BusReport> pAverias) {
        this.busReports = pAverias;
    }
    
    
    // Método para definir el último viaje del autubus
    public void setUltimoViaje(Viaje pViaje) {
        this.ultimoViaje =pViaje;
    }
    
    // Método para agregar reportes de daños que ha tenido el autobús
    public void agregarBusReport(BusReport pAveria) {
    	busReports.add(pAveria);
    	busReports.sort(Comparator.comparing(BusReport::getFecha));
    }
    
    public void setDisponibilidad(boolean pDispo) {
    	this.Disponibilidad = pDispo;
    }

    // Método para obtener la placa del autubús
    public String getPlaca() {
        return placa;
    }

    // Método para obtener el nombre del conductor del autubús
    public String getConductor() {
        return nombreConductor;
    }

    // Método para obtener el último viaje realizado por el autubús
    public Viaje getUltimoViaje() {
        return ultimoViaje;
    }

    // Setter para la capacidad máxima del vehículo
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    // Getter para la capacidad máxima del vehículo
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public List<BusReport> getBusReports() {
        return busReports;
    }
        
    public boolean getDisponibilidad() {
    	return Disponibilidad;
   
    }

}
