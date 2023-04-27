package APOO;

import java.util.List;

public class TestaConsulta2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Executar uma Select no Banco Usando o DAO
		ContatoDao dao = new ContatoDao();		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " +
			contato.getDataNascimento().getTime() + "\n");
		}	
	}
}