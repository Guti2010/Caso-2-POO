package Main;
   
import Trip.*;
import java.sql.Time;

import Bus.*;
import Config.*;
import Empresa.Flotilla;

import Route.Ruta;

public class Main {
	public static void main(String[] args) {
		getJSON JSON = new getJSON();
    	RutaJSON Rutas = JSON.getRutas();
    	settingJSON Configuracion = JSON.getSettings();
        Flotilla Flotilla = new Flotilla();
        Flotilla.agregarBus("Placa1", "Juan Pérez", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa2", "Antonio Rodríguez", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa3", "Carlos López", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa4", "Luis García", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa5", "Andrés Martínez", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa6", "Alejandro Fernández", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa7", "Sergio González", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa8", "Manuel Díaz", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa9", "Pedro Sánchez", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa10", "José Ramírez", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa11", "Mario Torres", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa12", "Rafael Ruiz", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa13", "Miguel Vargas", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa14", "Daniel Castro", Configuracion.getCantPersonas());
        Flotilla.agregarBus("Placa15", "David Ortega", Configuracion.getCantPersonas());
        
        
        
        Flotilla.agregarRutas(Rutas, Configuracion.getMinHoraServicio(),
        		Configuracion.getMaxHoraServicio(), Configuracion.getIntervalo());
        
        
        
        for(Ruta ruta:Flotilla.getRutas()) {
        	System.out.println(ruta.getName());
        	System.out.println(ruta.getIDruta());
        	System.out.println(ruta.getHorasInicio());
        	for (Time hora : ruta.getHorasInicio()) {
        		Flotilla.crearViaje(ruta, hora, Configuracion.getMinTiempoParadas(), Configuracion.getMaxTiempoParadas());
        		
        	}
        	
        	for(Viaje viaje :ruta.getViajes()) {
        		Flotilla.asignarAutobus(viaje);
        		
        	}
        
        }
		
	}
	
		
		

	

}
