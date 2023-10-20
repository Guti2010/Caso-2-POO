package Main;
   
import Trip.*;      
import java.sql.Time;
import Config.*;
import Empresa.Flotilla;
import GUI.*;
import Route.*;
import java.util.List;
import Bus.Autobus;
import java.io.*;
import Simulation.*;
public class Main {
	
	public static void main(String[] args) {
		getJSON JSON = new getJSON();
    	RutaJSON Rutas = JSON.getRutas();
    	settingJSON Configuracion = JSON.getSettings();
    	Flotilla Flotilla = new Flotilla();
    	List <Autobus> Autobuses = null;
        
        Flotilla.agregarRutas(Rutas, Configuracion.getMinHoraServicio(),
        		Configuracion.getMaxHoraServicio(), Configuracion.getIntervalo());
        
        for(Ruta ruta:Flotilla.getRutas()) {
        	for (Time hora : ruta.getHorasInicio()) {
        		List<BusStop> paradas = ruta.getBusStops();
        		Flotilla.crearViaje(ruta,paradas,hora, Configuracion.getMinTiempoParadas(), Configuracion.getMaxTiempoParadas());
        	}   
        }
        
        // Cargar la Flotilla desde un archivo binario
        try (FileInputStream fileInputStream = new FileInputStream("Autobuses.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
        	Autobuses = (List<Autobus>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Flotilla.setAutobuses(Autobuses);
           	
        VentanaInicio ventanaInicio = new VentanaInicio(Configuracion, Autobuses);
        ventanaInicio.setVisible(true);
        ventanaInicio.setFlotilla(Flotilla);
            
        for(Ruta ruta:Flotilla.getRutas()) {
        	ruta.setViajeActual(ruta.getViajes().get(0));
        	for (Viaje viaje:ruta.getViajes()) {
                ViajeSimulacion simulacionThread = new ViajeSimulacion(viaje,Flotilla,JSON);
                simulacionThread.start();		
        	}
        } 
	}
}
