public class FilaEstaticaCircular implements Enfileiravel {

    private int ponteiroInicio = -1;
    private int ponteiroFim = 0;
    private int quantidade = 0;
    private Object[] dados;

    public FilaEstaticaCircular(){
        this(10);
    }

    public FilaEstaticaCircular(int tamanho){
        dados = new Object[tamanho];
    }


    public void enqueue(Object dado){
        
    if(!isFull()){
        ponteiroFim++;
        if(ponteiroFim == dados.length)
        ponteiroFim = 0;
        dados[ponteiroFim] = dado;
        quantidade++;
    }else{
        System.out.println("Queue is full!");
    }}

    public String print(){

        String resultado = "[";
        int aux = ponteiroInicio;
        for(int i = 0; i <= quantidade; i++){
            if(i == quantidade){
            resultado += (dados[i] + ",");
        }else{
            resultado += (dados[i] + "]");
        }
        aux++;
        if(aux == dados.length)
        aux = 0;
    }

        return resultado;
    }

    public boolean isEmpty(){
        return !(ponteiroInicio <= ponteiroFim);
    }
    
    public boolean isFull(){
        return ponteiroFim == (dados.length - 1);
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
			//patch para que a fila funcione de forma circular
			if (ponteiroInicio == dados.length) {
				ponteiroInicio = 0;
			}
			quantidade--;
			//fim do patch			
		} else {
			System.err.println("Fila Vazia!");
		}
		return dadoInicio;
	}

    public void update(Object dado){
        dados[ponteiroInicio] = dado;
    }
}
