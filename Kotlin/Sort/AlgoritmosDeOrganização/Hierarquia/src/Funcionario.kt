data class Funcionario(
    val nome: String,
    val cargo: String,
    val subordinados: MutableList<Funcionario> = mutableListOf()
)