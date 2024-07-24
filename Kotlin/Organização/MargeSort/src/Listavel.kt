interface Listavel {

    fun anexar(numero: Int)
    fun inserir(numero: Int, indice: Int)
    fun selecionar(posicao: Int): Int?
    fun selecionarTodos(): Array<Int?>
    fun atualizar(numero: Int, indice: Int)
    fun remover(indice:Int): Int?
    fun limpar()

    override fun toString(): String
    fun isFull(): Boolean
    fun isEmpty(): Boolean
    fun tamanho(): Int
}