package Interface;

import java.util.List;
import Model.Ficha;
import Model.Relatorio;

public interface Ificha {

	public Ficha selectFicha(int id);
	public List<Ficha> selectAll();
	public String insertFicha(Ficha ob);
	public String updateFicha(Ficha ob);
	public List<Ficha> selectData(String dataInicial,String dataFinal);
	public List<Ficha> selectConfirmados();
	public List<Ficha> selectNConfirmados();
	public String deleteFicha(int idFicha);
	public String confirmaFicha(int idFicha);
	public Relatorio OxE();
	public Relatorio PxC();
	public Relatorio AxC();
	public Relatorio OxE(String dataInicial,String dataFinal);
	public Relatorio PxC(String dataInicial,String dataFinal);
	public Relatorio AxC(String dataInicial,String dataFinal);
	public List<Relatorio> OxEL(String dataInicial,String dataFinal);
	public List<Relatorio> PxCL(String dataInicial,String dataFinal);
	public List<Relatorio> AxCL(String dataInicial,String dataFinal);
	
	
}