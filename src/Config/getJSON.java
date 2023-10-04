package Config;

import java.io.FileReader; 
import javax.json.*;
import java.util.Vector;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.Map;

public class getJSON {
    private JsonObject jsonparser;
    
    private int TimeSimulation;
    private int minHoraServicio;
    private int maxHoraServicio;
    private int cantPresa;
    private int minPersonas;
    private int maxPersonas;
    private int minTiepoParadas;
    private int maxTiepoParadas;
    private int capacidadPersonas;
    private float posibilidadAveriaLeve;
    private float posibilidadAveriaGrave;
    private Vector<JsonArray> tiemposPresa;
    private Vector<JsonArray> tiemposAveria;
    private JsonArray AveriasLeves;
    private JsonArray AveriasGraves;
    private JsonObject rutas;
    
    public getJSON() {
        loadJson();
        tiemposPresa = new Vector<JsonArray>();
        tiemposAveria = new Vector<JsonArray>();
        
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
    	
    	TimeSimulation = jsonparser.getInt("tiempoSimulacionHora");
    	System.out.println(TimeSimulation);
        minHoraServicio = jsonparser.getInt("minHora");
        System.out.println(minHoraServicio);
        maxHoraServicio = jsonparser.getInt("maxHora");
        System.out.println(maxHoraServicio);
        minTiepoParadas = jsonparser.getInt("tiempo Min entre Parada");
        cantPresa = jsonparser.getInt("cantPresa");
        System.out.println(cantPresa);
        minPersonas = jsonparser.getInt("minPersonasEnParada");
        System.out.println(minPersonas);
        maxPersonas = jsonparser.getInt("maxPersonasEnParada");
        System.out.println(maxPersonas);
        System.out.println(minTiepoParadas);
        maxTiepoParadas = jsonparser.getInt("tiempo Max entre Parada");
        System.out.println(maxTiepoParadas);
        capacidadPersonas = jsonparser.getInt("capacidad Buses");
        System.out.println(capacidadPersonas);
        posibilidadAveriaLeve = (float) jsonparser.getJsonNumber("probabilidad Averia Leve").doubleValue();
        System.out.println(posibilidadAveriaLeve);
        posibilidadAveriaGrave = (float) jsonparser.getJsonNumber("probabilidad Averia Grave").doubleValue();
        System.out.println(posibilidadAveriaGrave);
          
    }
    public void averias() {
    	AveriasLeves = jsonparser.getJsonObject("averias").getJsonArray("leves");
        System.out.println(AveriasLeves);
        AveriasGraves = jsonparser.getJsonObject("averias").getJsonArray("graves");
        System.out.println(AveriasGraves);
    	
    }
    
    public void tiempos() {
    	tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("nula"));
        tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("baja"));
        tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("moderada"));
        tiemposPresa.add(jsonparser.getJsonObject("tiemposPresa").getJsonArray("alta"));
        System.out.println(tiemposPresa);
        tiemposAveria.add(jsonparser.getJsonObject("tiemposAveria").getJsonArray("leve"));
        tiemposAveria.add(jsonparser.getJsonObject("tiemposAveria").getJsonArray("grave"));
        System.out.println(tiemposAveria);
    }
    
	public void rutas() {
		rutas = jsonparser.getJsonObject("rutas");
        
        Iterator<String> keys = rutas.keySet().iterator();
        // Itera a través de las claves y muestra cada elemento
        while (keys.hasNext()) {
            String key = keys.next();
            JsonValue value = rutas.get(key);

            System.out.println("Clave: " + key.toString());
            
            JsonArray jsonArray = (JsonArray) value;
            // Itera a través de los elementos del arreglo
            for (JsonValue jsonValue : jsonArray) {
                System.out.println("Valor: " + jsonValue.toString());
            }
        }
		
	}
	       

}

