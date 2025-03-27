class ListaDinamica<T> : Listavel<T> {
    private var itens = arrayListOf<T>()  // Lista interna que cresce dinamicamente
    private var capacidade: Int = 10  // Tamanho inicial, que será aumentado conforme necessário

    // Adiciona um item na lista, aumentando a capacidade se necessário
    override fun adicionar(item: T) {
        if (itens.size >= capacidade) {
            capacidade *= 2  // Dobra a capacidade quando atinge o limite
            println("Capacidade aumentada para $capacidade")
        }
        itens.add(item)
    }

    // Remove um item da lista, se ele existir
    override fun remover(item: T) {
        if (itens.remove(item)) {
            println("Item $item removido.")
        } else {
            println("Item $item não encontrado na lista.")
        }
    }

    // Retorna todos os itens da lista
    override fun listar(): List<T> {
        return itens
    }

    // Retorna o número de itens atualmente na lista
    override fun tamanho(): Int {
        return itens.size
    }
}
