import kotlin.random.Random

fun main() {
    var lista: ListaDinamica = ListaDinamica()
    var margeSort: MargeSort = MargeSort()
    var cont = 0

    for (i in 0..<10000){
        lista.anexar(Random.nextInt(0,100))
    }

    for (i in 0..<10000){
        if (lista.selecionar(i) == 0){
            cont++
        }
    }

    println(lista)

    lista = margeSort.margeSort(lista)
    println("${cont} zeros")

    println(lista)
}