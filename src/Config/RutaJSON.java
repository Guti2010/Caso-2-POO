package Config;

import javax.json.JsonObject;

public class RutaJSON {
	private JsonObject rutas;
	public RutaJSON() {
		
	}
	public void setRutas(JsonObject pRutas) {
		this.rutas = pRutas;
	}
	public JsonObject getRutas() {
		return rutas;
	}
	

}
