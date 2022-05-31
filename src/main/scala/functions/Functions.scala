package functions
import dron.Dron
import scala.annotation.switch

object Functions {

    def createDron(id: Int) = {
        var dron = Dron(id, 0, 0, 0, 0, 0, 0)
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
        dron
    }

    def goTop(dron: Dron, top: Double) : Dron = {
        if(dron.top + top > 100) dron.copy(down = 0, top = 100)
        else if(dron.down + top < 0) dron.copy(down = dron.down + top)
        else if(dron.down < 0 && dron.down + top > 0) dron.copy(top = dron.down + top, down = 0)
        else dron.copy(top = dron.top + top)
    }

    def goDown(dron: Dron, down: Double) : Dron = {
        if(dron.down - down < -50) dron.copy(top = 0, down = -50)
        else if(dron.top - down > 0) dron.copy(top = dron.top - down)
        else if(dron.top > 0 && dron.top - down < 0) dron.copy(top = 0, down = dron.top - down)
        else dron.copy(down = dron.down - down)
    }

    def goLeft(dron: Dron, left: Double) : Dron = {
        if(dron.right - left > 0) dron.copy(right = dron.right - left)
        else if(dron.right > 0 && dron.right - left < 0) dron.copy(right = 0, left = dron.right - left)
        else dron.copy(left = dron.left - left)
    }

    def goRight(dron: Dron, right: Double) : Dron = {
        if(dron.left + right < 0) dron.copy(left = dron.left + right)
        else if(dron.left < 0 && dron.left + right > 0) dron.copy(left = 0, right = dron.left + right)
        else dron.copy(right = dron.right + right)
    }

    def goBack(dron: Dron, back: Double) : Dron = {
        if(dron.front - back > 0) dron.copy(front = dron.front - back)
        else if(dron.front > 0 && dron.front - back < 0) dron.copy(front = 0, back = dron.front - back)
        else dron.copy(back = dron.back - back)
    }

    def goFront(dron: Dron, front: Double) : Dron = {
        if(dron.back + front < 0) dron.copy(back = dron.back + front)
        else if(dron.back < 0 && dron.back + front > 0) dron.copy(back = 0, front = dron.back + front)
        else dron.copy(front = dron.front + front)
    }

    def showInfoDron(dron: Dron) : Unit = {
        println("Dron ID: " + dron.id)
        if(dron.down == 0) println("Top: \t" + dron.top)
        if(dron.top == 0) println("Down: \t" + dron.down)
        if(dron.right == 0) println("Left: \t" + dron.left)
        if(dron.left == 0) println("Right: \t" + dron.right)
        if(dron.front == 0) println("Back: \t" + dron.back)
        if(dron.back == 0) println("Front: \t" + dron.front)
    }

}
