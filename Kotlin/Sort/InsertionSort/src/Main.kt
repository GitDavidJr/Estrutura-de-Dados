import kotlin.random.Random

fun main() {
    println("Hello World!")

    var array = arrayOfNulls<Int>(10)

    for (i in array.indices) {
        array[i] = Random.nextInt(0,100)
    }

    imprimirArray(array)
    println()
    insertionSort(array)
    imprimirArray(array)
}

fun insertionSort(array: Array<Int?>){
    for (i in array.indices){
        var j = i
        while(j > 0 && array[j-1]!! > array[j]!!){
            swap(array, j)
            j=j.dec()
        }
    }
}

fun swap(array: Array<Int?>, indice: Int) {
    val numAux = array[indice]
    array[indice] = array[indice-1]
    array[indice-1] = numAux
}

fun imprimirArray(array: Array<Int?>) {
    for(i in array.indices){
        print("${array[i]} ")
    }
}