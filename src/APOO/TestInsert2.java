package APOO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JOptionPane;


public class TestInsert2 {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //Testa Grava��o - Preparando Obj para gravar
        Contato contato = new Contato();
        
        //Recebendo os dados via caixa de dialogo
        contato.setNome(JOptionPane.showInputDialog("Enter Nome"));
        contato.setEmail(JOptionPane.showInputDialog("Enter Email"));
        contato.setEndereco(JOptionPane.showInputDialog("Enter Endere�o"));

 

        //Formatando a data
        Calendar dataNascimento = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Enter Data"));
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de convers�o da data");
            return; //para a execu��o do m�todo
        }
        
        contato.setDataNascimento(dataNascimento);
        
        // Persist�ncia de dados!!!
        //Inicial uma conex�o com o BD
        ContatoDao dao = new ContatoDao();
        
        //Chama o metodo para inser��o de dados
        dao.adiciona(contato);
        JOptionPane.showMessageDialog(null, "Contato Salvo");
    }
}          

	