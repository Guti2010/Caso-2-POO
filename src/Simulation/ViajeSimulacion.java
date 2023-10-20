package Simulation;
import java.time.temporal.ChronoUnit; 
import java.util.List;
import Trip.*;
import Route.*;
import java.time.LocalTime;
import Empresa.*;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.json.JsonArray;

import Config.*;
public class ViajeSimulacion extends Thread {

    private Viaje viaje;
    private Flotilla flotilla;
    private settingJSON configuracion;
    private AveriaJSON averias;
    private TiempoJSON tiempos;
    private int cantAverias;
    private int paradaParaPresa;
    private int  cantViajes;
    private int indexViajeActual;

    public ViajeSimulacion(Viaje pViaje, Flotilla pFlotilla,getJSON pDatos) {
        this.viaje = pViaje;
        this.flotilla = pFlotilla;
        this.configuracion = pDatos.getSettings();
        this.averias = pDatos.getAverias();
        this.tiempos = pDatos.getTiempos();
        cantAverias=0;
        Random random = new Random();
        paradaParaPresa = random.nextInt(viaje.getBusStops().size()-1);
        cantViajes = viaje.getRuta().getViajes().size()-1;
        indexViajeActual = viaje.getRuta().getViajes().indexOf(viaje);
        
    }

    @Override
    public void run() {
    	LocalTime horaActual = LocalTime.of(5, 0);; // Inicializar a la medianoche

        List<BusStop> busStops = viaje.getBusStops();
        int busStopIndex = 0; // Índice de la parada actual
        
        while (busStopIndex < busStops.size()) {
        	
            BusStop busStop = busStops.get(busStopIndex);
            LocalTime horaParada = LocalTime.parse(busStop.getHoraAproximada().toString());
            
            if (horaActual.isAfter(horaParada) || horaActual.equals(horaParada)) {
            	if (busStopIndex==0) {
            		flotilla.seleccionarBus(viaje);
            		System.out.println(viaje.getAutobus().getPlaca());
            	}
            	if (busStopIndex==busStops.size()-1 && viaje != viaje.getRuta().getViajes().get(cantViajes)) {
            		Viaje sigViaje = viaje.getRuta().getViajes().get(indexViajeActual+1);
            		viaje.getRuta().setViajeActual(sigViaje);
            	}
            	
            	viaje.setUbicacionBus(busStop);
                // Crear una instancia de la clase Random
                   Random rand = new Random();

                // Generar un número aleatorio positivo entre min (inclusive) y max (inclusive)
                int numeroAleatorio = rand.nextInt((configuracion.getMaxPersonas() - 
                configuracion.getMinPersonas()) + 1) + configuracion.getMinPersonas();
                viaje.aumentarPasajeros(numeroAleatorio);
                System.out.println("Ubicacion Bus: " + viaje.getUbicacionBus().getUbicacion() + ", Hora: "
                   		+ viaje.getUbicacionBus().getHoraAproximada()+ ", Ruta: " + viaje.getRuta().getName() 
                   		+ ", Pasajeros: " + viaje.getCantPasajeros());
            	
                BusReport busReport = generarBusReportAleatorio(horaActual);
            	
            	if (busStopIndex==paradaParaPresa) {
            		int cantPresa = configuracion.getCantPresa();
            		int min = tiempos.getTiempoPresa().get(cantPresa).getInt(0);
            		int max = tiempos.getTiempoPresa().get(cantPresa).getInt(1);
            		flotilla.atrasarAutobus(viaje, min, max);
            	}
            	
            	
            	if (busReport!=null & cantAverias==1) {
            		 
            		if (busReport.getTipoAveria()==Gravedad.LEVE) {
            			int min = tiempos.getTiempoAverias().get(0).getInt(0);
                		int max = tiempos.getTiempoAverias().get(0).getInt(1);
            			flotilla.dañarAutobus(viaje, busReport, 
            					min, max);
            		}
            		if (busReport.getTipoAveria()==Gravedad.GRAVE) {
            			int min = tiempos.getTiempoAverias().get(1).getInt(0);
                		int max = tiempos.getTiempoAverias().get(1).getInt(1);
            			flotilla.dañarAutobus(viaje, busReport, 
            					min, max);
            		}
            		
            		
            	}
            	
                

                busStopIndex++;
            }

            
            horaActual = horaActual.plus(300, ChronoUnit.SECONDS); // Incrementar en 1 segundo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public BusReport generarBusReportAleatorio(LocalTime hora) {
        BusReport busReport = new BusReport();
        
        Random random = new Random();
        
     // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Crear un objeto LocalDateTime con la fecha actual y la hora proporcionada
        LocalDateTime fechaHoraAleatoria = fechaActual.atTime(hora);
        // Establece el tipo de avería aleatoriamente (leve o grave)
        
        Gravedad tipoAveria = null;
        
        // Generar un número aleatorio entre 0 y 100
        int probabilidad = random.nextInt(101);
        String descripcion = "";
        // Si la probabilidad está en el rango del 0 al 36 (37%), se crea un BusReport
        if (probabilidad <= configuracion.getAveriaLeve()) {
        	tipoAveria = Gravedad.LEVE;
        	JsonArray descripcionesLeves = averias.getLeves();
            descripcion = descripcionesLeves.getString(new Random().nextInt(descripcionesLeves.size()));
            boolean reparado = false;
            
            // Asigna los valores generados al objeto BusReport
            busReport.setFecha(fechaHoraAleatoria);
            busReport.setTipoDaño(tipoAveria);
            busReport.setDaño(descripcion);
            busReport.setEstado(reparado);
            cantAverias++;
            return busReport;
        }
        if (probabilidad <= configuracion.getAveriaGrave()) {
        	JsonArray descripcionesGraves = averias.getGraves();
            descripcion = descripcionesGraves.getString(new Random().nextInt(descripcionesGraves.size()));
            boolean reparado = false;
            
            // Asigna los valores generados al objeto BusReport
            busReport.setFecha(fechaHoraAleatoria);
            busReport.setTipoDaño(tipoAveria);
            busReport.setDaño(descripcion);
            busReport.setEstado(reparado);
            cantAverias++;
            return busReport;
        }
        
    
        return null;
        
    }






}