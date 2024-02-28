public class PilhaEstatica implements Empilhavel {
    // variaveis globais( de instancia)
    private int ponteirotopo;
    private int dados[];
// construtores
public PilhaEstatica() {
    this(10);
}

public PilhaEstatica(int tamanho) {
ponteirotopo = -1;
dados = new int[tamanho];
}

// metodos auxiliares

public boolean estaCheia(){
    return (ponteirotopo == (dados.length-1));

}

public boolean estaVazia() {
return (ponteirotopo == -1);
}

public String imprimir() {
    String resultado = "[";

    for(int i=ponteirotopo; i == -1; i--)
    {
        System.out.println(dados[i]);

    }
    return resultado;
}
// metodos principais 
      public Object topo(){

if(!estaVazia() ) {
        return ( dados[ponteirotopo] );
}
        else {System.out.println("Vazia");
        }

        
      }
      

      public Object desempilhar(){
      if(!estaVazia()) {
        return (dados[ponteirotopo]);
} 
        else { System.out.println("Vazia");
        }
    }

      public void empilhar(Object dados);


 
}
