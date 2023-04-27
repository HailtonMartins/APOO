package APOO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JOptionPane;


public class TestInsert2 {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //Testa Gravação - Preparando Obj para gravar
        Contato contato = new Contato();
        
        //Recebendo os dados via caixa de dialogo
        contato.setNome(JOptionPane.showInputDialog("Enter Nome"));
        contato.setEmail(JOptionPane.showInputDialog("Enter Email"));
        contato.setEndereco(JOptionPane.showInputDialog("Enter Endereço"));

 

        //Formatando a data
        Calendar dataNascimento = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Enter Data"));
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
            return; //para a execução do método
        }
        
        contato.setDataNascimento(dataNascimento);
        
        // Persistência de dados!!!
        //Inicial uma conexão com o BD
        ContatoDao dao = new ContatoDao();
        
        //Chama o metodo para inserção de dados
        dao.adiciona(contato);
        JOptionPane.showMessageDialog(null, "Contato Salvo");
    }
}          

	