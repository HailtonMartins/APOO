package APOO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	 public Connection getConnection(){
         //System.out.println("Banco Conectado");
         //Nao esquecer de colocar o driver jdbc dentro do tomcat/lib        
         try{
             DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
             //System.out.println("Banco Conectado");
             return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root", "");
         }catch(SQLException e){
             throw new RuntimeException(e);
         }
  }

}
