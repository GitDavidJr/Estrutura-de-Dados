class ListaDinamica(private var tamanho: Int = 10): Listavel {

    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade: Int = 0

    override fun anexar(dado: Any) {
        if(!estaCheia()){
            val dadoAux = NoDuplo(dado)
            dadoAux.anterior = ponteiroFim
            if(!estaVazia()){
                ponteiroFim?.proximo = dadoAux
            }else{
                ponteiroInicio = dadoAux
            }
            ponteiroFim = dadoAux
            quantidade.inc()
        }else{
            println("Fila esta cheia!")
        }
    }

    override fun inserir(posicao: Int, dado: Any) {
        if(!estaCheia()){
            if(posicao in 0..quantidade){
                val noTemp = NoDuplo(dado)
                var ponteiroAnterior: NoDuplo? = null
                val ponteiroProximo = ponteiroInicio

                for(i in 0 ..< posicao){
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo?.proximo
                }

                if(ponteiroAnterior != null){
                    ponteiroAnterior.proximo = noTemp
                } else{
                    ponteiroInicio = noTemp
                }

                if(ponteiroProximo != null){
                    ponteiroProximo.anterior = noTemp
                } else{
                    ponteiroFim = noTemp
                }

                noTemp.anterior = ponteiroAnterior
                noTemp.proximo = ponteiroProximo

                quantidade = quantidade.inc()
            } else{
                println("Indice invalido!")
            }
        } else{
            println("Lista esta cheia!")
        }
    }

    override fun selecionar(posicao: Int): Any? {
        var dadoAux: Any? = null
        if(!estaVazia()){
            if(posicao in 0..quantidade){
                var noTemp = ponteiroInicio
                for (i in 0 ..< posicao){
                noTemp = noTemp?.proximo
                }
                dadoAux = noTemp?.dado
            }else{
                println("Indice invalido")
            }
        }else{
            println("Lista vazia!")
        }
        return dadoAux
    }

    override fun selecionarTodas(): Array<Any?> {
        val dados: Array<Any?> = arrayOfNulls(quantidade)
        if(!estaVazia()){
            var noTemp = ponteiroInicio
            for (i in 0 ..< quantidade){
                dados[i] = noTemp?.dado
                noTemp = noTemp?.proximo
            }
        }else{
            println("Lista vazia!")
        }
        return dados
    }

    override fun atualizar(posicao: Int, dado: Any) {
        if(!estaVazia()){
            if (posicao in 0..quantidade){
                var noTemp = ponteiroInicio
                for(i in 0 ..<posicao){
                    noTemp = noTemp?.proximo
                }
                noTemp?.dado = dado
            }
        }
    }

    override fun apagar(posicao: Int): Any? {
        var dadoAux: Any? = null

        if(!estaVazia()){
            if(posicao in 0..quantidade){
                var ponteiroAux = ponteiroInicio
                for (i in 0 ..< posicao){
                    ponteiroAux = ponteiroAux?.proximo
                }
                dadoAux = ponteiroAux?.dado

                val ponteiroAnterior = ponteiroAux?.anterior
                val ponteiroProximo = ponteiroAux?.proximo

                if(ponteiroAnterior != null){
                    ponteiroAnterior.proximo = ponteiroProximo
                } else{
                    ponteiroInicio = ponteiroInicio?.proximo
                }

                if(ponteiroProximo != null){
                    ponteiroProximo.anterior = ponteiroAnterior
                }else{
                    ponteiroFim = ponteiroFim?.anterior
                }

                quantidade.dec()
            }else{
                println("Indice invalido")
            }
        }else{
            println("Lista vazia")
        }

        return dadoAux
    }

    override fun apagarTodos(): Array<Any?> {
        val dadosAux = selecionarTodas()
        limpar()
        return dadosAux
    }

    override fun limpar() {
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun estaCheia(): Boolean {
        return tamanho == quantidade
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var resultado = "["

        var ponteiroAux = ponteiroInicio

        for(i in 0 ..< quantidade){
            resultado += ponteiroAux?.dado
            if(i != quantidade-1){
                resultado += ", "
            }
            ponteiroAux = ponteiroAux?.proximo
        }

        return "$resultado]"
    }

    override fun tamanho(): Int {
        return tamanho
    }
}