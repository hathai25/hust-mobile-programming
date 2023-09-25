import java.util.Random

fun main(args: Array<String>) {
        //1
        println("Hello ${args[0]}")

        //2
        val isUnit = println("This is an expression")
        println(isUnit)

//        val temperature = 10
//        val isHot = if (temperature > 50) true else false
//        println(isHot)

        val temperature = 10
        val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
        println(message)

        //3
        fun randomDay() : String {
            val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday")
            return week[Random().nextInt(week.size)]
        }

        fun fishFood (day : String) : String {
            var food = ""
            when (day) {
                "Monday" -> food = "flakes"
                "Tuesday" -> food = "pellets"
                "Wednesday" -> food = "redworms"
                "Thursday" -> food = "granules"
                "Friday" -> food = "mosquitoes"
                "Saturday" -> food = "lettuce"
                "Sunday" -> food = "plankton"
                else -> food = "nothing"
            }
            return food
        }

        fun isTooHot(temperature: Int) = temperature > 30

        fun isDirty(dirty: Int) = dirty > 30

        fun isSunday(day: String) = day == "Sunday"

        fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
            return when {
                isTooHot(temperature) -> true
                isDirty(dirty) -> true
                isSunday(day) ->  true
                else -> false
            }
        }

        fun feedTheFish() {
            val day = randomDay()
            val food = fishFood(day)
            println ("Today is $day and the fish eat $food")
            println("Change water: ${shouldChangeWater(day)}")
        }

        feedTheFish()

    //4
    fun swim(speed: String = "fast") {
        println("swimming $speed")
    }

    swim()

    //5
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    val newList = filtered.toList()
    println("new list: $newList")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")

    //6
    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))

    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))
}

