package Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.Atividade;
import Interface.Iatividade;

public class AtividadeDAO implements Iatividade {
    
    private Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aps", "root", "");
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public List<Atividade> selectAll() {
        List<Atividade> lista = new ArrayList<Atividade>();
        Atividade ob = new Atividade();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Atividades");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ob.setIdAtividade(Integer.parseInt(rs.getString("idAtividade")));
                ob.setDescricao(rs.getString("Descricao"));
                lista.add(ob);
                ob = new Atividade();
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
    public String deleteAtividade(String id) {
        try{
        Connection con = conectar();
        PreparedStatement stmt = con.prepareStatement("delete from Atividades where idAtividade = "+id+"");
        stmt.execute();
        stmt.close();
        con.close();
        return "Deletado com Sucesso";
        }catch (Exception ex){
            return "Erro";
        }
    }

    @Override
    public String insertAtividade(Atividade ob) {
         try{
            Connection con = conectar();
            PreparedStatement stmt = con.prepareStatement("insert into Atividades(Descricao) values('" + ob.getDescricao() + "');");
            stmt.execute();
            stmt.close();
            con.close();
            return "Cadastro com sucesso";
        }catch (Exception ex) {
            return "Erro no Cadastro";
        }
    }

    @Override
    public Atividade selectAtividade(int id) {
        Atividade ob = new Atividade();
        Connection con = conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("select * from Atividades where idAtividade = "+id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	ob.setIdAtividade(Integer.parseInt(rs.getString("idAtividade")));
                ob.setDescricao(rs.getString("Descricao"));
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
