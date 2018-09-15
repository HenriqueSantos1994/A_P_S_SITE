package Interface;

import java.util.List;

import Model.Atividade;

public interface Iatividade {

	public Atividade selectAtividade(int id);

	public List<Atividade> selectAll();

	public String insertAtividade(Atividade ob);

	public String deleteAtividade(String id);
}
