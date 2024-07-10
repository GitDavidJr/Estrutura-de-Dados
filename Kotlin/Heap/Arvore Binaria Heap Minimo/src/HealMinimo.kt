class HealMinimo(var tamanho: Int): Amontoavel {

    var ponteiroFim = 0
    var dados = LongArray(tamanho){0}

    override fun inserir(dado: Long) {
        if(!estaCheia()){
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarCima(ponteiroFim)
        }else{
            println("Heap esta cheia")
        }
    }

    override fun obter(): Long? {
        var dadoAux: Long? = null
        if(!estaCheia()){
            dadoAux = dados[0]
        }else{
            println("Heal vazio")
        }
        return dadoAux
    }

    override fun extrair(): Long? {
        var dadoAux: Long? = null

        if(!estaVazia()){
            dadoAux = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarBaixo(0)
        } else{
            println("Vazio")
        }

        return dadoAux
    }

    override fun atualizar(dado: Long) {
        if(!estaVazia()){
            dados[0] = dado
        }else{
            println("Vazio")

        }    }

    override fun imprimir(): String {
        var result = "["

        for(i in 0..ponteiroFim){
            result += dados[i]
            if(i != ponteiroFim){
                result += ", "
            }
        }

        return "$result]"
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == tamanho-1
    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    private fun indicePai(filho: Int): Int{
        return (filho-1)/2
    }

    private fun indiceFilhoEsquerdo(indice: Int): Int{
        return (indice*2) + 1
    }

    private fun indiceFilhoDireito(indice: Int): Int{
        return (indice*2) + 2
    }

    private fun trocar(indice1: Int, indice2: Int){
        var temp = dados[indice1]
        dados[indice1] = dados[indice2]
        dados[indice2] = temp
    }

    private fun ajustarCima(indice: Int){

        var indiceAtual = indice

        while(indiceAtual != 0){

            var pai = indicePai(indiceAtual)

            if(dados[indice] < dados[pai]){
                trocar(indiceAtual,pai)
                indiceAtual = pai
            } else{
                break
            }
        }


    }

    private fun ajustarBaixo(pai: Int){

        var indiceEsquerdo = indiceFilhoEsquerdo(pai)
        var indiceDireito = indiceFilhoDireito(pai)
        var menor = pai

        if(indiceEsquerdo <= ponteiroFim){
            if(dados[menor] > dados[indiceEsquerdo]){
                menor = indiceEsquerdo
            }
        }

        if(indiceDireito <= ponteiroFim){
            if(dados[menor] > dados[indiceDireito]){
                menor = indiceDireito
            }
        }

        if(menor != pai){
            trocar(pai, menor)
            ajustarBaixo(menor)
        }
    }
}