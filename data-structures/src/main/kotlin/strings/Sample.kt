package strings

import java.io.File

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    //creating a string
    var newStr = "sample"
    println("newStr")
    println('a'.toInt())
    println(97.toChar())


    //string templating
    fun add(a:Int,b:Int) =  a+b
    println("Addition of ${2} and ${3} is ${add(2,3)}")

    // mutli line string and escape characters [storing JSON in code ]
    // trimIndent Detects a common minimal indent of all the input lines, removes it from every line + blank lines before/after string
    // also used to use escape characters
    //trimIndent - happens at compile time and not run time [constant operation]

    val multiStr = """
        
        Hey there! 
        Are you saying/You want to say
           "Go Back Home"
        
        
    """.trimIndent()

    println(multiStr)

    //Reading string and file
    val fromStdIn = readLine()
    //val fromFile = File("inp.txt").readText()

    //creating strings using buildString

    val name = "Jane"
    val newStr2 = buildString {
        repeat(3){
            append("Hey, ")
            append(name)
            appendLine("!!")
        }
    }
    println("String from string builder $newStr2")

    //useful string functions
    println(" ".isBlank())
    println("".isEmpty())
    println("shnas".endsWith("s"))
    println("shnas".startsWith("s"))
    println("shnas".substring(1,4))

    val defaultValueIfBlank = "".ifBlank { "Never Blank" }
    println(defaultValueIfBlank)

    println("       hey you    ".trim()) // remove space from beg and end

    val sampleStr = "##placeholder##"
    println(sampleStr.removePrefix("##"))
    println(sampleStr.removeSuffix("#"))
    println(sampleStr.removeSurrounding("#"))

    //comparing strings
    val str1 = "hey"
    val str2 = "hey"

    println("$str1 equality with $str2 is ${str1 == str2} ")
    println(" ab comparison with ad is ${"ab">"ad"} ")  //comparison on alphabetical order
    println("Quick compare with quick is ${"Quick".equals("quick",ignoreCase = true)}")
    println("Quick compare with quick is ${"Quick".compareTo("quick",ignoreCase = false)}")  //lexicographic comparison 0 if equal +ve if greater and -ve if lexicographically less than argument


    // splitting string

    val str3 = "hey, you have been, to, me "
    val strList = str3.split(",")
    val strListWithLimit = str3.split(",",limit = 2)

    val multiStr2 = """
        
        Hey there! 
        Are you saying/You want to say
           "Go Back Home"
        
        
    """.trimIndent()
    val multiSplit = multiStr.lines()



    println(strList)
    println(strListWithLimit)
    println(multiSplit)

    // string as array
    val str4 = "Hello, World"
    println("4th character of $str4 is ${str4[3]}")
    val upperCase = str4.filter {
        it.isUpperCase()
    }
    println("List of uppercase letters $upperCase")

    //joining to form string

    val charArray = charArrayOf('a','b','c','d','e')
    println("Joined string ${charArray.joinToString("")}")

    val chars = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q')
    println(chars.joinToString(limit = 5, truncated = "...!") { it.uppercaseChar().toString() })
    println(chars.joinToString(prefix = "<", postfix = ">", separator = "•"))
}