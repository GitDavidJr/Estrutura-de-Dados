public interface Empilhavel{

    /*
    Pilha                / Stack
    Empilhavel           / Stackable
    c = empilhar         / push
    r = topo             / top
    u = ----------------------------
    d = desempilhar      / pop
    ----
    Metodos auxiliares:

    imprimir = print
    esta vazio = isEmpty
    esta cheio = isFull
    */

    public Object topo();

    public Object desempilhar();

    public void empilhar(Object Dado);

    public boolean estaCheia();

    public boolean estaVazia();

    public String imprimir();

} 