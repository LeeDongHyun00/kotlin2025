package com.kotlinbasics

import android.health.connect.datatypes.ExercisePerformanceGoal.WeightGoal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        //week02Variables()
        //week02Functions()
        //week03Functions()
        week03Collections()
    }
}
private fun week03Collections(){
    Log.d("KotlinWeek03", "== Kotlin Collections ==")

    // listOf, 수정가능한 mutalbleListOf, js 파이썬 딕셔너리 mapOf
    val fruits = listOf("apple", "banana", "pear")
    val mutableFruits = mutableListOf("kiwi", "orange")
    mutableFruits.add("banana")
    val scores = mapOf("Kim" to 97, "Park" to 100, "Lee" to 12)

    // fruits.add("kiwi") <= err
    Log.d("KotlinWeek03", "Fruits : $fruits")
    Log.d("KotlinWeek03", "mutableFruits : $mutableFruits")
    Log.d("KotlinWeek03", "scores : $scores")

    for(fruit in mutableFruits){
        Log.d("KotlinWeek03", "Fruits : $fruit")
    }
    scores.forEach{(name, score) -> Log.d("KotlinWeek03","$name scoresd $score")}
}

private fun week04classes(){
    Log.d("KotlinWeek03", "== Kotlin Classese ==")

    class Person(val name : String, var age : Int){
        fun introduce(){
            Log.d("KotlinWeek03", "Hi, i'm $name ($age)")
        }
        fun birthday() {
            age++
            Log.d("KotlinWeek03", "Today is $name 's birthday, now ($age)")
        }
    }
    val person1 = Person("Hong", 33)
    person1.introduce()
    person1.birthday()

    // open으로 상속, override가능
    open class Animal(var species : String){
        var weight : Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek03", "$species 's weight is $weight kg")
        }
        //  open 추가
        open fun makeSound(){
            Log.d("KotlinWeek03", "$species makes noise")
        }
    }
    val puppy = Animal("강아지", 10)
    puppy.makeSound()

    // open이 없으면 final 이기에 override안됨
    class Dog(species : String, weight: Double, breed: String) : Animal(species, weight){
        override fun makeSound(){
            Log.d("KotlinWeek03", "$breed($species) makes noise")
        }
    }
    val dog = Dog("개", 12.5, "시츄")
    dog.makeSound()
//    class Student{
//        var name : String = ""
//        var age : Int = 0
//
//        fun introduce(name : String, age : Int){
//            println("Hi, my name is $name age is $age")
//        }
//    }
//    val student = Student()
//    student.name = "Lee"
//    student.age = 26
//    student.introduce()
//
//    // data class
//    data class Peson(val name : String, val age : int)
//
//    val person1 = Person(name="Kim",age=25)
//    val person2 = Person(name="Yang",age=24)
//    println("Person1 : $person1")
//    println("Person2 : $person2")
//    println("Equal? : ${person1 == person2}")
}

private fun week02Functions(){
    println("week02 Functions")

//    fun greet(name:String) = "Hello, $name"
//    println(greet("Android Developer"))
    println("== Kotlin Functions ==")
    fun greet(name : String) : String {
        return "Hello, $name"
    }

    fun add (a : Int, b: Int) = a+b

    fun introduce(name : String, age: Int = 19){
        println("name : $name, age: $age")
    }
    println(greet("Kotlin"))
    println("Sum 5 + 6 = ${add(5,6)}")
    introduce("Kim")
    introduce("Lee", 55)
}

private fun week02Variables(){
    println("Week02 Variables")

    val courseName = "Mobile Programming"
    // courseName = "Iot Programming" X 재할당 불가능
    var week = 1
    week = 2
    //
    println("Course : $courseName")
    println("Week : $week")

    val name : String = "Android"
    var version : Double = 8.1
    println("Hello $name $version")

    val age : Int = 25
    val height : Double = 180.0
    val isStudent : Boolean = true

    println("age: $age, height : $height, student : $isStudent")

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}