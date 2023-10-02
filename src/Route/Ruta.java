package Route;

import java.util.ArrayList;  
import java.util.List; 
import Trip.*;


public class Ruta {
    private int idRuta;
    private String nombre;
    private List<BusStop> busStops;
    private List<Viaje> viajes;

    // Constructor
    public Ruta() {
    	busStops = new ArrayList<>();
        viajes = new ArrayList<>();
      
    }
    public void setBusStop(List<BusStop> pParadas) {
    	this.busStops=pParadas;
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

    
}
