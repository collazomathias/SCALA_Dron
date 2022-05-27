import functions.Functions._

object Main extends App {
    var dron = createDron(1234)
    dron = goTop(dron, 30)
    dron = goDown(dron, 50)
    dron = goTop(dron, 100)
    dron = goDown(dron, 15)
    dron = goLeft(dron, 15)
    dron = goRight(dron, 30)
    dron = goLeft(dron, 100)
    dron = goBack(dron, 50)
    dron = goFront(dron, 100)
    dron = goTop(dron, 150)
    showInfoDron(dron)
}