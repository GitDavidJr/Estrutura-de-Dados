fun main() {
    val ceo = Funcionario("João", "CEO")
    val arvore = ArvoreHierarquica(ceo)

    val gerente1 = Funcionario("Julia", "Gerente")
    val gerente2 = Funcionario("Luis", "Gerente")
    val empregado1 = Funcionario("David", "Desenvolvedor")
    val empregado2 = Funcionario("Rebeca", "Desenvolvedor")
    val empregado3 = Funcionario("Luisa", "Desenvolvedor")

    arvore.adicionarFuncionario("João", gerente1)
    arvore.adicionarFuncionario("João", gerente2)
    arvore.adicionarFuncionario("Julia", empregado1)
    arvore.adicionarFuncionario("Julia", empregado2)
    arvore.adicionarFuncionario("Luis", empregado3)

    println("Hierarquia:")
    arvore.imprimirHierarquia()

    println("\nDetalhes do Funcionário Julia:")
    val detalhesJulia = arvore.detalhesFuncionario("Julia")
    println(detalhesJulia)

    println("\nRemovendo Luis e seus subordinados:")
    arvore.removerFuncionario("Luis")
    arvore.imprimirHierarquia()

    println("\nRelacionamentos de Julia:")
    arvore.imprimirRelacionamentos("Julia")
}