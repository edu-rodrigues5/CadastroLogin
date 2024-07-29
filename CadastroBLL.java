/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LDC1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author User
 */
public class CadastroBLL {
    
    
    public static void conecta()
    {
        CadastroDAL.conecta("Cadastro.mdb");
    }
    
    public static void desconecta()
    {
        CadastroDAL.desconecta();
    }
    
    public static void validaEmail(char _op)
    {
        Erro.setErro(false);
        if(Cadastro.getEmail().equals(""))
        {
            Erro.setErro("O Email está vazio");
        }
        
        switch(_op)
        {
        
            case 'c': CadastroDAL.consultaCadastro(); break;
            case 'd': CadastroDAL.deletaCadastro(); break;
        }
    }
    
    
    public static void validaDados(char _op)
{
    
 Erro.setErro(false);
 
 if (Cadastro.getEmail().equals(""))
   {Erro.setErro("O campo E-MAIL é de preenchimento obrigatório..."); return;}
 if (Cadastro.getNome().equals(""))
   {Erro.setErro("O campo NOME é de preenchimento obrigatório..."); return;}
 if (Cadastro.getSenha().equals(""))
   {Erro.setErro("O campo SENHA é de preenchimento obrigatório..."); return;}
 if (Cadastro.getDataregistro().equals(""))
   {Erro.setErro("O campo DATA é de preenchimento obrigatório..."); return;}
 else
 {
    //E-mail verifição 
    
    try {
    Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]{3,}");
    Matcher matcher = pattern.matcher(Cadastro.getEmail());
    if(!matcher.find())
    {
        int i=50/0;
    }

    } catch (Exception e) {
        Erro.setErro("O campo E-MAIL não está de acordo com a formatação!");return;
    }
    
    //verificação nome
 
    
    if(Cadastro.getNome().length() <= 2)
    {
        Erro.setErro("O campo NOME tem que ser maior que duas letras");return;
    }
    
    
    
    //senha verificação
    try {
    Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*).{8,}");
    Matcher matcher = pattern.matcher(Cadastro.getSenha());
    if(!matcher.find())
    {
        int i=1/0;
    }

    } catch (Exception e) {
        Erro.setErro("O campo SENHA está sem número ou letra ou caractere especial!");return;
    }
    
    if(Cadastro.getSenha().length() < 8)
    {
        Erro.setErro("O campo SENHA tem que ser maior que oito");return;
    }
    
    //verificação Data
    
    try {
    Pattern pattern = Pattern.compile("^([0-3][0-9])/([0-1][0-9])/([0-9]{4})$");
    Matcher matcher = pattern.matcher(Cadastro.getDataregistro());
    if(!matcher.find())
    {
        int i=1/0;
    }

    } catch (Exception e) {
        Erro.setErro("O campo DATA não está de acordo com a formatação (dd/mm/aaaa)!");return;
    }
    
    switch(_op)
    {
        case 'i': CadastroDAL.inseriCadastro(); break;
        case 'a': CadastroDAL.alteraCadastro(); break;
    }
 }
 }
}

