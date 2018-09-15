package Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Equipe;
import Interface.Iequipe;

public class EquipeDAO implements Iequipe{
    
    private Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aps", "root", "");
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public List<Equipe> selectAll() {
        List<Equipe> lista = new ArrayList<Equipe>();
        Equipe ob = new Equipe();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Equipe");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ob.setIdEquipe(Integer.parseInt(rs.getString("idEquipe")));
                ob.setNomeEquipe(rs.getString("NomeEquipe"));
                lista.add(ob);
                ob = new Equipe();
            }
        
            rs.close();
            stmt.close();
            con.close();
            return lista;
        }catch (Exception ex){
        	return null;
        }    
    }


    @Override
    public Equipe selectEquipe(int id) {
        Equipe ob = new Equipe();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Equipe where idEquipe = "+id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ob.setIdEquipe((Integer.parseInt(rs.getString("idEquipe"))));
                ob.setNomeEquipe(rs.getString("NomeEquipe"));
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
    public String insertEquipe(Equipe ob) {
        try{
            Connection con = conectar();
            PreparedStatement stmt = con.prepareStatement("insert into Equipe(IdEquipe, NomeEquipe) values(' " + ob.getIdEquipe() + " ',' " + ob.getNomeEquipe() + " ');");
            stmt.execute();
            stmt.close();
            con.close();
            return "Cadastro com sucesso";
        }catch (Exception ex) {
            return "Erro no Cadastro";
        }
    }

    @Override
    public String deleteEquipe(String id) {
        try{
        Connection con = conectar();
        PreparedStatement stmt = con.prepareStatement("delete from Equipe where IdEquipe = "+id);
        stmt.execute();
        stmt.close();
        con.close();
        return "Deletado com Sucesso";
        }catch (Exception ex){
            return "Erro";
        }
    }

}
