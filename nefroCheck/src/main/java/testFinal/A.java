package testFinal;

public class A {
	private void metodoPrivativo(){
		System.out.println("Classe A metodo privativo");
	}
	public  void metodoPublico(){ // protege o metodo para que não seja sobrescrito por extensoes
		System.out.println("Classe A metodo publico");
	}
	protected void metodoProtegido(){
	System.out.println("Classe A metodoProtegido");
	
	}
	void metodoFriendly(){ //void e publico instancio somente dentro do mesmo pacote
	System.out.println("Classe A metodoProtegido");
	}
}
