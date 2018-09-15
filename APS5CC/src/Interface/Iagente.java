package Interface;

import java.util.List;

import Model.Agente;

public interface Iagente {

	public Agente selectAgente(int id);
	public List<Agente> selectAll();
	public String insertAgente(Agente ob);
	public String deleteAgente(String id);
	public Agente login(String email, String senha);
}
