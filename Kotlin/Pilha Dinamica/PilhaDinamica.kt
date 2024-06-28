class PilhaDinamica(private val tamanho: Int = 10): Empilhavel {
    private var ponteiroTopo: NoDuplo? = null
    private var quantidade = 0

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroTopo
            if (!estaVazia())
                ponteiroTopo?.proximo = noTemp


            ponteiroTopo = noTemp
            quantidade = quantidade.inc()

        }
    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            quantidade = quantidade.dec()
            if (!estaCheia()) { //Não é preciso dessa condição para tranformar o pontoriroTopo.proximo em null, uma vez q ja desimpilhamos um dado, logo a pilha n estara cheia
                ponteiroTopo?.proximo = null
            }
        } else {
            println("Pilha Vazia!")
        }
        return dadoTopo
    }

    override fun espiar(): Any? {
        if (!estaVazia()) {
            return ponteiroTopo
        } else {
            println("Pilha Vazia!")
            return null
        }
    }

    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroTopo?.dado = dado
        } else {
            println("Pilha Vazia!")
        }
    }

    override fun estaCheia(): Boolean {
        return (quantidade == tamanho)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {
        var ponteiroAux = ponteiroTopo
        var result = "["
        for (i in 0 until quantidade) {
            result += (ponteiroAux?.dado)
            if (i != quantidade-1) {
                result += ", "
            } else {
                result += "]"
            }
            ponteiroAux = ponteiroAux?.anterior
        }
        return result
    }
}