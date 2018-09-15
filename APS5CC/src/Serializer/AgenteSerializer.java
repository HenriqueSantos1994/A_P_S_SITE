package Serializer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import Model.Agente;

public class AgenteSerializer {
	

	public JSONObject AgenteSerializerObj(Agente agente) throws JSONException {
		
		JSONObject data = new JSONObject();
		data.put("idAgente", agente.getIdAgente());
		//data.put("nome", agente.getNome());
		//data.put("idEquipe", agente.getIdEquipe());
		//data.put("telefone", agente.getTelefone());
		data.put("senha", agente.getSenha());
		data.put("email", agente.getEmail());
		
		
		
		return data;
	}
	
	public List<JSONObject> AgenteSerializerList(List<Agente> agentes) throws JSONException {
		
		List<JSONObject> data = new ArrayList<JSONObject>();
		
		JSONObject objAgente = new JSONObject();
		
		for(Agente agente : agentes) {
			objAgente.put("idAgente", agente.getIdAgente());
			//objAgente.put("nome", agente.getNome());
			//objAgente.put("idEquipe", agente.getIdEquipe());
			//objAgente.put("telefone", agente.getTelefone());
			objAgente.put("senha", agente.getSenha());
			objAgente.put("email", agente.getEmail());
			data.add(objAgente);
			objAgente = new JSONObject();
		}
		return data;
	}
}