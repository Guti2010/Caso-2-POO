package Empresa;

import java.util.ArrayList; 
import java.util.Date;
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

public class Flotilla {
    private List<Autobus> autobuses;
    private List<Ruta> rutas;
    private List<BusStop> busStops;
    private Horario tiempos;
    

    // Constructor
    public Flotilla() {
        autobuses = new ArrayList<>();
        rutas = new ArrayList<>();
        
        
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
    
    public void seleccionarBus(List<Autobus> Autobuses, Viaje viaje) {
    	
    	for (Autobus Bus : Autobuses){
    		if (Bus.getUltimoViaje()==null) {
    			viaje.setAutobus(Bus);
    			
    			System.out.println(Bus.getPlaca()+" primer if");
    			break;
    		}
    		else {
	    		//Si el bus está disponible y su ultimo BusReport fue reparado, puede asignarse a otro viaje
	    		if(Bus.getDisponibilidad()==true 
	    				& Bus.getUltimoViaje().getRuta()!=viaje.getRuta()){
	    			viaje.setAutobus(Bus);
    				System.out.println(Bus.getPlaca());
    				break;
	    			
	    		}
	    		else {
	    			if (Bus.getUltimoViaje().getRuta()==viaje.getRuta()&
		    				(viaje.getRuta().getViajes().indexOf(viaje)-
		    				Bus.getUltimoViaje().getRuta().getViajes().indexOf(Bus.getUltimoViaje()))>=2) {
		    				viaje.setAutobus(Bus);
		    				System.out.println(Bus.getPlaca());
		    				break;
		    			}
	    		}
	    		if (Bus.getBusReports()==null) {
	    			viaje.setAutobus(Bus);
	    			System.out.println(Bus.getPlaca());
	    			break;
	    		}
	    		//else {
	    			//if (Bus.getBusReports().get(Bus.getBusReports.size()-1).getEstado()==true) {
	    			//	viaje.setAutobus(Bus);
	    		//		System.out.println(Bus.getPlaca());
	        	//		break;
	    		//	}
	    		//}
    		}	
    	}
    }

    // Método para crear un nuevo viaje
    public void crearViaje(Ruta ruta, Time horaInicio,int tiempoMin, int tiempoMax) {
    	
        Viaje viaje = new Viaje();
        viaje.setCantPasajeros(0);
        viaje.setRuta(ruta);
        viaje.setBusStops(ruta.getBusStops());
        viaje.setEstadoBus(true);
        viaje.setHorario(horaInicio, tiempoMin, tiempoMax);
        ruta.agregarViajes(viaje);
        ;
    }
    
    public void asignarAutobus(Viaje viaje) {
    	seleccionarBus(autobuses,viaje);
    	viaje.getAutobus().setUltimoViaje(viaje);
    	
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
            busStops = new ArrayList<>();
            for (JsonValue jsonValue : jsonArray) {
            	crearBusStops(jsonValue.toString(),busStops);
            }
            ruta.setBusStop(busStops);
            // limpiar lista para la siguiente ruta
            rutas.add(ruta);
            i++;
        }  
        
    }
     
    public void crearBusReport(Time pHora,Date pFecha,boolean pEstado,String descripcion,Gravedad pTipo) {
        BusReport averia = new BusReport();
        averia.setHoraYFecha(pHora, pFecha);
        averia.setEstado(pEstado);
        averia.setDaño(descripcion);
        averia.setTipoDaño(pTipo);
    }
    

    // Método para reparar un autobús
    public void repararBus(Viaje viaje) {
        viaje.repararBus(true);
        
    }


    // Método para dañar un autobús y registrar un informe
    public void dañarAutobus(Viaje viaje, BusReport busReport,int min, int max) {
        viaje.averiarBus(busReport);
        viaje.setHorarioConPresa(min, max);
    }
    
 // Método para dañar un autobús y registrar un informe
    public void atrasarAutobus(Viaje viaje,int min, int max) {
        viaje.setHorarioConAveria(min, max);
    }

    // Método para actualizar la ubicación de un autobús en un viaje
    public void actualizarUbicacionAutobus(Viaje viaje, BusStop pParadaActual) {
        viaje.modificarUbicacionBus(pParadaActual);
        
    }
    
    public List<Ruta> getRutas() {
    	return rutas;
    }
    
    public List<Autobus> getBuses() {
    	return autobuses;
    }

    
    
}
