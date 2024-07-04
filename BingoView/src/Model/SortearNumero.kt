import java.io.File.separator
import kotlin.random.Random

class SortearNumero {

    private var numero: Int = 0
    private var numerosSorteados: Lista<Int> = Lista()

    fun sortearNumero() {
        var numeroAleatorio: Int

        do {
            numeroAleatorio = Random.nextInt(1,100)
        } while (jaFoiSorteado(numeroAleatorio))

        numero = numeroAleatorio
        numerosSorteados.anexar(numero)
    }

    private fun jaFoiSorteado(numero: Int): Boolean {
        val todosNumerosSorteados = numerosSorteados.selecionarTodos()
        for (i in 0 .. todosNumerosSorteados.size - 1) {
            if (todosNumerosSorteados[i] == numero) {
                return true
            }
        }
        return false
    }

    fun getNumero(): Int {
        return numero
    }

    public fun getNumerosSorteados(): Array<Int> {
        val numerosValidos = numerosSorteados.selecionarTodos().filterNotNull().toTypedArray()
        return numerosValidos
    }


}