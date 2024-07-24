import kotlin.random.Random

fun main() {

    var lista = arrayOfNulls<Int>(10)

    for(i in 0 ..< lista.size){
        lista[i] = Random.nextInt(0,100)
    }

    imprimirArray(lista)
    println()
    bubbleSort(lista)
    imprimirArray(lista)

}

fun bubbleSort(lista: Array<Int?>) {
    for(i in lista.indices){
        for(j in 0..<lista.size-1){
            if(lista[j]!! > lista[j+1]!!){
                swap(lista, j)
            }
        }
    }
}

fun imprimirArray(array: Array<Int?>) {
    for(i in array.indices){
        print("${array[i]} ")
    }
}

fun swap(array: Array<Int?>, indice1: Int) {
    val numAux = array[indice1]
    array[indice1] = array[indice1+1]
    array[indice1+1] = numAux
}
