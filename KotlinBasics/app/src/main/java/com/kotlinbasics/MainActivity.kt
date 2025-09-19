package com.kotlinbasics

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

    val fruits = listOf("apple", "banana", "pear")
    // fruits.add("kiwi") <= err
    Log.d("KotlinWeek03", "Fruits : $fruits")

    for(fruit in fruits){
        Log.d("KotlinWeek03", "Fruits : $fruit")
    }

}

private fun week04classes(){
    println("== Kotlin Classese ==")


    class Student{
        var name : String = ""
        var age : Int = 0

        fun introduce(name : String, age : Int){
            println("Hi, my name is $name age is $age")
        }
    }
    val student = Student()
    student.name = "Lee"
    student.age = 26
    student.introduce()

    // data class
    data class Peson(val name : String, val age : int)

    val person1 = Person(name="Kim",age=25)
    val person2 = Person(name="Yang",age=24)
    println("Person1 : $person1")
    println("Person2 : $person2")
    println("Equal? : ${person1 == person2}")
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