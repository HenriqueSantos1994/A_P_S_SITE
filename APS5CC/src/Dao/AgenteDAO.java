package Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Agente;
import Interface.Iagente;

public class AgenteDAO implements Iagente{
    
    private Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aps", "root", "");
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public List<Agente> selectAll() {
        List<Agente> lista = new ArrayList<Agente>();
        Agente ob = new Agente();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from agente");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ob.setIdAgente(Integer.parseInt(rs.getString("idAgente")));
                ob.setNome(rs.getString("Nome"));
                ob.setEmail(rs.getString("Email"));
                ob.setTelefone(rs.getString("Telefone"));
                ob.setIdEquipe(Integer.parseInt(rs.getString("Equipe_idEquipe")));
                ob.setSenha(rs.getString("senha"));
                ob.setIpUser(rs.getString("ip"));
                lista.add(ob);
                ob = new Agente();
            }
        
            rs.close();
            stmt.close();
            con.close();
            
            return lista;
        }catch (Exception ex){
            return null;
        }    
    }

    public String insertAgente(Agente ob){
            try{
            Connection con = conectar();
            PreparedStatement stmt;
                stmt = con.prepareStatement("insert into agente(Equipe_idEquipe, Nome, Email, Telefone, ip, senha) values(" + ob.getIdEquipe() + ",'" + ob.getNome()+ "','" + ob.getEmail() + "','" + ob.getTelefone() + "','"+ ob.getIpUser() +"','"+ ob.getSenha() +"');");
            stmt.execute();
            stmt.close();
            con.close();
            return "Cadastro com sucesso";
        }catch (Exception ex) {
            return "Erro no Cadastro";
        }
    }


    @Override
    public Agente selectAgente(int id) {
        Agente ob = new Agente();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from agente where idAgente = "+id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	ob.setIdAgente(Integer.parseInt(rs.getString("idAgente")));
                ob.setNome(rs.getString("Nome"));
                ob.setEmail(rs.getString("Email"));
                ob.setTelefone(rs.getString("Telefone"));
                ob.setIdEquipe(Integer.parseInt(rs.getString("Equipe_idEquipe")));
                ob.setSenha(rs.getString("senha"));
                ob.setIpUser(rs.getString("ip"));
            }
        
            rs.close();
            stmt.close();
            con.close();
            
            return ob;
        }catch (Exception ex){
            return null;
        }  
    }

    
    
    @Override
    public String deleteAgente(String idAgente) {
        try{
        Connection con = conectar();
        PreparedStatement stmt = con.prepareStatement("delete from agente where idAgente ="+ idAgente);
        stmt.execute();
        stmt.close();
        con.close();
        return "Deletado com Sucesso";
        }catch (Exception ex){
            return "Erro ao excluir";
        }
    }

	@Override
	public Agente login(String email, String senha) {
		Agente ob = new Agente();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from agente where email = '"+ email + "' and senha = '" + senha + "';");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	ob.setIdAgente(Integer.parseInt(rs.getString("idAgente")));
                ob.setNome(rs.getString("Nome"));
                ob.setEmail(rs.getString("Email"));
                ob.setTelefone(rs.getString("Telefone"));
                ob.setIdEquipe(Integer.parseInt(rs.getString("Equipe_idEquipe")));
                ob.setSenha(rs.getString("senha"));
                ob.setIpUser(rs.getString("ip"));
            }
        
            rs.close();
            stmt.close();
            con.close();
            
            return ob;
        }catch (Exception ex){
            return null;
        }  
	}
}