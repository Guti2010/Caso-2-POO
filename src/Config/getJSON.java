package Config;

import java.io.FileReader;   
import javax.json.*;
import java.util.Vector;



public class getJSON {
    private JsonObject jsonparser;
    private AveriaJSON Averias;
    private RutaJSON Rutas;
    private settingJSON Configuraciones;
    private TiempoJSON Tiempos;
    private Vector<JsonArray> tiemposPresa;
    private Vector<JsonArray> tiemposAveria;
    
    public getJSON() {
        loadJson();
        tiemposPresa = new Vector<JsonArray>(); 
        tiemposAveria = new Vector<JsonArray>(); 
        Averias = new AveriaJSON();
        Rutas = new RutaJSON();
        Configuraciones = new settingJSON();
        Tiempos = new TiempoJSON();
        settings();
        averias();
        tiempos();
        rutas();
    }
    
    private void loadJson() {
        String pathtofile = "C:\\Users\\windows\\Documents\\TransportePúblico\\src\\Config\\config.json";
        
        try (JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            jsonparser = reader.readObject();
                       
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    public void settings() {
    	Configuraciones.setTimeSimulation(jsonparser.getInt("tiempoSimulacionHora"));
    	Configuraciones.setMinHoraServicio(jsonparser.getInt("minHora"));
        Configuraciones.setMaxHoraServicio(jsonparser.getInt("maxHora"));
        Configuraciones.setCantPresa(jsonparser.getInt("cantPresa"));
        Configuraciones.setMinPersonas(jsonparser.getInt("minPersonasEnParada"));
        Configuraciones.setMaxPersonas(jsonparser.getInt("maxPersonasEnParada"));
        Configuraciones.setMinTiempoParadas(jsonparser.getInt("tiempo Min entre Parada"));
        Configuraciones.setMaxTiempoParadas(jsonparser.getInt("tiempo Max entre Parada"));
        Configuraciones.setCantPersonas(jsonparser.getInt("capacidad Buses"));
        Configuraciones.setAveriaLeve(jsonparser.getInt("probabilidad Averia Leve"));  
        Configuraciones.setAveriaGrave(jsonparser.getInt("probabilidad Averia Grave")); 
        Configuraciones.setIntervalo(jsonparser.getInt("tiempo entre viajes"));
    }
    public void averias() {
    	Averias.setLeves(jsonparser.getJsonObject("averias").getJsonArray("leves"));
        
        Averias.setGraves(jsonparser.getJsonObject("averias").getJsonArray("graves"));
        
    }
    
    public void tiempos() {
    	tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("nula"));
        tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("baja"));
        tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("moderada"));
        tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("alta"));
        Tiempos.setTimepoPresa(tiemposPresa);
        
        tiemposAveria.add(jsonparser.getJsonObject("tiemposAveria").getJsonArray("leve"));
        tiemposAveria.add(jsonparser.getJsonObject("tiemposAveria").getJsonArray("grave"));
        Tiempos.setTimepoAverias(tiemposAveria);
        
    }
    
	public void rutas() {
		Rutas.setRutas(jsonparser.getJsonObject("rutas"));	
	}
	
	public AveriaJSON getAverias() {
		return Averias;
	}
	
	public TiempoJSON getTiempos() {
		return Tiempos;
	}
	public RutaJSON getRutas() {
		return Rutas;
	}
	public settingJSON getSettings() {
		return Configuraciones;
	}
	       

}

