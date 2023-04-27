package APOO;

public class TestRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Criar objeto contato
		Contato contato = new Contato();
		
		//Numero do Id do registro a ser removido
		contato.setId((long) 2);
		
		ContatoDao daoRem = new ContatoDao();
		
		daoRem.remove(contato);
		
		//daoRem.remove((long)8);

	}

}
