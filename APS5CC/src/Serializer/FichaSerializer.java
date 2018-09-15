package Serializer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import Model.Ficha;

public class FichaSerializer {
	

	public JSONObject FichaSerializerObj(Ficha ficha) throws JSONException {
		
		JSONObject data = new JSONObject();
		data.put("id", ficha.getIdFicha());
		data.put("agente", ficha.getIdAgente());
		data.put("atividade", ficha.getIdAtividade());
		data.put("industria", ficha.getIdIndustria());
		data.put("comentario", ficha.getObservacao());
		return data;
	}
	
	public List<JSONObject> FichaSerializerList(List<Ficha> fichas) throws JSONException {
		
		List<JSONObject> data = new ArrayList<JSONObject>();
		
		JSONObject objFicha = new JSONObject();
		
		for(Ficha ficha : fichas) {
			objFicha.put("id", ficha.getIdFicha());
			objFicha.put("agente", ficha.getIdAgente());
			objFicha.put("atividade", ficha.getIdAtividade());
			objFicha.put("industria", ficha.getIdIndustria());
			objFicha.put("comentario", ficha.getObservacao());
			
			data.add(objFicha);
			objFicha = new JSONObject();
		}
		return data;
	}
}