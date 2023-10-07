package com.example.hellokotlin

abstract class AquariumFish {
    abstract val color: String
}

interface FishAction {
    fun eat()
}
interface FishColor {
    val color: String
}


class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}


class Plecostomus(fishColor: FishColor = GoldColor):  FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}


