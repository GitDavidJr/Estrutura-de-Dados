import kotlin.random.Random

data class Cartela(var nome: String) {

    var pontos: Int = 0
    private var numerosDaCartela = arrayOfNulls<Int>(25)
    private var qtd = 0


    public fun getJogador(): String{
        return nome
    }

    public fun getNumeros(): Array<Int?>{
        return numerosDaCartela
    }

    public fun gerarNumerosDaCartela(): Array<Int?> {
        for (indice in 0..24){
            do {
                var rnd = Random.nextInt(1, 100)
                numerosDaCartela[indice] = rnd
                qtd++
                if (repetido(rnd)) {
                    qtd--
                }
            }while (repetido(rnd))

        }
        return this.numerosDaCartela
    }

    public fun contemNumero(numero: Int): Boolean{
        for(i in 0..24){
            if(numero == numerosDaCartela[i]){
                return true
            }
        }
        return false
    }

    public fun imprimir(): String {
        var cart: String = ""

        for (i in 0..24){

            cart += numerosDaCartela[i]

            if (i != 0 && ((i+1)%5) == 0){
                cart += " | \n "
            }

            if (i != 24 && ((i+1)%5) != 0){
                cart += " | "
            }
        }
        //println(cart)
        return cart
    }

    private fun repetido(numero: Int): Boolean {
        val todosNumerosSorteados = this.numerosDaCartela
        for (i in 0 until qtd) {
            if (qtd != 1) {
                if (todosNumerosSorteados[i] == numero) {
                    return true
                }
            } else {
                break;
            }
        }
        return false
    }

    public fun setNumerosDaCartela(numerosImp: Array<Int>) {

        for (i in 0 until numerosDaCartela.size){
            numerosDaCartela[i] = numerosImp[i]
        }
    }

    public fun equalsC(cartela2: Cartela): Boolean {
        return cartela2.nome.equals(this.nome, ignoreCase = true)
    }
}