interface Listavel<T> {
    fun adicionar(item: T)
    fun remover(item: T)
    fun listar(): List<T>
    fun tamanho(): Int
}
