class PilhaDinamica<T> : Pilha<T> {
    private val itens = mutableListOf<T>()  // Usando MutableList para permitir adição e remoção dinâmicas

    // Adiciona um item na pilha
    override fun empurrar(item: T) {
        itens.add(item)
    }

    // Remove o item do topo da pilha e retorna ele
    override fun retirar(): T? {
        return if (vazia()) {
            println("Pilha vazia. Não há itens para remover.")
            null
        } else {
            itens.removeAt(itens.size - 1)  // Remove o último item da lista (topo da pilha)
        }
    }

    // Retorna o item do topo da pilha sem removê-lo
    override fun topo(): T? {
        return if (vazia()) {
            println("Pilha vazia. Não há itens no topo.")
            null
        } else {
            itens[itens.size - 1]  // Retorna o último item sem removê-lo
        }
    }

    // Verifica se a pilha está vazia
    override fun vazia(): Boolean {
        return itens.isEmpty()
    }

    // Retorna o número de elementos na pilha
    override fun tamanho(): Int {
        return itens.size
    }
}
