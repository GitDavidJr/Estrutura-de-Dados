package Controller

import Cartela
import Controller.Helper.HelperCartela
import Controller.Helper.HelperMenuPrincipal
import Lista
import Model.Bingo
import SortearNumero
import View.CartelaView
import View.MenuPrincipal
import javax.swing.DefaultListModel

class ControllerMenu(private val view: MenuPrincipal) {

    //helper
    private val helper: HelperMenuPrincipal = HelperMenuPrincipal(view)
    private var helperCartela: MutableList<HelperCartela> = mutableListOf()

    //models
    private var bingo = Bingo()
    private var sorteio: SortearNumero = SortearNumero()

    //variaveis de controle
    private var start = false
    private var vencedoresQnt = 0

    //Cartela View
    private var cartelaView: MutableList<CartelaView> = mutableListOf()

    fun incluirCartela() {

        if (!start) {

            cartelaView.add(CartelaView())
            helperCartela.add(HelperCartela(cartelaView[cartelaView.size - 1]))

            var cartela: Cartela = Cartela(helper.getNome())
            cartela.gerarNumerosDaCartela()

            bingo.incluirCartela(cartela)

            view.listaCartelas.model = DefaultListModel<String>().apply {

                bingo.getJogadores().forEach { addElement(it) }

                val controllerCartela: ControllerCartela = ControllerCartela(cartelaView[cartelaView.size - 1])
                controllerCartela.novaCartela(helper.getNome(), cartela)
                cartelaView[cartelaView.size - 1].isVisible = true

                helper.cleanNome()
            }
        }
    }

    fun sortear() {

        if(!start) start = true

        bingo.sortear(sorteio)

        //adicionar numero na lista
        view.listaNumerosSorteados.model = DefaultListModel<String>().apply {
            sorteio.getNumerosSorteados().forEach { addElement(it.toString()) }
        }

        for(i in 0 ..<cartelaView.size){
            helperCartela[i].setCor(sorteio)
        }

        for(i in vencedoresQnt..<bingo.getVencedores().size){
            view.exibirGanhador(bingo.getVencedores()[i]?.getJogador())
            vencedoresQnt++
        }

    }
}

