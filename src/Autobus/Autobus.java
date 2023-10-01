package Autobus;

import Trip.*;

public class Autobus {
	private String placa;
    private String nombreConductor;
    private int capacidadMaxima;
    private Viaje ultimoViaje;

    // Constructor
    public Autobus() {
       
    }

    // Método para definir la placa del  vehículo
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método para definir el conductor del vehículo
    public void setConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    // Método para obtener la placa del vehículo
    public String getPlaca() {
        return placa;
    }

    // Método para obtener el nombre del conductor del vehículo
    public String getConductor() {
        return nombreConductor;
    }

    // Método para obtener el último viaje realizado por el vehículo
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

    // Método para registrar un nuevo viaje
    public void realizarViaje(Viaje viaje) {
        
        this.ultimoViaje = viaje;
    }
}
