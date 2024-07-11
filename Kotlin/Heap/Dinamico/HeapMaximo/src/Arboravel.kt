interface Arboravel {

    fun inserir(dado: Any?)// pq vc pode chamar a função com o parametro null? /C
    fun getRaiz(): NoTriplo? // r
    fun buscar(dado: Any): NoTriplo? // r
    fun apagar(dado: Any?): Boolean // pq vc pode chamar a função com o parametro null? //d
    fun limpar() //d

    fun imprimirPreOrdem(): String
    fun imprimirEmOrdem(): String
    fun imprimirPosOrdem(): String

}