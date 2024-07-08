package Controller

import Bingo
import Cartela
import Controller.Helper.HelperCartela
import Controller.Helper.HelperMenuPrincipal
import SortearNumero
import View.CartelaView
import View.MenuPrincipal
import javax.swing.DefaultListModel

class ControllerMenu(private val view: MenuPrincipal) {

    //variaveis de controle
    private var tamanho = 20
    private var start = false
    private var vencedoresQnt = 0
    private var viewQnt = 0

    //models
    private var bingo = Bingo(tamanho)
    private var sorteio: SortearNumero = SortearNumero()

    //Cartela View
    private var cartelaView: Array<CartelaView?> = arrayOfNulls(tamanho)

    //helper
    private val helper: HelperMenuPrincipal = HelperMenuPrincipal(view)
    private var helperCartela: Array<HelperCartela?> = arrayOfNulls(tamanho)

    fun incluirCartela() {

        if (!start) {

            cartelaView[viewQnt] = (CartelaView())
            helperCartela[viewQnt] = (HelperCartela(cartelaView[viewQnt]))
            viewQnt = viewQnt.inc()

            var cartela: Cartela = Cartela(helper.getNome())

            cartela.gerarNumerosDaCartela()

            if(bingo.incluirCartela(cartela)){

            view.listaCartelas.model = DefaultListModel<String>().apply {

                bingo.getJogadores().forEach { addElement(it) }
            }
                val controllerCartela: ControllerCartela = ControllerCartela(cartelaView[viewQnt -1])
                controllerCartela.novaCartela(helper.getNome(), cartela)
                cartelaView[viewQnt - 1]!!.isVisible = true

                helper.cleanNome()

            }else{
                view.exibirMensagem("Não foi possivel adicionar Cartela. Cartela repetida ou bingo cheio")
                helper.cleanNome()
            }
        } else{
            view.exibirMensagem("Jogo já começou, não é possivel adicionar nova cartela")
        }
    }

    fun sortear() {

        if(!start) start = true

        bingo.sortear(sorteio)

        //adicionar numero na lista
        view.listaNumerosSorteados.model = DefaultListModel<String>().apply {
            sorteio.getNumerosSorteados().forEach { addElement(it.toString()) }
        }

        for(i in 0 ..<viewQnt){
            helperCartela[i]!!.setCor(sorteio)
        }

        bingo.verificarVencedores()

        println(bingo.getVencedores().contentToString())
        println("Vencedores ${bingo.getQuantidadeVencedores()}")



        for(i in vencedoresQnt..<bingo.getQuantidadeVencedores()){
            view.exibirGanhador(bingo.getVencedores()[i]?.getJogador())
            vencedoresQnt++
        }

    }

    public fun excluir(){

        if(!start){

            var cartelaExcluida = bingo.excluirCartela(helper.getNome())

            if (cartelaExcluida != null) {
                view.exibirMensagem("Cartela " + cartelaExcluida.getJogador() + " Excluida")

                for(i in 0..<viewQnt){

                    println()
                    println("Cartela encontrada: ${helperCartela[i]!!.getCartelaView()!!.getJogador()}")
                    println("Cartela que quero excluir: ${cartelaExcluida.getJogador()}")
                    println()

                    if(helperCartela[i]!!.getCartelaView()!!.equalsC(cartelaExcluida)){

                        cartelaView[i]!!.isVisible = false
                        cartelaView[i] = cartelaView[viewQnt -1]
                        viewQnt = viewQnt.dec()

                        println(bingo.getJogadores().contentToString())

                        view.listaCartelas.model = DefaultListModel<String>().apply {

                            bingo.getJogadores().forEach { addElement(it) }
                        }
                    }
                }
            }


        }else{
            view.exibirMensagem("Jogo já começou, não é possivel adicionar nova cartela")
        }
    }
}

