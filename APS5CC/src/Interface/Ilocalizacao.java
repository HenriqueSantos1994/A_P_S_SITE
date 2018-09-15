package Interface;

import java.util.List;
import Model.Localizacao;

public interface Ilocalizacao {

	public List<Localizacao> selectAll();
	public Localizacao selectLocalizacao(int id);
	
}
