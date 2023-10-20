package Config;

public class settingJSON {
	private int TimeSimulation;
    private int minHoraServicio;
    private int maxHoraServicio;
    private int intervalo;
    private int cantPresa;
    private int minPersonas;
    private int maxPersonas;
    private int minTiempoParadas;
    private int maxTiempoParadas;
    private int capacidadPersonas;
    private int posibilidadAveriaLeve;
    private int posibilidadAveriaGrave;
    
    public settingJSON() {
    	
    }
    
    public void setTimeSimulation(int TimeSimulation) {
        this.TimeSimulation = TimeSimulation;
    }
    
    // Getter para TimeSimulation
    public int getTimeSimulation() {
        return TimeSimulation;
    }

    // Setter para minHoraServicio
    public void setMinHoraServicio(int minHoraServicio) {
        this.minHoraServicio = minHoraServicio;
    }

    // Getter para minHoraServicio
    public int getMinHoraServicio() {
        return minHoraServicio;
    }
    
    public void setMaxHoraServicio(int minHoraServicio) {
        this.maxHoraServicio = minHoraServicio;
    }

    
    public int getMaxHoraServicio() {
        return maxHoraServicio;
    }
    
    public void setIntervalo(int tiempoEntreServicio) {
    	intervalo = tiempoEntreServicio;
    }
    
    public int getIntervalo() {
    	return intervalo;
    }
    
    public void setCantPresa(int cantPresa) {
        this.cantPresa = cantPresa;
    }

    public int getCantPresa() {
        return cantPresa;
    }
    
    // Setter y getter para minTiempoParadas
    public void setMinPersonas(int minPersonas) {
        this.minPersonas = minPersonas;
    }

    public int getMinPersonas() {
        return minPersonas;
    }

    public void setMaxPersonas(int maxPersonas) {
        this.maxPersonas = maxPersonas;
    }

    public int getMaxPersonas() {
        return maxPersonas;
    }

    
    
    // Setter y getter para minTiempoParadas
    public void setMinTiempoParadas(int minTiempoParadas) {
        this.minTiempoParadas = minTiempoParadas;
    }

    public int getMinTiempoParadas() {
        return minTiempoParadas;
    }

    // Setter y getter para maxTiempoParadas
    public void setMaxTiempoParadas(int maxTiempoParadas) {
        this.maxTiempoParadas = maxTiempoParadas;
    }

    public int getMaxTiempoParadas() {
        return maxTiempoParadas;
    }
    
    public void setCantPersonas(int cantPersonas) {
        this.capacidadPersonas = cantPersonas;
    }

    public int getCantPersonas() {
        return capacidadPersonas;
    }
    
    public void setAveriaLeve(int averiaLeve) {
        this.posibilidadAveriaLeve = averiaLeve;
    }

    public int getAveriaLeve() {
        return posibilidadAveriaLeve;
    }
    
    public void setAveriaGrave(int averiaGrave) {
        this.posibilidadAveriaGrave = averiaGrave;
    }

    public int getAveriaGrave() {
        return posibilidadAveriaGrave;
    }
    


}
