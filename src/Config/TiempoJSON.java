package Config;

import java.util.Vector;

import javax.json.JsonArray;

public class TiempoJSON {
	private Vector<JsonArray> tiemposPresa;
    private Vector<JsonArray> tiemposAveria;
	public TiempoJSON(){
		tiemposPresa = new Vector<JsonArray>();
        tiemposAveria = new Vector<JsonArray>();
	}
	
	public void setTimepoPresa(Vector<JsonArray> pPresa) {
		this.tiemposPresa = pPresa;
	}
	public void setTimepoAverias(Vector<JsonArray> pAveria) {
		this.tiemposAveria = pAveria;
	}
	
	public Vector<JsonArray> getTiempoPresa() {
		return tiemposPresa;
	}
	public Vector<JsonArray> getTiempoAverias() {
		return tiemposAveria;
	}

}
