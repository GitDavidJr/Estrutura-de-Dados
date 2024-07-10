class ArvoreBinariaHeapMaximo(private val tamanho: Int = 10): Amontoavel {

    private var dados = LongArray(tamanho){0}
    private var ponteiroFim = -1

    override fun inserir(dado: Long) {
        if(!estaCheio()){
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarCima(ponteiroFim)
        }else{
            println("Pilha cheia")
        }
    }

    override fun extrair(): Long? {
        var dadoRaiz: Long? = null
        if(!estaVazio()){
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarBaixo(0)
        }
        return dadoRaiz
    }

    override fun obter(): Long? {
        var dadoRaiz: Long? = null
        if(!estaVazio()){
            dadoRaiz = dados[0]
        }else{
            println("Pilha vazia")
        }
        return dadoRaiz
    }

    override fun atualizar(dado: Long) {
        if(!estaVazio()){
            dados[0] = dado
        } else{
            println("Pilha vazia")
        }
    }

    override fun imprimir(): String {
        var result = "["
        for(i in 0..ponteiroFim){
            result += dados[i]
            if(i!=ponteiroFim){
                result += ", "
            }
        }
        return "$result]"
    }

    override fun estaCheio(): Boolean {
        return ponteiroFim == tamanho-1
    }

    override fun estaVazio(): Boolean {
        return ponteiroFim == -1
    }

    private fun indicePai(filho: Int): Int{
        return (filho-1)/2
    }

    private fun indiceFilhoEsquerdo(pai: Int): Int{
        return (pai*2)+1
    }

    private fun indiceFilhoDireito(pai: Int): Int{
        return (pai*2)+2
    }

    private fun ajustarBaixo(pai: Int){

        val filhoEsquerdo = indiceFilhoEsquerdo(pai)
        val filhoDireito = indiceFilhoDireito(pai)
        var maior = pai

        if(filhoEsquerdo <= ponteiroFim){
            if(dados[maior] < dados[filhoEsquerdo]){
                maior = filhoEsquerdo
            }
        }

        if(filhoDireito <= ponteiroFim){
            if(dados[maior] < dados[filhoDireito]){
                maior = filhoDireito
            }
        }

        if(maior != pai){
            trocar(pai,maior)
            ajustarBaixo(maior)
        }
    }

    private fun ajustarCima(indice: Int){
        var indiceAtual = indice
        while(indiceAtual != 0){
            val indicePai = indicePai(indiceAtual)
            if(dados[indicePai] > dados[indiceAtual]){
                trocar(indicePai,indiceAtual)
                indiceAtual = indicePai
            }else{
                break
            }
        }
    }

    private fun trocar(dado1: Int, dado2: Int){
        val temp = dados[dado1]
        dados[dado1] = dados[dado2]
        dados[dado2] = temp
    }


}