package APOO;

import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formulario extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static JFrame Formulario = new JFrame();
	private static JPanel Painel = new JPanel();

    //--[ CRIANDO OS LABEL'S ]--\\
    JLabel LabNome = new JLabel("Nome:");
    JLabel LabEmail = new JLabel("Email:");        
    JLabel LabEndereco = new JLabel("Endereço:");
    JLabel LabdataNascimento = new JLabel("Data Nascimento:");
    
    //--[ CRIANDO OS CAMPOS DE TEXTO ]--\\
    JTextField nome = new JTextField("Digite o Nome");
    JTextField email = new JTextField();
    JTextField endereco = new JTextField();
    
    JFormattedTextField dataNascimento = new JFormattedTextField();

    //--[ CRIANDO BOTÕES ]--\\
    JButton btnCadastrar = new JButton("Cadastrar");     
    JButton btnListar = new JButton("Listar");  
    
    public Formulario() {	        
        //--[ SETA O TITULO  DO FORMULARIO ]--\\
        Formulario.setTitle("Cadastro de Contatos");         
        
        //--[ SETA O TAMANHO DO FORUMLARIO ]--\\
        Formulario.setSize(490, 250);             
        
        //--[ CENTRALIZA O FORMULARIO ]--\\
        Formulario.setLocationRelativeTo(null);    
        
        //--[ DESLIGANDO O GERENCIADOR DE LAYOUT ]--\\
        Painel.setLayout(null);         
        
        //--[ ADICIONA O PAINEL AO FORMULARIO ]--\\        
        Formulario.add(Painel);                                    
        
        //--[ CRIA UMA BORDA NO JLABEL ]--\\
        LabEndereco.setBorder(BorderFactory.createTitledBorder("")) ;
        
        //--[ SETA O ALINHAMENTO CENTRAL ]--\\
        LabEndereco.setHorizontalAlignment(SwingConstants.CENTER );
    
        //--[ ADICIONANDO OS COMPONENTES NO PAINEL DO FORMULARIO ]--\\
        Adiciona(LabNome, 10, 10, 70, 25);
        nome.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 14));
        
        nome.addMouseListener(new MouseListener() {
        	public void mousePressed(MouseEvent e) { 
        		nome.setText("");
        	}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub					
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			} 
        });
        
        Adiciona(nome, 80, 10, 230, 25);
        
        Adiciona(LabEmail, 10, 40, 70, 25); 
        Adiciona(email, 80, 40, 390, 25);         
        
        Adiciona(LabEndereco, 10, 70, 460, 25);     
        Adiciona(endereco, 10, 100, 460, 25);  
        
        Adiciona(LabdataNascimento, 10, 130, 250, 25);
        //Formatando uma mascara para a data do nascimento
        try {
        	MaskFormatter maskData = new MaskFormatter("##-##-####");
        	maskData.install(dataNascimento);
        }catch (ParseException dt) {
        	System.out.println("Erro na formatação da data");
			return; //para a execução do método
        }	             
        
        Adiciona(dataNascimento, 120, 130, 80, 25);	        
        Adiciona(btnCadastrar, 120, 170, 100, 30);                  
        
        //Evento Listener
        btnCadastrar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		//montando o objeto
	        		Contato contato = new Contato();
	        		contato.setNome(nome.getText());
	        		contato.setEmail(email.getText());
	        		contato.setEndereco(endereco.getText());
	        		
	        		//Formatando a data
	        		Calendar dtNascimento = null;
	        		try {
	        			Date date =	new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimento.getText());
	        			dtNascimento = Calendar.getInstance();
	        			dtNascimento.setTime(date);
	        		} catch (ParseException d) {
	        			System.out.println("Erro de conversão da data");
	        			return; //para a execução do método
	        		}
	        		
	        		contato.setDataNascimento(dtNascimento);
	        		
	        		//Chamando o metodo de cadastro e passando o obj contato
	        		onClickCadastrar(contato);
        		}
        	}
        );
        
        Adiciona(btnListar, 250, 170, 100, 30);
        btnListar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		GUILista lista = new GUILista();	
	        		//lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        		//lista.setVisible(true);
        		}
        	}
        );
        
        
        Formulario.setVisible(true);
    }
    
    //--[ FUNCAO PARA ADICIONAR COMPONENTES NO PAINEL DO FORMULARIO ]--\\
    private static void Adiciona(Component Componente, int nColuna, int nLinha, int nLargura, int nAltura ){
        //--[ ADICIONA O COMPONENTE NO PAINEL ]--\\
        Painel.add(Componente);                      
        
        //--[ SETA A POSICAO EXATA DO COMPONENTE ]--\\
        Componente.setBounds(nColuna, nLinha, nLargura, nAltura );
    }  

    private void onClickCadastrar(Contato contato) {

		// grave nessa conexão!!!
		ContatoDao dao = new ContatoDao();
			
		// método elegante
		dao.adiciona(contato);
		
		JOptionPane.showMessageDialog(this, "Contato salvo com sucesso! ");
		
		//limpando os campos
		nome.setText("");
		email.setText("");
		endereco.setText("");
		dataNascimento.setText("");
		
		//setando o foco para o campo nome
		nome.setFocusable(true);

    }
    
    public static void main(String[] args){        
    	//Cria uma instancia da classe formulario
    	Formulario Fcontato = new Formulario();
    	
    	//--[TERMINAR A EXECUCAO SE O FORMULARIO FOR FECHADO]--\\
    	Fcontato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    	    
}
