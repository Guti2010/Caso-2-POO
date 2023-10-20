package Trip;

import java.util.Date; 
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class BusReport implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Gravedad TipoAveria;
    private String descripcion;
    private LocalDateTime fechaAcontecimiento;
    private boolean Reparado;

    // Constructor
    public BusReport() {
        
    }

    // Método para definir la hora del reporte
    public void setFecha(LocalDateTime pFecha) {
        
        this.fechaAcontecimiento = pFecha;
    }
    
    // Método para definir si el problema ha sido resuelto o si no.
    public void setEstado(boolean pEstado) {
    	this.Reparado = pEstado;
    	
    }

    // Método para definir el tipo de daño del autobús
    public void setTipoDaño(Gravedad pTipo) {
        this.TipoAveria = pTipo;
    }

    // Método para agregar una descripción al reporte
    public void setDaño(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    public LocalDateTime getFecha() {
        return fechaAcontecimiento;
    }

    // Método para obtener el tipo de daño del autobús
    public Gravedad getTipoAveria() {
        return TipoAveria;
    }

    // Método para obtener la descripción del reporte
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean getEstado() {
    	return Reparado;
    }
}
