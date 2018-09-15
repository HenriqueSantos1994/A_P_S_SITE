package Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Industria;
import Interface.Iindustria;

public class IndustriaDAO implements Iindustria {
    
    private Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aps", "root", "");
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public List<Industria> selectAll() {
        List<Industria> lista = new ArrayList<Industria>();
        Industria ob = new Industria();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Industria");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ob.setIdIndustria((Integer.parseInt(rs.getString("idIndustria"))));
                ob.setNomeIndustria(rs.getString("nomeIndustria"));
                ob.setLocalizacao(rs.getInt("Localizacao_idCidade"));
                lista.add(ob);
                ob = new Industria();                
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
    public Industria selectIndustria(int id) {
        Industria ob = new Industria();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Industria where idIndustria = " + id + ";");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ob.setIdIndustria((Integer.parseInt(rs.getString("idIndustria"))));
                ob.setNomeIndustria(rs.getString("NomeIndustria"));
                ob.setLocalizacao(Integer.parseInt(rs.getString("Localizacao_idCidade")));
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
    public String insertIndustria(Industria ob) {
        try{
            Connection con = conectar();
            PreparedStatement stmt = con.prepareStatement("insert into industria(Localizacao_idCidade, NomeIndustria) values("+ ob.getLocalizacao() +",'" + ob.getNomeIndustria() + "');");            
            stmt.execute();
            stmt.close();
            con.close();
            return "Cadastro com sucesso";
        }catch (Exception ex) {
            return "Erro no Cadastro";
        }
    }

    @Override
    public String deleteIndustria(String id) {
        try{
        Connection con = conectar();
        PreparedStatement stmt = con.prepareStatement("delete from Industria where idIndustria = " + id );
        stmt.execute();
        stmt.close();
        con.close();
        return "Deletado com Sucesso";
        }catch (Exception ex){
        	System.out.println(ex.getMessage());
            return "Erro ao deletar";
        }
    }
}
