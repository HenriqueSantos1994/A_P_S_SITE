package Interface;

import java.util.List;

import Model.Industria;

public interface Iindustria {

	public Industria selectIndustria(int id);
	public List<Industria> selectAll();
	public String insertIndustria(Industria ob);
	public String deleteIndustria(String id);
	
}
