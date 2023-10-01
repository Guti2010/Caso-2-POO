package Route;

import java.util.List;
import Trip.*;
import Horario.Horario;

public class Ruta {
    private int idRuta;
    private String nombre;
    private List<BusStop> busStops;
    private List<Viaje> viajes;

    // Constructor
    public Ruta() {
      
    }
    public void crearBusStop(BusStop pParada) {
    	busStops.add(pParada);
    }
    
    public void setIDruta(int pID) {
    	this.idRuta = pID;
    }
    
    public void setNombre(String pNameRuta) {
    	this.nombre = pNameRuta;
    }

    // Método para establecer el horario de los autobuses en la ruta
    public void setBusHorario(Horario horario) {
        // Implementa la lógica para establecer el horario de los autobuses en la ruta.
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

    // Otros métodos y getters y setters según sea necesario
}
