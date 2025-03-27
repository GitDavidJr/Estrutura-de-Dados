fun main() {
    // Criando uma lista estática de Inteiros com capacidade de 5 elementos
    val lista = ListaEstatica<Int>(5)

    // Adicionando elementos
    lista.adicionar(10)
    lista.adicionar(20)
    lista.adicionar(30)
    lista.adicionar(40)
    lista.adicionar(50)
    lista.adicionar(60) // Este não será adicionado, pois a capacidade da lista é 5

    // Listando os itens
    println("Itens da lista: ${lista.listar()}") // [10, 20, 30, 40, 50]

    // Removendo um item
    lista.remover(30)
    println("Itens da lista após remover 30: ${lista.listar()}") // [10, 20, 40, 50]

    // Verificando o tamanho da lista
    println("Tamanho da lista: ${lista.tamanho()}") // 4
}
