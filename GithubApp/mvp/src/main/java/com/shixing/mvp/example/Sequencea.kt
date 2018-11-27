package com.shixing.mvp.example

fun main(args: Array<String>) {
    (0..6)
        .asSequence()
        .map {//map返回是Sequence<T>，故它属于中间操作
            println("map: $it")
            return@map it + 1
        }
        .filter {//filter返回是Sequence<T>，故它属于中间操作
            println("filter: $it")
            return@filter it % 2 == 0
        }.count { it < 5 }.apply(::println)
}