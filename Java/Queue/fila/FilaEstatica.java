public class FilaEstatica implements Enfileiravel {

    //varíaveis de instancia
    private int ponteiroInicio = 0;
    private int ponteiroFim = -1;
    private Object dados[];

    //construtures
    public FilaEstatica(){
        this(10);
    }

    public FilaEstatica(int tamanho){

        dados = new Object[tamanho];
    }
    //metodos auxiliares

    public String print(){

        String resultado = "[";
        for(int i = ponteiroInicio; i <= ponteiroFim; i++){
            if(i == ponteiroFim){
            resultado += (dados[i] + ",");
        }else{
            resultado += (dados[i] + "]");
        }}

        return resultado;
    }

    public boolean isEmpty(){
        return !(ponteiroInicio <= ponteiroFim);
    }
    
    public boolean isFull(){
        return ponteiroFim == (dados.length - 1);
    }

    //metodos principais
    public void enqueue(Object dado){
        if(!isFull()){
            ponteiroFim++;
            dados[ponteiroFim] = dado;
        }else{
            System.out.println("Queue is full");
        }
    }

    public Object peek(){
		Object dadoInicio = null;
		if (!isEmpty()) {
			dadoInicio = dados[ponteiroInicio];
		} else {
			System.err.println("Queue is Empty");		
		}
		return dadoInicio;
    }
    

    public Object dequeue(){
        Object dadoInicio = null;
		if (!isEmpty()) {
			dadoInicio = dados[ponteiroInicio];
			ponteiroInicio++;
		} else {
			System.err.println("Queue is Empty");
		}
		return dadoInicio;	
    }

    public void update(Object dado){
        dados[ponteiroInicio] = dado;
    }

}
