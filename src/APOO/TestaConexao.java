package APOO;

import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {

	public static void main(String[] args) throws SQLException { 
		
		
		//Testar Conexão
		Connection con = new Conexao().getConnection();
		System.out.println("Conexão Aberta");
		con.close();
		
		
	    
	        
	    }
	}
		

	


