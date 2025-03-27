class ListaEstatica<T>(private val capacidade: Int) : Listavel<T> {
    private val itens = arrayListOf<T?>() // Lista para armazenar os itens, com capacidade dinâmica.
    private var tamanhoAtual = 0

    // Adiciona um item na lista, desde que ainda haja espaço.
    override fun adicionar(item: T) {
        if (tamanhoAtual < capacidade) {
            itens.add(item)
            tamanhoAtual++
        } else {
            println("Capacidade da lista atingida, não é possível adicionar mais itens.")
        }
    }

    // Remove um item da lista, se ele existir.
    override fun remover(item: T) {
        if (itens.remove(item)) {
            tamanhoAtual--
        } else {
            println("Item não encontrado na lista.")
        }
    }

    // Retorna todos os itens da lista.
    override fun listar(): List<T> {
        return itens.filterNotNull()
    }

    // Retorna o número de itens atualmente na lista.
    override fun tamanho(): Int {
        return tamanhoAtual
    }
}
