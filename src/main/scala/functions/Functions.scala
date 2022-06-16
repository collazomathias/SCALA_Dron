package functions
import dron.Dron
import scala.annotation.switch


trait Movement

object Top extends Movement
object Down extends Movement
object Left extends Movement
object Right extends Movement
object Back extends Movement
object Front extends Movement

trait Functions {
    type Id = Int
    type Distance = Double
    def createDron(id : Id) : Dron
    def goTop(dron : Dron, top : Distance) : Dron
    def goDown(dron : Dron, down : Distance) : Dron
    def goLeft(dron : Dron, left : Distance) : Dron
    def goRight(dron : Dron, right : Distance) : Dron
    def goBack(dron : Dron, back : Distance) : Dron
    def goFront(dron : Dron, front : Distance) : Dron
    def showInfoDron(dron : Dron) : Unit
    def moveDron(dron : Dron, movement : Movement, distance : Distance) : Dron
}

object Functions extends Functions {
    def moveDron(dron: Dron, movement: Movement, distance: Distance) : Dron = {
        movement match {
            case Top => goTop(dron, distance)
            case Down => goDown(dron, distance)
            case Left => goLeft(dron, distance)
            case Right => goRight(dron, distance)
            case Back => goBack(dron, distance)
            case Front => goFront(dron, distance)
        }
    }

    def createDron(id: Id) = {
        val dron = Dron(id, 0, 0, 0, 0, 0, 0)
        val dron1 = moveDron(dron, Top, 30)
        val dron2 = moveDron(dron1, Down, 50)
        val dron3 = moveDron(dron2, Top, 100)
        val dron4 = moveDron(dron3, Down, 15)
        val dron5 = moveDron(dron4, Left, 15)
        val dron6 = moveDron(dron5, Right, 30)
        val dron7 = moveDron(dron6, Left, 100)
        val dron8 = moveDron(dron7, Back, 50)
        val dron9 = moveDron(dron8, Front, 100)
        val dron10 = moveDron(dron9, Top, 150)
        dron10
    }

    def goTop(dron: Dron, top: Distance) : Dron = {
        if(dron.top + top > 100) dron.copy(down = 0, top = 100)
        else if(dron.down + top < 0) dron.copy(down = dron.down + top)
        else if(dron.down < 0 && dron.down + top > 0) dron.copy(top = dron.down + top, down = 0)
        else dron.copy(top = dron.top + top)
    }

    def goDown(dron: Dron, down: Distance) : Dron = {
        if(dron.down - down < -50) dron.copy(top = 0, down = -50)
        else if(dron.top - down > 0) dron.copy(top = dron.top - down)
        else if(dron.top > 0 && dron.top - down < 0) dron.copy(top = 0, down = dron.top - down)
        else dron.copy(down = dron.down - down)
    }

    def goLeft(dron: Dron, left: Distance) : Dron = {
        if(dron.right - left > 0) dron.copy(right = dron.right - left)
        else if(dron.right > 0 && dron.right - left < 0) dron.copy(right = 0, left = dron.right - left)
        else dron.copy(left = dron.left - left)
    }

    def goRight(dron: Dron, right: Distance) : Dron = {
        if(dron.left + right < 0) dron.copy(left = dron.left + right)
        else if(dron.left < 0 && dron.left + right > 0) dron.copy(left = 0, right = dron.left + right)
        else dron.copy(right = dron.right + right)
    }

    def goBack(dron: Dron, back: Distance) : Dron = {
        if(dron.front - back > 0) dron.copy(front = dron.front - back)
        else if(dron.front > 0 && dron.front - back < 0) dron.copy(front = 0, back = dron.front - back)
        else dron.copy(back = dron.back - back)
    }

    def goFront(dron: Dron, front: Distance) : Dron = {
        if(dron.back + front < 0) dron.copy(back = dron.back + front)
        else if(dron.back < 0 && dron.back + front > 0) dron.copy(back = 0, front = dron.back + front)
        else dron.copy(front = dron.front + front)
    }

    def showInfoDron(dron: Dron) : Unit = {
        println("Dron ID: " + dron.id)
        if(dron.down == 0) println("Y: " + dron.top)
        if(dron.top == 0) println("Y: " + dron.down)
        if(dron.right == 0) println("X: " + dron.left)
        if(dron.left == 0) println("X: " + dron.right)
        if(dron.front == 0) println("Z: " + dron.back)
        if(dron.back == 0) println("Z: " + dron.front)
    }
}
