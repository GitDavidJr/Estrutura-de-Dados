class ListaDinamica: Listavel {

    var ponteiroInicio: NoDuplo? = null
    var ponteiroFim: NoDuplo? = null
    var quantidade = 0


    override fun anexar(numero: Int) {
        if(!isFull()){
            var noTemp = NoDuplo(numero)
            noTemp.anterior = ponteiroInicio
            if(!isEmpty()){
                ponteiroFim?.proximo = noTemp
            } else{
                ponteiroInicio = noTemp
            }

            quantidade = quantidade.inc()
            ponteiroFim = noTemp
        }
    }

    override fun inserir(numero: Int, indice: Int) {

        var noTemp = NoDuplo(numero)

        if(!isEmpty()){
            if(indice in 0..<quantidade){

                var ponteiroAnterior: NoDuplo? = null
                var ponteiroProximo = ponteiroInicio

                for (i in 0..<indice){
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo = ponteiroProximo?.proximo
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
            }
        }


    }

    override fun selecionar(posicao: Int): Int? {
        var dadoAux: Int? = null

        if(!isEmpty()){
            if(posicao in 0..<quantidade){


                var ponteiroAux = ponteiroInicio

                for(i in 0..<posicao){
                    ponteiroAux = ponteiroAux?.proximo
                }
                dadoAux = ponteiroAux?.dado
            }
        }

        return dadoAux
    }

    override fun selecionarTodos(): Array<Int?> {
        var arrayInt: Array<Int?> = arrayOfNulls(quantidade)

        if(!isEmpty()){
            var ponteiroAux = ponteiroInicio
            for(i in 0..<quantidade){
                arrayInt[i] = ponteiroAux?.dado
                ponteiroAux = ponteiroAux?.proximo
            }
        }

        return arrayInt
    }

    override fun atualizar(numero: Int, indice: Int) {
        if(!isEmpty()){
            if(indice in 0..<quantidade){
                var ponteiroAux = ponteiroInicio
                for(i in 0..<indice){
                    ponteiroAux = ponteiroAux?.proximo
                }
                ponteiroAux?.dado = numero
            }
        }
    }

    override fun remover(indice: Int): Int? {
        var dadoAux: Int? = null
        if(!isEmpty()){
            if(indice in 0..<quantidade){
                var ponteiroAux = ponteiroInicio
                for(i in 0..<indice){
                    ponteiroAux = ponteiroAux?.proximo
                }

                dadoAux = ponteiroAux?.dado
                var ponteiroAnterior = ponteiroAux?.anterior
                var ponteiroProximo = ponteiroAux?.proximo

                if(ponteiroAnterior != null){
                    ponteiroAnterior.proximo = ponteiroProximo
                }else{
                    ponteiroInicio = ponteiroInicio?.proximo
                }

                if(ponteiroProximo != null){
                    ponteiroProximo.anterior = ponteiroAnterior
                }else{
                    ponteiroFim = ponteiroFim?.anterior
                }

                quantidade = quantidade.dec()
            }
        }
        return dadoAux
    }

    override fun limpar(){
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun toString(): String {
        var result = "["

        if (!isEmpty()){
            var ponteritoAux = ponteiroInicio
            for(i in 0..<quantidade){
                result += ponteritoAux?.dado
                if(ponteritoAux?.proximo != null){
                    result += ", "
                }
                ponteritoAux = ponteritoAux?.proximo
            }
        }

        return "$result]"
    }

    override fun isFull(): Boolean {
        return false
    }

    override fun isEmpty(): Boolean {
        return quantidade == 0
    }

    override fun tamanho(): Int {
        return quantidade
    }


}