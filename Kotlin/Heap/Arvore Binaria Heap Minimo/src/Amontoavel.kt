interface Amontoavel {

    fun inserir(dado: Long)
    fun obter(): Long?
    fun extrair(): Long?
    fun atualizar(dado: Long)

    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean

    // private fun indicePai(filho: Int): Int
    // private fun indiceFilhoEsquerdo(indice: Int): Int
    // private fun indiceFilhoDireito(indice: Int): Int
    // private fun trocar(indice1: Int, indice2: Int)
    // private fun ajustarCima(indice: Int)
    // private fun ajustarBaixo(pai: Int)
}