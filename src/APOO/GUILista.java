package APOO;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUILista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JFrame frame;
	private JTextArea txtlista;
    
	public GUILista() {
		txtlista = new JTextArea();
		txtlista.setLineWrap(true);
		txtlista.setEditable(false);
			
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();	
		
		for (Contato contato: contatos) {
			txtlista.append(String.valueOf("Id: " + contato.getId()));		
			txtlista.append(System.lineSeparator());
			txtlista.append(String.valueOf("Nome: " + contato.getNome()));
			txtlista.append(System.lineSeparator());
			txtlista.append(String.valueOf("Email: " + contato.getEmail()));
			txtlista.append(System.lineSeparator());
			txtlista.append(String.valueOf("Endereço: " + contato.getEndereco()));
			txtlista.append(System.lineSeparator());
			txtlista.append(String.valueOf("Data de Nascimento: " +
			contato.getDataNascimento().getTime() + "\n"));
			txtlista.append(System.lineSeparator());
		}
		
		// Cria barra de rolagem e adiciona a area de texto
	    JScrollPane scrooll = new JScrollPane(txtlista);
		
        // Adiciona valores as propriedades da barra de rolagem
        
        // Barra vertical
        scrooll.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Tamanho da barra
        scrooll.setPreferredSize(new Dimension(450, 350));
         
        // Borda com titulo
        scrooll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Lista de Contatos"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                                scrooll.getBorder()));
        
        //---- alimentação de dados no jTextArea
		panel = new JPanel();
		
        // Adiciona a barra de rolagem pois a area de texto
        // está já foi adiciona dentro dela logo acima.
        panel.add(scrooll);
        panel.add(Box.createVerticalStrut(5));
        //panel.add(Box.createVerticalStrut(5));

		//Estilo da frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Contatos HR");
		frame.setLocation(500,200);
		frame.setSize(600, 400);  	
		frame.add(panel);
		
		//Faz com que o frame se ajuste as componentes		
		frame.pack();	
		
		//Anula o frame.setLocation(500,200);
		//frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUILista listar = new GUILista();
		listar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}