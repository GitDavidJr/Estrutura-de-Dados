interface Empilhavel<T> {
    fun empurrar(item: T) // Adiciona um item na pilha
    fun retirar(): T? // Remove o item do topo da pilha
    fun topo(): T? // Retorna o item do topo da pilha, sem removê-lo
    fun vazia(): Boolean // Verifica se a pilha está vazia
    fun tamanho(): Int // Retorna o número de elementos na pilha
}
