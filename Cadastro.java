package LDC1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Cadastro {
 private static String nome;
 private static String email;
 private static String senha;
 private static String dataregistro;
 
 public Cadastro(){}
 public static void setNome(String nome_){nome = nome_ ;}
 public static void setEmail(String email_){email = email_;}
 public static void setSenha(String senha_){senha = senha_ ;}
 public static void setDataregistro(String dataregistro_){dataregistro = dataregistro_ ;}
 
 public static String getNome(){return nome;}
 public static String getEmail(){return email;}
 public static String getSenha(){return senha;}
 public static String getDataregistro(){return dataregistro;}
}
   
