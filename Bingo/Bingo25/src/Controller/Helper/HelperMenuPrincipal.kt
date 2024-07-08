package Controller.Helper

import View.MenuPrincipal

class HelperMenuPrincipal(var view: MenuPrincipal) {

    public fun getNome(): String{
        return view.campoNomeCartela.text.toString()
    }

    public fun cleanNome(){
        view.campoNomeCartela.text = ""
    }
}