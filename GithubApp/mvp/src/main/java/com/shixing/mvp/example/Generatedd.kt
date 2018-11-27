package com.shixing.mvp.example

interface Production<out T> {
    fun produce():T
}

interface Comsumer<in T> {
    fun consume(item:T)
}

interface ProductionConsumer<T> {
    fun produce() :T
    fun consume(item: T)
}

open class Food
open class FastFood:Food()
class Burger:FastFood()

class FoodStore:Production<Food> {
    override fun produce(): Food {
        println("foodStore produce food")
        return Food()
    }
}

class FastFoodStore:Production<FastFood> {
    override fun produce(): FastFood {
        println("fastFoodStore produce food")
        return FastFood()
    }
}

class InOutBurgerStore:Production<Burger> {
    override fun produce(): Burger {
        println("InOutBurgerStore produce food")
        return Burger()
    }
}

class Human:Comsumer<Food> {
    override fun consume(item: Food) {
        println("human eat food")
    }
}
class ModernPeople:Comsumer<FastFood> {
    override fun consume(item: FastFood) {
        println("modernpeople eat fast food")
    }
}
class American:Comsumer<Burger> {
    override fun consume(item: Burger) {
        println("american eat berger")
    }
}
fun main(args: Array<String>) {
    //对于out类型，子类泛型的对象能赋值给父类泛型的引用,但反过来会编译报错
    val pro0:Production<Food> = FoodStore()
//    val pro1:Production<FastFood> = FoodStore() //编译报错
    val pro11:Production<FastFood> = FastFoodStore()
    val pro2:Production<Food> = FastFoodStore()
    val pro3:Production<Food> = InOutBurgerStore()
    val pro4:Production<FastFood> = InOutBurgerStore()
    //反过来会报错
//    var pro6:Production<Burger> = FoodStore() //编译报错
//    var pro7:Production<Burger> = FastFoodStore() //编译报错
    var pro8:Production<Burger> = InOutBurgerStore()

    //对于in类型，父类泛型的对象能赋值给子类泛型的引用，但反过来不行
    var con1:Comsumer<Burger> = Human()
    var con2:Comsumer<Burger> = ModernPeople()
    var con3:Comsumer<Burger> = American()
    //反过来会报错
    var con4:Comsumer<Food> = Human()
//    var con5:Comsumer<Food> = ModernPeople() //编译报错
//    var con6:Comsumer<Food> = American() //编译报错

}

