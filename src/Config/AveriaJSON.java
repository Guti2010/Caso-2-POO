package Config;

import javax.json.JsonArray;

public class AveriaJSON {
	private JsonArray AveriasLeves;
    private JsonArray AveriasGraves;
	public AveriaJSON(){
		
	}
	
	public void setLeves(JsonArray pLeves) {
		this.AveriasLeves = pLeves;
	}
	public void setGraves(JsonArray pGraves) {
		this.AveriasGraves = pGraves;
	}
	
	public JsonArray getLeves() {
		return AveriasLeves;
	}
	public JsonArray getGraves() {
		return AveriasGraves;
	}
	
	


}
