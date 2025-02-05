class ArvoreHierarquica(val ceo: Funcionario) {

    fun adicionarFuncionario(superior: String, novoFuncionario: Funcionario): Boolean {
        val No = buscarFuncionario(ceo, superior)
        return if (No != null) {
            No.subordinados.add(novoFuncionario)
            true
        } else {
            false
        }
    }

    fun buscarFuncionario(funcionario: Funcionario, nome: String): Funcionario? {
        if (funcionario.nome == nome) {
            return funcionario
        }
        for (sub in funcionario.subordinados) {
            val encontrado = buscarFuncionario(sub, nome)
            if (encontrado != null) {
                return encontrado
            }
        }
        return null
    }

    fun removerFuncionario(nome: String): Boolean {
        return removerFuncionarioRecursivo(ceo, nome)
    }

    private fun removerFuncionarioRecursivo(pai: Funcionario, nome: String): Boolean {
        val iterator = pai.subordinados.iterator()
        while (iterator.hasNext()) {
            val filho = iterator.next()
            if (filho.nome == nome) {
                iterator.remove()
                return true
            }
            if (removerFuncionarioRecursivo(filho, nome)) {
                return true
            }
        }
        return false
    }

    fun detalhesFuncionario(nome: String): Funcionario? {
        return buscarFuncionario(ceo, nome)
    }

    fun imprimirHierarquia(funcionario: Funcionario = ceo, nivel: Int = 0) {
        println("${" ".repeat(nivel * 2)}- ${funcionario.nome} (${funcionario.cargo})")
        funcionario.subordinados.forEach { imprimirHierarquia(it, nivel + 1) }
    }

    fun imprimirRelacionamentos(nome: String) {
        val funcionario = buscarFuncionario(ceo, nome)
        if (funcionario != null) {
            println("${funcionario.nome} (${funcionario.cargo})")
            funcionario.subordinados.forEach { println("  -> ${it.nome} (${it.cargo})") }
        } else {
            println("Funcionário $nome não encontrado.")
        }
    }
}