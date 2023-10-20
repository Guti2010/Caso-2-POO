package Empresa;

import java.util.ArrayList;          
import java.util.Iterator;
import java.sql.Time;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonValue;
import Config.*;
import Bus.*;
import Trip.*;
import Route.*;
import Tiempo.Horario;
import java.io.Serializable;
public class Flotilla implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1442488656288151532L;
	private List<Autobus> autobuses;
    private List<Ruta> rutas;
    private Horario tiempos;
    

    // Constructor
    public Flotilla() {
        autobuses = new ArrayList<>();
        rutas = new ArrayList<>();    
    }
    
    public void setAutobuses(List<Autobus> pAutobuses) {
    	this.autobuses = pAutobuses;
    }
    
    public void setRutas(List<Ruta> pRutas) {
    	this.rutas = pRutas;
    }
    
 // Método para agregar un nuevo autobús a la flotilla
    public void agregarBus(String placa, String nombreChofer, int cantMax) {
        Autobus autobus = new Autobus();
        autobus.setPlaca(placa);
        autobus.setConductor(nombreChofer);
        autobus.setCapacidadMaxima(cantMax);
        autobus.setDisponibilidad(true);
        autobuses.add(autobus);
    }
    
    
    public void seleccionarBus(Viaje viaje) {
   
    	for (Autobus Bus : autobuses){
    		if (Bus.getUltimoViaje()==null) {
    			viaje.setAutobus(Bus);
    			Bus.setUltimoViaje(viaje);
    			return;
    		}
    		else {
    			long diferenciaMillis = viaje.getHoraInicio().getTime() - 
    					Bus.getUltimoViaje().getHoraInicio().getTime();
    			double diferenciaHoras = (double) diferenciaMillis / 3600000;
    	        // Convierte la diferencia a horas dividiendo entre 3600000 (milisegundos en una hora)
    	        
    	        
    			if (diferenciaHoras >= 3.0 & Bus.getDisponibilidad()==true & viaje.getRuta()!=
    					Bus.getUltimoViaje().getRuta()) {
    				viaje.setAutobus(Bus);
    				Bus.setUltimoViaje(viaje);
    				return;
    			}
    		}	
    	}
    }

    // Método para crear un nuevo viaje
    public void crearViaje(Ruta ruta,List<BusStop> paradas, Time horaInicio,int tiempoMin, int tiempoMax) {
    	
        Viaje viaje = new Viaje();
        viaje.setCantPasajeros(0);
        viaje.setRuta(ruta);
        viaje.setBusStops(paradas);
        viaje.setUbicacionBus(paradas.get(0));
        viaje.setEstadoBus(true);
        viaje.setHorario(horaInicio, tiempoMin, tiempoMax);
        ruta.agregarViajes(viaje);
        
    }
    
    
    
    // Método para crear BusStops 
    public void crearBusStops(String pUbicacion, List<BusStop> busStops) {
    	BusStop busStop = new BusStop();
    	busStop.setUbicacion(pUbicacion);
        busStops.add(busStop);
        
    }
    
    // Método para agregar una nueva ruta a la flotilla
    public void agregarRutas(RutaJSON Recorridos, int min, int Max, int intervalo) {
    	Iterator<String> keys = Recorridos.getRutas().keySet().iterator();
        // Itera a través de las claves y muestra cada elemento
    	int i = 1;
        while (keys.hasNext()) {
            String key = keys.next();
            JsonValue value = Recorridos.getRutas().get(key);
            Ruta ruta = new Ruta();
            tiempos = new Horario();
            tiempos.setHorasInicio(min, Max,intervalo);
            ruta.setHorasInicio(tiempos.getHorasServicio());
            ruta.setNombre(key.toString());
            ruta.setIDruta(i);
            JsonArray jsonArray = (JsonArray) value;
            // Itera a través de los elementos del arreglo
            List <BusStop >busStops = new ArrayList<>();
            for (JsonValue jsonValue : jsonArray) {
            	crearBusStops(jsonValue.toString(),busStops);
            }
            ruta.setBusStop(busStops);
            // limpiar lista para la siguiente ruta
            rutas.add(ruta);
            i++;
        }  
        
    }
     
    // Método para dañar un autobús y registrar un informe
    public void dañarAutobus(Viaje viaje, BusReport busReport,int min, int max) {
        viaje.averiarBus(busReport);
        viaje.setHorarioConAveria(min, max);
        
    }
    
 // Método para dañar un autobús y registrar un informe
    public void atrasarAutobus(Viaje viaje,int min, int max) {
    	viaje.setHorarioConPresa(min, max);
    }

    // Método para actualizar la ubicación de un autobús en un viaje
    public void actualizarUbicacionAutobus(Viaje viaje, BusStop pParadaActual) {
        viaje.setUbicacionBus(pParadaActual);
        
    }
    
    public List<Ruta> getRutas() {
    	return rutas;
    }
    
    public List<Autobus> getBuses() {
    	return autobuses;
    }

    
    
}
