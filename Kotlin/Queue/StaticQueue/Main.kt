fun main() {
    // Criando uma pilha estática de Inteiros com capacidade 5
    val pilha = PilhaEstatica<Int>(5)

    // Empurrando elementos para a pilha
    pilha.empurrar(10)
    pilha.empurrar(20)
    pilha.empurrar(30)
    pilha.empurrar(40)
    pilha.empurrar(50)
    pilha.empurrar(60) // Este não será adicionado, pois a pilha tem capacidade de 5

    // Listando o item no topo da pilha
    println("Topo da pilha: ${pilha.topo()}") // 50

    // Retirando um item da pilha
    println("Item retirado: ${pilha.retirar()}") // 50
    println("Topo da pilha após retirar: ${pilha.topo()}") // 40

    // Verificando o tamanho da pilha
    println("Tamanho da pilha: ${pilha.tamanho()}") // 4

    // Tentando empurrar mais um item
    pilha.empurrar(60) // Agora a pilha está cheia, então não será possível adicionar
}
