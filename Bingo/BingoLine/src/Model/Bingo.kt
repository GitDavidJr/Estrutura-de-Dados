package Model

import Lista
import Cartela
import SortearNumero

class Bingo {

    private var vencedores = linkedSetOf<Cartela?>()
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
    fun excluirCartela(jogador: String): String {

        var mensagem = ""

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
                        mensagem =("Cartela excluida")
                        break
                    } else {
                        mensagem =("Nome invalido")
                    }
                } else {
                    mensagem = ("O bingo esta vazio")
                }

            } else
                mensagem = ("Cartela não encontrada")
        }

        return mensagem
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


    fun isEmpty(): Boolean {
        return (quantidade == 0)
    }

    fun isFull(): Boolean {
        return (quantidade == cartelasJogo.size)
    }

    fun sortear(sorteio: SortearNumero){

        sorteio.sortearNumero()
        bingo(sorteio)

    }


    /**
    Signature David
     **/

    private fun bingoV(sorteio: SortearNumero): MutableList<Cartela?> {
        val bingoCartelas: MutableList<Cartela?> = mutableListOf()
        val numerosSorteados = sorteio.getNumerosSorteados().toSet()

        for (i in 0 until quantidade) {
            val cartela = cartelasJogo[i]!!
            val acertos = IntArray(5) { 0 }
            var fezBingo = false

            // Passa por todos os números da cartela
            for (f in 0 until 25) {
                // Verifica se o número da cartela foi sorteado
                if (cartela.getNumeros()[f] in numerosSorteados) {
                    acertos[f % 5]++
                }

                // Verifica se fez bingo na coluna
                if (acertos[f % 5] == 5) {
                    bingoCartelas.add(cartela)
                    fezBingo = true
                    break // Sai do loop se a cartela já fez bingo
                }
            }
        }

        return bingoCartelas
    }

    private fun bingoH(sorteio: SortearNumero): MutableList<Cartela?> {
        val bingoCartelas: MutableList<Cartela?> = mutableListOf()
        val numerosSorteados = sorteio.getNumerosSorteados().toSet()

        for (i in 0 until quantidade) {
            val cartela = cartelasJogo[i]!!
            val acertos = IntArray(5) { 0 }
            var fezBingo = false

            // Passa por todos os números da cartela
            for (f in 0 until 25) {
                // Verifica se o número da cartela foi sorteado
                if (cartela.getNumeros()[f] in numerosSorteados) {
                    acertos[f / 5]++
                }

                // Verifica se fez bingo na linha
                if (acertos[f / 5] == 5) {
                    bingoCartelas.add(cartela)
                    fezBingo = true
                    break // Sai do loop se a cartela já fez bingo
                }
            }
        }

        return bingoCartelas
    }

    private fun bingoD(sorteio: SortearNumero): MutableList<Cartela?> {
        val bingoCartelas: MutableList<Cartela?> = mutableListOf()
        val numerosSorteados = sorteio.getNumerosSorteados().toSet()

        for (i in 0 until quantidade) {
            val cartela = cartelasJogo[i]!!
            val acertos = IntArray(2) { 0 } // Para diagonal principal e secundária

            // Verifica a diagonal principal (0, 6, 12, 18, 24)
            for (f in 0..24 step 6) {
                if (cartela.getNumeros()[f] in numerosSorteados) {
                    acertos[0]++
                }
            }

            // Verifica a diagonal secundária (4, 8, 12, 16, 20)
            for (f in 4..20 step 4) {
                if (cartela.getNumeros()[f] in numerosSorteados) {
                    acertos[1]++
                }
            }

            if (acertos[0] == 5 || acertos[1] == 5) {
                bingoCartelas.add(cartela)
            }
        }

        return bingoCartelas
    }

    private fun bingo(sorteio: SortearNumero): List<Cartela?> {

        // Adiciona cartelas que fizeram bingo diagonal
        vencedores.addAll(bingoD(sorteio))

        // Adiciona cartelas que fizeram bingo horizontal
        vencedores.addAll(bingoH(sorteio))

        // Adiciona cartelas que fizeram bingo vertical
        vencedores.addAll(bingoV(sorteio))

        // Converte para lista e retorna
        return vencedores.toList()
    }

    public fun getCartelas(): Array<Cartela?> {
        return cartelasJogo
    }

    public fun getVencedores(): LinkedHashSet<Cartela?> {
        return vencedores
    }
}
