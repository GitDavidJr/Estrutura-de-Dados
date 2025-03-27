interface Listavel {

    fun anexar(dado: Any) //c
    fun inserir(posicao: Int, dado: Any) //c
    fun selecionar(posicao: Int): Any? //r
    fun selecionarTodas(): Array<Any?> //r
    fun atualizar(posicao: Int, dado: Any) //u
    fun apagar(posicao: Int): Any? //d
    fun apagarTodos(): Array<Any?>
    fun limpar() //d

    //metedos aux

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
    fun tamanho(): Int

}