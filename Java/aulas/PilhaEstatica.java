public class PilhaEstatica implements Empilhavel {

    // variaveis globais( de instancia)

    private int ponteiroTopo;
    private Object dados[];

    // construtores
    
    public PilhaEstatica() {
        this(10);
    }
        public PilhaEstatica(int tamanho) {
            ponteiroTopo = -1;
            dados = new Object[tamanho];
        }

        // metodos auxiliares

        public boolean estaCheia(){
            return (ponteiroTopo == (dados.length-1));
        }
        
        public boolean estaVazia() {
            return (ponteiroTopo == -1);
        }
        public String imprimir() {
            String resultado = "[";
            for(int i=ponteiroTopo; i == -1; i--){
                System.out.println(dados[i]);
            }
            return resultado;
        }
        // metodos principais 
        public Object topo(){
            Object retorno = null;
            if(!estaVazia()) {
                retorno = dados[ponteiroTopo];
            }else{
                System.out.println("Vazia");
            }
            return retorno;
        }
    
    public Object desempilhar(){
         Object retorno = null;
            if(!estaVazia()) {
                retorno = dados[ponteiroTopo];
                ponteiroTopo--;
            }else{
                System.out.println("Stack is empyt");
            }
            return retorno;
    }

      public void empilhar(Object dado){
        if(!estaCheia()){
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
            System.out.println(dado + " dado adicionado na pilha com sucesso.");
        }else{
            System.out.println("Stack is full");
        }
      }


 
}