package Interface;

import java.util.List;

import Model.Equipe;

public interface Iequipe {
	
	public Equipe selectEquipe(int id);
	public List<Equipe> selectAll();
	public String insertEquipe(Equipe ob);
	public String deleteEquipe(String id);
	
}
