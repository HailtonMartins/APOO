package APOO;

import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {

	public static void main(String[] args) throws SQLException { 
		
		
		//Testar Conex�o
		Connection con = new Conexao().getConnection();
		System.out.println("Conex�o Aberta");
		con.close();
		
		
	    
	        
	    }
	}
		

	


