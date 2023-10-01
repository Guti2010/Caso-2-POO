package Empresa;

import java.util.ArrayList; 
import java.util.List;
import java.util.Date;
import Autobus.*;
import Trip.*;
import Route.*;
import Horario.Horario;
public class Flotilla {
    private List<Autobus> autobuses;
    private List<Ruta> rutas;
    private List<Viaje> viajes;
    
    private List<BusStop> busStops;
    private List<Horario> horarios;

    // Constructor
    public Flotilla() {
        autobuses = new ArrayList<>();
        rutas = new ArrayList<>();
        viajes = new ArrayList<>();
        busStops = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    // Método para crear un nuevo viaje
    public void crearViaje(Ruta ruta, Autobus autobus, Horario horario) {
        Viaje viaje = new Viaje();
        viajes.add(viaje);
    }

    // Método para reparar un autobús
    public void repararBus(Viaje viaje) {
        Autobus autobus = viaje.getAutobus();
        autobus.repararBus(true);
    }

    // Método para agregar un nuevo autobús a la flotilla
    public void agregarBus(String placa, String nombreChofer, int cantMax) {
        Autobus autobus = new Autobus();
        autobus.setPlaca(placa);
        autobus.setConductor(nombreChofer);
        autobus.setCapacidadMaxima(cantMax);
        autobuses.add(autobus);
    }

    // Método para agregar una nueva ruta a la flotilla
    public void agregarRuta(String nombre, List<BusStop> busStops) {
        Ruta ruta = new Ruta();
        ruta.setNombre(nombre);
        for (BusStop parada: busStops) {
        	ruta.agregarBusStop(parada);
        }
        rutas.add(ruta);
    }

    // Método para dañar un autobús y registrar un informe
    public void dañarAutobus(Viaje viaje, BusReport busReport) {
        Autobus autobus = viaje.getAutobus();
        autobus.averiarBus(busReport);
    }

    // Método para actualizar la ubicación de un autobús en un viaje
    public void actualizarUbicacionAutobus(Viaje viaje, BusStop.getUbicacion()) {
        Autobus autobus = viaje.getAutobus();
        autobus.modificarUbicacionBus(ubicacion);
    }

    // Método para crear varios viajes para una ruta y una lista de horarios
    public void crearViajesParaRuta(Ruta ruta, List<Horario> horarios) {
        for (Horario horario : horarios) {
            crearViaje(ruta, autobuses.get(0), horario); // Aquí asumimos que usas el primer autobús en la lista.
        }
    }

    // Método para crear BusStops y Horarios
    public void crearBusStopsYHorario(String pUbicacion, Date hora) {
    	BusStop busStop = new BusStop();
    	busStop.setUbicacion(pUbicacion);
    	busStop.setHora(hora);
        busStops.add(busStop);
        
    }
}
