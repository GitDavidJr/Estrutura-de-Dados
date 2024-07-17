class ABP(): Arboravel {

    var raiz: NoTriplo? = null

    override fun inserir(dado: Any?){
        val novoNo = NoTriplo(dado)

        if (raiz == null){
            raiz = novoNo
        } else {
            var noAux = raiz
            while (noAux != null) {

                if((noAux.dado as Int) > (dado as Int)){
                    if(noAux.esquerda != null){
                        noAux = noAux.esquerda
                    } else{
                        noAux.esquerda = novoNo
                        novoNo.genitor = noAux
                        break
                    }
                } else{
                    if(noAux.direita != null){
                        noAux = noAux.direita
                    } else{
                        noAux.direita = novoNo
                        novoNo.genitor = noAux
                        break
                    }
                }
            }
        }
    }

    override fun getRaiz(): NoTriplo? {
        return raiz
    }

    override fun buscar(dado: Any): NoTriplo? {
        TODO("Not yet implemented")
    }

    override fun apagar(dado: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun limpar() {
        TODO("Not yet implemented")
    }

    override fun imprimirPreOrdem(): String {
        return formataSaida(imprimirPreOrdemRec(raiz))
    }

    override fun imprimirEmOrdem(): String {
        return formataSaida(imprimirEmOrdemRec(raiz))
    }

    override fun imprimirPosOrdem(): String {
        return formataSaida(imprimirPosOrdemRec(raiz))
    }

    fun imprimirPreOrdemRec(pai: NoTriplo?): String {
        return "$pai.dado ${imprimirPreOrdemRec(pai?.esquerda)} ${imprimirPreOrdemRec(pai?.direita)}"
    }

    fun imprimirEmOrdemRec(pai: NoTriplo?): String {
        return "${imprimirPreOrdemRec(pai?.esquerda)} $pai.dado ${imprimirPreOrdemRec(pai?.direita)}"
    }

    fun imprimirPosOrdemRec(pai: NoTriplo?): String {
        return "${imprimirPreOrdemRec(pai?.esquerda)} ${imprimirPreOrdemRec(pai?.direita)} $pai.dado"
    }

    private fun formataSaida(msg: String): String {
        var resultado: String
        var mensagem = msg
        do {
            resultado = mensagem
            mensagem = mensagem.replace("  ", " ") //remove excesso de espaços
        } while (mensagem != resultado)
        mensagem = mensagem.trim() //remove espaços em branco do inicio e fim, se existir
        mensagem = mensagem.replace(" ", ",") //troca espaço por vírgula
        return "[$mensagem]"
    }
}