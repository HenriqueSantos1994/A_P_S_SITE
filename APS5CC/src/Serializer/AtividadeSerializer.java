package Serializer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import Model.Atividade;

public class AtividadeSerializer {
public JSONObject AtividadeSerializerObj(Atividade atividade) throws JSONException {
		
		JSONObject data = new JSONObject();
		data.put("idAtividade", atividade.getIdAtividade());
		data.put("descricao", atividade.getDescricao());
		return data;
	}
	
	public List<JSONObject> AtividadeSerializerList(List<Atividade> atividades) throws JSONException {
		
		List<JSONObject> data = new ArrayList<JSONObject>();
		
		JSONObject objAtividade = new JSONObject();
		
		for(Atividade atividade : atividades) {
			objAtividade.put("idAtividade", atividade.getIdAtividade());
			objAtividade.put("descricao", atividade.getDescricao());
			data.add(objAtividade);
			objAtividade = new JSONObject();
		}
		return data;
	}
}
