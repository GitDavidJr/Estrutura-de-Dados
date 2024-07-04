package Controller

import Cartela
import Controller.Helper.HelperMenuPrincipal
import Lista
import Model.Bingo
import SortearNumero
import View.CartelaView
import View.MenuPrincipal
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.ListModel
import javax.swing.text.StyledEditorKit.BoldAction

class ControllerMenu(private val view: MenuPrincipal) {

    private val helper: HelperMenuPrincipal = HelperMenuPrincipal(view)
    private var quantidadeCartelas: Int = 0
    private var bingoA = Bingo()
    private var sorteio: SortearNumero = SortearNumero()
    private var start = false
    private var nomes: Array<String?> = arrayOfNulls(20)

    fun incluirCartela() {

        if (!start) {
            var cartelaView: CartelaView = CartelaView()
            var cartela: Cartela = Cartela(helper.getNome())

            cartela.gerarNumerosDaCartela()

            bingoA.incluirCartela(cartela)

            nomes[quantidadeCartelas] = helper.getNome()
            view.listaCartelas.model = DefaultListModel<String>().apply {
                nomes.forEach { addElement(it) }

                val controllerCartela: ControllerCartela = ControllerCartela(cartelaView)
                controllerCartela.novaCartela(helper.getNome(), cartela)
                cartelaView.setVisible(true)

                helper.cleanNome()
                quantidadeCartelas = quantidadeCartelas.inc()
            }
        }
    }

    public fun sortear() {
        bingoA.sortear(sorteio)
        //adicionar numero na lista
        view.listaCartelas.model = DefaultListModel<String>().apply {
            sorteio.getNumerosSorteados().forEach { addElement(it.toString()) }

        }
    }
}

