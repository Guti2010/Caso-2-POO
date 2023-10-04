package Empresa;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.util.List;

import Bus.*;
import Trip.*;
import Route.*;

public class Flotilla {
    private List<Autobus> autobuses;
    private List<Ruta> rutas;
    private List<BusStop> busStops;
    

    // Constructor
    public Flotilla() {
        autobuses = new ArrayList<>();
        rutas = new ArrayList<>();
        busStops = new ArrayList<>();
        
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

    // Método para crear un nuevo viaje
    public void crearViaje(Ruta ruta, Autobus autobus, Time horaInicio,int tiempoMin, int tiempoMax) {
        Viaje viaje = new Viaje();
        viaje.setAutobus(autobus);
        viaje.getAutobus().setUltimoViaje(viaje);
        viaje.setCantPasajeros(0);
        viaje.setRuta(ruta);
        viaje.setEstadoBus(true);
        viaje.setHorario(horaInicio, tiempoMin, tiempoMax);
        ruta.agregarViajes(viaje);
        
    }
    
    // Método para crear BusStops 
    public void crearBusStops(String pUbicacion) {
    	BusStop busStop = new BusStop();
    	busStop.setUbicacion(pUbicacion);
        busStops.add(busStop);
        
    }
    
    // Método para agregar una nueva ruta a la flotilla
    public void agregarRuta(int idRuta, String nombre) {
        Ruta ruta = new Ruta();
        ruta.setNombre(nombre);
        ruta.setIDruta(idRuta);
        ruta.setBusStop(busStops);
        busStops.clear();// limpiar lista para la siguiente ruta
        rutas.add(ruta);
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
    public void dañarAutobus(Viaje viaje, BusReport busReport) {
        viaje.averiarBus(busReport);
        
    }

    // Método para actualizar la ubicación de un autobús en un viaje
    public void actualizarUbicacionAutobus(Viaje viaje, BusStop pParadaActual) {
        viaje.modificarUbicacionBus(pParadaActual);
        
    }

    
    
}
