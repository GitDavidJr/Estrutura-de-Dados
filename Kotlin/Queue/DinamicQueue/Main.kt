fun main() {
    // Criando uma pilha dinâmica de Inteiros
    val pilha = PilhaDinamica<Int>()

    // Empurrando elementos para a pilha
    pilha.empurrar(10)
    pilha.empurrar(20)
    pilha.empurrar(30)
    pilha.empurrar(40)
    pilha.empurrar(50)

    // Listando o item no topo da pilha
    println("Topo da pilha: ${pilha.topo()}") // 50

    // Retirando um item da pilha
    println("Item retirado: ${pilha.retirar()}") // 50
    println("Topo da pilha após retirar: ${pilha.topo()}") // 40

    // Verificando o tamanho da pilha
    println("Tamanho da pilha: ${pilha.tamanho()}") // 4

    // Empurrando mais itens
    pilha.empurrar(60)
    pilha.empurrar(70)

    // Listando a pilha após mais adições
    println("Topo da pilha após mais adições: ${pilha.topo()}") // 70
    println("Tamanho da pilha após mais adições: ${pilha.tamanho()}") // 6
}
