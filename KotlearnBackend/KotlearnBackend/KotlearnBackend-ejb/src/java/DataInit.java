/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import session.TopicSessionLocal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
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
    private TopicSessionLocal topicSessionLocal;
    
    public DataInit() {
    }

    @PostConstruct
    public void postConstruct() {
        List<String> contents = new ArrayList<>();
        String topic;
        String content;
        topic = "Overview";
        content = "Kotlin is a new open source programming language like Java, JavaScript, etc. It is a high level strongly statically typed language that combines functional and technical part in a same place. Currently, Kotlin targets Java and JavaScript. It runs on JVM.\n" +
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
                "No Static Declaration − Kotlin does not have usual static handling modifier like Java, which can cause some problem to the conventional Java developer.";

        topicSessionLocal.createTopic(topic, content, 1L);
        topic = "Environment Setup";
        content = "However, if you still want to use Kotlin offline in your local system, then you need to execute the following steps to configure your local workspace.\n" +
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
                "<result>Hello, World!</result>";

        topicSessionLocal.createTopic(topic, content, 2L);
        topic = "Architecture";
        content = "Kotlin is a programming language and has its own architecture to allocate memory and produce a quality output to the end user. Following are the different scenarios where Kotlin compiler will work differently, whenever it is targeting different other kind of languages such as Java and JavaScript.\n" +
                "\n" +
                "Kotlin compiler creates a byte code and that byte code can run on the JVM, which is exactly equal to the byte code generated by the Java .class file. Whenever two byte coded file runs on the JVM, they can communicate with each other and this is how an interoperable feature is established in Kotlin for Java." +
                "\n" +
                "Whenever Kotlin targets JavaScript, the Kotlin compiler converts the .kt file into ES5.1 and generates a compatible code for JavaScript. Kotlin compiler is capable of creating platform basis compatible codes via LLVM.";

        topicSessionLocal.createTopic(topic, content, 3L);
        topic = "Basic Types";
        content = "In this chapter, we will learn about the basic data types available in Kotlin programming language.\n" +
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
                "<result>1234we found your number --2</result>";

        topicSessionLocal.createTopic(topic, content, 4L);
        topic = "Control Flow";
        content = "In the previous chapter we have learned about different types of data types available in Kotlin system. In this chapter, we will discuss different types of control flow mechanism available in the Kotlin.\n" +
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
                "As you can see, the controller continues the loop, until and unless the value of x is 5. Once the value of x reaches 5, it starts executing the if block and once the break statement is reached, the entire control flow terminates the program execution.";

        topicSessionLocal.createTopic(topic, content, 5L);
        topic = "Class & Object";
        content = "In this chapter, we will learn the basics of Object-Oriented Programming (OOP) using Kotlin. We will learn about class and its object and how to play with that object. By definition of OOP, a class is a blueprint of a runtime entity and object is its state, which includes both its behavior and state. In Kotlin, class declaration consists of a class header and a class body surrounded by curly braces, similar to Java.\n" +
                "\n" +
                "<code>Class myClass { // class Header \n" +
                "\n" +
                "   // class Body\n" +
                "}</code>\n" +
                "\n" +
                "Like Java, Kotlin also allows to create several objects of a class and you are free to include its class members and functions. We can control the visibility of the class members variables using different keywords that we will learn in Chapter 10 – Visibility Control. In the following example, we will create one class and its object through which we will access different data members of that class.\n" +
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
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser, where we are calling the nested class using the default constructor provided by Kotlin compilers at the time of compiling.\n" +
                "\n" +
                "<result>Welcome to the TutorialsPoint.com</result>\n" +
                "\n" +
                "Anonymous Inner Class\n" +
                "Anonymous inner class is a pretty good concept that makes the life of a programmer very easy. Whenever we are implementing an interface, the concept of anonymous inner block comes into picture. The concept of creating an object of interface using runtime object reference is known as anonymous class. In the following example, we will create an interface and we will create an object of that interface using Anonymous Inner class mechanism.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   var programmer :Human = object:Human // creating an instance of the interface {\n" +
                "      override fun think() { // overriding the think method\n" +
                "         print(\"I am an example of Anonymous Inner Class \")\n" +
                "      }\n" +
                "   }\n" +
                "   programmer.think()\n" +
                "}\n" +
                "interface Human {\n" +
                "   fun think()\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>I am an example of Anonymous Inner Class </result>\n" +
                "\n" +
                "Type Aliases\n" +
                "Type aliases are a property of Kotlin compiler. It provides the flexibility of creating a new name of an existing type, it does not create a new type. If the type name is too long, you can easily introduce a shorter name and use the same for future usage. Type aliases is really helpful for complex type. In the latest version, Kotlin revoked the support for type aliases, however, if you are using an old version of Kotlin you may have use it like the following −\n" +
                "\n" +
                "<code>typealias NodeSet = Set<Network.Node>\n" +
                "typealias FileTable<K> = MutableMap<K, MutableList<File>></code>";

        topicSessionLocal.createTopic(topic, content, 6L);
        topic = "Constructors";
        content = "In this chapter, we will learn about constructors in Kotlin. Kotlin has two types of constructor - one is the primary constructor and the other is the secondary constructor. One Kotlin class can have one primary constructor, and one or more secondary constructor. Java constructor initializes the member variables, however, in Kotlin the primary constructor initializes the class, whereas the secondary constructor helps to include some extra logic while initializing the same. The primary constructor can be declared at class header level as shown in the following example.\n" +
                "\n" +
                "<code>class Person(val firstName: String, var age: Int) {\n" +
                "   // class body\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, we have declared the primary constructor inside the parenthesis. Among the two fields, first name is read-only as it is declared as “val”, while the field age can be edited. In the following example, we will use the primary constructor.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val person1 = Person(\"TutorialsPoint.com\", 15)\n" +
                "   println(\"First Name = ${person1.firstName}\")\n" +
                "   println(\"Age = ${person1.age}\")\n" +
                "}\n" +
                "class Person(val firstName: String, var age: Int) {\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will automatically initialize the two variables and provide the following output in the browser.\n" +
                "\n" +
                "<result>First Name = TutorialsPoint.com\n" +
                "Age = 15</result>\n" +
                "\n" +
                "As mentioned earlier, Kotlin allows to create one or more secondary constructors for your class. This secondary constructor is created using the “constructor” keyword. It is required whenever you want to create more than one constructor in Kotlin or whenever you want to include more logic in the primary constructor and you cannot do that because the primary constructor may be called by some other class. Take a look at the following example, where we have created a secondary constructor and are using the above example to implement the same.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val HUman = HUman(\"TutorialsPoint.com\", 25)\n" +
                "   print(\"${HUman.message}\"+\"${HUman.firstName}\"+\n" +
                "      \"Welcome to the example of Secondary  constructor, Your Age is-${HUman.age}\")\n" +
                "}\n" +
                "class HUman(val firstName: String, var age: Int) {\n" +
                "   val message:String  = \"Hey!!!\"\n" +
                "\tconstructor(name : String , age :Int ,message :String):this(name,age) {\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "Note − Any number of secondary constructors can be created, however, all of those constructors should call the primary constructor directly or indirectly.\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Hey!!! TutorialsPoint.comWelcome to the example of Secondary  constructor, Your Age is- 25</result>";

        topicSessionLocal.createTopic(topic, content, 7L);
        topic = "Inheritance";
        content = "In this chapter, we will learn about inheritance. By definition, we all know that inheritance means accruing some properties of the mother class into the child class. In Kotlin, the base class is named as “Any”, which is the super class of the ‘any’ default class declared in Kotlin. Like all other OOPS, Kotlin also provides this functionality using one keyword known as “:”.\n" +
                "\n" +
                "Everything in Kotlin is by default final, hence, we need to use the keyword “open” in front of the class declaration to make it allowable to inherit. Take a look at the following example of inheritance.\n" +
                "\n" +
                "<code>import java.util.Arrays\n" +
                "\n" +
                "open class ABC {\n" +
                "   fun think () {\n" +
                "      print(\"Hey!! i am thiking \")\n" +
                "   }\n" +
                "}\n" +
                "class BCD: ABC(){ // inheritence happend using default constructor \n" +
                "}\n" +
                "\n" +
                "fun main(args: Array<String>) {\n" +
                "   var  a = BCD()\n" +
                "   a.think()\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Hey!! i am thiking </result>\n" +
                "\n" +
                "Now, what if we want to override the think() method in the child class. Then, we need to consider the following example where we are creating two classes and override one of its function into the child class.\n" +
                "\n" +
                "<code>import java.util.Arrays\n" +
                "\n" +
                "open class ABC {\n" +
                "   open fun think () {\n" +
                "      print(\"Hey!! i am thinking \")\n" +
                "   }\n" +
                "}\n" +
                "class BCD: ABC() { // inheritance happens using default constructor \n" +
                "   override fun think() {\n" +
                "      print(\"I Am from Child\")\n" +
                "   }\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   var  a = BCD()\n" +
                "   a.think()\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will call the child class inherited method and it will yield the following output in the browser. Like Java, Kotlin too doesn’t allow multiple inheritances.\n" +
                "\n" +
                "<result>I Am from Child </result>";

        topicSessionLocal.createTopic(topic, content, 8L);
        topic = "Interface ";
        content = "In this chapter, we will learn about the interface in Kotlin. In Kotlin, the interface works exactly similar to Java 8, which means they can contain method implementation as well as abstract methods declaration. An interface can be implemented by a class in order to use its defined functionality. We have already introduced an example with an interface in Chapter 6 - section “anonymous inner class”. In this chapter, we will learn more about it. The keyword “interface” is used to define an interface in Kotlin as shown in the following piece of code.\n" +
                "\n" +
                "<code>interface ExampleInterface {\n" +
                "   var myVar: String     // abstract property\n" +
                "   fun absMethod()       // abstract method\n" +
                "   fun sayHello() = \"Hello there\" // method with default implementation\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, we have created one interface named as “ExampleInterface” and inside that we have a couple of abstract properties and methods all together. Look at the function named “sayHello()”, which is an implemented method.\n" +
                "\n" +
                "In the following example, we will be implementing the above interface in a class.\n" +
                "\n" +
                "<code>interface ExampleInterface  {\n" +
                "   var myVar: Int            // abstract property\n" +
                "   fun absMethod():String    // abstract method\n" +
                "   \n" +
                "   fun hello() {\n" +
                "      println(\"Hello there, Welcome to TutorialsPoint.Com!\")\n" +
                "   }\n" +
                "}\n" +
                "class InterfaceImp : ExampleInterface {\n" +
                "   override var myVar: Int = 25\n" +
                "   override fun absMethod() = \"Happy Learning \"\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   val obj = InterfaceImp()\n" +
                "   println(\"My Variable Value is = ${obj.myVar}\")\n" +
                "   print(\"Calling hello(): \")\n" +
                "   obj.hello()\n" +
                "   \n" +
                "   print(\"Message from the Website-- \")\n" +
                "   println(obj.absMethod())\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Calling hello(): Hello there, Welcome to TutorialsPoint.Com!\n" +
                "Message from the Website-- Happy Learning </result>\n" +
                "\n" +
                "As mentioned earlier, Kotlin doesn’t support multiple inheritances, however, the same thing can be achieved by implementing more than two interfaces at a time.\n" +
                "\n" +
                "In the following example, we will create two interfaces and later we will implement both the interfaces into a class.\n" +
                "\n" +
                "<code>interface A {\n" +
                "   fun printMe() {\n" +
                "      println(\" method of interface A\")\n" +
                "   }\n" +
                "}\n" +
                "interface B  {\n" +
                "   fun printMeToo() {\n" +
                "      println(\"I am another Method from interface B\")\n" +
                "   }\n" +
                "}\n" +
                "\n" +
                "// implements two interfaces A and B\n" +
                "class multipleInterfaceExample: A, B\n" +
                "\n" +
                "fun main(args: Array<String>) {\n" +
                "   val obj = multipleInterfaceExample()\n" +
                "   obj.printMe()\n" +
                "   obj.printMeToo()\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, we have created two sample interfaces A, B and in the class named “multipleInterfaceExample” we have implemented two interfaces declared earlier. The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<code>method of interface A\n" +
                "I am another Method from interface B</code>";

        topicSessionLocal.createTopic(topic, content, 9L);
        topic = "Visibility Control";
        content = "In this chapter, we will learn about different modifiers available in Kotlin language. Access modifier is used to restrict the usage of the variables, methods and class used in the application. Like other OOP programming language, this modifier is applicable at multiple places such as in the class header or method declaration. There are four access modifiers available in Kotlin.\n" +
                "\n" +
                "Private\n" +
                "The classes, methods, and packages can be declared with a private modifier. Once anything is declared as private, then it will be accessible within its immediate scope. For instance, a private package can be accessible within that specific file. A private class or interface can be accessible only by its data members, etc.\n" +
                "\n" +
                "<code>private class privateExample {\n" +
                "   private val i = 1\n" +
                "   private val doSomething() {\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, the class “privateExample” and the variable i both can be accessible only in the same Kotlin file, where its mentioned as they all are declared as private in the declaration block.\n" +
                "\n" +
                "Protected\n" +
                "Protected is another access modifier for Kotlin, which is currently not available for top level declaration like any package cannot be protected. A protected class or interface is visible to its subclass only.\n" +
                "\n" +
                "<code>class A() {\n" +
                "   protected val i = 1\n" +
                "}\n" +
                "class B : A() {\n" +
                "   fun getValue() : Int {\n" +
                "      return i\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, the variable “i” is declared as protected, hence, it is only visible to its subclass.\n" +
                "\n" +
                "Internal\n" +
                "Internal is a newly added modifier introduced in Kotlin. If anything is marked as internal, then that specific field will be in the internal field. An Internal package is visible only inside the module under which it is implemented. An internal class interface is visible only by other class present inside the same package or the module. In the following example, we will see how to implement an internal method.\n" +
                "\n" +
                "<code>class internalExample {\n" +
                "   internal val i = 1\n" +
                "   internal fun doSomething() {\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, the method named “doSomething” and the variable is mentioned as internal, hence, these two fields can be accessible only inside the package under which it is declared.\n" +
                "\n" +
                "Public\n" +
                "Public modifier is accessible from anywhere in the project workspace. If no access modifier is specified, then by default it will be in the public scope. In all our previous examples, we have not mentioned any modifier, hence, all of them are in the public scope. Following is an example to understand more on how to declare a public variable or method.\n" +
                "\n" +
                "<code>class publicExample {\n" +
                "   val i = 1\n" +
                "   fun doSomething() {\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, we have not mentioned any modifier, thus all these methods and variables are by default public.";

        topicSessionLocal.createTopic(topic, content, 10L);
        topic = "Extension";
        content="In this chapter, we will learn about another new feature of Kotlin named “Extension”. Using extension, we will be able to add or remove some method functionality even without inheriting or modifying them. Extensions are resolved statistically. It does not actually modify the existing class, but it creates a callable function that can be called with a dot operation.\n" +
                "\n" +
                "Function Extension\n" +
                "In function extension, Kotlin allows to define a method outside of the main class. In the following example, we will see how the extension is implemented at the functional level.\n" +
                "\n" +
                "<code>class Alien {\n" +
                "   var skills : String = \"null\"\n" +
                "\t\n" +
                "   fun printMySkills() {\n" +
                "      print(skills)\n" +
                "   }\t\t\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   var  a1 = Alien()\n" +
                "   a1.skills = \"JAVA\"\n" +
                "   //a1.printMySkills()\n" +
                "\t\n" +
                "   var  a2 = Alien()\n" +
                "   a2.skills = \"SQL\"\n" +
                "   //a2.printMySkills()\n" +
                "\t\n" +
                "   var  a3 = Alien()\n" +
                "   a3.skills = a1.addMySkills(a2)\n" +
                "   a3.printMySkills()\n" +
                "}\n" +
                "fun Alien.addMySkills(a:Alien):String{\n" +
                "   var a4 = Alien()\n" +
                "   a4.skills = this.skills + \" \" +a.skills\n" +
                "   return a4.skills\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, we don’t have any method inside “Alien” class named as “addMySkills()”, however, we still are implementing the same method somewhere else outside of the class, This is the magic of extension.\n" +
                "\n" +
                "The above piece of code will generate the following output in the browser.\n" +
                "\n" +
                "<result>JAVA SQL</result>\n" +
                "\n" +
                "bject Extension\n" +
                "Kotlin provides another mechanism to implement static functionality of Java. This can be achieved using the keyword “companion object”. Using this mechanism, we can create an object of a class inside a factory method and later we can just call that method using the reference of the class name. In the following example, we will create a “companion object”.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   println(\"Heyyy!!!\"+A.show())\n" +
                "}\n" +
                "class A {\n" +
                "   companion object {\n" +
                "      fun show():String {\n" +
                "         return(\"You are learning Kotlin from TutorialsPoint.com\")\n" +
                "      }\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Heyyy!!! You are learning Kotlin from TutorialsPoint.com</result>\n" +
                "\n" +
                "The above example seems like static in Java, however, in real-time we are creating an object as a member variable of that same class. This is why it is also included under extension property and can be alternatively called as an object extension. You are basically extending the object of the same class to use some of the member functions.\n";
        topicSessionLocal.createTopic(topic, content, 11L);

        topic = "Data Classes";
        content="In this chapter, we will learn more about Data classes of Kotlin programming language. A class can be marked as a Data class whenever it is marked as ”data”. This type of class can be used to hold the basic data apart. Other than this, it does not provide any other functionality.\n" +
                "\n" +
                "All the data classes need to have one primary constructor and all the primary constructor should have at least one parameter. Whenever a class is marked as data, we can use some of the inbuilt function of that data class such as “toString()”,”hashCode()”, etc. Any data class cannot have a modifier like abstract and open or internal. Data class can be extended to other classes too. In the following example, we will create one data class.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val book: Book = Book(\"Kotlin\", \"TutorialPoint.com\", 5)\n" +
                "   println(\"Name of the Book is--\"+book.name) // \"Kotlin\"\n" +
                "   println(\"Puclisher Name--\"+book.publisher) // \"TutorialPoint.com\"\n" +
                "   println(\"Review of the book is--\"+book.reviewScore) // 5\n" +
                "   book.reviewScore = 7\n" +
                "   println(\"Printing all the info all together--\"+book.toString()) \n" +
                "   //using inbuilt function of the data class \n" +
                "   \n" +
                "   println(\"Example of the hashCode function--\"+book.hashCode())\n" +
                "}\n" +
                "\n" +
                "data class Book(val name: String, val publisher: String, var reviewScore: Int)</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser, where we have created one data class to hold some of the data, and from the main function we have accessed all of its data members.\n" +
                "\n" +
                "<result>Name of the Book is--\"Kotlin\"\n" +
                "Puclisher Name--\"TutorialPoint.com\"\n" +
                "Review of the book is--5\n" +
                "Printing all the info all together--(name-Kotlin, publisher-TutorialPoint.com, reviewScore-7)\n" +
                "Example of the hashCode function---1753517245</result>";
        topicSessionLocal.createTopic(topic, content, 12L);

        topic = "Sealed Class";
        content="In this chapter, we will learn about another class type called “Sealed” class. This type of class is used to represent a restricted class hierarchy. Sealed allows the developers to maintain a data type of a predefined type. To make a sealed class, we need to use the keyword “sealed” as a modifier of that class. A sealed class can have its own subclass but all those subclasses need to be declared inside the same Kotlin file along with the sealed class. In the following example, we will see how to use a sealed class.\n" +
                "<code>sealed class MyExample {\n" +
                "   class OP1 : MyExample() // MyExmaple class can be of two types only\n" +
                "   class OP2 : MyExample()\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   val obj: MyExample = MyExample.OP2() \n" +
                "   \n" +
                "   val output = when (obj) { // defining the object of the class depending on the inuputs \n" +
                "      is MyExample.OP1 -> \"Option One has been chosen\"\n" +
                "      is MyExample.OP2 -> \"option Two has been chosen\"\n" +
                "   }\n" +
                "   \n" +
                "   println(output)\n" +
                "}</code>\n" +
                "\n" +
                "In the above example, we have one sealed class named “MyExample”, which can be of two types only - one is “OP1” and another one is “OP2”. In the main class, we are creating an object in our class and assigning its type at runtime. Now, as this “MyExample” class is sealed, we can apply the “when ” clause at runtime to implement the final output.\n" +
                "\n" +
                "In sealed class, we need not use any unnecessary “else” statement to complex out the code. The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>option Two has been chosen</result>";
        topicSessionLocal.createTopic(topic, content, 13L);
        topic = "Generics";
        content="Like Java, Kotlin provides higher order of variable typing called as Generics. In this chapter, we will learn how Kotlin implements Generics and how as a developer we can use those functionalities provided inside the generics library. Implementation wise, generics is pretty similar to Java but Kotlin developer has introduced two new keywords “out” and “in” to make Kotlin codes more readable and easy for the developer.\n" +
                "\n" +
                "In Kotlin, a class and a type are totally different concepts. As per the example, List is a class in Kotlin, whereas List<String> is a type in Kotlin. The following example depicts how generics is implemented in Kotlin.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val integer: Int = 1\n" +
                "   val number: Number = integer\n" +
                "   print(number)\n" +
                "}</code>\n" +
                "\n" +
                "In the above code, we have declared one “integer” and later we have assigned that variable to a number variable. This is possible because “Int” is a subclass of Number class, hence the type conversion happens automatically at runtime and produces the output as “1”.\n" +
                "\n" +
                "Let us learn something more about generics in Kotlin. It is better to go for generic data type whenever we are not sure about the data type we are going to use in the application. Generally, in Kotlin generics is defined by <T> where “T” stands for template, which can be determined dynamically by Kotlin complier. In the following example, we will see how to use generic data types in Kotlin programming language.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   var objet = genericsExample<String>(\"JAVA\")\n" +
                "   var objet1 = genericsExample<Int>(10)\n" +
                "}\n" +
                "class genericsExample<T>(input:T) {\n" +
                "   init {\n" +
                "      println(\"I am getting called with the value \"+input)\n" +
                "   }\n" +
                "}</code>\n" +
                "In the above piece of code, we are creating one class with generic return type, which is represented as <T>. Take a look at the main method, where we have dynamically defined its value at the run by proving the value type, while creating the object of this class. This is how generics is interpreted by Kotlin compiler. We will get the following output in the browser, once we run this code in our coding ground.\n" +
                "\n" +
                "<result>I am getting called with the value JAVA\n" +
                "I am getting called with the value 10</result>\n" +
                "\n" +
                "When we want to assign the generic type to any of its super type, then we need to use “out” keyword, and when we want to assign the generic type to any of its sub-type, then we need to use “in” keyword. In the following example, we will use “out” keyword. Similarly, you can try using “in” keyword.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   var objet1 = genericsExample<Int>(10)\n" +
                "   var object2 = genericsExample<Double>(10.00)\n" +
                "   println(objet1)\n" +
                "   println(object2)\n" +
                "}\n" +
                "class genericsExample<out T>(input:T) {\n" +
                "   init {\n" +
                "      println(\"I am getting called with the value \"+input)\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "The above code will yield the following output in the browser.\n" +
                "\n" +
                "<result>I am getting called with the value 10\n" +
                "I am getting called with the value 10.0\n" +
                "genericsExample@28d93b30\n" +
                "genericsExample@1b6d3586</result>";
        topicSessionLocal.createTopic(topic, content, 14L);

        topic = "Delegation";
        content="Kotlin supports “delegation” design pattern by introducing a new keyword “by”. Using this keyword or delegation methodology, Kotlin allows the derived class to access all the implemented public methods of an interface through a specific object. The following example demonstrates how this happens in Kotlin.\n" +
                "\n" +
                "<code>interface Base {\n" +
                "   fun printMe() //abstract method\n" +
                "}\n" +
                "class BaseImpl(val x: Int) : Base {\n" +
                "   override fun printMe() { println(x) }   //implementation of the method\n" +
                "}\n" +
                "class Derived(b: Base) : Base by b  // delegating the public method on the object b\n" +
                "\n" +
                "fun main(args: Array<String>) {\n" +
                "   val b = BaseImpl(10)\n" +
                "   Derived(b).printMe() // prints 10 :: accessing the printMe() method \n" +
                "}</code>\n" +
                "\n" +
                "In the example, we have one interface “Base” with its abstract method named “printme()”. In the BaseImpl class, we are implementing this “printme()” and later from another class we are using this implementation using “by” keyword.\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>10</result>\n" +
                "Property Delegation\n" +
                "In the previous section, we have learned about the delegation design pattern using “by” keyword. In this section, we will learn about delegation of properties using some standard methods mentioned in Kotlin library.\n" +
                "\n" +
                "Delegation means passing the responsibility to another class or method. When a property is already declared in some places, then we should reuse the same code to initialize them. In the following examples, we will use some standard delegation methodology provided by Kotlin and some standard library function while implementing delegation in our examples.\n" +
                "\n" +
                "Using Lazy()\n" +
                "Lazy is a lambda function which takes a property as an input and in return gives an instance of Lazy<T>, where <T> is basically the type of the properties it is using. Let us take a look at the following to understand how it works.\n" +
                "\n" +
                "<code>val myVar: String by lazy {\n" +
                "   \"Hello\"\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   println(myVar +\" My dear friend\")\n" +
                "}</code>\n" +
                "In the above piece of code, we are passing a variable “myVar” to the Lazy function, which in return assigns the value to its object and returns the same to the main function. Following is the output in the browser.\n" +
                "<result>Hello My dear friend</result>\n" +
                "\n" +
                "Delegetion.Observable()\n" +
                "Observable() takes two arguments to initialize the object and returns the same to the called function. In the following example, we will see how to use Observable() method in order to implement delegation.\n" +
                "\n" +
                "<code>import kotlin.properties.Delegates\n" +
                "class User {\n" +
                "   var name: String by Delegates.observable(\"Welcome to Tutorialspoint.com\") {\n" +
                "      prop, old, new ->\n" +
                "      println(\"$old -> $new\")\n" +
                "   }\n" +
                "}\n" +
                "fun main(args: Array<String>) {\n" +
                "   val user = User()\n" +
                "   user.name = \"first\"\n" +
                "   user.name = \"second\"\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<code>first -> second</code>\n" +
                "\n" +
                "In general, the syntax is the expression after the “by” keyword is delegated. The get() and set() methods of the variable p will be delegated to its getValue() and setValue() methods defined in the Delegate class.\n" +
                "\n" +
                "<code>class Example {\n" +
                "   var p: String by Delegate()\n" +
                "}</code>\n" +
                "\n" +
                "For the above piece of code, following is the delegate class that we need to generate in order to assign the value in the variable p.\n" +
                "\n" +
                "<code>class Delegate {\n" +
                "   operator fun getValue(thisRef: Any?, property: KProperty<*>): String {\n" +
                "      return \"$thisRef, thank you for delegating '${property.name}' to me!\"\n" +
                "   }\n" +
                "   operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {\n" +
                "      println(\"$value has been assigned to '${property.name} in $thisRef.'\")\n" +
                "   }</code>\n" +
                "\n" +
                "While reading, getValue() method will be called and while setting the variable setValue() method will be called.";
        topicSessionLocal.createTopic(topic, content, 15L);
        topic = "Functions";
        content="Kotlin is a statically typed language, hence, functions play a great role in it. We are pretty familiar with function, as we are using function throughout the examples. Function is declared with the keyword “fun”. Like any other OOP, it also needs a return type and an option argument list.\n" +
                "\n" +
                "In the following example, we are defining a function called MyFunction and from the main function we are calling this function and passing some argument.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   println(MyFunction(\"tutorialsPoint.com\"))\n" +
                "}\n" +
                "fun MyFunction(x: String): String {\n" +
                "   var c:String  = \"Hey!! Welcome To ---\"\n" +
                "   return (c+x)\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>Hey!! Welcome To ---tutorialsPoint.com</result>\n" +
                "\n" +
                "The function should be declared as follows −\n" +
                "<code>fun <nameOfFunction>(<argument>:<argumentType>):<ReturnType></code>\n" +
                "\n" +
                "Following are some of the different types of function available in Kotlin.\n" +
                "\n" +
                "Lambda Function\n" +
                "Lambda is a high level function that drastically reduces the boiler plate code while declaring a function and defining the same. Kotlin allows you to define your own lambda. In Kotlin, you can declare your lambda and pass that lambda to a function.\n" +
                "\n" +
                "Take a look at the following example.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val mylambda :(String)->Unit  = {s:String->print(s)}\n" +
                "   val v:String = \"TutorialsPoint.com\"\n" +
                "   mylambda(v)\n" +
                "}</code>\n" +
                "\n" +
                "In the above code, we have created our own lambda known as “mylambda” and we have passed one variable to this lambda, which is of type String and contains a value “TutorialsPoint.com”.\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>TutorialsPoint.com</result>\n" +
                "\n" +
                "Inline Function\n" +
                "The above example shows the basic of the lambda expression that we can use in Kotlin application. Now, we can pass a lambda to another function to get our output which makes the calling function an inline function.\n" +
                "\n" +
                "Take a look at the following example.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val mylambda:(String)->Unit  = {s:String->print(s)}\n" +
                "   val v:String = \"TutorialsPoint.com\"\n" +
                "   myFun(v,mylambda) //passing lambda as a parameter of another function \n" +
                "}\n" +
                "fun myFun(a :String, action: (String)->Unit) { //passing lambda \n" +
                "   print(\"Heyyy!!!\")\n" +
                "   action(a)// call to lambda function\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser. Using inline function, we have passed a lambda as a parameter. Any other function can be made an inline function using the “inline” keyword.\n" +
                "\n" +
                "<result>Heyyy!!!TutorialsPoint.com</result>";
        topicSessionLocal.createTopic(topic, content, 16L);
        topic = "Destructuring Declarations";
        content="Kotlin contains many features of other programming languages. It allows you to declare multiple variables at once. This technique is called Destructuring declaration.\n" +
                "\n" +
                "Following is the basic syntax of the destructuring declaration.\n" +
                "\n" +
                "<code>val (name, age) = person</code>\n" +
                "\n" +
                "In the above syntax, we have created an object and defined all of them together in a single statement. Later, we can use them as follows.\n" +
                "\n" +
                "<code>println(name)\n" +
                "println(age)</code>\n" +
                "\n" +
                "Now, let us see how we can use the same in our real-life application. Consider the following example where we are creating one Student class with some attributes and later we will be using them to print the object values.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   val s = Student(\"TutorialsPoint.com\",\"Kotlin\")\n" +
                "   val (name,subject) = s\n" +
                "   println(\"You are learning \"+subject+\" from \"+name)\n" +
                "}\n" +
                "data class Student( val a :String,val b: String ){\n" +
                "   var name:String = a\n" +
                "   var subject:String = b\n" +
                "}</code>\n" +
                "\n" +
                "The above piece of code will yield the following output in the browser.\n" +
                "\n" +
                "<result>You are learning Kotlin from TutorialsPoint.com</result>";
        topicSessionLocal.createTopic(topic, content, 17L);
        topic = "Exception Handling";
        content="Exception handling is a very important part of a programming language. This technique restricts our application from generating the wrong output at runtime. In this chapter, we will learn how to handle runtime exception in Kotlin. The exceptions in Kotlin is pretty similar to the exceptions in Java. All the exceptions are descendants of the “Throwable” class. Following example shows how to use exception handling technique in Kotlin.\n" +
                "\n" +
                "<code>fun main(args: Array<String>) {\n" +
                "   try {\n" +
                "      val myVar:Int = 12;\n" +
                "      val v:String = \"Tutorialspoint.com\";\n" +
                "      v.toInt();\n" +
                "   } catch(e:Exception) {\n" +
                "      e.printStackTrace();\n" +
                "   } finally {\n" +
                "      println(\"Exception Handeling in Kotlin\");\n" +
                "   }\n" +
                "}</code>\n" +
                "\n" +
                "In the above piece of code, we have declared a String and later tied that string into the integer, which is actually a runtime exception. Hence, we will get the following output in the browser.\n" +
                "\n" +
                "<result>val myVar:Int = 12;\n" +
                "Exception Handeling in Kotlin</result>\n" +
                "\n" +
                "Note − Like Java, Kotlin also executes the finally block after executing the catch block.\n";
        topicSessionLocal.createTopic(topic, content, 18L);
//        topicSessionLocal.retrieveAllTopics();
//        createContents(contents);
    }
}
