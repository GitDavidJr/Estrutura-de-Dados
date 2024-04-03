//Heap = Monte
//Heapify = Organizar dados na forma de um Heap
//Heapifiable = Amontoavel
public interface Amontoavel<T> {
	//insert
	public void inserir(T dado);
	//extract
	T extrair();
	//get
	T obterRaiz();
	//print
	String imprimir();
	//isEmpty
	boolean estaVazia();
	//isFull
	boolean estaCheia();
}