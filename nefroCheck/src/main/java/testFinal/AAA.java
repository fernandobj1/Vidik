package testFinal;

public class AAA extends A{
	public void metodoPublico(){ //para verificar o "final" na classe A, retire a palavra final de metodopublico
		System.out.println("ClasseA1 - metodo publico");
	}
	public void metodoPublicoClasseMae(){
		super.metodoPublico();
	}
}
