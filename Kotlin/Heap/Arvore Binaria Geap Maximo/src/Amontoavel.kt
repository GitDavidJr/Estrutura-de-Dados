interface Amontoavel {

    fun inserir(dado: Long)
    fun extrair(): Long?
    fun obter(): Long?
    fun atualizar(dado: Long)

    fun imprimir(): String
    fun estaCheio(): Boolean
    fun estaVazio(): Boolean

    //private fun indicePai(filho: Int): Int
    //private fun indiceFilhoEsquerdo(pai: Int): int
    //private fun indiceFilhoDireito(pai: Int): Int
    //private fun ajustarBaixo(pai: Int)
    //private fun ajustarCima(indice: Int)
    //private fun trocar(dado1: Int, dado2: Int)
}