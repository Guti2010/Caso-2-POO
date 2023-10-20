package Route;

import java.io.Serializable;
import java.sql.Time;


public class BusStop implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Time horaAproximada;
    private String ubicacion;

    // Constructor
    public BusStop() {
       
    }

    // Método para definir la hora aproximada del bus en la parada
    public void setHora(Time horaAproximada) {
        this.horaAproximada = horaAproximada;
    }
 
    // Método para definir la ubicación de la parada de autobús
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método para obtener la hora aproximada del bus en la parada
    public Time getHoraAproximada() {
        return horaAproximada;
    }

    // Método para obtener la ubicación de la parada de autobús
    public String getUbicacion() {
        return ubicacion;
    }
}
