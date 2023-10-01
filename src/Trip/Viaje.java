package Trip;

import java.util.Date; 
import Autobus.*;
import Route.*;

public class Viaje {
    private Ruta ruta;
    private String autobus;
    private Date horaInicio;
    private int cantPasajeros;
    private BusReport busReport;
    private BusStop ubicacionBus;

    // Constructor
    public Viaje() {
        // Constructor vacío
    }

    // Métodos para establecer atributos
    public void establecerRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void establecerAutobus(String autobus) {
        this.autobus = autobus;
    }

    public void establecerHorario(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void modificarHorarioSegunPresa(int cantPresa) {
        // Implementa la lógica para ajustar el horario según la presa de tráfico.
    }

    public void modificarHorarioSegunDaño(String daño) {
        // Implementa la lógica para ajustar el horario según el daño.
    }

    public void averiarBus(BusReport busReport) {
        this.busReport = busReport;
    }

    public void repararBus(boolean estado) {
        // Implementa la lógica para reparar o desaveriar el autobús.
    }

    public void modificarUbicacionBus(BusStop ubicacionBus) {
        this.ubicacionBus = ubicacionBus;
    }

    public void aumentarPasajeros(int cantPersonas) {
        this.cantPasajeros += cantPersonas;
    }

    // Métodos para obtener atributos
    public Ruta getRuta() {
        return ruta;
    }

    public String getAutobus() {
        return autobus;
    }

    public BusReport getBusReport() {
        return busReport;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public BusStop getUbicacionBus() {
        return ubicacionBus;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }
}
