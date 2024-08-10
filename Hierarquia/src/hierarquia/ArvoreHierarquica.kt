import hierarquia.Funcionario

class ArvoreHierarquica<T : Funcionario>(val ceo: T) {

    fun adicionarFuncionario(superior: String, novoFuncionario: T): Boolean {
        val No = busca(ceo, superior)
        return if (No != null) {
            novoFuncionario.nivel = No.nivel + 1
            No.subordinados.add(novoFuncionario)
            true
        } else {
            false
        }
    }

    fun busca(funcionario: T, nome: String): T? {
        if (funcionario.nome == nome) {
            return funcionario
        }
        for (sub in funcionario.subordinados) {
            val encontrado = busca(sub as T, nome)
            if (encontrado != null) {
                return encontrado
            }
        }
        return null
    }

    fun buscarFuncionario(nome: String): String {
        val encontrado = busca(ceo, nome)
        var retorno: String = null.toString()
        if (encontrado == null) {
            retorno = "\nFuncionário $nome não encontrado(a)."
        } else {
            retorno = "\n$nome encontrado(a)"
        }
        return retorno
    }

    fun buscarSuperior(funcionario: T, nome: String): T? {
        for (sub in funcionario.subordinados) {
            if (sub.nome == nome) {
                return funcionario
            }
            val superior = buscarSuperior(sub as T, nome)
            if (superior != null) {
                return superior
            }
        }
        return null
    }

    fun removerFuncionario(nome: String): Boolean {
        return removerFuncionarioRecursivo(ceo, nome)
    }

    private fun removerFuncionarioRecursivo(pai: T, nome: String): Boolean {
        val iterator = pai.subordinados.iterator()
        while (iterator.hasNext()) {
            val filho = iterator.next()
            if (filho.nome == nome) {
                iterator.remove()
                return true
            }
            if (removerFuncionarioRecursivo(filho as T, nome)) {
                return true
            }
        }
        return false
    }

    fun detalhesFuncionario(nome: String) {
        val funcionario = busca(ceo, nome)
        if (funcionario == null) {
            println("Funcionário $nome não encontrado.")
        } else {
            println("Nome: ${funcionario.nome}")
            println("Cargo: ${funcionario.cargo}")
            println("Nível: ${funcionario.nivel}")
        }
    }

    fun imprimirHierarquia(funcionario: T = ceo) {
        println("${" ".repeat(funcionario.nivel * 2)}- ${funcionario.nome} (${funcionario.cargo})")
        funcionario.subordinados.forEach { imprimirHierarquia(it as T) }
    }

    fun imprimirRelacionamentos(nome: String) {
        val funcionario = busca(ceo, nome)
        if (funcionario != null) {
            val superior = buscarSuperior(ceo, nome)
            if (superior != null) {
                println("${funcionario.nome} (${funcionario.cargo}) -> Superior: ${superior.nome} (${superior.cargo})")
            } else {
                println("${funcionario.nome} (${funcionario.cargo}) -> Sem superior")
            }
            funcionario.subordinados.forEach { println("  -> ${it.nome} (${it.cargo})") }
        } else {
            println("Funcionário $nome não encontrado.")
        }
    }
}
