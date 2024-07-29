/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LDC1;
import java.sql.*;

/**
 *
 * @author unisanta
 */
public class CadastroDAL {

    private static Connection con;

    public static void conecta(String _bd)
    {
        Erro.setErro(false);
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + _bd);
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta()
    {
        Erro.setErro(false);
        try 
        {
            con.close();
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void inseriCadastro()
    {
        try 
        {
            PreparedStatement st = con.prepareStatement("insert into Tabela1 (nome,email,senha,data) values (?,?,?,?)");
            st.setString(1,Cadastro.getNome());
            st.setString(2,Cadastro.getEmail());
            st.setString(3,Cadastro.getSenha());
            st.setString(4,Cadastro.getDataregistro());
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }
    
    public static void alteraCadastro()
    {
        Erro.setErro(false);
        try 
        {
        PreparedStatement st = con.prepareStatement("update Tabela1 set nome=?, senha=?, data=? WHERE email=?");
        st.setString(1,Cadastro.getNome());
        st.setString(2,Cadastro.getSenha());
        st.setString(3,Cadastro.getDataregistro());
        st.setString(4,Cadastro.getEmail());
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void deletaCadastro()
    {
        try
        {
        PreparedStatement st = con.prepareStatement("delete from Tabela1 WHERE email=?");
        st.setString(1,Cadastro.getEmail());
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
        
    }
    
    public static void consultaCadastro()
    {
        ResultSet rs;

        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM Tabela1 WHERE email=?");
            st.setString(1,Cadastro.getEmail());
            rs = st.executeQuery();
            if (rs.next())
            {
                Cadastro.setNome(rs.getString("nome"));
                Cadastro.setSenha(rs.getString("senha"));
                Cadastro.setDataregistro(rs.getString("data"));
            }
            else
            {
                Erro.setErro("Cadastro não localizado.");
                return;
            }
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }
}