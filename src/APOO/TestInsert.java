package APOO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


         
public class TestInsert {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //Testa Grava��o - Preparando Obj para gravar
        Contato contato = new Contato();
        contato.setNome("Hailton");
        contato.setEmail("yagamoto.com.br");
        contato.setEndereco("R. beija-flor 3185 cj57");
        contato.setDataNascimento(Calendar.getInstance());
        
        Calendar dataNascimento = null;
        try {
            //Date date =    new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            Date date =    new SimpleDateFormat("yyyy-MM-dd").parse("1975-08-25");
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de convers�o da data");
            return; //para a execu��o do m�todo
        }
        
        contato.setDataNascimento(dataNascimento);
        
        // grave nessa conex�o!!!
        ContatoDao dao = new ContatoDao();
            
        // m�todo elegante
        dao.adiciona(contato);
        System.out.println("Gravado!");
    }

 

}

		
	   
		       




		
