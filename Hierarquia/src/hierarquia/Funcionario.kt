package hierarquia

data class Funcionario(
    val nome: String,
    val cargo: String,
    var nivel: Int = 0,
    val subordinados: MutableList<Funcionario> = mutableListOf()
)