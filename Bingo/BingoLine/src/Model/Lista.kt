class Lista<Integer>(var tamanho: Int = 75) {
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var quantidade = 0
    private var dados: Array<Int?> = arrayOfNulls(tamanho)
    private var cartelasJogo: Array<Cartela?> = arrayOfNulls(tamanho)
    //private var numerosSorteados: Array<Int?> = arrayOfNulls(tamanho)

    fun getQuantidade(): Int{
        return quantidade
    }

    fun isEmpty(): Boolean {
        return (quantidade == 0)
    }

    fun isFull(): Boolean {
        return (quantidade == dados.size)
    }

    fun anexar(dado: Int) {
        if (!isFull()) {
            ponteiroFim++
            if (ponteiroFim == dados.size) {
                ponteiroFim = 0
            }
            dados[ponteiroFim] = dado
            quantidade++
        } else {
            println("The list is full")
        }
    }

    fun selecionarTodos(): Array<Int?> {
        val dadosAux: Array<Int?> = arrayOfNulls(quantidade)
        if (!isEmpty()) {
            for (i in 0 until quantidade) {
                dadosAux[i] = dados[(ponteiroInicio + i) % dados.size]
            }
        }
        return dadosAux
    }

    fun selecionar(posicao: Int): Any? {
        var retorno: Int? = null
        if (!isEmpty()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                retorno = dados[posicaoFisica]
            } else {
                println("Invalid index")
            }
        } else {
            println("The list is empty")
        }
        return retorno
    }

    fun print(): String {
        var resultado = "["
        for (i in 0 until quantidade) {
            if (i == quantidade - 1) {
                resultado += "${dados[(ponteiroInicio + i) % dados.size]}"
            } else {
                resultado += "${dados[(ponteiroInicio + i) % dados.size]}, "
            }
        }
        return "${resultado}]"
    }

    fun atualizar(posicao: Int, dado: Int?) {
        if (!isEmpty()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                dados[posicaoFisica] = dado
            } else {
                println("Invalid index")
            }
        } else {
            println("The list is empty")
        }
    }

    fun inserir(posicao: Int, dado: Int?) {
        if (!isFull()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                var ponteiroAux = ponteiroFim + 1
                for (i in 0..quantidade - posicao) {
                    var anterior = ponteiroAux - 1
                    if (ponteiroAux == dados.size) {
                        ponteiroAux = 0
                    }
                    var atual = ponteiroAux
                    dados[atual] = dados[anterior]
                    ponteiroAux--
                    if (ponteiroAux == -1) {
                        ponteiroAux = dados.size - 1
                    }
                }
                dados[posicaoFisica] = dado
                ponteiroFim++
                if (ponteiroFim == dados.size) {
                    ponteiroFim = 0
                }
                quantidade++
            } else {
                println("Invalid index")
            }
        } else {
            println("The list is full")
        }
    }

    fun apagar(posicao: Int): Int? {
        var retorno: Int? = null
        if (!isEmpty()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % dados.size
                retorno = dados[posicaoFisica]
                var ponteiroAux = posicaoFisica
                for (i in 0 until quantidade - posicao) {
                    var atual = ponteiroAux % dados.size
                    var proximo = (ponteiroAux + 1) % dados.size
                    dados[atual] = dados[proximo]
                    ponteiroAux++
                }
                ponteiroFim--
                if (ponteiroFim == -1) {
                    ponteiroFim = dados.size - 1
                }
                quantidade--
            } else {
                println("Invalid index")
            }
        } else {
            println("The list is empty")
        }
        return retorno
    }

    fun toArray(): Array<Int?> {
        return dados.copyOf()
    }

    private fun trocar(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    //print
    fun imprimir() {
        for (item in dados) {
            print("$item ")
        }
        println("")
    }

    //sort
    fun ordenar() {
        for (i in 0 until dados.size - 1) {
            for (j in 0 until dados.size - i - 1) {
                if (dados[j]!! > dados[j + 1]!!)
                    trocar(j, j + 1)
            }
        }
    }

    fun add(cartela: Cartela?) {
        if (!isFull()) {
            ponteiroFim++
            if (ponteiroFim == cartelasJogo.size) {
                ponteiroFim = 0
            }
            cartelasJogo[ponteiroFim] = cartela
            quantidade++
        } else {
            println("The list is full")
        }
    }

    fun excluir(posicao: Int): Cartela? {
        var retorno: Cartela? = null
        if (!isEmpty()) {
            if (posicao >= 0 && posicao < quantidade) {
                var posicaoFisica = (ponteiroInicio + posicao) % cartelasJogo.size
                retorno = cartelasJogo[posicaoFisica]
                var ponteiroAux = posicaoFisica
                for (i in 0 until quantidade - posicao) {
                    var atual = ponteiroAux % cartelasJogo.size
                    var proximo = (ponteiroAux + 1) % cartelasJogo.size
                    cartelasJogo[atual] = cartelasJogo[proximo]
                    ponteiroAux++
                }
                ponteiroFim--
                if (ponteiroFim == -1) {
                    ponteiroFim = cartelasJogo.size - 1
                }
                quantidade--
            } else {
                println("Invalid index")
            }
        } else {
            println("The list is empty")
        }
        return retorno
    }

    private fun troca(i: Int, j: Int) {
        val temp = cartelasJogo[i]
        cartelasJogo[i] = cartelasJogo[j]
        cartelasJogo[j] = temp
    }

    //sort
    fun sort() {
        for (i in 0 until cartelasJogo.size - 1) {
            for (j in 0 until cartelasJogo.size - i - 1) {
                if (cartelasJogo[j]!!.pontos > cartelasJogo[j + 1]!!.pontos)
                    troca(j, j + 1)
            }
        }
    }
}