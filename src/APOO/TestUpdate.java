package APOO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Alterar um contato
		Contato contato = new Contato();
		
		contato.setId((long) 55);
		contato.setNome("Gabriel Silva");
		contato.setEmail("gabriel@hotmail.com");
		contato.setEndereco("R. Vergueiro 3185 conjunto águas claras");
				
		//fazendo a conversao da data
		Calendar dataNasc = null;//Cria a variavel do tipo Calendar
				
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/11/1980");
			dataNasc = Calendar.getInstance();
			dataNasc.setTime(date);	
			
			//Adiciona a data ao contato
			contato.setDataNascimento(dataNasc);
		}catch (ParseException e){
			System.out.println("Erro de conversao da data");
			return; //para execucao do metodo
		}
				
		ContatoDao daoAlt = new ContatoDao();
		daoAlt.altera(contato);
	}

}