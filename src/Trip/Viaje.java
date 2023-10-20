package Trip;

import java.util.ArrayList;     
import java.util.List;
import java.io.Serializable;
import java.sql.Time;  
import Bus.*;
import Route.*;
import Tiempo.Horario;

public class Viaje implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ruta ruta;
    private Autobus autobus;
    private Time horaInicio;
    private int cantPasajeros;
    private BusReport busReport;
    private BusStop ubicacionBus;
    private List<BusStop> busStops;
    private boolean EstadoBus;
    private Horario Horario;

    // Constructor
    public Viaje() { 
    	busStops = new ArrayList<>();
    	Horario = new Horario();
    }
    
 // Métodos para establecer atributos
    public void setEstadoBus(boolean Estado) {
        this.EstadoBus = Estado;
    }
    
    // Métodos para establecer atributos
    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
         
    }
    
    public void setBusStops(List<BusStop> pBusStops) {
    	for(BusStop parada: pBusStops) {
    		BusStop parada2 = new BusStop();
    		parada2.setUbicacion(parada.getUbicacion());
    		this.busStops.add(parada2);
    	}
    
    }
    
    

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public void setHorario(Time pHoraInicio, int pTiempoMin, int pTiempoMax) {
        this.horaInicio = pHoraInicio;
        Horario.establecerHorario(busStops, pHoraInicio, pTiempoMin, pTiempoMax);
        
        
    }
    
    public void setHorarioConPresa(int pTiempoMin, int pTiempoMax) {
        Horario.cambiarHora(busStops, pTiempoMin, pTiempoMax, ubicacionBus);
        
        busStops = Horario.getHorario();
        
    }
    public void setHorarioConAveria(int pTiempoMin, int pTiempoMax) {
        Horario.cambiarHora(busStops, pTiempoMin, pTiempoMax, ubicacionBus);
        
        busStops = Horario.getHorario();
        
    }
    
    public void setCantPasajeros(int pasajeros) {
    	this.cantPasajeros=pasajeros;
    }


    public void averiarBus(BusReport pBusReport) {
    	EstadoBus = false; //Bus dañado
        this.busReport = pBusReport;
        autobus.agregarBusReport(pBusReport);
        autobus.setDisponibilidad(EstadoBus);
    }

    public void repararBus(boolean estado) {
    	EstadoBus = true; //Bus reparado
    	autobus.setDisponibilidad(EstadoBus);
    	//Cambiar el estado del ultimo BusReport a true que sería que ya fue reparado
    	autobus.getBusReports().get(-1).setEstado(estado);
    	
    
    }

    public void setUbicacionBus(BusStop ubicacionBus) {
        this.ubicacionBus = ubicacionBus;
    }
    

    public void aumentarPasajeros(int cantPersonas) {
    	if (autobus.getCapacidadMaxima()>cantPasajeros) {
    		this.cantPasajeros += cantPersonas;
    	}
    	
    }

    // Métodos para obtener atributos
    public Ruta getRuta() {
        return ruta;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public BusReport getBusReport() {
        return busReport;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }
    
    public BusStop getUbicacionBus() {
    	return ubicacionBus;
    }
    
    public boolean getEstadoBus() {
    	return EstadoBus;
    }
}
