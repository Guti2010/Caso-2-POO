package Route;

import java.util.ArrayList;    
import java.util.List; 
import Trip.*;

import java.io.Serializable;
import java.sql.Time; 

public class Ruta implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRuta;
    private String nombre;
    private Viaje viajeActual;
    private List<BusStop> busStops;
    private List<Viaje> viajes;
    private List<Time> horaServicio;

    // Constructor
    public Ruta() {
    	busStops = new ArrayList<>();
        viajes = new ArrayList<>();
      
    }
    public void setBusStop(List<BusStop> pParadas) {
    	this.busStops=pParadas;
    }
    
    public void setViajeActual(Viaje pViaje) {
    	this.viajeActual = pViaje;
    }
    
    public Viaje getViajeActual() {
    	return viajeActual;
    }
    
    public void agregarViajes(Viaje pViaje) {
    	viajes.add(pViaje);
    }
    public void setIDruta(int pID) {
    	this.idRuta = pID;
    }
    
    public void setNombre(String pNameRuta) {
    	this.nombre = pNameRuta;
    }
    
    public void setHorasInicio(List<Time> pHoras) {
    	this.horaServicio = pHoras;
    }

    public int getIDruta() {
    	return idRuta;
    }
    public String getName() {
    	return nombre;
    }

    // Método para obtener la lista de paradas de autobús en la ruta
    public List<BusStop> getBusStops() {
        return busStops;
    }

    // Método para obtener la lista de viajes en la ruta
    public List<Viaje> getViajes() {
        return viajes;
    }
    
    public List<Time> getHorasInicio() {
    	return horaServicio;
    }
    
    public int getID() {
    	return idRuta;
    } 

    
}
