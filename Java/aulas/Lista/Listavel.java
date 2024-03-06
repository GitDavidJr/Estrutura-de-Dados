public interface Listavel {
    
    /*
    lista                           / List
    Listavel                        / Listable
    c = inserir , anexar            / insert, append
    r = selecionar, selecionarTodos / select, selectAll
    u = atualizar                   / update
    d = apagar, limpar              / delete, clean
    s = sort. ordenar (usado pricipalmente para otimizar buscas -> buscas binarias e ordenadas)
    ----
    Metodos auxiliares:

    imprimir = print
    esta vazio = isEmpty
    esta cheio = isFull
    */

    public void insert(Object dado);

    public Object select(int posição);

    public Object[] selectAll();

    public void update(int posição, Object dado);

    public Object apagar(int posição);

    public Object[] clean();
}
