/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entity.ContentEntity;
import entity.TopicEntity;
import session.ContentSessionLocal;
import session.TopicSessionLocal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sinhv
 */
@Singleton
@LocalBean
@Startup
public class DataInit {
    @EJB
    private ContentSessionLocal contentSessionLocal;
    @EJB
    private TopicSessionLocal topicSessionLocal;
    
    public DataInit() {
    }

    @PostConstruct
    public void postConstruct() {
        createTopics();
        String text = "";
        List<String> contents = new ArrayList<>();
        contents.add("Kotlin is a new open source programming language like Java, JavaScript, etc. It is a high level strongly statically typed language that combines functional and technical part in a same place. Currently, Kotlin targets Java and JavaScript. It runs on JVM.\n" +
                "\n" +
                "Kotlin is influenced by other programming languages such as Java, Scala, Groovy, Gosu, etc. The syntax of Kotlin may not be exactly similar to JAVA, however, internally Kotlin is reliant on the existing Java Class library to produce wonderful results for the programmers. Kotlin provides interoperability, code safety, and clarity to the developers around the world.\n" +
                "\n" +
                "Advantages and Disadvantages\n" +
                "Following are some of the advantages of using Kotlin for your application development.\n" +
                "\n" +
                "Easy Language − Kotlin is a functional language and very easy to learn. The syntax is pretty much similar to Java, hence it is very easy to remember. Kotlin is more expressive, which makes your code more readable and understandable.\n" +
                "\n" +
                "Concise − Kotlin is based on JVM and it is a functional language. Thus, it reduce lots of boiler plate code used in other programming languages.\n" +
                "\n" +
                "Runtime and Performance − Better performance and small runtime.\n" +
                "\n" +
                "Interoperability − Kotlin is mature enough to build an interoperable application in a less complex manner.\n" +
                "\n" +
                "Brand New − Kotlin is a brand new language that gives developers a fresh start. It is not a replacement of Java, though it is developed over JVM. It is accepted as the first official language of android development. Kotlin can be defined as - Kotlin = JAVA + extra updated new features.\n" +
                "\n" +
                "Following are some of the disadvantages of Kotlin.\n" +
                "\n" +
                "Namespace declaration − Kotlin allows developers to declare the functions at the top level. However, whenever the same function is declared in many places of your application, then it is hard to understand which function is being called.\n" +
                "\n" +
                "No Static Declaration − Kotlin does not have usual static handling modifier like Java, which can cause some problem to the conventional Java developer.");

        contents.add("However, if you still want to use Kotlin offline in your local system, then you need to execute the following steps to configure your local workspace.\n" +
                "\n" +
                "Step 1 − Java 8 installation.\n" +
                "\n" +
                "Kotlin runs on JVM, hence. it is really necessary to use JDK 8 for your local Kotlin development. Please refer to the official website of oracle to download and install JDK 8 or an above version. You might have to set the environment variable for JAVA such that it can work properly. To verify your installation in Windows operating system, hit “java –version” in the command prompt and as an output it will show you the java version installed in your system.\n" +
                "\n" +
                "Step 2 − IDE installation.\n" +
                "\n" +
                "There are a number of IDE available over the internet. You can use any of your choice.\n" +
                "\n" +
                "NetBeans: https://netbeans.org/downloads/\n" +
                "Eclipse: https://www.eclipse.org/downloads/\n" +
                "Intellij: https://www.jetbrains.com/idea/download/#section = windows\n" +
                "\n" +
                "It is always recommended to use the recent software version to drag out maximum facility from it.\n" +
                "\n" +
                "Step 3 − Configuring Eclipse.\n" +
                "\n" +
                "Open Eclipse and go to “Eclipse Market Place”.\n" +
                "\n" +
                "Search for Kotlin in the search box and install the same in your local system. It might take some time depending on the internet speed. You may have to restart your Eclipse, once it is successfully installed.\n" +
                "\n" +
                "Step 4 − Kotlin Project.\n" +
                "\n" +
                "Once Eclipse is successfully restarted and Kotlin is installed, you will be able to create a Kotlin project on the fly. Go to File → New → Others and select “Kotlin project” from the list.\n" +
                "\n" +
                "Once the project setup is done, you can create a Kotlin file under “SRC” folder. Left-click on the “Src” folder and hit “new”. You will get an option for Kotlin file, otherwise you may have to search from the “others”.\n" +
                "\n" +
                "Your development environment is ready now. Go ahead and add the following piece of code in the “Hello.kt” file.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   println(\"Hello, World!\")\n" +
                "}</code>" +
                "\n" +
                "Run it as a Kotlin application and see the output in the console as shown in the following screenshot.\n" +
                "\n" +
                "<result>Hello, World!</result>");

        contents.add("Kotlin is a programming language and has its own architecture to allocate memory and produce a quality output to the end user. Following are the different scenarios where Kotlin compiler will work differently, whenever it is targeting different other kind of languages such as Java and JavaScript.\n" +
                "\n" +
                "Kotlin compiler creates a byte code and that byte code can run on the JVM, which is exactly equal to the byte code generated by the Java .class file. Whenever two byte coded file runs on the JVM, they can communicate with each other and this is how an interoperable feature is established in Kotlin for Java." +
                "\n" +
                "Whenever Kotlin targets JavaScript, the Kotlin compiler converts the .kt file into ES5.1 and generates a compatible code for JavaScript. Kotlin compiler is capable of creating platform basis compatible codes via LLVM.");

        contents.add("In this chapter, we will learn about the basic data types available in Kotlin programming language.\n" +
                "\n" +
                "Numbers\n" +
                "The representation of numbers in Kotlin is pretty similar to Java, however, Kotlin does not allow internal conversion of different data types. Following table lists different variable lengths for different numbers." +
                "\n" +
                "Double: 64\n" +
                "Float: 32\n" +
                "Long: 64\n" +
                "Int: 32\n" +
                "Short: 16\n" +
                "Byte: 8\n" +
                "\n" +
                "In the following example, we will see how Kotlin works with different data types. Please enter the following set of code in our coding ground." +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val a: Int = 10000\n" +
                "   val d: Double = 100.00\n" +
                "   val f: Float = 100.00f\n" +
                "   val l: Long = 1000000004\n" +
                "   val s: Short = 10\n" +
                "   val b: Byte = 1\n" +
                "   \n" +
                "   println(\"Your Int Value is \"+a);\n" +
                "   println(\"Your Double  Value is \"+d);\n" +
                "   println(\"Your Float Value is \"+f);\n" +
                "   println(\"Your Long Value is \"+l);\n" +
                "   println(\"Your Short Value is \"+s);\n" +
                "   println(\"Your Byte Value is \"+b);\n" +
                "}</code>\n" +
                "\n" +
                "When you run the above piece of code in the coding ground, it will generate the following output in the web console.\n" +
                "\n" +
                "<result>Your Int Value is 10000\n" +
                "Your Double  Value is 100.0\n" +
                "Your Float Value is 100.0\n" +
                "Your Long Value is 1000000004\n" +
                "Your Short Value is 10\n" +
                "Your Byte Value is 1</result>\n" +
                "\n" +
                "Characters\n" +
                "Kotlin represents character using char. Character should be declared in a single quote like ‘c’. Please enter the following code in our coding ground and see how Kotlin interprets the character variable. Character variable cannot be declared like number variables. Kotlin variable can be declared in two ways - one using “var” and another using “val”.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val letter: Char    // defining a variable \n" +
                "   letter = 'A'        // Assigning a value to it \n" +
                "   println(\"$letter\")\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser output window.\n" +
                "\n" +
                "<result>A</result>\n" +
                "\n" +
                "Boolean\n" +
                "Boolean is very simple like other programming languages. We have only two values for Boolean – either true or false. In the following example, we will see how Kotlin interprets Boolean.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val letter: Boolean   // defining a variable \n" +
                "   letter = true         // Assinging a value to it \n" +
                "   println(\"Your character value is \"+\"$letter\")\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Your character value is true</result>\n" +
                "Strings\n" +
                "Strings are character arrays. Like Java, they are immutable in nature. We have two kinds of string available in Kotlin - one is called raw String and another is called escaped String. In the following example, we will make use of these strings.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   var rawString :String  = \"I am Raw String!\"\n" +
                "   val escapedString : String  = \"I am escaped String!\\n\"\n" +
                "   \n" +
                "   println(\"Hello!\"+escapedString)\n" +
                "   println(\"Hey!!\"+rawString)   \n" +
                "}</code>\n" +
                "\n" +
                "The above example of escaped String allows to provide extra line space after the first print statement. Following will be the output in the browser.\n" +
                "\n" +
                "Hello!I am escaped String!\n" +
                "\n" +
                "Hey!!I am Raw String!\n" +
                "\n" +
                "Arrays\n" +
                "Arrays are a collection of homogeneous data. Like Java, Kotlin supports arrays of different data types. In the following example, we will make use of different arrays.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)\n" +
                "   println(\"Hey!! I am array Example\"+numbers[2])\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output. The indexing of the array is similar to other programming languages. Here, we are searching for a second index, whose value is “3”.\n" +
                "\n" +
                "<result>Hey!! I am array Example3</result>\n" +
                "\n" +
                "Collections\n" +
                "\n" +
                "Collection is a very important part of the data structure, which makes the software development easy for engineers. Kotlin has two types of collection - one is immutable collection (which means lists, maps and sets that cannot be editable) and another is mutable collection (this type of collection is editable). It is very important to keep in mind the type of collection used in your application, as Kotlin system does not represent any specific difference in them.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) { \n" +
                "   val numbers: MutableList<Int> = mutableListOf(1, 2, 3) //mutable List \n" +
                "   val readOnlyView: List<Int> = numbers                  // immutable list \n" +
                "   println(\"my mutable list--\"+numbers)        // prints \"[1, 2, 3]\" \n" +
                "   numbers.add(4) \n" +
                "   println(\"my mutable list after addition --\"+numbers)        // prints \"[1, 2, 3, 4]\" \n" +
                "   println(readOnlyView)     \n" +
                "   readOnlyView.clear()    // ⇒ does not compile  \n" +
                "// gives error  \n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser. It gives an error when we try to clear the mutable list of collection.\n" +
                "\n" +
                "main.kt:9:18: error: unresolved reference: clear\n" +
                "   readOnlyView.clear()    // -> does not compile  \n" +
                "\n" +
                "In collection, Kotlin provides some useful methods such as first(), last(), filter(), etc. All these methods are self-descriptive and easy to implement. Moreover, Kotlin follows the same structure such as Java while implementing collection. You are free to implement any collection of your choice such as Map and Set.\n" +
                "\n" +
                "In the following example, we have implemented Map and Set using different built-in methods.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val items = listOf(1, 2, 3, 4)\n" +
                "   println(\"First Element of our list----\"+items.first())\n" +
                "   println(\"Last Element of our list----\"+items.last())\n" +
                "   println(\"Even Numbers of our List----\"+items.\n" +
                "      filter { it % 2 = = 0 })   // returns [2, 4]\n" +
                "   \n" +
                "   val readWriteMap = hashMapOf(\"foo\" to 1, \"bar\" to 2)\n" +
                "   println(readWriteMap[\"foo\"])  // prints \"1\"\n" +
                "   \n" +
                "   val strings = hashSetOf(\"a\", \"b\", \"c\", \"c\")\n" +
                "   println(\"My Set Values are\"+strings)\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser.\n" +
                "\n" +
                "<result>First Element of our list----1\n" +
                "Last Element of our list----4\n" +
                "Even Numbers of our List----[2, 4]\n" +
                "1\n" +
                "My Set Values are[a, b, c]</result>\n" +
                "\n" +
                "Ranges\n" +
                "Ranges is another unique characteristic of Kotlin. Like Haskell, it provides an operator that helps you iterate through a range. Internally, it is implemented using rangeTo() and its operator form is (..).\n" +
                "\n" +
                "In the following example, we will see how Kotlin interprets this range operator.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val i:Int  = 2\n" +
                "   for (j in 1..4) \n" +
                "   print(j) // prints \"1234\"\n" +
                "   \n" +
                "   if (i in 1..10) { // equivalent of 1 < = i && i < = 10\n" +
                "      println(\"we found your number --\"+i)\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser.\n" +
                "\n" +
                "<result>1234we found your number --2</result>");

        contents.add("In the previous chapter we have learned about different types of data types available in Kotlin system. In this chapter, we will discuss different types of control flow mechanism available in the Kotlin.\n" +
                "\n" +
                "If - Else\n" +
                "Kotlin is a functional language hence like every functional language in Kotlin “if” is an expression, it is not a keyword. The expression “if” will return a value whenever necessary. Like other programming language, “if-else” block is used as an initial conditional checking operator. In the following example, we will compare two variables and provide the required output accordingly.\n" +
                "\n" +
                "<code>" +
                "fun main(args: Array<String>) {\n" +
                "   val a:Int = 5\n" +
                "   val b:Int = 2\n" +
                "   var max: Int\n" +
                "   \n" +
                "   if (a > b) {\n" +
                "      max = a\n" +
                "   } else {\n" +
                "      max = b\n" +
                "   }\n" +
                "   print(\"Maximum of a or b is \" +max)\n" +
                " \n" +
                "   // As expression \n" +
                "   // val max = if (a > b) a else b\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output as a result in the browser. Our example also contains another line of code, which depicts how to use “If” statement as an expression.\n" +
                "\n" +
                "<result>Maximum of a or b is 5</result>\n" +
                "\n" +
                "Use of When\n" +
                "If you are familiar with other programming languages, then you might have heard of the term switch statement, which is basically a conditional operator when multiple conditions can be applied on a particular variable. “when” operator matches the variable value against the branch conditions. If it is satisfying the branch condition then it will execute the statement inside that scope. In the following example, we will learn more about “when” in Kotlin.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val x:Int = 5\n" +
                "   when (x) {\n" +
                "      1 -> print(\"x = = 1\")\n" +
                "      2 -> print(\"x = = 2\")\n" +
                "      \n" +
                "      else -> { // Note the block\n" +
                "         print(\"x is neither 1 nor 2\")\n" +
                "      }\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser.\n" +
                "\n" +
                "<result>fun main(args: Array<String>) {\n" +
                "   val x:Int = 5\n" +
                "   when (x) {\n" +
                "      1 -> print(\"x = = 1\")\n" +
                "      2 -> print(\"x = = 2\")\n" +
                "      \n" +
                "      else -> { // Note the block\n" +
                "         print(\"x is neither 1 nor 2\")\n" +
                "      }\n" +
                "   }\n" +
                "}</result>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser.\n" +
                "<result>x is neither 1 nor 2</result>\n" +
                "In the above example, Kotlin compiler matches the value of x with the given branches. If it is not matching any of the branches, then it will execute the else part. Practically, when is equivalent to multiple if block. Kotlin provides another flexibility to the developer, where the developer can provide multiple checks in the same line by providing “,” inside the checks. Let us modify the above example as follows.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val x:Int = 5\n" +
                "   when (x) {\n" +
                "      1,2 -> print(\" Value of X either 1,2\")\n" +
                "      \n" +
                "      else -> { // Note the block\n" +
                "         print(\"x is neither 1 nor 2\")\n" +
                "      }\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "Run the same in the browser, which will yield the following output in the browser.\n" +
                "\n" +
                "<result>x is neither 1 nor 2</result>\n" +
                "\n" +
                "For Loop\n" +
                "Loop is such an invention that provides the flexibility to iterate through any kind of data structure. Like other programming languages, Kotlin also provides many kinds of Looping methodology, however, among them “For” is the most successful one. The implementation and use of For loop is conceptually similar to Java for loop. The following example shows how we can use the same in real-life examples.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val items = listOf(1, 2, 3, 4)\n" +
                "   for (i in items) println(\"values of the array\"+i)\n" +
                "}</code>\n" +
                "\n" +
                "In the above piece of code, we have declared one list named as “items” and using for loop we are iterating through that defined list and printing its value in the browser. Following is the output.\n" +
                "\n" +
                "<result>values of the array1\n" +
                "values of the array2\n" +
                "values of the array3\n" +
                "values of the array4</result>\n" +
                "\n" +
                "Following is another example of code, where we are using some library function to make our development work easier than ever before.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val items = listOf(1, 22, 83, 4)\n" +
                "   \n" +
                "   for ((index, value) in items.withIndex()) {\n" +
                "      println(\"the element at $index is $value\")\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "Once we compile and execute the above piece of code in our coding ground, it will yield the following output in the browser.\n" +
                "\n" +
                "<result>the element at 0 is 1\n" +
                "the element at 1 is 22\n" +
                "the element at 2 is 83\n" +
                "the element at 3 is 4</result>\n" +
                "\n" +
                "While Loop and Do-While Loop\n" +
                "While and Do-While work exactly in a similar way like they do in other programming languages. The only difference between these two loops is, in case of Do-while loop the condition will be tested at the end of the loop. The following example shows the usage of the While loop." +
                "<code>fun main(args: Array<String>) {\n" +
                "   var x:Int = 0\n" +
                "   println(\"Example of While Loop--\")\n" +
                "   \n" +
                "   while(x< = 10) {\n" +
                "      println(x)\n" +
                "      x++\n" +
                "   } \n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser.\n" +
                "\n" +
                "<result>Example of While Loop--\n" +
                "0\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10</result>\n" +
                "\n" +
                "Kotlin also has another loop called Do-While loop, where the loop body will be executed once, only then the condition will be checked. The following example shows the usage of the Do-while loop.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   var x:Int = 0\n" +
                "   do {\n" +
                "      x = x + 10\n" +
                "      println(\"I am inside Do block---\"+x)\n" +
                "   } while(x <= 50)\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser. In the above code, Kotlin compiler will execute the DO block, then it will go for condition checking in while block.\n" +
                "\n" +
                "<result>I am inside Do block---10\n" +
                "I am inside Do block---20\n" +
                "I am inside Do block---30\n" +
                "I am inside Do block---40\n" +
                "I am inside Do block---50\n" +
                "I am inside Do block---60</result>\n" +
                "\n" +
                "Use of Return, Break, Continue\n" +
                "If you are familiar with any programming language, then you must have an idea of different keywords that help us implement good control flow in the application. Following are the different keywords that can be used to control the loops or any other types of control flow.\n" +
                "\n" +
                "Return − Return is a keyword that returns some value to the calling function from the called function. In the following example, we will implement this scenario using our Kotlin coding ground.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   var x:Int = 10\n" +
                "   println(\"The value of X is--\"+doubleMe(x))\n" +
                "}\n" +
                "fun doubleMe(x:Int):Int {\n" +
                "   return 2*x;\n" +
                "}</code>\n" +
                "\n" +
                "In the above piece of code, we are calling another function and multiplying the input with 2, and returning the resultant value to the called function that is our main function. Kotlin defines the function in a different manner that we will look at in a subsequent chapter. For now, it is enough to understand that the above code will generate the following output in the browser.\n" +
                "\n" +
                "<result>The value of X is--20</result>\n" +
                "\n" +
                "Continue & Break − Continue and break are the most vital part of a logical problem. The “break” keyword terminates the controller flow if some condition has failed and “continue” does the opposite. All this operation happens with immediate visibility. Kotlin is smarter than other programming languages, wherein the developer can apply more than one label as visibility. The following piece of code shows how we are implementing this label in Kotlin.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   println(\"Example of Break and Continue\")\n" +
                "   myLabel@ for(x in 1..10) { // appling the custom label\n" +
                "      if(x = = 5) {\n" +
                "         println(\"I am inside if block with value\"+x+\"\\n-- hence it will close the operation\")\n" +
                "         break@myLabel //specifing the label\n" +
                "      } else {\n" +
                "         println(\"I am inside else block with value\"+x)\n" +
                "         continue@myLabel\n" +
                "      }\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code yields the following output in the browser.\n" +
                "\n" +
                "<result>Example of Break and Continue\n" +
                "I am inside else block with value1\n" +
                "I am inside else block with value2\n" +
                "I am inside else block with value3\n" +
                "I am inside else block with value4\n" +
                "I am inside if block with value5\n" +
                "-- hence it will close the operation</result>\n" +
                "\n" +
                "As you can see, the controller continues the loop, until and unless the value of x is 5. Once the value of x reaches 5, it starts executing the if block and once the break statement is reached, the entire control flow terminates the program execution.");

        contents.add("In this chapter, we will learn the basics of Object-Oriented Programming (OOP) using Kotlin. We will learn about class and its object and how to play with that object. By definition of OOP, a class is a blueprint of a runtime entity and object is its state, which includes both its behavior and state. In Kotlin, class declaration consists of a class header and a class body surrounded by curly braces, similar to Java.\n" +
                "\n" +
                "<code>Class myClass { // class Header \n" +
                "\n" +
                "   // class Body\n" +
                "}</code>\n" +
                "");

        contents.add("Like Java, Kotlin also allows to create several objects of a class and you are free to include its class members and functions. We can control the visibility of the class members variables using different keywords that we will learn in Chapter 10 – Visibility Control. In the following example, we will create one class and its object through which we will access different data members of that class.\n" +
                "\n" +
                "<code>class myClass {\n" +
                "   // property (data member)\n" +
                "   private var name: String = \"Kotlearn\"\n" +
                "   \n" +
                "   // member function\n" +
                "   fun printMe() {\n" +
                "      print(\"You are at the best Learning website Named-\"+name)\n" +
                "   }\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   val obj = myClass() // create obj object of myClass class\n" +
                "   obj.printMe()\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser, where we are calling printMe() of myClass using its own object.\n" +
                "\n" +
                "<result>You are at the best Learning website Named- KotLearn</result>\n" +
                "\n" +
                "Nested Class\n" +
                "By definition, when a class has been created inside another class, then it is called as a nested class. In Kotlin, nested class is by default static, hence, it can be accessed without creating any object of that class. In the following example, we will see how Kotlin interprets our nested class.\n" +
                "\n" +
                "<code>un main(args: Array<String>) {\n" +
                "   val demo = Outer.Nested().foo() // calling nested class method\n" +
                "   print(demo)\n" +
                "}\n" +
                "class Outer {\n" +
                "   class Nested {\n" +
                "      fun foo() = \"Welcome to KotLearn\"\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Welcome to KotLearn</result>\n" +
                "\n" +
                "Inner Class\n" +
                "When a nested class is marked as a “inner”, then it will be called as an Inner class. An inner class can be accessed by the data member of the outer class. In the following example, we will be accessing the data member of the outer class.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val demo = Outer().Nested().foo() // calling nested class method\n" +
                "   print(demo)\n" +
                "}\n" +
                "class Outer {\n" +
                "   private val welcomeMessage: String = \"Welcome to the TutorialsPoint.com\"\n" +
                "   inner class Nested {\n" +
                "      fun foo() = welcomeMessage\n" +
                "   }\n" +
                "}</code>\n");

        contents.add("");

        contents.add("");

        contents.add("");
//        createContents(contents);
    }

    private void createContents(List<String> contents) {
        for (int i = 0; i < contents.size(); i++) {
            createContent(contents.get(i), i);
        }
    }

    private void createContent(String text, Integer topicId) {
        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setText(text);
        TopicEntity topic = topicSessionLocal.retrieveTopicById(topicId);
        contentEntity.setTopicEntity(topic);
        topic.setContentEntity(contentEntity);
        topicSessionLocal.updateTopic(topic);
        contentSessionLocal.createContent(contentEntity);
    }

    private void createTopics() {
        createTopic("Overview");
        createTopic("Environment Setup");
        createTopic("Architecture");
        createTopic("Basic Types");
        createTopic("Control Flow");
        createTopic("Class & Object");
        createTopic("Constructors");
        createTopic("Inheritance");
        createTopic("Interface ");
        createTopic("Visibility");
        createTopic("Control");
        createTopic("Extension");
        createTopic("Data Classes");
        createTopic("Sealed Class");
        createTopic("Generics");
        createTopic("Delegation");
        createTopic("Functions");
        createTopic("Destructuring");
        createTopic("Declarations");
        createTopic("Exception Handling");
        createTopic("Function");
    }

    private void createTopic(String text) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setText(text);
        topicSessionLocal.createTopic(topicEntity);
    }
    
    private static class DataInitHolder {

        private static final DataInit INSTANCE = new DataInit();
    }
}
