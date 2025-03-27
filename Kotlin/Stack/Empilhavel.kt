interface Empilhavel {
    //fun main
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun espiar(): Any?
    fun atualizar(dado: Any?)
    //fun aux
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}