package Tiempo;

import java.sql.Time;   
import Route.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Horario {
	private List<BusStop> Paradas;
	
	public static Time sumarMinutos(Time hora, int minutos) {
        long tiempoActual = hora.getTime();
        long tiempoNuevo = tiempoActual + (minutos * 60 * 1000); // 60 segundos * 1000 milisegundos

        return new Time(tiempoNuevo);
    }
	
	public void establecerHorario(List<BusStop> pBusStops, Time pHoraInicio, int pTiempoMin, int pTiempoMax){
		
		int numeroParadas = pBusStops.size();
        int tiempoTotalDisponible = 80; // Suponiendo que hay 1:30  entre la primera y la última parada
        int i = 0;
        pBusStops.get(0).setHora(pHoraInicio);
        for (BusStop x: pBusStops) {
        	if (i>0) {
	        	// Calcula el tiempo aleatorio basado en la proporción del tiempo total disponible
	            int tiempoAleatorio = (int) Math.round((double)i / numeroParadas * tiempoTotalDisponible);
	            tiempoAleatorio = ThreadLocalRandom.current().nextInt(pTiempoMin, pTiempoMax + 1);
	            tiempoTotalDisponible= tiempoTotalDisponible - tiempoAleatorio;
	            // Agrega el tiempo aleatorio a la hora de la parada anterior
	            pBusStops.get(i).setHora(sumarMinutos(pBusStops.get(i - 1).getHoraAproximada(), tiempoAleatorio));    
        	}
        	i++;
        }
        this.Paradas = pBusStops;
        
       
	}
	
	public void cambiarHora (List<BusStop> busStops, int pTiempoMin,int pTiempoMax, BusStop pParada){
		int i = 0;
    	int i2 = busStops.indexOf(pParada);
    	
        for (BusStop busStop: busStops) {
        	if (i>i2) {
        		int tiempoAleatorio = ThreadLocalRandom.current().nextInt(pTiempoMin, pTiempoMax + 1);
        		Time horaParadaAnterior = busStops.get(i - 1).getHoraAproximada();
                Time horaParadaActual = busStops.get(i).getHoraAproximada();
                Time nuevaHora = horaParadaAnterior;
                
                // Calcular una nueva hora que cumpla con los requisitos
                while (nuevaHora.compareTo(horaParadaAnterior) <= 0 || nuevaHora.compareTo(horaParadaActual) <= 0) {
                    nuevaHora = sumarMinutos(horaParadaActual, tiempoAleatorio);
                    tiempoAleatorio++;
                }
                
                // Establecer la nueva hora
                busStops.get(i).setHora(nuevaHora);    
        	}
        	i++;
        }
		
		
        this.Paradas = busStops;
	}
	
	public List<BusStop> getHorario (){
		return Paradas;
	}

}
 