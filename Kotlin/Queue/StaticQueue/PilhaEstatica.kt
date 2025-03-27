class PilhaEstatica<T>(private val capacidade: Int) : Pilha<T> {
    private val itens = arrayOfNulls<Any>(capacidade) // Array para armazenar os itens
    private var topo = -1 // Índice do topo da pilha, começa como -1 (vazia)

    // Adiciona um item na pilha, se houver espaço
    override fun empurrar(item: T) {
        if (topo < capacidade - 1) {
            topo++
            itens[topo] = item
        } else {
            println("Pilha cheia. Não é possível adicionar o item.")
        }
    }

    // Remove o item do topo da pilha e retorna ele
    override fun retirar(): T? {
        if (topo == -1) {
            println("Pilha vazia. Não há itens para remover.")
            return null
        }
        val item = itens[topo]
        topo--
        return item as T
    }

    // Retorna o item do topo da pilha sem removê-lo
    override fun topo(): T? {
        return if (topo == -1) {
            println("Pilha vazia. Não há itens no topo.")
            null
        } else {
            itens[topo] as T
        }
    }

    // Verifica se a pilha está vazia
    override fun vazia(): Boolean {
        return topo == -1
    }

    // Retorna o número de elementos na pilha
    override fun tamanho(): Int {
        return topo + 1
    }
}
