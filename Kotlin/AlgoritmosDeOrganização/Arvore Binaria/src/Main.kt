fun main() {

    var heapMin: ABP<Int> = ABP<Int>()

    heapMin.inserir(93)
    heapMin.inserir(52)
    heapMin.inserir(47)
    heapMin.inserir(31)
    heapMin.inserir(85)
    heapMin.inserir(9)
    heapMin.inserir(73)
    heapMin.inserir(83)
    heapMin.inserir(33)
    heapMin.inserir(55 )


    println(heapMin.imprimirPreOrdem())
    println(heapMin.imprimirEmOrdem())
    println(heapMin.imprimirPosOrdem())
}