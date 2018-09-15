package Serializer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import Model.Industria;

public class IndustriaSerializer {
	

	public JSONObject IndustriaSerializerObj(Industria industria) throws JSONException {
		
		JSONObject data = new JSONObject();
		data.put("idIndustria", industria.getIdIndustria());
		data.put("nomeIndustria", industria.getNomeIndustria());
		//data.put("idCidade", industria.getLocalizacao());
		return data;
	}
	
	public List<JSONObject> IndustriaSerializerList(List<Industria> industrias) throws JSONException {
		
		List<JSONObject> data = new ArrayList<JSONObject>();
		
		JSONObject objIndustria = new JSONObject();
		
		for(Industria industria : industrias) {
			objIndustria.put("idIndustria", industria.getIdIndustria());
			objIndustria.put("nomeIndustria", industria.getNomeIndustria());
			//objIndustria.put("idCidade", industria.getLocalizacao());
			data.add(objIndustria);
			objIndustria = new JSONObject();
		}
		return data;
	}
}