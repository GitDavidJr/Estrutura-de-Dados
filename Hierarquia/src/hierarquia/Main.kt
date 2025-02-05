import hierarquia.Funcionario
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("------------ ESTRUTURA EMPRESARIAL ------------")
    println("Primeiro adicione o CEO da empresa: ")
    print("Nome do CEO: ")
    val nomeCEO = scanner.nextLine()
    val ceo = Funcionario(nomeCEO, "CEO")
    val arvore = ArvoreHierarquica(ceo)
    println("CEO adicionado com sucesso")
    println("-----------------------------------------------")

    do {
        println("---------------- MENU DE OPÇÕES ----------------")
        println("1. Inserir funcionário")
        println("2. Visualizar hierarquia completa")
        println("3. Buscar funcionário")
        println("4. Visualizar detalhes de um funcionário")
        println("5. Remover funcionário e seus subordinados")
        println("6. Visualizar os relacionamentos de um funcionário")
        println("7. Encerrar aplicação")
        println("-------------------------------------------------")
        print("\nOpção escolhida: ")
        var op = scanner.nextInt()
        scanner.nextLine()

        when (op) {
            1 -> {
                println("INSERIR FUNCIONÁRIO")
                print("Nome do funcionário: ")
                var nomeF = scanner.nextLine()
                print("Cargo do funcionário: ")
                var cargo = scanner.nextLine()
                var f = Funcionario(nomeF, cargo)
                print("Digite o superior do funcionário: ")
                var superior = scanner.nextLine()
                if (arvore.adicionarFuncionario(superior, f)) {
                    println("Funcionário adicionado com sucesso")
                } else {
                    println("Funcionário já existe")
                }
            }
            2 -> {
                println("VISUALIZAR HIERARQUIA COMPLETA")
                arvore.imprimirHierarquia()
            }
            3 -> {
                println("BUSCAR FUNCIONÁRIO")
                print("Nome do funcionário que deseja buscar: ")
                var nome = scanner.nextLine();
                println(arvore.buscarFuncionario(nome))
                var achado = arvore.buscarFuncionario(nome)
                if (achado.equals("\n$nome encontrado(a)", ignoreCase = true)) {
                    var valido = true
                    do {
                        print("Deseja ver os detalhes desse funcionário? [S/N]: ")
                        var resp = scanner.nextLine();
                        if (resp.equals("s", ignoreCase = true)) {
                            arvore.detalhesFuncionario(nome)
                            valido = true
                        } else if (resp.equals("n", ignoreCase = true)) {
                            break
                        } else {
                            println("Resposta inválida. Responda com S ou N!")
                            valido = false
                        }
                    } while (!valido)
                }
            }
            4 -> {
                println("VISUALIZAR DETALHES DE UM FUNCIONÁRIO")
                print("Nome do funcionário que deseja visualizar: ")
                var nomeF = scanner.nextLine()
                arvore.detalhesFuncionario(nomeF)
            }
            5 -> {
                println("REMOVER FUNCIONÁRIO E SEUS SUBORDINADOS")
                print("Nome do funcionário que deseja remover: ")
                var name = scanner.nextLine();
                if (arvore.removerFuncionario(name)) {
                    println("$name e seus subordinados removidos com sucesso")
                } else {
                    println("Funcionário não encontrado")
                }
            }
            6 -> {
                println("VISUALIZAR OS RELACIONAMENTOS DE UM FUNCIONÁRIO")
                print("Nome do funcionário que deseja vizualizar os relacionamentos: ")
                var nomeFu = scanner.nextLine()
                println(arvore.imprimirRelacionamentos(nomeFu))
            }
            7 -> {
                println("APLICAÇÃO ENCERRADA")
            }
            else -> {
                println("Operação inválida! Digite novamente.")
            }
        }
    } while (op != 7)

    /*val gerente1 = Funcionario("Julia", "Gerente")
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
    arvore.detalhesFuncionario("Julia")

    arvore.buscarFuncionario("Luis")

    println("\nRemovendo Luis e seus subordinados:")
    arvore.removerFuncionario("Luis")
    arvore.imprimirHierarquia()

    println("\nRelacionamentos de Julia:")
    arvore.imprimirRelacionamentos("Julia")*/
}