package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Localizacao;
import Model.Localizacao;
import Interface.Ilocalizacao;

public class LocalizacaoDAO implements Ilocalizacao {

	private Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/aps", "root", "");
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public Localizacao selectLocalizacao(int id) {
		Localizacao ob = new Localizacao();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement("select*from Localizacao where idCidade =" + id + " ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setIdCidade((Integer.parseInt(rs.getString("idCidade"))));
				ob.setNomeCidade(rs.getString("NomeCidade"));
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
	public List<Localizacao> selectAll() {
		List<Localizacao> lista = new ArrayList<Localizacao>();
		Localizacao ob = new Localizacao();
		Connection con = conectar();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Localizacao order by NomeCidade");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ob.setIdCidade(Integer.parseInt(rs.getString("idCidade")));
				ob.setNomeCidade(rs.getString("NomeCidade"));
				lista.add(ob);
				ob = new Localizacao();
			}

			rs.close();
			stmt.close();
			con.close();
			return lista;
		} catch (Exception ex) {
			return null;
		}
	}

}
