class MargeSort {

    fun margeSort(lista: ListaDinamica): ListaDinamica{

        var indice = (lista.tamanho() -1)

        if(indice == 0){
            return lista
        }

        var lista1: ListaDinamica = ListaDinamica()
        var lista2:ListaDinamica = ListaDinamica()


        for(i in 0 ..(indice/2)){
            lista1.anexar(lista.selecionar(i)!!)
        }

        for(i in (indice/2)+1 .. indice){
            lista2?.anexar(lista.selecionar(i)!!)
        }

        lista1 = margeSort(lista1)
        lista2 = margeSort(lista2)

        return merge(lista1, lista2)
    }

    private fun merge(lista1: ListaDinamica, lista2: ListaDinamica): ListaDinamica{
        var lista3:ListaDinamica = ListaDinamica()

        while (!lista1.isEmpty() && !lista2.isEmpty()){
            if(lista1.selecionar(0)!! > lista2.selecionar(0)!!){
                lista3.anexar(lista2.selecionar(0)!!)
                lista2.remover(0)
            } else{
                lista3.anexar(lista1.selecionar(0)!!)
                lista1.remover(0)
            }
        }

        while (!lista1.isEmpty()){
            lista3.anexar(lista1.selecionar(0)!!)
            lista1.remover(0)
        }

        while (!lista2.isEmpty()){
            lista3.anexar(lista2.selecionar(0)!!)
            lista2.remover(0)
        }

        return lista3
    }
}