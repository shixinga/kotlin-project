package com.shixing.mvp.example

class PersonTest(val name:String,val age:Int)

fun main(args: Array<String>) {
    val p = PersonTest("csx", 22)
    val str = PersonTest::class.java.declaredFields.map {
        it.isAccessible = true
        "name=${it.name}, get=${it.get(p)}"
    }.joinToString(",")
    println("str：$str")
}