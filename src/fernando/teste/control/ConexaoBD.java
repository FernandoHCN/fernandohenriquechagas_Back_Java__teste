/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernando.teste.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fer_n
 */
public class ConexaoBD {

   private String connectionString;
   private String driver;
   private String usuario;
   private String senha;
   private Connection connection=null;

   public ConexaoBD(String usuario, String senha) {   
        this.usuario = usuario;
        this.senha = senha;   
   }

   public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
   }

   public void setDriver(String driver) {
        this.driver = driver;
   }
   
   public Connection conectar() {
        
	   if (connection == null){
	      try {
                 Class.forName(driver);
            
                 connection = DriverManager.getConnection(connectionString, usuario, senha);               
	         System.out.println("Conexao OK");
              }catch (Exception ex) {
                  System.out.println("Falha na Conexao");
                  System.out.println(ex.toString() + ex.getMessage());
          }
	   }
       
	   return connection;
   }
   
   public void fecharConexao(){
        if (connection != null){
	   try {
                  connection.close();
           } catch (SQLException ex) {
                   System.out.println(ex.toString());    
           }
        }   
    }
}
