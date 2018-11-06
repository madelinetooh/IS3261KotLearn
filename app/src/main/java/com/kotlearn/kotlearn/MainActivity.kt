package com.kotlearn.kotlearn

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var topicDbHelper: DBHelper
    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var URL = "URL"

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: android.support.v4.app.Fragment? = null
        when (item.itemId) {
            R.id.navigation_web -> {
                selectedFragment = ProfileFragment()
            }
            R.id.navigation_content -> {
                selectedFragment = ContentFragment()
            }
            R.id.navigation_complier -> {
                selectedFragment = CompilerFragment()
            }
        }
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, selectedFragment)
        transaction.commit()
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .commit()


        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val fragmentContent= ContentFragment()
        transaction.add(R.id.fragment_content,fragmentContent)

        val fragmentProfile = ProfileFragment()
        transaction.add(R.id.fragment_profile, fragmentProfile)

        val fragmentComplier = CompilerFragment()
        transaction.add(R.id.fragment_complier, fragmentComplier)

        transaction.hide(fragmentComplier)
        transaction.hide(fragmentContent)
        transaction.hide(fragmentProfile)

        transaction.commit()


        topicDbHelper = DBHelper(this)

        topicDbHelper.clearAllTopics()
        sharedPreferences = this.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(URL, "")
        editor.apply()

        var allTopics = topicDbHelper.readAllTopics()

        if (allTopics.isEmpty()) {
            println("NO TOPICS " + allTopics.size)
//            InternetJSON(this@MainActivity,"http://172.19.195.190:8080/KotlearnBackend-war/resources/topics/getTopics",
//                    topicDbHelper).execute()
            populateData()
        }



    }

    private fun populateData() {
        insertTopic(1, "Overview", "<h1>Overview</h1><p>Kotlin is a new open source programming language like Java, JavaScript, etc. It is a high level strongly statically typed language that combines functional and technical part in a same place. Currently, Kotlin targets Java and JavaScript. It runs on JVM.<br /><br />" +
                "Kotlin is influenced by other programming languages such as Java, Scala, Groovy, Gosu, etc. The syntax of Kotlin may not be exactly similar to JAVA, however, internally Kotlin is reliant on the existing Java Class library to produce wonderful results for the programmers. Kotlin provides interoperability, code safety, and clarity to the developers around the world.<br /><br />" +
                "<br />" +
                "<h2>Advantages and Disadvantages</h2>" +
                "Following are some of the advantages of using Kotlin for your application development.<br /><br />" +
                "<b>Easy Language</b> − Kotlin is a functional language and very easy to learn. The syntax is pretty much similar to Java, hence it is very easy to remember. Kotlin is more expressive, which makes your code more readable and understandable.<br /><br />" +
                "<b>Concise</b> − Kotlin is based on JVM and it is a functional language. Thus, it reduce lots of boiler plate code used in other programming languages.<br /><br />" +
                "<b>Runtime and Performance</b> − Better performance and small runtime.<br /><br />" +
                "<b>Interoperability</b> − Kotlin is mature enough to build an interoperable application in a less complex manner.<br /><br />" +
                "<b>Brand New</b> − Kotlin is a brand new language that gives developers a fresh start. It is not a replacement of Java, though it is developed over JVM. It is accepted as the first official language of android development. Kotlin can be defined as - Kotlin = JAVA + extra updated new features.<br /><br />" +
                "Following are some of the disadvantages of Kotlin.<br /><br />" +
                "<b>Namespace declaration</b> − Kotlin allows developers to declare the functions at the top level. However, whenever the same function is declared in many places of your application, then it is hard to understand which function is being called.<br /><br />" +
                "<b>No Static Declaration</b> − Kotlin does not have usual static handling modifier like Java, which can cause some problem to the conventional Java developer."
        )

        insertTopic(2, "Environment Setup", "<h1>Environment Setup</h1>However, if you still want to use Kotlin offline in your local system, then you need to execute the following steps to configure your local workspace.<br />" +
                "<br />" +
                "<b>Step 1 − Java 8 installation.</b><br />" +
                "<br />" +
                "Kotlin runs on JVM, hence. it is really necessary to use JDK 8 for your local Kotlin development. Please refer to the official website of oracle to download and install JDK 8 or an above version. You might have to set the environment variable for JAVA such that it can work properly. To verify your installation in Windows operating system, hit “java –version” in the command prompt and as an output it will show you the java version installed in your system.<br />" +
                "<br />" +
                "<b>Step 2 − IDE installation.</b><br />" +
                "<br />" +
                "There are a number of IDE available over the internet. You can use any of your choice.<br />" +
                "<br />" +
                "NetBeans: https://netbeans.org/downloads/<br />" +
                "Eclipse: https://www.eclipse.org/downloads/<br />" +
                "Intellij: https://www.jetbrains.com/idea/download/#section = windows<br />" +
                "<br />" +
                "It is always recommended to use the recent software version to drag out maximum facility from it.<br />" +
                "<br />" +
                "<b>Step 3 − Configuring Eclipse.</b><br />" +
                "<br />" +
                "Open Eclipse and go to “Eclipse Market Place”.<br />" +
                "<br />" +
                "Search for Kotlin in the search box and install the same in your local system. It might take some time depending on the internet speed. You may have to restart your Eclipse, once it is successfully installed.<br />" +
                "<br />" +
                "<b>Step 4 − Kotlin Project.</b><br />" +
                "<br />" +
                "Once Eclipse is successfully restarted and Kotlin is installed, you will be able to create a Kotlin project on the fly. Go to File → New → Others and select “Kotlin project” from the list.<br />" +
                "<br />" +
                "Once the project setup is done, you can create a Kotlin file under “SRC” folder. Left-click on the “Src” folder and hit “new”. You will get an option for Kotlin file, otherwise you may have to search from the “others”.<br />" +
                "<br />" +
                "Your development environment is ready now. Go ahead and add the following piece of code in the “Hello.kt” file.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   println(\"Hello, World!\")<br />" +
                "}</code>" +
                "Run it as a Kotlin application and see the output in the console as shown in the following screenshot.<br />" +
                "<result>Hello, World!</result>")

        insertTopic(3, "Architecture", "<h1>Architecture</h1>Kotlin is a programming language and has its own architecture to allocate memory and produce a quality output to the end user. Following are the different scenarios where Kotlin compiler will work differently, whenever it is targeting different other kind of languages such as Java and JavaScript.<br />" +
                "<br />" +
                "Kotlin compiler creates a byte code and that byte code can run on the JVM, which is exactly equal to the byte code generated by the Java .class file. Whenever two byte coded file runs on the JVM, they can communicate with each other and this is how an interoperable feature is established in Kotlin for Java." +
                "<br />" +
                "Whenever Kotlin targets JavaScript, the Kotlin compiler converts the .kt file into ES5.1 and generates a compatible code for JavaScript. Kotlin compiler is capable of creating platform basis compatible codes via LLVM.")

        insertTopic(4, "Basic Types", "<h1>Basic Types</h1>In this chapter, we will learn about the basic data types available in Kotlin programming language.<br />" +
                "<br />" +
                "<h2>Numbers</h2>" +
                "The representation of numbers in Kotlin is pretty similar to Java, however, Kotlin does not allow internal conversion of different data types. Following table lists different variable lengths for different numbers." +
                "<br />" +
                "Double: 64<br />" +
                "Float: 32<br />" +
                "Long: 64<br />" +
                "Int: 32<br />" +
                "Short: 16<br />" +
                "Byte: 8<br />" +
                "<br />" +
                "In the following example, we will see how Kotlin works with different data types. Please enter the following set of code in our coding ground." +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val a: Int = 10000<br />" +
                "   val d: Double = 100.00<br />" +
                "   val f: Float = 100.00f<br />" +
                "   val l: Long = 1000000004<br />" +
                "   val s: Short = 10<br />" +
                "   val b: Byte = 1<br />" +
                "   <br />" +
                "   println(\"Your Int Value is \"+a);<br />" +
                "   println(\"Your Double  Value is \"+d);<br />" +
                "   println(\"Your Float Value is \"+f);<br />" +
                "   println(\"Your Long Value is \"+l);<br />" +
                "   println(\"Your Short Value is \"+s);<br />" +
                "   println(\"Your Byte Value is \"+b);<br />" +
                "}</code>" +
                "When you run the above piece of code in the coding ground, it will generate the following output in the web console.<br />" +
                "<result>Your Int Value is 10000<br />" +
                "Your Double  Value is 100.0<br />" +
                "Your Float Value is 100.0<br />" +
                "Your Long Value is 1000000004<br />" +
                "Your Short Value is 10<br />" +
                "Your Byte Value is 1</result>" +
                "<br />" +
                "<h2>Characters</h2>" +
                "Kotlin represents character using char. Character should be declared in a single quote like ‘c’. Please enter the following code in our coding ground and see how Kotlin interprets the character variable. Character variable cannot be declared like number variables. Kotlin variable can be declared in two ways - one using “var” and another using “val”.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val letter: Char    // defining a variable <br />" +
                "   letter = 'A'        // Assigning a value to it <br />" +
                "   println(\"\$letter\")<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser output window.<br />" +
                "<result>A</result>" +
                "<br />" +
                "<h2>Boolean</h2>" +
                "Boolean is very simple like other programming languages. We have only two values for Boolean – either true or false. In the following example, we will see how Kotlin interprets Boolean.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val letter: Boolean   // defining a variable <br />" +
                "   letter = true         // Assinging a value to it <br />" +
                "   println(\"Your character value is \"+\"\$letter\")<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Your character value is true</result>" +
                "<br />" +
                "<h2>Strings</h2>" +
                "Strings are character arrays. Like Java, they are immutable in nature. We have two kinds of string available in Kotlin - one is called raw String and another is called escaped String. In the following example, we will make use of these strings." +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var rawString :String  = \"I am Raw String!\"<br />" +
                "   val escapedString : String  = \"I am escaped String!\n\"<br />" +
                "   <br />" +
                "   println(\"Hello!\"+escapedString)<br />" +
                "   println(\"Hey!!\"+rawString)   <br />" +
                "}</code>" +
                "The above example of escaped String allows to provide extra line space after the first print statement. Following will be the output in the browser.<br />" +
                "<result>Hello!I am escaped String!<br />" +
                "Hey!!I am Raw String!</result>" +
                "<br />" +
                "<h2>Arrays</h2>" +
                "Arrays are a collection of homogeneous data. Like Java, Kotlin supports arrays of different data types. In the following example, we will make use of different arrays.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)<br />" +
                "   println(\"Hey!! I am array Example\"+numbers[2])<br />" +
                "}</code>" +
                "The above piece of code yields the following output. The indexing of the array is similar to other programming languages. Here, we are searching for a second index, whose value is “3”.<br />" +
                "<result>Hey!! I am array Example3</result>" +
                "<br />" +
                "<br />" +
                "<h2>Collections</h2>" +
                "Collection is a very important part of the data structure, which makes the software development easy for engineers. Kotlin has two types of collection - one is immutable collection (which means lists, maps and sets that cannot be editable) and another is mutable collection (this type of collection is editable). It is very important to keep in mind the type of collection used in your application, as Kotlin system does not represent any specific difference in them.<br />" +
                "<code>fun main(args: Array<String>) { <br />" +
                "   val numbers: MutableList<Int> = mutableListOf(1, 2, 3) //mutable List <br />" +
                "   val readOnlyView: List<Int> = numbers                  // immutable list <br />" +
                "   println(\"my mutable list--\"+numbers)        // prints \"[1, 2, 3]\" <br />" +
                "   numbers.add(4) <br />" +
                "   println(\"my mutable list after addition --\"+numbers)        // prints \"[1, 2, 3, 4]\" <br />" +
                "   println(readOnlyView)     <br />" +
                "   readOnlyView.clear()    // ⇒ does not compile  <br />" +
                "// gives error  <br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser. It gives an error when we try to clear the mutable list of collection.<br />" +
                "<result>main.kt:9:18: error: unresolved reference: clear<br />" +
                "   readOnlyView.clear()    // -> does not compile  </result>" +
                "<br />" +
                "In collection, Kotlin provides some useful methods such as first(), last(), filter(), etc. All these methods are self-descriptive and easy to implement. Moreover, Kotlin follows the same structure such as Java while implementing collection. You are free to implement any collection of your choice such as Map and Set.<br />" +
                "<br />" +
                "In the following example, we have implemented Map and Set using different built-in methods.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val items = listOf(1, 2, 3, 4)<br />" +
                "   println(\"First Element of our list----\"+items.first())<br />" +
                "   println(\"Last Element of our list----\"+items.last())<br />" +
                "   println(\"Even Numbers of our List----\"+items.<br />" +
                "      filter { it % 2 = = 0 })   // returns [2, 4]<br />" +
                "   <br />" +
                "   val readWriteMap = hashMapOf(\"foo\" to 1, \"bar\" to 2)<br />" +
                "   println(readWriteMap[\"foo\"])  // prints \"1\"<br />" +
                "   <br />" +
                "   val strings = hashSetOf(\"a\", \"b\", \"c\", \"c\")<br />" +
                "   println(\"My Set Values are\"+strings)<br />" +
                "}</code>" +
                "The above piece of code yields the following output in the browser.<br />" +
                "<result>First Element of our list----1<br />" +
                "Last Element of our list----4<br />" +
                "Even Numbers of our List----[2, 4]<br />" +
                "1<br />" +
                "My Set Values are[a, b, c]</result>" +
                "<br />" +
                "<h2>Ranges</h2>" +
                "Ranges is another unique characteristic of Kotlin. Like Haskell, it provides an operator that helps you iterate through a range. Internally, it is implemented using rangeTo() and its operator form is (..).<br />" +
                "<br />" +
                "In the following example, we will see how Kotlin interprets this range operator.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val i:Int  = 2<br />" +
                "   for (j in 1..4) <br />" +
                "   print(j) // prints \"1234\"<br />" +
                "   <br />" +
                "   if (i in 1..10) { // equivalent of 1 < = i && i < = 10<br />" +
                "      println(\"we found your number --\"+i)<br />" +
                "   }<br />" +
                "}</code>" +
                "The above piece of code yields the following output in the browser.<br />" +
                "<result>1234we found your number --2</result>")

        insertTopic(5, "Control Flow", "<h1>Control Flow</h1>In the previous chapter we have learned about different types of data types available in Kotlin system. In this chapter, we will discuss different types of control flow mechanism available in the Kotlin.<br />" +
                "<br />" +
                "If - Else<br />" +
                "Kotlin is a functional language hence like every functional language in Kotlin “if” is an expression, it is not a keyword. The expression “if” will return a value whenever necessary. Like other programming language, “if-else” block is used as an initial conditional checking operator. In the following example, we will compare two variables and provide the required output accordingly.<br />" +
                "<code>" +
                "fun main(args: Array<String>) {<br />" +
                "   val a:Int = 5<br />" +
                "   val b:Int = 2<br />" +
                "   var max: Int<br />" +
                "   <br />" +
                "   if (a > b) {<br />" +
                "      max = a<br />" +
                "   } else {<br />" +
                "      max = b<br />" +
                "   }<br />" +
                "   print(\"Maximum of a or b is \" +max)<br />" +
                " <br />" +
                "   // As expression <br />" +
                "   // val max = if (a > b) a else b<br />" +
                "}</code>" +
                "The above piece of code yields the following output as a result in the browser. Our example also contains another line of code, which depicts how to use “If” statement as an expression.<br />" +
                "<result>Maximum of a or b is 5</result>" +
                "<br />" +
                "Use of When<br />" +
                "If you are familiar with other programming languages, then you might have heard of the term switch statement, which is basically a conditional operator when multiple conditions can be applied on a particular variable. “when” operator matches the variable value against the branch conditions. If it is satisfying the branch condition then it will execute the statement inside that scope. In the following example, we will learn more about “when” in Kotlin.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val x:Int = 5<br />" +
                "   when (x) {<br />" +
                "      1 -> print(\"x = = 1\")<br />" +
                "      2 -> print(\"x = = 2\")<br />" +
                "      <br />" +
                "      else -> { // Note the block<br />" +
                "         print(\"x is neither 1 nor 2\")<br />" +
                "      }<br />" +
                "   }<br />" +
                "}</code>" +
                "The above piece of code yields the following output in the browser.<br />" +
                "<result>fun main(args: Array<String>) {<br />" +
                "   val x:Int = 5<br />" +
                "   when (x) {<br />" +
                "      1 -> print(\"x = = 1\")<br />" +
                "      2 -> print(\"x = = 2\")<br />" +
                "      <br />" +
                "      else -> { // Note the block<br />" +
                "         print(\"x is neither 1 nor 2\")<br />" +
                "      }<br />" +
                "   }<br />" +
                "}</result>" +
                "<br />" +
                "The above piece of code yields the following output in the browser.<br />" +
                "<result>x is neither 1 nor 2</result>" +
                "In the above example, Kotlin compiler matches the value of x with the given branches. If it is not matching any of the branches, then it will execute the else part. Practically, when is equivalent to multiple if block. Kotlin provides another flexibility to the developer, where the developer can provide multiple checks in the same line by providing “,” inside the checks. Let us modify the above example as follows.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val x:Int = 5<br />" +
                "   when (x) {<br />" +
                "      1,2 -> print(\" Value of X either 1,2\")<br />" +
                "      <br />" +
                "      else -> { // Note the block<br />" +
                "         print(\"x is neither 1 nor 2\")<br />" +
                "      }<br />" +
                "   }<br />" +
                "}</code>" +
                "Run the same in the browser, which will yield the following output in the browser.<br />" +
                "<result>x is neither 1 nor 2</result>" +
                "<br />" +
                "For Loop<br />" +
                "Loop is such an invention that provides the flexibility to iterate through any kind of data structure. Like other programming languages, Kotlin also provides many kinds of Looping methodology, however, among them “For” is the most successful one. The implementation and use of For loop is conceptually similar to Java for loop. The following example shows how we can use the same in real-life examples.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val items = listOf(1, 2, 3, 4)<br />" +
                "   for (i in items) println(\"values of the array\"+i)<br />" +
                "}</code>" +
                "In the above piece of code, we have declared one list named as “items” and using for loop we are iterating through that defined list and printing its value in the browser. Following is the output.<br />" +
                "<result>values of the array1<br />" +
                "values of the array2<br />" +
                "values of the array3<br />" +
                "values of the array4</result>" +
                "<br />" +
                "Following is another example of code, where we are using some library function to make our development work easier than ever before.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val items = listOf(1, 22, 83, 4)<br />" +
                "   <br />" +
                "   for ((index, value) in items.withIndex()) {<br />" +
                "      println(\"the element at \$index is \$value\")<br />" +
                "   }<br />" +
                "}</code>" +
                "Once we compile and execute the above piece of code in our coding ground, it will yield the following output in the browser.<br />" +
                "<result>the element at 0 is 1<br />" +
                "the element at 1 is 22<br />" +
                "the element at 2 is 83<br />" +
                "the element at 3 is 4</result>" +
                "<br />" +
                "While Loop and Do-While Loop<br />" +
                "While and Do-While work exactly in a similar way like they do in other programming languages. The only difference between these two loops is, in case of Do-while loop the condition will be tested at the end of the loop. The following example shows the usage of the While loop." +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var x:Int = 0<br />" +
                "   println(\"Example of While Loop--\")<br />" +
                "   <br />" +
                "   while(x< = 10) {<br />" +
                "      println(x)<br />" +
                "      x++<br />" +
                "   } <br />" +
                "}</code>" +
                "The above piece of code yields the following output in the browser.<br />" +
                "<result>Example of While Loop--<br />" +
                "0<br />" +
                "1<br />" +
                "2<br />" +
                "3<br />" +
                "4<br />" +
                "5<br />" +
                "6<br />" +
                "7<br />" +
                "8<br />" +
                "9<br />" +
                "10</result>" +
                "<br />" +
                "Kotlin also has another loop called Do-While loop, where the loop body will be executed once, only then the condition will be checked. The following example shows the usage of the Do-while loop.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var x:Int = 0<br />" +
                "   do {<br />" +
                "      x = x + 10<br />" +
                "      println(\"I am inside Do block---\"+x)<br />" +
                "   } while(x <= 50)<br />" +
                "}</code>" +
                "The above piece of code yields the following output in the browser. In the above code, Kotlin compiler will execute the DO block, then it will go for condition checking in while block.<br />" +
                "<result>I am inside Do block---10<br />" +
                "I am inside Do block---20<br />" +
                "I am inside Do block---30<br />" +
                "I am inside Do block---40<br />" +
                "I am inside Do block---50<br />" +
                "I am inside Do block---60</result>" +
                "<br />" +
                "Use of Return, Break, Continue<br />" +
                "If you are familiar with any programming language, then you must have an idea of different keywords that help us implement good control flow in the application. Following are the different keywords that can be used to control the loops or any other types of control flow.<br />" +
                "<br />" +
                "Return − Return is a keyword that returns some value to the calling function from the called function. In the following example, we will implement this scenario using our Kotlin coding ground.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var x:Int = 10<br />" +
                "   println(\"The value of X is--\"+doubleMe(x))<br />" +
                "}<br />" +
                "fun doubleMe(x:Int):Int {<br />" +
                "   return 2*x;<br />" +
                "}</code>" +
                "In the above piece of code, we are calling another function and multiplying the input with 2, and returning the resultant value to the called function that is our main function. Kotlin defines the function in a different manner that we will look at in a subsequent chapter. For now, it is enough to understand that the above code will generate the following output in the browser.<br />" +
                "<result>The value of X is--20</result>" +
                "<br />" +
                "Continue & Break − Continue and break are the most vital part of a logical problem. The “break” keyword terminates the controller flow if some condition has failed and “continue” does the opposite. All this operation happens with immediate visibility. Kotlin is smarter than other programming languages, wherein the developer can apply more than one label as visibility. The following piece of code shows how we are implementing this label in Kotlin.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   println(\"Example of Break and Continue\")<br />" +
                "   myLabel@ for(x in 1..10) { // appling the custom label<br />" +
                "      if(x = = 5) {<br />" +
                "         println(\"I am inside if block with value\"+x+\"\n-- hence it will close the operation\")<br />" +
                "         break@myLabel //specifing the label<br />" +
                "      } else {<br />" +
                "         println(\"I am inside else block with value\"+x)<br />" +
                "         continue@myLabel<br />" +
                "      }<br />" +
                "   }<br />" +
                "}</code>" +
                "The above piece of code yields the following output in the browser.<br />" +
                "<result>Example of Break and Continue<br />" +
                "I am inside else block with value1<br />" +
                "I am inside else block with value2<br />" +
                "I am inside else block with value3<br />" +
                "I am inside else block with value4<br />" +
                "I am inside if block with value5<br />" +
                "-- hence it will close the operation</result>" +
                "<br />" +
                "As you can see, the controller continues the loop, until and unless the value of x is 5. Once the value of x reaches 5, it starts executing the if block and once the break statement is reached, the entire control flow terminates the program execution.")
        insertTopic(6, "Class & Object", "<h1>Class & Object</h1>In this chapter, we will learn the basics of Object-Oriented Programming (OOP) using Kotlin. We will learn about class and its object and how to play with that object. By definition of OOP, a class is a blueprint of a runtime entity and object is its state, which includes both its behavior and state. In Kotlin, class declaration consists of a class header and a class body surrounded by curly braces, similar to Java.<br />" +
                "<code>Class myClass { // class Header <br />" +
                "<br />" +
                "   // class Body<br />" +
                "}</code>" +
                "Like Java, Kotlin also allows to create several objects of a class and you are free to include its class members and functions. We can control the visibility of the class members variables using different keywords that we will learn in Chapter 10 – Visibility Control. In the following example, we will create one class and its object through which we will access different data members of that class.<br />" +
                "<code>class myClass {<br />" +
                "   // property (data member)<br />" +
                "   private var name: String = \"Kotlearn\"<br />" +
                "   <br />" +
                "   // member function<br />" +
                "   fun printMe() {<br />" +
                "      print(\"You are at the best Learning website Named-\"+name)<br />" +
                "   }<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   val obj = myClass() // create obj object of myClass class<br />" +
                "   obj.printMe()<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser, where we are calling printMe() of myClass using its own object.<br />" +
                "<result>You are at the best Learning website Named- KotLearn</result>" +
                "<br />" +
                "Nested Class<br />" +
                "By definition, when a class has been created inside another class, then it is called as a nested class. In Kotlin, nested class is by default static, hence, it can be accessed without creating any object of that class. In the following example, we will see how Kotlin interprets our nested class.<br />" +
                "<code>un main(args: Array<String>) {<br />" +
                "   val demo = Outer.Nested().foo() // calling nested class method<br />" +
                "   print(demo)<br />" +
                "}<br />" +
                "class Outer {<br />" +
                "   class Nested {<br />" +
                "      fun foo() = \"Welcome to KotLearn\"<br />" +
                "   }<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Welcome to KotLearn</result>" +
                "<br />" +
                "Inner Class<br />" +
                "When a nested class is marked as a “inner”, then it will be called as an Inner class. An inner class can be accessed by the data member of the outer class. In the following example, we will be accessing the data member of the outer class.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val demo = Outer().Nested().foo() // calling nested class method<br />" +
                "   print(demo)<br />" +
                "}<br />" +
                "class Outer {<br />" +
                "   private val welcomeMessage: String = \"Welcome to the TutorialsPoint.com\"<br />" +
                "   inner class Nested {<br />" +
                "      fun foo() = welcomeMessage<br />" +
                "   }<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser, where we are calling the nested class using the default constructor provided by Kotlin compilers at the time of compiling.<br />" +
                "<result>Welcome to the TutorialsPoint.com</result>" +
                "<br />" +
                "Anonymous Inner Class<br />" +
                "Anonymous inner class is a pretty good concept that makes the life of a programmer very easy. Whenever we are implementing an interface, the concept of anonymous inner block comes into picture. The concept of creating an object of interface using runtime object reference is known as anonymous class. In the following example, we will create an interface and we will create an object of that interface using Anonymous Inner class mechanism.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var programmer :Human = object:Human // creating an instance of the interface {<br />" +
                "      override fun think() { // overriding the think method<br />" +
                "         print(\"I am an example of Anonymous Inner Class \")<br />" +
                "      }<br />" +
                "   }<br />" +
                "   programmer.think()<br />" +
                "}<br />" +
                "interface Human {<br />" +
                "   fun think()<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>I am an example of Anonymous Inner Class </result>" +
                "<br />" +
                "Type Aliases<br />" +
                "Type aliases are a property of Kotlin compiler. It provides the flexibility of creating a new name of an existing type, it does not create a new type. If the type name is too long, you can easily introduce a shorter name and use the same for future usage. Type aliases is really helpful for complex type. In the latest version, Kotlin revoked the support for type aliases, however, if you are using an old version of Kotlin you may have use it like the following −<br />" +
                "<code>typealias NodeSet = Set<Network.Node><br />" +
                "typealias FileTable<K> = MutableMap<K, MutableList<File>></code>")
        insertTopic(7, "Constructors", "<h1>Constructors</h1>In this chapter, we will learn about constructors in Kotlin. Kotlin has two types of constructor - one is the primary constructor and the other is the secondary constructor. One Kotlin class can have one primary constructor, and one or more secondary constructor. Java constructor initializes the member variables, however, in Kotlin the primary constructor initializes the class, whereas the secondary constructor helps to include some extra logic while initializing the same. The primary constructor can be declared at class header level as shown in the following example.<br />" +
                "<code>class Person(val firstName: String, var age: Int) {<br />" +
                "   // class body<br />" +
                "}</code>" +
                "In the above example, we have declared the primary constructor inside the parenthesis. Among the two fields, first name is read-only as it is declared as “val”, while the field age can be edited. In the following example, we will use the primary constructor.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val person1 = Person(\"TutorialsPoint.com\", 15)<br />" +
                "   println(\"First Name = \${person1.firstName}\")<br />" +
                "   println(\"Age = \${person1.age}\")<br />" +
                "}<br />" +
                "class Person(val firstName: String, var age: Int) {<br />" +
                "}</code>" +
                "The above piece of code will automatically initialize the two variables and provide the following output in the browser.<br />" +
                "<result>First Name = TutorialsPoint.com<br />" +
                "Age = 15</result>" +
                "<br />" +
                "As mentioned earlier, Kotlin allows to create one or more secondary constructors for your class. This secondary constructor is created using the “constructor” keyword. It is required whenever you want to create more than one constructor in Kotlin or whenever you want to include more logic in the primary constructor and you cannot do that because the primary constructor may be called by some other class. Take a look at the following example, where we have created a secondary constructor and are using the above example to implement the same.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val HUman = HUman(\"TutorialsPoint.com\", 25)<br />" +
                "   print(\"\${HUman.message}\"+\"\${HUman.firstName}\"+<br />" +
                "      \"Welcome to the example of Secondary  constructor, Your Age is-\${HUman.age}\")<br />" +
                "}<br />" +
                "class HUman(val firstName: String, var age: Int) {<br />" +
                "   val message:String  = \"Hey!!!\"<br />" +
                "\tconstructor(name : String , age :Int ,message :String):this(name,age) {<br />" +
                "   }<br />" +
                "}</code>" +
                "Note − Any number of secondary constructors can be created, however, all of those constructors should call the primary constructor directly or indirectly.<br />" +
                "<br />" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Hey!!! TutorialsPoint.comWelcome to the example of Secondary  constructor, Your Age is- 25</result>")
        insertTopic(8, "Inheritance", "<h1>Inheritance</h1>In this chapter, we will learn about inheritance. By definition, we all know that inheritance means accruing some properties of the mother class into the child class. In Kotlin, the base class is named as “Any”, which is the super class of the ‘any’ default class declared in Kotlin. Like all other OOPS, Kotlin also provides this functionality using one keyword known as “:”.<br />" +
                "<br />" +
                "Everything in Kotlin is by default final, hence, we need to use the keyword “open” in front of the class declaration to make it allowable to inherit. Take a look at the following example of inheritance.<br />" +
                "<code>import java.util.Arrays<br />" +
                "<br />" +
                "open class ABC {<br />" +
                "   fun think () {<br />" +
                "      print(\"Hey!! i am thiking \")<br />" +
                "   }<br />" +
                "}<br />" +
                "class BCD: ABC(){ // inheritence happend using default constructor <br />" +
                "}<br />" +
                "<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   var  a = BCD()<br />" +
                "   a.think()<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Hey!! i am thiking </result>" +
                "<br />" +
                "Now, what if we want to override the think() method in the child class. Then, we need to consider the following example where we are creating two classes and override one of its function into the child class.<br />" +
                "<code>import java.util.Arrays<br />" +
                "<br />" +
                "open class ABC {<br />" +
                "   open fun think () {<br />" +
                "      print(\"Hey!! i am thinking \")<br />" +
                "   }<br />" +
                "}<br />" +
                "class BCD: ABC() { // inheritance happens using default constructor <br />" +
                "   override fun think() {<br />" +
                "      print(\"I Am from Child\")<br />" +
                "   }<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   var  a = BCD()<br />" +
                "   a.think()<br />" +
                "}</code>" +
                "The above piece of code will call the child class inherited method and it will yield the following output in the browser. Like Java, Kotlin too doesn’t allow multiple inheritances.<br />" +
                "<result>I Am from Child </result>")
        insertTopic(9, "Interface ", "<h1>Interface</h1>In this chapter, we will learn about the interface in Kotlin. In Kotlin, the interface works exactly similar to Java 8, which means they can contain method implementation as well as abstract methods declaration. An interface can be implemented by a class in order to use its defined functionality. We have already introduced an example with an interface in Chapter 6 - section “anonymous inner class”. In this chapter, we will learn more about it. The keyword “interface” is used to define an interface in Kotlin as shown in the following piece of code.<br />" +
                "<code>interface ExampleInterface {<br />" +
                "   var myVar: String     // abstract property<br />" +
                "   fun absMethod()       // abstract method<br />" +
                "   fun sayHello() = \"Hello there\" // method with default implementation<br />" +
                "}</code>" +
                "In the above example, we have created one interface named as “ExampleInterface” and inside that we have a couple of abstract properties and methods all together. Look at the function named “sayHello()”, which is an implemented method.<br />" +
                "<br />" +
                "In the following example, we will be implementing the above interface in a class.<br />" +
                "<code>interface ExampleInterface  {<br />" +
                "   var myVar: Int            // abstract property<br />" +
                "   fun absMethod():String    // abstract method<br />" +
                "   <br />" +
                "   fun hello() {<br />" +
                "      println(\"Hello there, Welcome to TutorialsPoint.Com!\")<br />" +
                "   }<br />" +
                "}<br />" +
                "class InterfaceImp : ExampleInterface {<br />" +
                "   override var myVar: Int = 25<br />" +
                "   override fun absMethod() = \"Happy Learning \"<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   val obj = InterfaceImp()<br />" +
                "   println(\"My Variable Value is = \${obj.myVar}\")<br />" +
                "   print(\"Calling hello(): \")<br />" +
                "   obj.hello()<br />" +
                "   <br />" +
                "   print(\"Message from the Website-- \")<br />" +
                "   println(obj.absMethod())<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Calling hello(): Hello there, Welcome to TutorialsPoint.Com!<br />" +
                "Message from the Website-- Happy Learning </result>" +
                "<br />" +
                "As mentioned earlier, Kotlin doesn’t support multiple inheritances, however, the same thing can be achieved by implementing more than two interfaces at a time.<br />" +
                "<br />" +
                "In the following example, we will create two interfaces and later we will implement both the interfaces into a class.<br />" +
                "<code>interface A {<br />" +
                "   fun printMe() {<br />" +
                "      println(\" method of interface A\")<br />" +
                "   }<br />" +
                "}<br />" +
                "interface B  {<br />" +
                "   fun printMeToo() {<br />" +
                "      println(\"I am another Method from interface B\")<br />" +
                "   }<br />" +
                "}<br />" +
                "<br />" +
                "// implements two interfaces A and B<br />" +
                "class multipleInterfaceExample: A, B<br />" +
                "<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   val obj = multipleInterfaceExample()<br />" +
                "   obj.printMe()<br />" +
                "   obj.printMeToo()<br />" +
                "}</code>" +
                "In the above example, we have created two sample interfaces A, B and in the class named “multipleInterfaceExample” we have implemented two interfaces declared earlier. The above piece of code will yield the following output in the browser.<br />" +
                "<code>method of interface A<br />" +
                "I am another Method from interface B</code>")
        insertTopic(10, "Visibility Control", "<h1>Visibility Control</h1>In this chapter, we will learn about different modifiers available in Kotlin language. Access modifier is used to restrict the usage of the variables, methods and class used in the application. Like other OOP programming language, this modifier is applicable at multiple places such as in the class header or method declaration. There are four access modifiers available in Kotlin.<br />" +
                "<br />" +
                "Private<br />" +
                "The classes, methods, and packages can be declared with a private modifier. Once anything is declared as private, then it will be accessible within its immediate scope. For instance, a private package can be accessible within that specific file. A private class or interface can be accessible only by its data members, etc.<br />" +
                "<code>private class privateExample {<br />" +
                "   private val i = 1<br />" +
                "   private val doSomething() {<br />" +
                "   }<br />" +
                "}</code>" +
                "In the above example, the class “privateExample” and the variable i both can be accessible only in the same Kotlin file, where its mentioned as they all are declared as private in the declaration block.<br />" +
                "<br />" +
                "Protected<br />" +
                "Protected is another access modifier for Kotlin, which is currently not available for top level declaration like any package cannot be protected. A protected class or interface is visible to its subclass only.<br />" +
                "<code>class A() {<br />" +
                "   protected val i = 1<br />" +
                "}<br />" +
                "class B : A() {<br />" +
                "   fun getValue() : Int {<br />" +
                "      return i<br />" +
                "   }<br />" +
                "}</code>" +
                "In the above example, the variable “i” is declared as protected, hence, it is only visible to its subclass.<br />" +
                "<br />" +
                "Internal<br />" +
                "Internal is a newly added modifier introduced in Kotlin. If anything is marked as internal, then that specific field will be in the internal field. An Internal package is visible only inside the module under which it is implemented. An internal class interface is visible only by other class present inside the same package or the module. In the following example, we will see how to implement an internal method.<br />" +
                "<code>class internalExample {<br />" +
                "   internal val i = 1<br />" +
                "   internal fun doSomething() {<br />" +
                "   }<br />" +
                "}</code>" +
                "In the above example, the method named “doSomething” and the variable is mentioned as internal, hence, these two fields can be accessible only inside the package under which it is declared.<br />" +
                "<br />" +
                "Public<br />" +
                "Public modifier is accessible from anywhere in the project workspace. If no access modifier is specified, then by default it will be in the public scope. In all our previous examples, we have not mentioned any modifier, hence, all of them are in the public scope. Following is an example to understand more on how to declare a public variable or method.<br />" +
                "<code>class publicExample {<br />" +
                "   val i = 1<br />" +
                "   fun doSomething() {<br />" +
                "   }<br />" +
                "}</code>" +
                "In the above example, we have not mentioned any modifier, thus all these methods and variables are by default public.")

        insertTopic(11, "Extension", "<h1>Extension</h1>In this chapter, we will learn about another new feature of Kotlin named “Extension”. Using extension, we will be able to add or remove some method functionality even without inheriting or modifying them. Extensions are resolved statistically. It does not actually modify the existing class, but it creates a callable function that can be called with a dot operation.<br />" +
                "<br />" +
                "Function Extension<br />" +
                "In function extension, Kotlin allows to define a method outside of the main class. In the following example, we will see how the extension is implemented at the functional level.<br />" +
                "<code>class Alien {<br />" +
                "   var skills : String = \"null\"<br />" +
                "\t<br />" +
                "   fun printMySkills() {<br />" +
                "      print(skills)<br />" +
                "   }\t\t<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   var  a1 = Alien()<br />" +
                "   a1.skills = \"JAVA\"<br />" +
                "   //a1.printMySkills()<br />" +
                "\t<br />" +
                "   var  a2 = Alien()<br />" +
                "   a2.skills = \"SQL\"<br />" +
                "   //a2.printMySkills()<br />" +
                "\t<br />" +
                "   var  a3 = Alien()<br />" +
                "   a3.skills = a1.addMySkills(a2)<br />" +
                "   a3.printMySkills()<br />" +
                "}<br />" +
                "fun Alien.addMySkills(a:Alien):String{<br />" +
                "   var a4 = Alien()<br />" +
                "   a4.skills = this.skills + \" \" +a.skills<br />" +
                "   return a4.skills<br />" +
                "}</code>" +
                "In the above example, we don’t have any method inside “Alien” class named as “addMySkills()”, however, we still are implementing the same method somewhere else outside of the class, This is the magic of extension.<br />" +
                "<br />" +
                "The above piece of code will generate the following output in the browser.<br />" +
                "<result>JAVA SQL</result>" +
                "<br />" +
                "bject Extension<br />" +
                "Kotlin provides another mechanism to implement static functionality of Java. This can be achieved using the keyword “companion object”. Using this mechanism, we can create an object of a class inside a factory method and later we can just call that method using the reference of the class name. In the following example, we will create a “companion object”.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   println(\"Heyyy!!!\"+A.show())<br />" +
                "}<br />" +
                "class A {<br />" +
                "   companion object {<br />" +
                "      fun show():String {<br />" +
                "         return(\"You are learning Kotlin from TutorialsPoint.com\")<br />" +
                "      }<br />" +
                "   }<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Heyyy!!! You are learning Kotlin from TutorialsPoint.com</result>" +
                "<br />" +
                "The above example seems like static in Java, however, in real-time we are creating an object as a member variable of that same class. This is why it is also included under extension property and can be alternatively called as an object extension. You are basically extending the object of the same class to use some of the member functions.")

        insertTopic(12, "Data Classes", "<h1>Data Classes</h1>In this chapter, we will learn more about Data classes of Kotlin programming language. A class can be marked as a Data class whenever it is marked as ”data”. This type of class can be used to hold the basic data apart. Other than this, it does not provide any other functionality.<br />" +
                "<br />" +
                "All the data classes need to have one primary constructor and all the primary constructor should have at least one parameter. Whenever a class is marked as data, we can use some of the inbuilt function of that data class such as “toString()”,”hashCode()”, etc. Any data class cannot have a modifier like abstract and open or internal. Data class can be extended to other classes too. In the following example, we will create one data class.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val book: Book = Book(\"Kotlin\", \"TutorialPoint.com\", 5)<br />" +
                "   println(\"Name of the Book is--\"+book.name) // \"Kotlin\"<br />" +
                "   println(\"Puclisher Name--\"+book.publisher) // \"TutorialPoint.com\"<br />" +
                "   println(\"Review of the book is--\"+book.reviewScore) // 5<br />" +
                "   book.reviewScore = 7<br />" +
                "   println(\"Printing all the info all together--\"+book.toString()) <br />" +
                "   //using inbuilt function of the data class <br />" +
                "   <br />" +
                "   println(\"Example of the hashCode function--\"+book.hashCode())<br />" +
                "}<br />" +
                "<br />" +
                "data class Book(val name: String, val publisher: String, var reviewScore: Int)</code>" +
                "The above piece of code will yield the following output in the browser, where we have created one data class to hold some of the data, and from the main function we have accessed all of its data members.<br />" +
                "<result>Name of the Book is--\"Kotlin\"<br />" +
                "Puclisher Name--\"TutorialPoint.com\"<br />" +
                "Review of the book is--5<br />" +
                "Printing all the info all together--(name-Kotlin, publisher-TutorialPoint.com, reviewScore-7)<br />" +
                "Example of the hashCode function---1753517245</result>")

        insertTopic(13, "Sealed Class", "<h1>Sealed Class</h1>In this chapter, we will learn about another class type called “Sealed” class. This type of class is used to represent a restricted class hierarchy. Sealed allows the developers to maintain a data type of a predefined type. To make a sealed class, we need to use the keyword “sealed” as a modifier of that class. A sealed class can have its own subclass but all those subclasses need to be declared inside the same Kotlin file along with the sealed class. In the following example, we will see how to use a sealed class.<br />" +
                "<code>sealed class MyExample {<br />" +
                "   class OP1 : MyExample() // MyExmaple class can be of two types only<br />" +
                "   class OP2 : MyExample()<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   val obj: MyExample = MyExample.OP2() <br />" +
                "   <br />" +
                "   val output = when (obj) { // defining the object of the class depending on the inuputs <br />" +
                "      is MyExample.OP1 -> \"Option One has been chosen\"<br />" +
                "      is MyExample.OP2 -> \"option Two has been chosen\"<br />" +
                "   }<br />" +
                "   <br />" +
                "   println(output)<br />" +
                "}</code>" +
                "In the above example, we have one sealed class named “MyExample”, which can be of two types only - one is “OP1” and another one is “OP2”. In the main class, we are creating an object in our class and assigning its type at runtime. Now, as this “MyExample” class is sealed, we can apply the “when ” clause at runtime to implement the final output.<br />" +
                "<br />" +
                "In sealed class, we need not use any unnecessary “else” statement to complex out the code. The above piece of code will yield the following output in the browser.<br />" +
                "<result>option Two has been chosen</result>")

        insertTopic(14, "Generics", "<h1>Generics</h1>Like Java, Kotlin provides higher order of variable typing called as Generics. In this chapter, we will learn how Kotlin implements Generics and how as a developer we can use those functionalities provided inside the generics library. Implementation wise, generics is pretty similar to Java but Kotlin developer has introduced two new keywords “out” and “in” to make Kotlin codes more readable and easy for the developer.<br />" +
                "<br />" +
                "In Kotlin, a class and a type are totally different concepts. As per the example, List is a class in Kotlin, whereas List<String> is a type in Kotlin. The following example depicts how generics is implemented in Kotlin.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val integer: Int = 1<br />" +
                "   val number: Number = integer<br />" +
                "   print(number)<br />" +
                "}</code>" +
                "In the above code, we have declared one “integer” and later we have assigned that variable to a number variable. This is possible because “Int” is a subclass of Number class, hence the type conversion happens automatically at runtime and produces the output as “1”.<br />" +
                "<br />" +
                "Let us learn something more about generics in Kotlin. It is better to go for generic data type whenever we are not sure about the data type we are going to use in the application. Generally, in Kotlin generics is defined by <T> where “T” stands for template, which can be determined dynamically by Kotlin complier. In the following example, we will see how to use generic data types in Kotlin programming language.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var objet = genericsExample<String>(\"JAVA\")<br />" +
                "   var objet1 = genericsExample<Int>(10)<br />" +
                "}<br />" +
                "class genericsExample<T>(input:T) {<br />" +
                "   init {<br />" +
                "      println(\"I am getting called with the value \"+input)<br />" +
                "   }<br />" +
                "}</code>" +
                "In the above piece of code, we are creating one class with generic return type, which is represented as <T>. Take a look at the main method, where we have dynamically defined its value at the run by proving the value type, while creating the object of this class. This is how generics is interpreted by Kotlin compiler. We will get the following output in the browser, once we run this code in our coding ground.<br />" +
                "<result>I am getting called with the value JAVA<br />" +
                "I am getting called with the value 10</result>" +
                "<br />" +
                "When we want to assign the generic type to any of its super type, then we need to use “out” keyword, and when we want to assign the generic type to any of its sub-type, then we need to use “in” keyword. In the following example, we will use “out” keyword. Similarly, you can try using “in” keyword.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   var objet1 = genericsExample<Int>(10)<br />" +
                "   var object2 = genericsExample<Double>(10.00)<br />" +
                "   println(objet1)<br />" +
                "   println(object2)<br />" +
                "}<br />" +
                "class genericsExample<out T>(input:T) {<br />" +
                "   init {<br />" +
                "      println(\"I am getting called with the value \"+input)<br />" +
                "   }<br />" +
                "}</code>" +
                "The above code will yield the following output in the browser.<br />" +
                "<result>I am getting called with the value 10<br />" +
                "I am getting called with the value 10.0<br />" +
                "genericsExample@28d93b30<br />" +
                "genericsExample@1b6d3586</result>")

        insertTopic(15, "Delegation", "<h1>Delegation</h1>Kotlin supports “delegation” design pattern by introducing a new keyword “by”. Using this keyword or delegation methodology, Kotlin allows the derived class to access all the implemented public methods of an interface through a specific object. The following example demonstrates how this happens in Kotlin.<br />" +
                "<code>interface Base {<br />" +
                "   fun printMe() //abstract method<br />" +
                "}<br />" +
                "class BaseImpl(val x: Int) : Base {<br />" +
                "   override fun printMe() { println(x) }   //implementation of the method<br />" +
                "}<br />" +
                "class Derived(b: Base) : Base by b  // delegating the public method on the object b<br />" +
                "<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   val b = BaseImpl(10)<br />" +
                "   Derived(b).printMe() // prints 10 :: accessing the printMe() method <br />" +
                "}</code>" +
                "In the example, we have one interface “Base” with its abstract method named “printme()”. In the BaseImpl class, we are implementing this “printme()” and later from another class we are using this implementation using “by” keyword.<br />" +
                "<br />" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>10</result>" +
                "Property Delegation<br />" +
                "In the previous section, we have learned about the delegation design pattern using “by” keyword. In this section, we will learn about delegation of properties using some standard methods mentioned in Kotlin library.<br />" +
                "<br />" +
                "Delegation means passing the responsibility to another class or method. When a property is already declared in some places, then we should reuse the same code to initialize them. In the following examples, we will use some standard delegation methodology provided by Kotlin and some standard library function while implementing delegation in our examples.<br />" +
                "<br />" +
                "Using Lazy()<br />" +
                "Lazy is a lambda function which takes a property as an input and in return gives an instance of Lazy<T>, where <T> is basically the type of the properties it is using. Let us take a look at the following to understand how it works.<br />" +
                "<code>val myVar: String by lazy {<br />" +
                "   \"Hello\"<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   println(myVar +\" My dear friend\")<br />" +
                "}</code>" +
                "In the above piece of code, we are passing a variable “myVar” to the Lazy function, which in return assigns the value to its object and returns the same to the main function. Following is the output in the browser.<br />" +
                "<result>Hello My dear friend</result>" +
                "<br />" +
                "Delegetion.Observable()<br />" +
                "Observable() takes two arguments to initialize the object and returns the same to the called function. In the following example, we will see how to use Observable() method in order to implement delegation.<br />" +
                "<code>import kotlin.properties.Delegates<br />" +
                "class User {<br />" +
                "   var name: String by Delegates.observable(\"Welcome to Tutorialspoint.com\") {<br />" +
                "      prop, old, new -><br />" +
                "      println(\"\$old -> \$new\")<br />" +
                "   }<br />" +
                "}<br />" +
                "fun main(args: Array<String>) {<br />" +
                "   val user = User()<br />" +
                "   user.name = \"first\"<br />" +
                "   user.name = \"second\"<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<code>first -> second</code>" +
                "In general, the syntax is the expression after the “by” keyword is delegated. The get() and set() methods of the variable p will be delegated to its getValue() and setValue() methods defined in the Delegate class.<br />" +
                "<code>class Example {<br />" +
                "   var p: String by Delegate()<br />" +
                "}</code>" +
                "For the above piece of code, following is the delegate class that we need to generate in order to assign the value in the variable p.<br />" +
                "<code>class Delegate {<br />" +
                "   operator fun getValue(thisRef: Any?, property: KProperty<*>): String {<br />" +
                "      return \"\$thisRef, thank you for delegating '\${property.name}' to me!\"<br />" +
                "   }<br />" +
                "   operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {<br />" +
                "      println(\"\$value has been assigned to '\${property.name} in $\thisRef.'\")<br />" +
                "   }</code>" +
                "While reading, getValue() method will be called and while setting the variable setValue() method will be called.")

        insertTopic(16, "Functions", "<h1>Functions</h1>Kotlin is a statically typed language, hence, functions play a great role in it. We are pretty familiar with function, as we are using function throughout the examples. Function is declared with the keyword “fun”. Like any other OOP, it also needs a return type and an option argument list.<br />" +
                "<br />" +
                "In the following example, we are defining a function called MyFunction and from the main function we are calling this function and passing some argument.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   println(MyFunction(\"tutorialsPoint.com\"))<br />" +
                "}<br />" +
                "fun MyFunction(x: String): String {<br />" +
                "   var c:String  = \"Hey!! Welcome To ---\"<br />" +
                "   return (c+x)<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>Hey!! Welcome To ---tutorialsPoint.com</result>" +
                "<br />" +
                "The function should be declared as follows −<br />" +
                "<code>fun <nameOfFunction>(<argument>:<argumentType>):<ReturnType></code>" +
                "Following are some of the different types of function available in Kotlin.<br />" +
                "<br />" +
                "Lambda Function<br />" +
                "Lambda is a high level function that drastically reduces the boiler plate code while declaring a function and defining the same. Kotlin allows you to define your own lambda. In Kotlin, you can declare your lambda and pass that lambda to a function.<br />" +
                "<br />" +
                "Take a look at the following example.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val mylambda :(String)->Unit  = {s:String->print(s)}<br />" +
                "   val v:String = \"TutorialsPoint.com\"<br />" +
                "   mylambda(v)<br />" +
                "}</code>" +
                "In the above code, we have created our own lambda known as “mylambda” and we have passed one variable to this lambda, which is of type String and contains a value “TutorialsPoint.com”.<br />" +
                "<br />" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>TutorialsPoint.com</result>" +
                "<br />" +
                "Inline Function<br />" +
                "The above example shows the basic of the lambda expression that we can use in Kotlin application. Now, we can pass a lambda to another function to get our output which makes the calling function an inline function.<br />" +
                "<br />" +
                "Take a look at the following example.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val mylambda:(String)->Unit  = {s:String->print(s)}<br />" +
                "   val v:String = \"TutorialsPoint.com\"<br />" +
                "   myFun(v,mylambda) //passing lambda as a parameter of another function <br />" +
                "}<br />" +
                "fun myFun(a :String, action: (String)->Unit) { //passing lambda <br />" +
                "   print(\"Heyyy!!!\")<br />" +
                "   action(a)// call to lambda function<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser. Using inline function, we have passed a lambda as a parameter. Any other function can be made an inline function using the “inline” keyword.<br />" +
                "<result>Heyyy!!!TutorialsPoint.com</result>")

        insertTopic(17, "Destructuring Declarations", "<h1>Destructuring Declarations</h1>Kotlin contains many features of other programming languages. It allows you to declare multiple variables at once. This technique is called Destructuring declaration.<br />" +
                "<br />" +
                "Following is the basic syntax of the destructuring declaration.<br />" +
                "<code>val (name, age) = person</code>" +
                "In the above syntax, we have created an object and defined all of them together in a single statement. Later, we can use them as follows.<br />" +
                "<code>println(name)<br />" +
                "println(age)</code>" +
                "Now, let us see how we can use the same in our real-life application. Consider the following example where we are creating one Student class with some attributes and later we will be using them to print the object values.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   val s = Student(\"TutorialsPoint.com\",\"Kotlin\")<br />" +
                "   val (name,subject) = s<br />" +
                "   println(\"You are learning \"+subject+\" from \"+name)<br />" +
                "}<br />" +
                "data class Student( val a :String,val b: String ){<br />" +
                "   var name:String = a<br />" +
                "   var subject:String = b<br />" +
                "}</code>" +
                "The above piece of code will yield the following output in the browser.<br />" +
                "<result>You are learning Kotlin from TutorialsPoint.com</result>")

        insertTopic(18, "Exception Handling", "<h1>Exception Handling</h1>Exception handling is a very important part of a programming language. This technique restricts our application from generating the wrong output at runtime. In this chapter, we will learn how to handle runtime exception in Kotlin. The exceptions in Kotlin is pretty similar to the exceptions in Java. All the exceptions are descendants of the “Throwable” class. Following example shows how to use exception handling technique in Kotlin.<br />" +
                "<code>fun main(args: Array<String>) {<br />" +
                "   try {<br />" +
                "      val myVar:Int = 12;<br />" +
                "      val v:String = \"Tutorialspoint.com\";<br />" +
                "      v.toInt();<br />" +
                "   } catch(e:Exception) {<br />" +
                "      e.printStackTrace();<br />" +
                "   } finally {<br />" +
                "      println(\"Exception Handeling in Kotlin\");<br />" +
                "   }<br />" +
                "}</code>" +
                "In the above piece of code, we have declared a String and later tied that string into the integer, which is actually a runtime exception. Hence, we will get the following output in the browser.<br />" +
                "<result>val myVar:Int = 12;<br />" +
                "Exception Handeling in Kotlin</result>" +
                "<br />" +
                "Note − Like Java, Kotlin also executes the finally block after executing the catch block.")

    }

    private fun insertTopic(id: Int, topicHeader: String, topicContent: String) {
        val topic = TopicRecord(id, topicHeader, topicContent)
        topicDbHelper.insertTopic(topic)
    }
}
