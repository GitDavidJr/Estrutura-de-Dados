import Model.Bingo


fun main(args: Array<String>) {

    var c1 = Cartela("Jose")
    var c2 = Cartela("Ninguem")
    var c3 = Cartela("Paula")
    var c4 = Cartela("Gustavinho")
    var c5 = Cartela("Rebeca")
    var c6 = Cartela("Vicente")
    var c7 = Cartela("Ramon")
    var c8 = Cartela("Paula")
    var c9 = Cartela("Lays")
    var c10 = Cartela("Cecilia")
    var c11 = Cartela("Anne")
    var c12 = Cartela("Ana Luiza")

    c1.gerarNumerosDaCartela()
    c2.gerarNumerosDaCartela()
    c3.gerarNumerosDaCartela()
    c4.gerarNumerosDaCartela()
    c5.gerarNumerosDaCartela()
    c6.gerarNumerosDaCartela()
    c7.gerarNumerosDaCartela()
    c8.gerarNumerosDaCartela()
    c9.gerarNumerosDaCartela()
    c10.gerarNumerosDaCartela()
    c11.gerarNumerosDaCartela()
    c12.gerarNumerosDaCartela()

    var bingoA = Bingo()
    var sorteio = SortearNumero()
    bingoA.incluirCartela(c1)
    bingoA.incluirCartela(c2)
    bingoA.incluirCartela(c3)
    bingoA.incluirCartela(c4)
    bingoA.incluirCartela(c5)
    bingoA.incluirCartela(c6)
    bingoA.incluirCartela(c7)
    bingoA.incluirCartela(c8)
    bingoA.incluirCartela(c9)
    bingoA.incluirCartela(c10)
    bingoA.incluirCartela(c11)
    bingoA.incluirCartela(c12)

    bingoA.consultarJogadores()

    bingoA.sortear(sorteio)




    bingoA.consultarNumOrdemCrescente(sorteio)
    bingoA.consultarQtdNumSorteados()
    bingoA.verificarVencedores()

    print("Numeros sorteados: ")
    println(sorteio.getNumerosSorteados().contentToString())
}