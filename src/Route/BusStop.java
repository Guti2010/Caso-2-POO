package Route;

import java.util.Date;

public class BusStop {
    private Date horaAproximada;
    private String ubicacion;

    // Constructor
    public BusStop() {
        // Constructor vacío
    }

    // Método para definir la hora aproximada del bus en la parada
    public void setHora(Date horaAproximada) {
        this.horaAproximada = horaAproximada;
    }

    // Método para definir la ubicación de la parada de autobús
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método para obtener la hora aproximada del bus en la parada
    public Date getHoraAproximada() {
        return horaAproximada;
    }

    // Método para obtener la ubicación de la parada de autobús
    public String getUbicacion() {
        return ubicacion;
    }
}
