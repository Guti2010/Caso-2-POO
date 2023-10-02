package Main;
import Route.*;
import Trip.*;
import java.sql.Time;
import java.util.ArrayList;
 
import java.util.List; 
public class Main {
	public static void main(String[] args) {
		Viaje Viaje_1= new Viaje();
		Ruta Ruta_1= new Ruta();
		List<BusStop> busStops = new ArrayList<>();
		BusStop Parada1 = new BusStop();
		busStops.add(Parada1);
		BusStop Parada2 = new BusStop();
		busStops.add(Parada2);
		BusStop Parada3 = new BusStop();
		busStops.add(Parada3);
		BusStop Parada4 = new BusStop();
		busStops.add(Parada4);
		BusStop Parada5 = new BusStop();
		busStops.add(Parada5);
		BusStop Parada6 = new BusStop();
		busStops.add(Parada6);
		BusStop Parada7 = new BusStop();
		busStops.add(Parada7);
		BusStop Parada8 = new BusStop();
		busStops.add(Parada8);
		Time Hora = Time.valueOf("07:00:00");  
		Ruta_1.setBusStop(busStops);
		
		Viaje_1.setRuta(Ruta_1);
		Viaje_1.setHorario(Hora, 5, 15);
		List<BusStop> prueba = new ArrayList<>();
		prueba = Viaje_1.getBusStops();
		for (BusStop parada:prueba) {
			System.out.println(parada.getHoraAproximada());
		}
		System.out.println("");
		CantPresa cantidad = CantPresa.Moderada;
		Viaje_1.modificarHorarioSegunPresa(cantidad, Parada3);
		prueba = Viaje_1.getBusStops();
		for (BusStop parada:prueba) {
			System.out.println(parada.getHoraAproximada());
		} 
		System.out.println("");
		Gravedad pTipo = Gravedad.GRAVE;
		BusReport averia = new BusReport();
		averia.definirTipoDaño(pTipo);
		Viaje_1.modificarHorarioSegunDaño(averia, Parada5);
		prueba = Viaje_1.getBusStops();
		for (BusStop parada:prueba) {
			System.out.println(parada.getHoraAproximada());
		} 
		
		
	} 
	

}
