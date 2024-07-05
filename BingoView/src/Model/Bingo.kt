package Model

import Lista
import Cartela
import SortearNumero

class Bingo {

    private var vencedores: MutableList<Cartela> = mutableListOf<Cartela>() //vai organizar os vencedores em ordem
    private var quantidade = 0
    private var cartelas: Lista<Cartela> = Lista() //@david não sei se precisa dessa variavel
    private var cartelasJogo: Array<Cartela?> = arrayOfNulls(20) // @David: tamanho tive que deixar previamente descidido pelo sistema, pois preciso chamar a variavel da classe Bingo antes de descidir quantos vai participar, essa metodologia leva ao sistema delimitar a quantidade maxima de participantes
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    //Recebe uma cartela e verifica se ela é igual a alguma outra cartela do array, caso seja diferente, insere a cartela no final do array e retorna true, caso contrario retorna false
    fun incluirCartela(cartela: Cartela) {
        for (i in 0 until cartelasJogo.size - 1) {
            if (cartelasJogo[i]?.component1().equals(cartela.component1(), ignoreCase = true)) {
                println("Ja existe essa cartela")
                break
            } else {
                if (!isFull()) {
                    ponteiroFim++
                    cartelasJogo[ponteiroFim] = cartela
                    quantidade++
                    println("Cartela adicionada com sucesso!")
                    break
                } else {
                    println("O bingo já está cheio!")
                }
            }
        }
    }


    //Recebe o nome do jogador, localiza sua cartela e muda seu nome. Caso o processo seja executado com sucesso retorna true, caso contrario retorna false
    //cartelasJogo equivale a "dados" nas listas desenvolvidas em sala
    fun alterarJogador(jogadorAntigo: String, jogadorNovo: String) {
        for (i in 0 until cartelasJogo.size - 1) {
            if (cartelasJogo[i]?.nome.equals(jogadorAntigo, ignoreCase = true)) {
                cartelasJogo[i]?.nome = jogadorNovo
                println("Nome alterado com sucesso!")
                break
            } else
                println("Nao foi possivel localizar esse jogador :/")
        }

    }

    //Recebe o nome do jogador e localiza sua cartela, caso consiga localizar a cartela, ela é excluida.
    fun excluirCartela(jogador: String) {
        for (i in 0 until cartelasJogo.size - 1) {
            if (cartelasJogo[i]?.getJogador().equals(jogador, ignoreCase = true)) {
                var posicao = i
                if (!isEmpty()) {
                    if (posicao >= 0 && posicao < quantidade) {
                        var posicaoFisica = (ponteiroInicio + posicao) % cartelasJogo.size
                        var ponteiroAux = posicaoFisica
                        for (j in 0 until quantidade - posicao) {
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
                        println("Cartela excluida")
                        break
                    } else {
                        println("Nome invalido")
                    }
                } else {
                    println("O bingo esta vazio")
                }

            } else
                println("Cartela não encontrada :/")
        }
    }

    //Cria um array de String com os nomes dos jogadores que possuem o numero sorteado na cartela
    fun verificarJogadoresSorteio(numeroSorteado: Int) {
        for (i in 0 until cartelasJogo.size - 1) {
            if (cartelasJogo[i]!!.contemNumero(numeroSorteado)) {
                println(cartelasJogo[i]?.nome + "\n")
            } else {
                println("Nenhum jogador possui esse numero!")
            }
        }
    }

    fun verificarVencedores() {
        var vencedores = ""
        for (i in 0 until cartelasJogo.size) {
            if (cartelasJogo[i]!!.pontos == 25)
                println("Vencedores até o momento: " + cartelasJogo[i]?.nome)
        }
    }

    //retorna o array com nome dos jogadores e suas cartelas na ordem em que foram inseridos.
    // @david fiz uma mudanças pos não estava retornarno um array com os nomes
    fun getJogadores(): MutableList<String?> {

        var nomes: MutableList<String?> = mutableListOf()

        for(i in 0 .. quantidade - 1 ){
            nomes.add(cartelasJogo[i]?.nome)
        }
        return nomes
    }

    //numeros na ordem que foram sorteados
    fun consultarNumSorteados(sorteio: SortearNumero) {  //igual getNumerosSorteados
        println("Numeros sorteados ate o momento: ")
        println(sorteio.getNumerosSorteados().contentToString())
    }

    //numeros em ordem crescente
    fun consultarNumOrdemCrescente(sorteio: SortearNumero) {
        println("Numeros sorteados em ordem crescente: ")
        var numeros = sorteio.getNumerosSorteados()
        for (i in 0 until numeros.size - 1) {
            for (j in 0 until numeros.size - i - 1) {
                if (numeros[j]!! > numeros[j + 1]!!) {
                    val temp = numeros[j]
                    numeros[j] = numeros[j + 1]
                    numeros[j + 1] = temp
                }
            }
        }
        println(numeros.contentToString())
    }

    //ordena as cartelas em quantidade de numeros sorteados em ordem decrescente e retorna o nome do jogador e a quantidade de numeros sorteados dele
    fun consultarQtdNumSorteados() {

        for (i in 0 until cartelasJogo.size - 1) {
            for (j in 0 until cartelasJogo.size - i - 1) {
                if (cartelasJogo[j]!!.pontos < cartelasJogo[j + 1]!!.pontos) {
                    val temp = cartelasJogo[j]
                    cartelasJogo[j] = cartelasJogo[j + 1]
                    cartelasJogo[j + 1] = temp
                }
            }
        }
        for (i in 0 until cartelasJogo.size) {
            println(cartelasJogo[i]!!.nome + " possui " + cartelasJogo[i]!!.pontos + " pontos até o momento")
        }
    }


    //retorna os numeros nao sorteados da cartela de cada jogador
    fun consultarNumNaoSorteados(sorteio: SortearNumero) {
        for (i in 0 until cartelasJogo.size - 1) {
            for (j in 0 until cartelasJogo.size - i - 1) {
                if (cartelasJogo[j]!!.pontos < cartelasJogo[j + 1]!!.pontos) {
                    val temp = cartelasJogo[j]
                    cartelasJogo[j] = cartelasJogo[j + 1]
                    cartelasJogo[j + 1] = temp
                }
            }
        }
        for (i in 0 until cartelasJogo.size) {
            println(cartelasJogo[i]!!.nome + " possui " + ((25) - (cartelasJogo[i]!!.pontos)) + " números não sorteados até o momento")
        }
    }


    fun isEmpty(): Boolean {
        return (quantidade == 0)
    }

    fun isFull(): Boolean {
        return (quantidade == cartelasJogo.size)
    }

    fun sortear(sorteio: SortearNumero): MutableList<Cartela> {

        sorteio.sortearNumero()
        bingo(sorteio)




        return vencedores

        /**
        for (c in 0 until cartelasJogo.size) { //passar pela cartela de todos os jogadores
            var numerosCartela = cartelasJogo[c]?.getNumeros()
            for (i in 0 until numerosCartela!!.size) { //passar por cada numero de cada cartela individual
                if (numerosCartela[i] == sorteio.getNumero())
                    cartelasJogo[c]!!.pontos = cartelasJogo[c]!!.pontos.inc()
            }
        }
        **/
    }


    /**
    Signature David
     **/

    private fun bingoV(sorteio: SortearNumero): MutableList<Cartela?> { // pode ser que 1 numero sorteado novo seja responsavel por dar bingo em mais de uma cartela tendo a nescecidade de retornar mais de uma

        //array de cartelas que fizeram bingo
        var bingoCartelas: MutableList<Cartela?> = mutableListOf()

        // variavel acertos irar controlar quantos numeros foi sorteado por linha, sendo representado por um array onde cada casa do array representa uma linha
        val acertos = IntArray(5)
        acertos.fill(0)

        //passa por todas cartelas
        for (i in 0..<quantidade) {

            //passa por todos os numeros da cartela
            for (f in 0..<24) {

                //passa por todos os numeros sorteados
                for (j in 0..<sorteio.getQuantidade()) {

                    //confere se o numero da cartela ja foi sorteado
                    if (cartelasJogo[i]!!.getNumeros()[f] == sorteio.getNumerosSorteados()[j]) {

                        //se tiver sido sorteado incrementa a sequencia. Se vc pegar o resto do numero do indice do numero da tabela dividido por 5 vc consegue qual Coluna o numero da tabela esta
                        acertos[(f % 5)]++
                    }
                }

                //confere se fez bingo na coluna e adiciona no array que registra as cartelas que fizeram bingo com o ultimo sorteio
                if(acertos[(f % 5)] == 5){
                    bingoCartelas.add(cartelasJogo[i])
                }

            }
        }
        return bingoCartelas
    }

    private fun bingoH(sorteio: SortearNumero): MutableList<Cartela?> { // pode ser que 1 numero sorteado novo seja responsavel por dar bingo em mais de uma cartela tendo a nescecidade de retornar mais de uma

        //array de cartelas que fizeram bingo
        var bingoCartelas: MutableList<Cartela?> = mutableListOf()

        // variavel acertos irar controlar quantos numeros foi sorteado por linha, sendo representado por um array onde cada casa do array representa uma linha
        val acertos = IntArray(5)
        acertos.fill(0)

        //quantidade de bingos
        var bingos = 0

        //passa por todas cartelas
        for (i in 0..<quantidade) {

            //passa por todos os numeros da cartela
            for (f in 0..<24) {

                //passa por todos os numeros sorteados
                for (j in 0..<sorteio.getQuantidade()) {

                    //confere se o numero da cartela ja foi sorteado
                    if (cartelasJogo[i]!!.getNumeros()[f] == sorteio.getNumerosSorteados()[j]) {

                        //se tiver sido sorteado incrementa a sequencia. Se vc dividir o numero do indice do numero da tabela por 5 vc consegue qual linha o numero da tabela esta
                        acertos[(f / 5)]++
                    }



                }

                //confere se fez bingo na linha e adiciona no array que registra as cartelas que fizeram bingo com o ultimo sorteio
                if(acertos[(f / 5)] == 5){
                    bingoCartelas.add(cartelasJogo[i])
                }

            }
        }
        return bingoCartelas
    }

    private fun bingoD(sorteio: SortearNumero): MutableList<Cartela?> {

        //array de cartelas que fizeram bingo
        var bingoCartelas: MutableList<Cartela?> = mutableListOf()

        // variavel acertos irar controlar quantos numeros foi sorteado por diagonal sendo o indice 0 a diagonal que começa no 0 e o indice 1 na diagonal que começa no 4
        val acertos = IntArray(2)
        acertos.fill(0)

        //passa por todas cartelas
        for (i in 0..<quantidade) {

            // passa pelos numeros na diagonal que começa no 0
            for (f in 0..24 step 6) {

                //passa por todos os numeros sorteados
                for (j in 0..<sorteio.getQuantidade()) {

                    //confere se o numero da cartela com o numero que ja foi sorteado
                    if (cartelasJogo[i]!!.getNumeros()[f] == sorteio.getNumerosSorteados()[j]) {

                        //se tiver sido sorteado incrementa a sequencia
                        acertos[0]++
                    }
                }
            }

            if (acertos[0] == 5) {
                bingoCartelas.add(cartelasJogo[i])
            }
        }

        //passa por todas cartelas
        for (i in 0..<quantidade) {

            // passa pelos numeros na diagonal que começa no 4
            for (f in 4..20 step 4) {

                //passa por todos os numeros sorteados
                for (j in 0..<sorteio.getQuantidade()) {

                    //confere se o numero da cartela com o numero que ja foi sorteado
                    if (cartelasJogo[i]!!.getNumeros()[f] == sorteio.getNumerosSorteados()[j]) {

                        //se tiver sido sorteado incrementa a sequencia
                        acertos[1]++
                    }
                }
            }

            if (acertos[1] == 5) {
                bingoCartelas.add(cartelasJogo[i])
            }
        }

        return bingoCartelas
    }

    private fun bingo(sorteio: SortearNumero): MutableList<Cartela> {

        //passa por todas as cartelas que fizeram bingo na vertical
        for(i in 0..<bingoV(sorteio).size){
            var rep = 0
            //passa por todos os vencedores
            for(f in 0..<vencedores.size){

                //verifica se a cartela que fez bingo ja foi registrada como vencedora
                if(bingoV(sorteio)[i]!!.getJogador().equals(vencedores[f].getJogador())){

                }
            }
        }

        return vencedores
    }

    public fun getCartelas(): Array<Cartela?> {
        return cartelasJogo
    }

    public fun getVencedores(): MutableList<Cartela> {
        return vencedores
    }
}
