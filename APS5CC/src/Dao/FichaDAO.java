package Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Ficha;
import Model.Relatorio;
import Interface.Iatividade;
import Interface.Ificha;
import Interface.Iindustria;
import Interface.Ilocalizacao;

public class FichaDAO implements Ificha {

	private Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/aps", "root", "");
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Ficha> selectAll() {
		List<Ficha> lista = new ArrayList<Ficha>();
		Ficha ob = new Ficha();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from FichaAtividadesPoluentes");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setIdFicha(rs.getInt("idFicha"));
				ob.setIdAtividade(rs.getInt("Atividades_idAtividade"));
				ob.setIdIndustria(rs.getInt("Industria_idIndustria"));
				ob.setIdAgente(rs.getInt("Agente_idAgente"));
				ob.setConfirmacao(Integer.parseInt(rs.getString("Confirmacao")));
				ob.setObservacao(rs.getString("Observacao"));
				ob.setDataFicha(rs.getString("DataFicha"));
				lista.add(ob);
				ob = new Ficha();
			}

			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Ficha selectFicha(int id) {
		Ficha ob = new Ficha();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select*from FichaAtividadesPoluentes where idFicha =" + id + " ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setIdFicha(rs.getInt("idFicha"));
				ob.setIdAtividade(rs.getInt("Atividades_idAtividade"));
				ob.setIdIndustria(rs.getInt("Industria_idIndustria"));
				ob.setIdAgente(rs.getInt("Agente_idAgente"));
				ob.setConfirmacao(Integer.parseInt(rs.getString("Confirmacao")));
				ob.setObservacao(rs.getString("Observacao"));
				ob.setDataFicha(rs.getString("DataFicha"));
			}

			rs.close();
			stmt.close();
			con.close();
			
			return ob;
		} catch (Exception ex) {
			return null;
		}

	}

	@Override
	public String insertFicha(Ficha ob) {
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(
					"insert into FichaAtividadesPoluentes(Atividades_idAtividade, Industria_IdIndustria, Agente_IdAgente, Confirmacao,"
							+ "Observacao,DataFicha) values(" + ob.getIdAtividade() + "," + ob.getIdIndustria() + ","
							+ ob.getIdAgente() + ",0,'" + ob.getObservacao() + "','" + ob.getDataFicha() + "');");
			stmt.execute();
			stmt.close();
			con.close();
			return "Cadastro com sucesso";
		} catch (Exception ex) {
			return "Erro no Cadastro";
		}
	}
	
	@Override
	public String updateFicha(Ficha ob) {
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(
					"update FichaAtividadesPoluentes set Atividades_idAtividade = " + ob.getIdAtividade() + ", Industria_IdIndustria = " + ob.getIdIndustria() + ", Agente_IdAgente = "+ ob.getIdAgente() + ", Confirmacao = " + ob.getConfirmacao() + ", Observacao = '" + ob.getObservacao() + "',DataFicha = '" + ob.getDataFicha() + "' where idFicha = " + ob.getIdFicha());
			stmt.execute();
			stmt.close();
			con.close();
			return "Atualizado com sucesso";
		} catch (Exception ex) {
			return "Erro na Atualização";
		}
	}

	@Override
	public List<Ficha> selectData(String dataInicial, String dataFinal) {
		ArrayList<Ficha> lista = new ArrayList<Ficha>();
		Ficha ob = new Ficha();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT id, numero FROM (select Atividades_idAtividade as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by Atividades_idAtividade with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setConfirmacao((Integer.parseInt(rs.getString("Confirmacao"))));
				ob.setIdFicha((Integer.parseInt(rs.getString("idFicha"))));
				ob.setIdAgente((Integer.parseInt(rs.getString("idAgente"))));
				ob.setIdAtividade((Integer.parseInt(rs.getString("idAtividade"))));
				ob.setIdIndustria((Integer.parseInt(rs.getString("idIndustria"))));
				ob.setObservacao("Observacao");
				ob.setDataFicha("DataFicha");
				lista.add(ob);
				ob = new Ficha();
			}

			rs.close();
			stmt.close();
			con.close();

			return lista;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Ficha> selectConfirmados() {
		List<Ficha> lista = new ArrayList<Ficha>();
		Ficha ob = new Ficha();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from FichaAtividadesPoluentes where Confirmacao = 1");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setIdFicha(rs.getInt("idFicha"));
				ob.setIdAtividade(rs.getInt("Atividades_idAtividade"));
				ob.setIdIndustria(rs.getInt("Industria_idIndustria"));
				ob.setIdAgente(rs.getInt("Agente_idAgente"));
				ob.setConfirmacao(Integer.parseInt(rs.getString("Confirmacao")));
				ob.setObservacao(rs.getString("Observacao"));
				ob.setDataFicha(rs.getString("DataFicha"));
				lista.add(ob);
				ob = new Ficha();
			}

			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Ficha> selectNConfirmados() {
		List<Ficha> lista = new ArrayList<Ficha>();
		Ficha ob = new Ficha();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from FichaAtividadesPoluentes where Confirmacao = 0");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setIdFicha(rs.getInt("idFicha"));
				ob.setIdAtividade(rs.getInt("Atividades_idAtividade"));
				ob.setIdIndustria(rs.getInt("Industria_idIndustria"));
				ob.setIdAgente(rs.getInt("Agente_idAgente"));
				ob.setConfirmacao(Integer.parseInt(rs.getString("Confirmacao")));
				ob.setObservacao(rs.getString("Observacao"));
				ob.setDataFicha(rs.getString("DataFicha"));
				lista.add(ob);
				ob = new Ficha();
			}

			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public String deleteFicha(int idFicha) {
		try {
			Connection con = conectar();
			PreparedStatement stmt = con
					.prepareStatement("delete from FichaAtividadesPoluentes where idAgente =" + idFicha);
			stmt.execute();
			stmt.close();
			con.close();
			return "Deletado com Sucesso";
		} catch (Exception ex) {
			return "Erro ao excluir";
		}
	}

	@Override
	public String confirmaFicha(int idFicha) {
		try {
			Connection con = conectar();
			PreparedStatement stmt = con
					.prepareStatement("update FichaAtividadesPoluentes set Confirmacao = 1 where idFicha = " + idFicha);
			stmt.execute();
			stmt.close();
			con.close();
			return "Ficha confirmada";
		} catch (Exception ex) {
			return "Erro ao confirmar ficha";
		}
	}

	@Override
	public Relatorio OxE() {
		Relatorio ob = new Relatorio();
		Iindustria dao = new IndustriaDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select industria_idindustria as id, count(*) as numero from FichaAtividadesPoluentes group by industria_idindustria with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
					int id2 = rs.getInt("id");
					numeros += ("'" + rs.getString("numero") + "',");
					id += ("'" + dao.selectIndustria(id2).getNomeIndustria() + "',");
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			ob.setId(id);
			ob.setNumeros(numeros);

			
			
			rs.close();
			stmt.close();
			con.close();
			return ob;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Relatorio PxC() {
		Relatorio ob = new Relatorio();
		Iindustria dao = new IndustriaDAO();
		Ilocalizacao daol = new LocalizacaoDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select industria_idindustria as id, count(*) as numero from FichaAtividadesPoluentes group by industria_idindustria with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
					int id2 = rs.getInt("id");
					numeros += ("'" + rs.getString("numero") + "',");
					id += ("'" + daol.selectLocalizacao(dao.selectIndustria(id2).getLocalizacao()).getNomeCidade()
							+ "',");
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			ob.setId(id);
			ob.setNumeros(numeros);

			
			
			rs.close();
			stmt.close();
			con.close();
			return ob;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Relatorio AxC() {
		Relatorio ob = new Relatorio();
		Iatividade dao = new AtividadeDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select Atividades_idAtividade as id, count(*) as numero from FichaAtividadesPoluentes group by Atividades_idAtividade with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
						int id2 = rs.getInt("id");
						numeros += ("'" + rs.getString("numero") + "',");
						id += ("'" + dao.selectAtividade((id2)).getDescricao() + "',");
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			ob.setId(id);
			ob.setNumeros(numeros);

			
			
			rs.close();
			stmt.close();
			con.close();
			return ob;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Relatorio OxE(String dataInicial, String dataFinal) {
		Relatorio ob = new Relatorio();
		Iindustria dao = new IndustriaDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT id, numero FROM (select industria_idindustria as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by industria_idindustria with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
					int id2 = rs.getInt("id");
					numeros += ("'" + rs.getString("numero") + "',");
					id += ("'" + dao.selectIndustria(id2).getNomeIndustria() + "',");
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			ob.setId(id);
			ob.setNumeros(numeros);
			rs.close();
			stmt.close();
			con.close();
			return ob;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Relatorio PxC(String dataInicial, String dataFinal) {
		Relatorio ob = new Relatorio();
		Iindustria dao = new IndustriaDAO();
		Ilocalizacao daol = new LocalizacaoDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select industria_idindustria as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by industria_idindustria with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
					int id2 = rs.getInt("id");
					numeros += ("'" + rs.getString("numero") + "',");
					id += ("'" + daol.selectLocalizacao(dao.selectIndustria(id2).getLocalizacao()).getNomeCidade()
							+ "',");
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			ob.setId(id);
			ob.setNumeros(numeros);
			rs.close();
			stmt.close();
			con.close();
			return ob;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Relatorio AxC(String dataInicial, String dataFinal) {
		
		Relatorio ob = new Relatorio();
		Iatividade dao = new AtividadeDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select Atividades_idAtividade as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by Atividades_idAtividade with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
						int id2 = rs.getInt("id");
						numeros += ("'" + rs.getString("numero") + "',");
						id += ("'" + dao.selectAtividade((id2)).getDescricao() + "',");
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			ob.setId(id);
			ob.setNumeros(numeros);
			rs.close();
			stmt.close();
			con.close();
			return ob;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Relatorio> OxEL(String dataInicial, String dataFinal) {
		List<Relatorio> lista = new ArrayList<Relatorio>();
		Relatorio ob = new Relatorio();
		Iindustria dao = new IndustriaDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select industria_idindustria as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by industria_idindustria with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
					int id2 = rs.getInt("id");
					ob.setId(rs.getString("numero"));
					ob.setNumeros(Integer.toString(dao.selectIndustria(id2).getIdIndustria()));
					lista.add(ob);
					ob = new Relatorio();
				}else {
					String old = rs.getString("id");
				}
				cont++;
				
			}
			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Relatorio> PxCL(String dataInicial, String dataFinal) {
		List<Relatorio> lista = new ArrayList<Relatorio>();
		Relatorio ob = new Relatorio();
		Iindustria dao = new IndustriaDAO();
		Ilocalizacao daol = new LocalizacaoDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select industria_idindustria as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by industria_idindustria with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
					
					ob.setId(Integer.toString(daol.selectLocalizacao(dao.selectIndustria(rs.getInt("id")).getLocalizacao()).getIdCidade()));
					ob.setNumeros(rs.getString("numero"));
					lista.add(ob);
					ob = new Relatorio();
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Relatorio> AxCL(String dataInicial, String dataFinal) {
		List<Relatorio> lista = new ArrayList<Relatorio>();
		Relatorio ob = new Relatorio();
		Iatividade dao = new AtividadeDAO();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id, numero FROM (select Atividades_idAtividade as id, count(*) as numero from (select * from FichaAtividadesPoluentes where dataFicha between ('" + dataInicial + "') and ('" + dataFinal + "')) dataF group by Atividades_idAtividade with rollup) total ORDER BY numero desc;");
			ResultSet rs = stmt.executeQuery();
			String id = "";
			String numeros = "";
			int cont = 0;
			while (rs.next()) {
				if (cont != 0 && cont <= 6) {
						int id2 = rs.getInt("id");
						ob.setNumeros(rs.getString("numero"));
						ob.setId(Integer.toString(dao.selectAtividade((id2)).getIdAtividade()));
						lista.add(ob);
						ob = new Relatorio();
				}else {
					String old = rs.getString("id");
				}
				cont++;
			}
			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			return null;
		}
	}

}
