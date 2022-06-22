import functions._
import functions.Functions.Distance

object Main extends App {
    val movements : List[(Movement, Distance)] = List(
        (Top, 50),
        (Down, 20),
        (Left, 150),
        (Right, 30),
        (Right, 500),
        (Back, 40),
        (Front, 90),
        (Top, 20),
        (Down, 35),
    )
    val dron = Functions.createDron(1234, movements)
    Functions.showInfoDron(dron)
}