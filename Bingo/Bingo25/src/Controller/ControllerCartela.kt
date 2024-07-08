package Controller

import Cartela
import Controller.Helper.HelperCartela
import View.CartelaView

class ControllerCartela(private val view: CartelaView?) {

    private val helper: HelperCartela = HelperCartela(view)

    public fun novaCartela(nome: String, cartela: Cartela ){
        helper.setNome(nome)
        helper.setCarletaView(cartela)
    }
}