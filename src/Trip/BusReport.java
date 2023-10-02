package Trip;

import java.util.Date;

public class BusReport {
    private Date hora;
    private Gravedad TipoAveria;
    private String descripcion;
    private Date fechaAcontecimiento;
    private boolean Reparado;

    // Constructor
    public BusReport() {
        
    }

    // Método para definir la hora del reporte
    public void definirHoraYFecha(Date pHora,Date pFecha) {
        this.hora = pHora;
        this.fechaAcontecimiento = pFecha;
    }
    
    // Método para definir si el problema ha sido resuelto o si no.
    public void setEstado(boolean pEstado) {
    	this.Reparado = pEstado;
    	
    }

    // Método para definir el tipo de daño del autobús
    public void definirTipoDaño(Gravedad pTipo) {
        this.TipoAveria = pTipo;
    }

    // Método para agregar una descripción al reporte
    public void agregarDaño(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la hora del reporte
    public Date getHora() {
        return hora;
    }
    
    public Date getFecha() {
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
