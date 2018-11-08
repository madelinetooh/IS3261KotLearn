package com.kotlearn.kotlearn

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var topicDbHelper: DBHelper
    lateinit var sharedPreferences: SharedPreferences
    lateinit var active: android.support.v4.app.Fragment
    private var myPreferences = "myPrefs"
    private var URL = "URL"
    private var CODE = "code"
    private val permissionList = arrayOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA)
    private val fragmentWeb = ProfileFragment()
    private val fragmentCompiler = CompilerFragment()
    private val fragmentContent = ContentFragment()

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                var selectedFragment: android.support.v4.app.Fragment? = null
                when (item.itemId) {
                    R.id.navigation_web -> {
                        selectedFragment = fragmentWeb
                    }
                    R.id.navigation_content -> {
                        selectedFragment = fragmentContent
                    }
                    R.id.navigation_complier -> {
                        selectedFragment = fragmentCompiler
                    }
                }
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.hide(active)
                transaction.show(selectedFragment)
                active = selectedFragment!!
                transaction.commit()
                return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragmentContent)
        transaction.add(R.id.fragment_container, fragmentWeb)
        transaction.add(R.id.fragment_container, fragmentCompiler)

        transaction.hide(fragmentCompiler)
        transaction.hide(fragmentWeb)
        active = fragmentContent

        transaction.commit()


        topicDbHelper = DBHelper(this)

        topicDbHelper.clearAllTopics()
        sharedPreferences = this.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(URL, "")
        editor.putString(CODE, "")
        editor.apply()

        var allTopics = topicDbHelper.readAllTopics()

        if (allTopics.isEmpty()) populateData()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (allPermissionsEnabled()) {
            } else {
                setupMultiplePermissions()
            }
        } else {
            // it must be older than Marshmallow, no need to do anything as long as
            // you have added the permission in the AndroidManifest.xml file
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && data.hasExtra("compiler") && (resultCode == Activity.RESULT_OK)) {
            navigation.menu.findItem(R.id.navigation_complier).isChecked = true
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.hide(active)
            transaction.show(fragmentCompiler)
            active = fragmentCompiler
            fragmentCompiler.setCodeText(findViewById(R.id.code_editor), true)
            transaction.commit()
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun allPermissionsEnabled(): Boolean {
        return permissionList.none{
            checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED}
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun setupMultiplePermissions() {
        val remainingPermissions = permissionList.filter {
            checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED }
        requestPermissions(remainingPermissions.toTypedArray(), 101)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissionsList: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissionsList, grantResults)

        if (requestCode == 101) {
            if (grantResults.any { it != PackageManager.PERMISSION_GRANTED }) {

                @TargetApi(Build.VERSION_CODES.M)
                if (permissionList.any{ shouldShowRequestPermissionRationale(it)}) {
                    AlertDialog.Builder(this)
                            .setMessage("Press Permissions to Decide Permission Again")
                            .setPositiveButton("Permissions") { _, _ ->
                                setupMultiplePermissions()}
                            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss()}
                            .create()
                            .show()

                }
            }
        }
    }

    private fun populateData() {
        insertTopic(1, "Overview", "H1HEREOverviewH1ENDHEREKotlin is a new open source programming language like Java, JavaScript, etc. It is a high level strongly statically typed language that combines functional and technical part in a same place. Currently, Kotlin targets Java and JavaScript. It runs on JVM.BREAKHEREBREAKHERE" +
                "Kotlin is influenced by other programming languages such as Java, Scala, Groovy, Gosu, etc. The syntax of Kotlin may not be exactly similar to JAVA, however, internally Kotlin is reliant on the existing Java Class library to produce wonderful results for the programmers. Kotlin provides interoperability, code safety, and clarity to the developers around the world.BREAKHEREBREAKHERE" +
                "BREAKHERE" +
                "H2HEREAdvantages and DisadvantagesH2ENDHERE" +
                "Following are some of the advantages of using Kotlin for your application development.BREAKHEREBREAKHERE" +
                "BOLDHEREEasy LanguageBOLDENDHERE − Kotlin is a functional language and very easy to learn. The syntax is pretty much similar to Java, hence it is very easy to remember. Kotlin is more expressive, which makes your code more readable and understandable.BREAKHEREBREAKHERE" +
                "BOLDHEREConciseBOLDENDHERE − Kotlin is based on JVM and it is a functional language. Thus, it reduce lots of boiler plate code used in other programming languages.BREAKHEREBREAKHERE" +
                "BOLDHERERuntime and PerformanceBOLDENDHERE − Better performance and small runtime.BREAKHEREBREAKHERE" +
                "BOLDHEREInteroperabilityBOLDENDHERE − Kotlin is mature enough to build an interoperable application in a less complex manner.BREAKHEREBREAKHERE" +
                "BOLDHEREBrand NewBOLDENDHERE − Kotlin is a brand new language that gives developers a fresh start. It is not a replacement of Java, though it is developed over JVM. It is accepted as the first official language of android development. Kotlin can be defined as - Kotlin = JAVA + extra updated new features.BREAKHEREBREAKHERE" +
                "Following are some of the disadvantages of Kotlin.BREAKHEREBREAKHERE" +
                "BOLDHERENamespace declarationBOLDENDHERE − Kotlin allows developers to declare the functions at the top level. However, whenever the same function is declared in many places of your application, then it is hard to understand which function is being called.BREAKHEREBREAKHERE" +
                "BOLDHERENo Static DeclarationBOLDENDHERE − Kotlin does not have usual static handling modifier like Java, which can cause some problem to the conventional Java developer."
        )

        insertTopic(2, "Environment Setup", "H1HEREEnvironment SetupH1ENDHEREHowever, if you still want to use Kotlin offline in your local system, then you need to execute the following steps to configure your local workspace.BREAKHERE" +
                "BREAKHERE" +
                "BOLDHEREStep 1 − Java 8 installation.BOLDENDHEREBREAKHERE" +
                "BREAKHERE" +
                "Kotlin runs on JVM, hence. it is really necessary to use JDK 8 for your local Kotlin development. Please refer to the official website of oracle to download and install JDK 8 or an above version. You might have to set the environment variable for JAVA such that it can work properly. To verify your installation in Windows operating system, hit “java –version” in the command prompt and as an output it will show you the java version installed in your system.BREAKHERE" +
                "BREAKHERE" +
                "BOLDHEREStep 2 − IDE installation.BOLDENDHEREBREAKHERE" +
                "BREAKHERE" +
                "There are a number of IDE available over the internet. You can use any of your choice.BREAKHERE" +
                "BREAKHERE" +
                "NetBeans: https://netbeans.org/downloads/BREAKHERE" +
                "Eclipse: https://www.eclipse.org/downloads/BREAKHERE" +
                "Intellij: https://www.jetbrains.com/idea/download/#section = windowsBREAKHERE" +
                "BREAKHERE" +
                "It is always recommended to use the recent software version to drag out maximum facility from it.BREAKHERE" +
                "BREAKHERE" +
                "BOLDHEREStep 3 − Configuring Eclipse.BOLDENDHEREBREAKHERE" +
                "BREAKHERE" +
                "Open Eclipse and go to “Eclipse Market Place”.BREAKHERE" +
                "BREAKHERE" +
                "Search for Kotlin in the search box and install the same in your local system. It might take some time depending on the internet speed. You may have to restart your Eclipse, once it is successfully installed.BREAKHERE" +
                "BREAKHERE" +
                "BOLDHEREStep 4 − Kotlin Project.BOLDENDHEREBREAKHERE" +
                "BREAKHERE" +
                "Once Eclipse is successfully restarted and Kotlin is installed, you will be able to create a Kotlin project on the fly. Go to File → New → Others and select “Kotlin project” from the list.BREAKHERE" +
                "BREAKHERE" +
                "Once the project setup is done, you can create a Kotlin file under “SRC” folder. Left-click on the “Src” folder and hit “new”. You will get an option for Kotlin file, otherwise you may have to search from the “others”.BREAKHERE" +
                "BREAKHERE" +
                "Your development environment is ready now. Go ahead and add the following piece of code in the “Hello.kt” file.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   println(\"Hello, World!\")BREAKHERE" +
                "}CODEENDHERE" +
                "Run it as a Kotlin application and see the output in the console as shown in the following screenshot.BREAKHERE" +
                "RESULTHEREHello, World!RESULTENDHERE")

        insertTopic(3, "Architecture", "H1HEREArchitectureH1ENDHEREKotlin is a programming language and has its own architecture to allocate memory and produce a quality output to the end user. Following are the different scenarios where Kotlin compiler will work differently, whenever it is targeting different other kind of languages such as Java and JavaScript.BREAKHERE" +
                "BREAKHERE" +
                "Kotlin compiler creates a byte code and that byte code can run on the JVM, which is exactly equal to the byte code generated by the Java .class file. Whenever two byte coded file runs on the JVM, they can communicate with each other and this is how an interoperable feature is established in Kotlin for Java." +
                "BREAKHERE" +
                "Whenever Kotlin targets JavaScript, the Kotlin compiler converts the .kt file into ES5.1 and generates a compatible code for JavaScript. Kotlin compiler is capable of creating platform basis compatible codes via LLVM.")

        insertTopic(4, "Basic Types", "H1HEREBasic TypesH1ENDHEREIn this chapter, we will learn about the basic data types available in Kotlin programming language.BREAKHERE" +
                "BREAKHERE" +
                "H2HERENumbersH2ENDHERE" +
                "The representation of numbers in Kotlin is pretty similar to Java, however, Kotlin does not allow internal conversion of different data types. Following table lists different variable lengths for different numbers." +
                "BREAKHERE" +
                "Double: 64BREAKHERE" +
                "Float: 32BREAKHERE" +
                "Long: 64BREAKHERE" +
                "Int: 32BREAKHERE" +
                "Short: 16BREAKHERE" +
                "Byte: 8BREAKHERE" +
                "BREAKHERE" +
                "In the following example, we will see how Kotlin works with different data types. Please enter the following set of code in our coding ground." +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val a: Int = 10000BREAKHERE" +
                "   val d: Double = 100.00BREAKHERE" +
                "   val f: Float = 100.00fBREAKHERE" +
                "   val l: Long = 1000000004BREAKHERE" +
                "   val s: Short = 10BREAKHERE" +
                "   val b: Byte = 1BREAKHERE" +
                "   BREAKHERE" +
                "   println(\"Your Int Value is \"+a);BREAKHERE" +
                "   println(\"Your Double  Value is \"+d);BREAKHERE" +
                "   println(\"Your Float Value is \"+f);BREAKHERE" +
                "   println(\"Your Long Value is \"+l);BREAKHERE" +
                "   println(\"Your Short Value is \"+s);BREAKHERE" +
                "   println(\"Your Byte Value is \"+b);BREAKHERE" +
                "}CODEENDHERE" +
                "When you run the above piece of code in the coding ground, it will generate the following output in the web console.BREAKHERE" +
                "RESULTHEREYour Int Value is 10000BREAKHERE" +
                "Your Double  Value is 100.0BREAKHERE" +
                "Your Float Value is 100.0BREAKHERE" +
                "Your Long Value is 1000000004BREAKHERE" +
                "Your Short Value is 10BREAKHERE" +
                "Your Byte Value is 1RESULTENDHERE" +
                "BREAKHERE" +
                "H2HERECharactersH2ENDHERE" +
                "Kotlin represents character using char. Character should be declared in a single quote like ‘c’. Please enter the following code in our coding ground and see how Kotlin interprets the character variable. Character variable cannot be declared like number variables. Kotlin variable can be declared in two ways - one using “var” and another using “val”.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val letter: Char    // defining a variable BREAKHERE" +
                "   letter = 'A'        // Assigning a value to it BREAKHERE" +
                "   println(\"\$letter\")BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser output window.BREAKHERE" +
                "RESULTHEREARESULTENDHERE" +
                "BREAKHERE" +
                "H2HEREBooleanH2ENDHERE" +
                "Boolean is very simple like other programming languages. We have only two values for Boolean – either true or false. In the following example, we will see how Kotlin interprets Boolean.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val letter: Boolean   // defining a variable BREAKHERE" +
                "   letter = true         // Assinging a value to it BREAKHERE" +
                "   println(\"Your character value is \"+\"\$letter\")BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREYour character value is trueRESULTENDHERE" +
                "BREAKHERE" +
                "H2HEREStringsH2ENDHERE" +
                "Strings are character arrays. Like Java, they are immutable in nature. We have two kinds of string available in Kotlin - one is called raw String and another is called escaped String. In the following example, we will make use of these strings." +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var rawString :String  = \"I am Raw String!\"BREAKHERE" +
                "   val escapedString : String  = \"I am escaped String!\n\"BREAKHERE" +
                "   BREAKHERE" +
                "   println(\"Hello!\"+escapedString)BREAKHERE" +
                "   println(\"Hey!!\"+rawString)   BREAKHERE" +
                "}CODEENDHERE" +
                "The above example of escaped String allows to provide extra line space after the first print statement. Following will be the output in the browser.BREAKHERE" +
                "RESULTHEREHello!I am escaped String!BREAKHERE" +
                "Hey!!I am Raw String!RESULTENDHERE" +
                "BREAKHERE" +
                "H2HEREArraysH2ENDHERE" +
                "Arrays are a collection of homogeneous data. Like Java, Kotlin supports arrays of different data types. In the following example, we will make use of different arrays.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)BREAKHERE" +
                "   println(\"Hey!! I am array Example\"+numbers[2])BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output. The indexing of the array is similar to other programming languages. Here, we are searching for a second index, whose value is “3”.BREAKHERE" +
                "RESULTHEREHey!! I am array Example3RESULTENDHERE" +
                "BREAKHERE" +
                "BREAKHERE" +
                "H2HERECollectionsH2ENDHERE" +
                "Collection is a very important part of the data structure, which makes the software development easy for engineers. Kotlin has two types of collection - one is immutable collection (which means lists, maps and sets that cannot be editable) and another is mutable collection (this type of collection is editable). It is very important to keep in mind the type of collection used in your application, as Kotlin system does not represent any specific difference in them.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) { BREAKHERE" +
                "   val numbers: MutableList&lt;Int&gt; = mutableListOf(1, 2, 3) //mutable List BREAKHERE" +
                "   val readOnlyView: List&lt;Int&gt; = numbers                  // immutable list BREAKHERE" +
                "   println(\"my mutable list--\"+numbers)        // prints \"[1, 2, 3]\" BREAKHERE" +
                "   numbers.add(4) BREAKHERE" +
                "   println(\"my mutable list after addition --\"+numbers)        // prints \"[1, 2, 3, 4]\" BREAKHERE" +
                "   println(readOnlyView)     BREAKHERE" +
                "   readOnlyView.clear()    // ⇒ does not compile  BREAKHERE" +
                "// gives error  BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser. It gives an error when we try to clear the mutable list of collection.BREAKHERE" +
                "RESULTHEREmain.kt:9:18: error: unresolved reference: clearBREAKHERE" +
                "   readOnlyView.clear()    // -&gt; does not compile  RESULTENDHERE" +
                "BREAKHERE" +
                "In collection, Kotlin provides some useful methods such as first(), last(), filter(), etc. All these methods are self-descriptive and easy to implement. Moreover, Kotlin follows the same structure such as Java while implementing collection. You are free to implement any collection of your choice such as Map and Set.BREAKHERE" +
                "BREAKHERE" +
                "In the following example, we have implemented Map and Set using different built-in methods.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val items = listOf(1, 2, 3, 4)BREAKHERE" +
                "   println(\"First Element of our list----\"+items.first())BREAKHERE" +
                "   println(\"Last Element of our list----\"+items.last())BREAKHERE" +
                "   println(\"Even Numbers of our List----\"+items.BREAKHERE" +
                "      filter { it % 2 = = 0 })   // returns [2, 4]BREAKHERE" +
                "   BREAKHERE" +
                "   val readWriteMap = hashMapOf(\"foo\" to 1, \"bar\" to 2)BREAKHERE" +
                "   println(readWriteMap[\"foo\"])  // prints \"1\"BREAKHERE" +
                "   BREAKHERE" +
                "   val strings = hashSetOf(\"a\", \"b\", \"c\", \"c\")BREAKHERE" +
                "   println(\"My Set Values are\"+strings)BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output in the browser.BREAKHERE" +
                "RESULTHEREFirst Element of our list----1BREAKHERE" +
                "Last Element of our list----4BREAKHERE" +
                "Even Numbers of our List----[2, 4]BREAKHERE" +
                "1BREAKHERE" +
                "My Set Values are[a, b, c]RESULTENDHERE" +
                "BREAKHERE" +
                "H2HERERangesH2ENDHERE" +
                "Ranges is another unique characteristic of Kotlin. Like Haskell, it provides an operator that helps you iterate through a range. Internally, it is implemented using rangeTo() and its operator form is (..).BREAKHERE" +
                "BREAKHERE" +
                "In the following example, we will see how Kotlin interprets this range operator.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val i:Int  = 2BREAKHERE" +
                "   for (j in 1..4) BREAKHERE" +
                "   print(j) // prints \"1234\"BREAKHERE" +
                "   BREAKHERE" +
                "   if (i in 1..10) { // equivalent of 1 &lt; = i && i &lt; = 10BREAKHERE" +
                "      println(\"we found your number --\"+i)BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output in the browser.BREAKHERE" +
                "RESULTHERE1234we found your number --2RESULTENDHERE")

        insertTopic(5, "Control Flow", "H1HEREControl FlowH1ENDHEREIn the previous chapter we have learned about different types of data types available in Kotlin system. In this chapter, we will discuss different types of control flow mechanism available in the Kotlin.BREAKHERE" +
                "BREAKHERE" +
                "If - ElseBREAKHERE" +
                "Kotlin is a functional language hence like every functional language in Kotlin “if” is an expression, it is not a keyword. The expression “if” will return a value whenever necessary. Like other programming language, “if-else” block is used as an initial conditional checking operator. In the following example, we will compare two variables and provide the required output accordingly.BREAKHERE" +
                "CODEHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val a:Int = 5BREAKHERE" +
                "   val b:Int = 2BREAKHERE" +
                "   var max: IntBREAKHERE" +
                "   BREAKHERE" +
                "   if (a &gt; b) {BREAKHERE" +
                "      max = aBREAKHERE" +
                "   } else {BREAKHERE" +
                "      max = bBREAKHERE" +
                "   }BREAKHERE" +
                "   print(\"Maximum of a or b is \" +max)BREAKHERE" +
                " BREAKHERE" +
                "   // As expression BREAKHERE" +
                "   // val max = if (a &gt; b) a else bBREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output as a result in the browser. Our example also contains another line of code, which depicts how to use “If” statement as an expression.BREAKHERE" +
                "RESULTHEREMaximum of a or b is 5RESULTENDHERE" +
                "BREAKHERE" +
                "Use of WhenBREAKHERE" +
                "If you are familiar with other programming languages, then you might have heard of the term switch statement, which is basically a conditional operator when multiple conditions can be applied on a particular variable. “when” operator matches the variable value against the branch conditions. If it is satisfying the branch condition then it will execute the statement inside that scope. In the following example, we will learn more about “when” in Kotlin.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val x:Int = 5BREAKHERE" +
                "   when (x) {BREAKHERE" +
                "      1 -&gt; print(\"x = = 1\")BREAKHERE" +
                "      2 -&gt; print(\"x = = 2\")BREAKHERE" +
                "      BREAKHERE" +
                "      else -&gt; { // Note the blockBREAKHERE" +
                "         print(\"x is neither 1 nor 2\")BREAKHERE" +
                "      }BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output in the browser.BREAKHERE" +
                "RESULTHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val x:Int = 5BREAKHERE" +
                "   when (x) {BREAKHERE" +
                "      1 -&gt; print(\"x = = 1\")BREAKHERE" +
                "      2 -&gt; print(\"x = = 2\")BREAKHERE" +
                "      BREAKHERE" +
                "      else -&gt; { // Note the blockBREAKHERE" +
                "         print(\"x is neither 1 nor 2\")BREAKHERE" +
                "      }BREAKHERE" +
                "   }BREAKHERE" +
                "}RESULTENDHERE" +
                "BREAKHERE" +
                "The above piece of code yields the following output in the browser.BREAKHERE" +
                "RESULTHEREx is neither 1 nor 2RESULTENDHERE" +
                "In the above example, Kotlin compiler matches the value of x with the given branches. If it is not matching any of the branches, then it will execute the else part. Practically, when is equivalent to multiple if block. Kotlin provides another flexibility to the developer, where the developer can provide multiple checks in the same line by providing “,” inside the checks. Let us modify the above example as follows.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val x:Int = 5BREAKHERE" +
                "   when (x) {BREAKHERE" +
                "      1,2 -&gt; print(\" Value of X either 1,2\")BREAKHERE" +
                "      BREAKHERE" +
                "      else -&gt; { // Note the blockBREAKHERE" +
                "         print(\"x is neither 1 nor 2\")BREAKHERE" +
                "      }BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "Run the same in the browser, which will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREx is neither 1 nor 2RESULTENDHERE" +
                "BREAKHERE" +
                "For LoopBREAKHERE" +
                "Loop is such an invention that provides the flexibility to iterate through any kind of data structure. Like other programming languages, Kotlin also provides many kinds of Looping methodology, however, among them “For” is the most successful one. The implementation and use of For loop is conceptually similar to Java for loop. The following example shows how we can use the same in real-life examples.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val items = listOf(1, 2, 3, 4)BREAKHERE" +
                "   for (i in items) println(\"values of the array\"+i)BREAKHERE" +
                "}CODEENDHERE" +
                "In the above piece of code, we have declared one list named as “items” and using for loop we are iterating through that defined list and printing its value in the browser. Following is the output.BREAKHERE" +
                "RESULTHEREvalues of the array1BREAKHERE" +
                "values of the array2BREAKHERE" +
                "values of the array3BREAKHERE" +
                "values of the array4RESULTENDHERE" +
                "BREAKHERE" +
                "Following is another example of code, where we are using some library function to make our development work easier than ever before.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val items = listOf(1, 22, 83, 4)BREAKHERE" +
                "   BREAKHERE" +
                "   for ((index, value) in items.withIndex()) {BREAKHERE" +
                "      println(\"the element at \$index is \$value\")BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "Once we compile and execute the above piece of code in our coding ground, it will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREthe element at 0 is 1BREAKHERE" +
                "the element at 1 is 22BREAKHERE" +
                "the element at 2 is 83BREAKHERE" +
                "the element at 3 is 4RESULTENDHERE" +
                "BREAKHERE" +
                "While Loop and Do-While LoopBREAKHERE" +
                "While and Do-While work exactly in a similar way like they do in other programming languages. The only difference between these two loops is, in case of Do-while loop the condition will be tested at the end of the loop. The following example shows the usage of the While loop." +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var x:Int = 0BREAKHERE" +
                "   println(\"Example of While Loop--\")BREAKHERE" +
                "   BREAKHERE" +
                "   while(x&lt; = 10) {BREAKHERE" +
                "      println(x)BREAKHERE" +
                "      x++BREAKHERE" +
                "   } BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output in the browser.BREAKHERE" +
                "RESULTHEREExample of While Loop--BREAKHERE" +
                "0BREAKHERE" +
                "1BREAKHERE" +
                "2BREAKHERE" +
                "3BREAKHERE" +
                "4BREAKHERE" +
                "5BREAKHERE" +
                "6BREAKHERE" +
                "7BREAKHERE" +
                "8BREAKHERE" +
                "9BREAKHERE" +
                "10RESULTENDHERE" +
                "BREAKHERE" +
                "Kotlin also has another loop called Do-While loop, where the loop body will be executed once, only then the condition will be checked. The following example shows the usage of the Do-while loop.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var x:Int = 0BREAKHERE" +
                "   do {BREAKHERE" +
                "      x = x + 10BREAKHERE" +
                "      println(\"I am inside Do block---\"+x)BREAKHERE" +
                "   } while(x &lt;= 50)BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output in the browser. In the above code, Kotlin compiler will execute the DO block, then it will go for condition checking in while block.BREAKHERE" +
                "RESULTHEREI am inside Do block---10BREAKHERE" +
                "I am inside Do block---20BREAKHERE" +
                "I am inside Do block---30BREAKHERE" +
                "I am inside Do block---40BREAKHERE" +
                "I am inside Do block---50BREAKHERE" +
                "I am inside Do block---60RESULTENDHERE" +
                "BREAKHERE" +
                "Use of Return, Break, ContinueBREAKHERE" +
                "If you are familiar with any programming language, then you must have an idea of different keywords that help us implement good control flow in the application. Following are the different keywords that can be used to control the loops or any other types of control flow.BREAKHERE" +
                "BREAKHERE" +
                "Return − Return is a keyword that returns some value to the calling function from the called function. In the following example, we will implement this scenario using our Kotlin coding ground.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var x:Int = 10BREAKHERE" +
                "   println(\"The value of X is--\"+doubleMe(x))BREAKHERE" +
                "}BREAKHERE" +
                "fun doubleMe(x:Int):Int {BREAKHERE" +
                "   return 2*x;BREAKHERE" +
                "}CODEENDHERE" +
                "In the above piece of code, we are calling another function and multiplying the input with 2, and returning the resultant value to the called function that is our main function. Kotlin defines the function in a different manner that we will look at in a subsequent chapter. For now, it is enough to understand that the above code will generate the following output in the browser.BREAKHERE" +
                "RESULTHEREThe value of X is--20RESULTENDHERE" +
                "BREAKHERE" +
                "Continue & Break − Continue and break are the most vital part of a logical problem. The “break” keyword terminates the controller flow if some condition has failed and “continue” does the opposite. All this operation happens with immediate visibility. Kotlin is smarter than other programming languages, wherein the developer can apply more than one label as visibility. The following piece of code shows how we are implementing this label in Kotlin.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   println(\"Example of Break and Continue\")BREAKHERE" +
                "   myLabel@ for(x in 1..10) { // appling the custom labelBREAKHERE" +
                "      if(x = = 5) {BREAKHERE" +
                "         println(\"I am inside if block with value\"+x+\"\n-- hence it will close the operation\")BREAKHERE" +
                "         break@myLabel //specifing the labelBREAKHERE" +
                "      } else {BREAKHERE" +
                "         println(\"I am inside else block with value\"+x)BREAKHERE" +
                "         continue@myLabelBREAKHERE" +
                "      }BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code yields the following output in the browser.BREAKHERE" +
                "RESULTHEREExample of Break and ContinueBREAKHERE" +
                "I am inside else block with value1BREAKHERE" +
                "I am inside else block with value2BREAKHERE" +
                "I am inside else block with value3BREAKHERE" +
                "I am inside else block with value4BREAKHERE" +
                "I am inside if block with value5BREAKHERE" +
                "-- hence it will close the operationRESULTENDHERE" +
                "BREAKHERE" +
                "As you can see, the controller continues the loop, until and unless the value of x is 5. Once the value of x reaches 5, it starts executing the if block and once the break statement is reached, the entire control flow terminates the program execution.")
        insertTopic(6, "Class & Object", "H1HEREClass & ObjectH1ENDHEREIn this chapter, we will learn the basics of Object-Oriented Programming (OOP) using Kotlin. We will learn about class and its object and how to play with that object. By definition of OOP, a class is a blueprint of a runtime entity and object is its state, which includes both its behavior and state. In Kotlin, class declaration consists of a class header and a class body surrounded by curly braces, similar to Java.BREAKHERE" +
                "CODEHEREClass myClass { // class Header BREAKHERE" +
                "BREAKHERE" +
                "   // class BodyBREAKHERE" +
                "}CODEENDHERE" +
                "Like Java, Kotlin also allows to create several objects of a class and you are free to include its class members and functions. We can control the visibility of the class members variables using different keywords that we will learn in Chapter 10 – Visibility Control. In the following example, we will create one class and its object through which we will access different data members of that class.BREAKHERE" +
                "CODEHEREclass myClass {BREAKHERE" +
                "   // property (data member)BREAKHERE" +
                "   private var name: String = \"Kotlearn\"BREAKHERE" +
                "   BREAKHERE" +
                "   // member functionBREAKHERE" +
                "   fun printMe() {BREAKHERE" +
                "      print(\"You are at the best Learning website Named-\"+name)BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val obj = myClass() // create obj object of myClass classBREAKHERE" +
                "   obj.printMe()BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser, where we are calling printMe() of myClass using its own object.BREAKHERE" +
                "RESULTHEREYou are at the best Learning website Named- KotLearnRESULTENDHERE" +
                "BREAKHERE" +
                "Nested ClassBREAKHERE" +
                "By definition, when a class has been created inside another class, then it is called as a nested class. In Kotlin, nested class is by default static, hence, it can be accessed without creating any object of that class. In the following example, we will see how Kotlin interprets our nested class.BREAKHERE" +
                "CODEHEREun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val demo = Outer.Nested().foo() // calling nested class methodBREAKHERE" +
                "   print(demo)BREAKHERE" +
                "}BREAKHERE" +
                "class Outer {BREAKHERE" +
                "   class Nested {BREAKHERE" +
                "      fun foo() = \"Welcome to KotLearn\"BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREWelcome to KotLearnRESULTENDHERE" +
                "BREAKHERE" +
                "Inner ClassBREAKHERE" +
                "When a nested class is marked as a “inner”, then it will be called as an Inner class. An inner class can be accessed by the data member of the outer class. In the following example, we will be accessing the data member of the outer class.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val demo = Outer().Nested().foo() // calling nested class methodBREAKHERE" +
                "   print(demo)BREAKHERE" +
                "}BREAKHERE" +
                "class Outer {BREAKHERE" +
                "   private val welcomeMessage: String = \"Welcome to the Kotlearn\"BREAKHERE" +
                "   inner class Nested {BREAKHERE" +
                "      fun foo() = welcomeMessageBREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser, where we are calling the nested class using the default constructor provided by Kotlin compilers at the time of compiling.BREAKHERE" +
                "RESULTHEREWelcome to the KotlearnRESULTENDHERE" +
                "BREAKHERE" +
                "Anonymous Inner ClassBREAKHERE" +
                "Anonymous inner class is a pretty good concept that makes the life of a programmer very easy. Whenever we are implementing an interface, the concept of anonymous inner block comes into picture. The concept of creating an object of interface using runtime object reference is known as anonymous class. In the following example, we will create an interface and we will create an object of that interface using Anonymous Inner class mechanism.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var programmer :Human = object:Human // creating an instance of the interface {BREAKHERE" +
                "      override fun think() { // overriding the think methodBREAKHERE" +
                "         print(\"I am an example of Anonymous Inner Class \")BREAKHERE" +
                "      }BREAKHERE" +
                "   }BREAKHERE" +
                "   programmer.think()BREAKHERE" +
                "}BREAKHERE" +
                "interface Human {BREAKHERE" +
                "   fun think()BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREI am an example of Anonymous Inner Class RESULTENDHERE" +
                "BREAKHERE" +
                "Type AliasesBREAKHERE" +
                "Type aliases are a property of Kotlin compiler. It provides the flexibility of creating a new name of an existing type, it does not create a new type. If the type name is too long, you can easily introduce a shorter name and use the same for future usage. Type aliases is really helpful for complex type. In the latest version, Kotlin revoked the support for type aliases, however, if you are using an old version of Kotlin you may have use it like the following −BREAKHERE" +
                "CODEHEREtypealias NodeSet = Set&lt;Network.Node&gt;BREAKHERE" +
                "typealias FileTable&lt;K&gt; = MutableMap&lt;K, MutableList&lt;File&gt;&gt;CODEENDHERE")
        insertTopic(7, "Constructors", "H1HEREConstructorsH1ENDHEREIn this chapter, we will learn about constructors in Kotlin. Kotlin has two types of constructor - one is the primary constructor and the other is the secondary constructor. One Kotlin class can have one primary constructor, and one or more secondary constructor. Java constructor initializes the member variables, however, in Kotlin the primary constructor initializes the class, whereas the secondary constructor helps to include some extra logic while initializing the same. The primary constructor can be declared at class header level as shown in the following example.BREAKHERE" +
                "CODEHEREclass Person(val firstName: String, var age: Int) {BREAKHERE" +
                "   // class bodyBREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, we have declared the primary constructor inside the parenthesis. Among the two fields, first name is read-only as it is declared as “val”, while the field age can be edited. In the following example, we will use the primary constructor.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val person1 = Person(\"Kotlearn\", 15)BREAKHERE" +
                "   println(\"First Name = \${person1.firstName}\")BREAKHERE" +
                "   println(\"Age = \${person1.age}\")BREAKHERE" +
                "}BREAKHERE" +
                "class Person(val firstName: String, var age: Int) {BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will automatically initialize the two variables and provide the following output in the browser.BREAKHERE" +
                "RESULTHEREFirst Name = KotlearnBREAKHERE" +
                "Age = 15RESULTENDHERE" +
                "BREAKHERE" +
                "As mentioned earlier, Kotlin allows to create one or more secondary constructors for your class. This secondary constructor is created using the “constructor” keyword. It is required whenever you want to create more than one constructor in Kotlin or whenever you want to include more logic in the primary constructor and you cannot do that because the primary constructor may be called by some other class. Take a look at the following example, where we have created a secondary constructor and are using the above example to implement the same.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val HUman = HUman(\"Kotlearn\", 25)BREAKHERE" +
                "   print(\"\${HUman.message}\"+\"\${HUman.firstName}\"+BREAKHERE" +
                "      \"Welcome to the example of Secondary  constructor, Your Age is-\${HUman.age}\")BREAKHERE" +
                "}BREAKHERE" +
                "class HUman(val firstName: String, var age: Int) {BREAKHERE" +
                "   val message:String  = \"Hey!!!\"BREAKHERE" +
                "\tconstructor(name : String , age :Int ,message :String):this(name,age) {BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "Note − Any number of secondary constructors can be created, however, all of those constructors should call the primary constructor directly or indirectly.BREAKHERE" +
                "BREAKHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREHey!!! KotlearnWelcome to the example of Secondary  constructor, Your Age is- 25RESULTENDHERE")
        insertTopic(8, "Inheritance", "H1HEREInheritanceH1ENDHEREIn this chapter, we will learn about inheritance. By definition, we all know that inheritance means accruing some properties of the mother class into the child class. In Kotlin, the base class is named as “Any”, which is the super class of the ‘any’ default class declared in Kotlin. Like all other OOPS, Kotlin also provides this functionality using one keyword known as “:”.BREAKHERE" +
                "BREAKHERE" +
                "Everything in Kotlin is by default final, hence, we need to use the keyword “open” in front of the class declaration to make it allowable to inherit. Take a look at the following example of inheritance.BREAKHERE" +
                "CODEHEREimport java.util.ArraysBREAKHERE" +
                "BREAKHERE" +
                "open class ABC {BREAKHERE" +
                "   fun think () {BREAKHERE" +
                "      print(\"Hey!! i am thiking \")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "class BCD: ABC(){ // inheritence happend using default constructor BREAKHERE" +
                "}BREAKHERE" +
                "BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var  a = BCD()BREAKHERE" +
                "   a.think()BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREHey!! i am thiking RESULTENDHERE" +
                "BREAKHERE" +
                "Now, what if we want to override the think() method in the child class. Then, we need to consider the following example where we are creating two classes and override one of its function into the child class.BREAKHERE" +
                "CODEHEREimport java.util.ArraysBREAKHERE" +
                "BREAKHERE" +
                "open class ABC {BREAKHERE" +
                "   open fun think () {BREAKHERE" +
                "      print(\"Hey!! i am thinking \")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "class BCD: ABC() { // inheritance happens using default constructor BREAKHERE" +
                "   override fun think() {BREAKHERE" +
                "      print(\"I Am from Child\")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var  a = BCD()BREAKHERE" +
                "   a.think()BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will call the child class inherited method and it will yield the following output in the browser. Like Java, Kotlin too doesn’t allow multiple inheritances.BREAKHERE" +
                "RESULTHEREI Am from Child RESULTENDHERE")
        insertTopic(9, "Interface ", "H1HEREInterfaceH1ENDHEREIn this chapter, we will learn about the interface in Kotlin. In Kotlin, the interface works exactly similar to Java 8, which means they can contain method implementation as well as abstract methods declaration. An interface can be implemented by a class in order to use its defined functionality. We have already introduced an example with an interface in Chapter 6 - section “anonymous inner class”. In this chapter, we will learn more about it. The keyword “interface” is used to define an interface in Kotlin as shown in the following piece of code.BREAKHERE" +
                "CODEHEREinterface ExampleInterface {BREAKHERE" +
                "   var myVar: String     // abstract propertyBREAKHERE" +
                "   fun absMethod()       // abstract methodBREAKHERE" +
                "   fun sayHello() = \"Hello there\" // method with default implementationBREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, we have created one interface named as “ExampleInterface” and inside that we have a couple of abstract properties and methods all together. Look at the function named “sayHello()”, which is an implemented method.BREAKHERE" +
                "BREAKHERE" +
                "In the following example, we will be implementing the above interface in a class.BREAKHERE" +
                "CODEHEREinterface ExampleInterface  {BREAKHERE" +
                "   var myVar: Int            // abstract propertyBREAKHERE" +
                "   fun absMethod():String    // abstract methodBREAKHERE" +
                "   BREAKHERE" +
                "   fun hello() {BREAKHERE" +
                "      println(\"Hello there, Welcome to Kotlearn!\")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "class InterfaceImp : ExampleInterface {BREAKHERE" +
                "   override var myVar: Int = 25BREAKHERE" +
                "   override fun absMethod() = \"Happy Learning \"BREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val obj = InterfaceImp()BREAKHERE" +
                "   println(\"My Variable Value is = \${obj.myVar}\")BREAKHERE" +
                "   print(\"Calling hello(): \")BREAKHERE" +
                "   obj.hello()BREAKHERE" +
                "   BREAKHERE" +
                "   print(\"Message from the Website-- \")BREAKHERE" +
                "   println(obj.absMethod())BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHERECalling hello(): Hello there, Welcome to Kotlearn!BREAKHERE" +
                "Message from the Website-- Happy Learning RESULTENDHERE" +
                "BREAKHERE" +
                "As mentioned earlier, Kotlin doesn’t support multiple inheritances, however, the same thing can be achieved by implementing more than two interfaces at a time.BREAKHERE" +
                "BREAKHERE" +
                "In the following example, we will create two interfaces and later we will implement both the interfaces into a class.BREAKHERE" +
                "CODEHEREinterface A {BREAKHERE" +
                "   fun printMe() {BREAKHERE" +
                "      println(\" method of interface A\")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "interface B  {BREAKHERE" +
                "   fun printMeToo() {BREAKHERE" +
                "      println(\"I am another Method from interface B\")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "BREAKHERE" +
                "// implements two interfaces A and BBREAKHERE" +
                "class multipleInterfaceExample: A, BBREAKHERE" +
                "BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val obj = multipleInterfaceExample()BREAKHERE" +
                "   obj.printMe()BREAKHERE" +
                "   obj.printMeToo()BREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, we have created two sample interfaces A, B and in the class named “multipleInterfaceExample” we have implemented two interfaces declared earlier. The above piece of code will yield the following output in the browser.BREAKHERE" +
                "CODEHEREmethod of interface ABREAKHERE" +
                "I am another Method from interface BCODEENDHERE")
        insertTopic(10, "Visibility Control", "H1HEREVisibility ControlH1ENDHEREIn this chapter, we will learn about different modifiers available in Kotlin language. Access modifier is used to restrict the usage of the variables, methods and class used in the application. Like other OOP programming language, this modifier is applicable at multiple places such as in the class header or method declaration. There are four access modifiers available in Kotlin.BREAKHERE" +
                "BREAKHERE" +
                "PrivateBREAKHERE" +
                "The classes, methods, and packages can be declared with a private modifier. Once anything is declared as private, then it will be accessible within its immediate scope. For instance, a private package can be accessible within that specific file. A private class or interface can be accessible only by its data members, etc.BREAKHERE" +
                "CODEHEREprivate class privateExample {BREAKHERE" +
                "   private val i = 1BREAKHERE" +
                "   private val doSomething() {BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, the class “privateExample” and the variable i both can be accessible only in the same Kotlin file, where its mentioned as they all are declared as private in the declaration block.BREAKHERE" +
                "BREAKHERE" +
                "ProtectedBREAKHERE" +
                "Protected is another access modifier for Kotlin, which is currently not available for top level declaration like any package cannot be protected. A protected class or interface is visible to its subclass only.BREAKHERE" +
                "CODEHEREclass A() {BREAKHERE" +
                "   protected val i = 1BREAKHERE" +
                "}BREAKHERE" +
                "class B : A() {BREAKHERE" +
                "   fun getValue() : Int {BREAKHERE" +
                "      return iBREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, the variable “i” is declared as protected, hence, it is only visible to its subclass.BREAKHERE" +
                "BREAKHERE" +
                "InternalBREAKHERE" +
                "Internal is a newly added modifier introduced in Kotlin. If anything is marked as internal, then that specific field will be in the internal field. An Internal package is visible only inside the module under which it is implemented. An internal class interface is visible only by other class present inside the same package or the module. In the following example, we will see how to implement an internal method.BREAKHERE" +
                "CODEHEREclass internalExample {BREAKHERE" +
                "   internal val i = 1BREAKHERE" +
                "   internal fun doSomething() {BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, the method named “doSomething” and the variable is mentioned as internal, hence, these two fields can be accessible only inside the package under which it is declared.BREAKHERE" +
                "BREAKHERE" +
                "PublicBREAKHERE" +
                "Public modifier is accessible from anywhere in the project workspace. If no access modifier is specified, then by default it will be in the public scope. In all our previous examples, we have not mentioned any modifier, hence, all of them are in the public scope. Following is an example to understand more on how to declare a public variable or method.BREAKHERE" +
                "CODEHEREclass publicExample {BREAKHERE" +
                "   val i = 1BREAKHERE" +
                "   fun doSomething() {BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, we have not mentioned any modifier, thus all these methods and variables are by default public.")

        insertTopic(11, "Extension", "H1HEREExtensionH1ENDHEREIn this chapter, we will learn about another new feature of Kotlin named “Extension”. Using extension, we will be able to add or remove some method functionality even without inheriting or modifying them. Extensions are resolved statistically. It does not actually modify the existing class, but it creates a callable function that can be called with a dot operation.BREAKHERE" +
                "BREAKHERE" +
                "Function ExtensionBREAKHERE" +
                "In function extension, Kotlin allows to define a method outside of the main class. In the following example, we will see how the extension is implemented at the functional level.BREAKHERE" +
                "CODEHEREclass Alien {BREAKHERE" +
                "   var skills : String = \"null\"BREAKHERE" +
                "\tBREAKHERE" +
                "   fun printMySkills() {BREAKHERE" +
                "      print(skills)BREAKHERE" +
                "   }\t\tBREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var  a1 = Alien()BREAKHERE" +
                "   a1.skills = \"JAVA\"BREAKHERE" +
                "   //a1.printMySkills()BREAKHERE" +
                "\tBREAKHERE" +
                "   var  a2 = Alien()BREAKHERE" +
                "   a2.skills = \"SQL\"BREAKHERE" +
                "   //a2.printMySkills()BREAKHERE" +
                "\tBREAKHERE" +
                "   var  a3 = Alien()BREAKHERE" +
                "   a3.skills = a1.addMySkills(a2)BREAKHERE" +
                "   a3.printMySkills()BREAKHERE" +
                "}BREAKHERE" +
                "fun Alien.addMySkills(a:Alien):String{BREAKHERE" +
                "   var a4 = Alien()BREAKHERE" +
                "   a4.skills = this.skills + \" \" +a.skillsBREAKHERE" +
                "   return a4.skillsBREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, we don’t have any method inside “Alien” class named as “addMySkills()”, however, we still are implementing the same method somewhere else outside of the class, This is the magic of extension.BREAKHERE" +
                "BREAKHERE" +
                "The above piece of code will generate the following output in the browser.BREAKHERE" +
                "RESULTHEREJAVA SQLRESULTENDHERE" +
                "BREAKHERE" +
                "bject ExtensionBREAKHERE" +
                "Kotlin provides another mechanism to implement static functionality of Java. This can be achieved using the keyword “companion object”. Using this mechanism, we can create an object of a class inside a factory method and later we can just call that method using the reference of the class name. In the following example, we will create a “companion object”.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   println(\"Heyyy!!!\"+A.show())BREAKHERE" +
                "}BREAKHERE" +
                "class A {BREAKHERE" +
                "   companion object {BREAKHERE" +
                "      fun show():String {BREAKHERE" +
                "         return(\"You are learning Kotlin from Kotlearn\")BREAKHERE" +
                "      }BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREHeyyy!!! You are learning Kotlin from KotlearnRESULTENDHERE" +
                "BREAKHERE" +
                "The above example seems like static in Java, however, in real-time we are creating an object as a member variable of that same class. This is why it is also included under extension property and can be alternatively called as an object extension. You are basically extending the object of the same class to use some of the member functions.")

        insertTopic(12, "Data Classes", "H1HEREData ClassesH1ENDHEREIn this chapter, we will learn more about Data classes of Kotlin programming language. A class can be marked as a Data class whenever it is marked as ”data”. This type of class can be used to hold the basic data apart. Other than this, it does not provide any other functionality.BREAKHERE" +
                "BREAKHERE" +
                "All the data classes need to have one primary constructor and all the primary constructor should have at least one parameter. Whenever a class is marked as data, we can use some of the inbuilt function of that data class such as “toString()”,”hashCode()”, etc. Any data class cannot have a modifier like abstract and open or internal. Data class can be extended to other classes too. In the following example, we will create one data class.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val book: Book = Book(\"Kotlin\", \"Kotlearn\", 5)BREAKHERE" +
                "   println(\"Name of the Book is--\"+book.name) // \"Kotlin\"BREAKHERE" +
                "   println(\"Puclisher Name--\"+book.publisher) // \"Kotlearn\"BREAKHERE" +
                "   println(\"Review of the book is--\"+book.reviewScore) // 5BREAKHERE" +
                "   book.reviewScore = 7BREAKHERE" +
                "   println(\"Printing all the info all together--\"+book.toString()) BREAKHERE" +
                "   //using inbuilt function of the data class BREAKHERE" +
                "   BREAKHERE" +
                "   println(\"Example of the hashCode function--\"+book.hashCode())BREAKHERE" +
                "}BREAKHERE" +
                "BREAKHERE" +
                "data class Book(val name: String, val publisher: String, var reviewScore: Int)CODEENDHERE" +
                "The above piece of code will yield the following output in the browser, where we have created one data class to hold some of the data, and from the main function we have accessed all of its data members.BREAKHERE" +
                "RESULTHEREName of the Book is--\"Kotlin\"BREAKHERE" +
                "Puclisher Name--\"Kotlearn\"BREAKHERE" +
                "Review of the book is--5BREAKHERE" +
                "Printing all the info all together--(name-Kotlin, publisher-Kotlearn, reviewScore-7)BREAKHERE" +
                "Example of the hashCode function---1753517245RESULTENDHERE")

        insertTopic(13, "Sealed Class", "H1HERESealed ClassH1ENDHEREIn this chapter, we will learn about another class type called “Sealed” class. This type of class is used to represent a restricted class hierarchy. Sealed allows the developers to maintain a data type of a predefined type. To make a sealed class, we need to use the keyword “sealed” as a modifier of that class. A sealed class can have its own subclass but all those subclasses need to be declared inside the same Kotlin file along with the sealed class. In the following example, we will see how to use a sealed class.BREAKHERE" +
                "CODEHEREsealed class MyExample {BREAKHERE" +
                "   class OP1 : MyExample() // MyExmaple class can be of two types onlyBREAKHERE" +
                "   class OP2 : MyExample()BREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val obj: MyExample = MyExample.OP2() BREAKHERE" +
                "   BREAKHERE" +
                "   val output = when (obj) { // defining the object of the class depending on the inuputs BREAKHERE" +
                "      is MyExample.OP1 -&gt; \"Option One has been chosen\"BREAKHERE" +
                "      is MyExample.OP2 -&gt; \"option Two has been chosen\"BREAKHERE" +
                "   }BREAKHERE" +
                "   BREAKHERE" +
                "   println(output)BREAKHERE" +
                "}CODEENDHERE" +
                "In the above example, we have one sealed class named “MyExample”, which can be of two types only - one is “OP1” and another one is “OP2”. In the main class, we are creating an object in our class and assigning its type at runtime. Now, as this “MyExample” class is sealed, we can apply the “when ” clause at runtime to implement the final output.BREAKHERE" +
                "BREAKHERE" +
                "In sealed class, we need not use any unnecessary “else” statement to complex out the code. The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREoption Two has been chosenRESULTENDHERE")

        insertTopic(14, "Generics", "H1HEREGenericsH1ENDHERELike Java, Kotlin provides higher order of variable typing called as Generics. In this chapter, we will learn how Kotlin implements Generics and how as a developer we can use those functionalities provided inside the generics library. Implementation wise, generics is pretty similar to Java but Kotlin developer has introduced two new keywords “out” and “in” to make Kotlin codes more readable and easy for the developer.BREAKHERE" +
                "BREAKHERE" +
                "In Kotlin, a class and a type are totally different concepts. As per the example, List is a class in Kotlin, whereas List&lt;String&gt; is a type in Kotlin. The following example depicts how generics is implemented in Kotlin.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val integer: Int = 1BREAKHERE" +
                "   val number: Number = integerBREAKHERE" +
                "   print(number)BREAKHERE" +
                "}CODEENDHERE" +
                "In the above code, we have declared one “integer” and later we have assigned that variable to a number variable. This is possible because “Int” is a subclass of Number class, hence the type conversion happens automatically at runtime and produces the output as “1”.BREAKHERE" +
                "BREAKHERE" +
                "Let us learn something more about generics in Kotlin. It is better to go for generic data type whenever we are not sure about the data type we are going to use in the application. Generally, in Kotlin generics is defined by &lt;T&gt; where “T” stands for template, which can be determined dynamically by Kotlin complier. In the following example, we will see how to use generic data types in Kotlin programming language.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var objet = genericsExample&lt;String&gt;(\"JAVA\")BREAKHERE" +
                "   var objet1 = genericsExample&lt;Int&gt;(10)BREAKHERE" +
                "}BREAKHERE" +
                "class genericsExample&lt;T&gt;(input:T) {BREAKHERE" +
                "   init {BREAKHERE" +
                "      println(\"I am getting called with the value \"+input)BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "In the above piece of code, we are creating one class with generic return type, which is represented as &lt;T&gt;. Take a look at the main method, where we have dynamically defined its value at the run by proving the value type, while creating the object of this class. This is how generics is interpreted by Kotlin compiler. We will get the following output in the browser, once we run this code in our coding ground.BREAKHERE" +
                "RESULTHEREI am getting called with the value JAVABREAKHERE" +
                "I am getting called with the value 10RESULTENDHERE" +
                "BREAKHERE" +
                "When we want to assign the generic type to any of its super type, then we need to use “out” keyword, and when we want to assign the generic type to any of its sub-type, then we need to use “in” keyword. In the following example, we will use “out” keyword. Similarly, you can try using “in” keyword.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   var objet1 = genericsExample&lt;Int&gt;(10)BREAKHERE" +
                "   var object2 = genericsExample&lt;Double&gt;(10.00)BREAKHERE" +
                "   println(objet1)BREAKHERE" +
                "   println(object2)BREAKHERE" +
                "}BREAKHERE" +
                "class genericsExample&lt;out T&gt;(input:T) {BREAKHERE" +
                "   init {BREAKHERE" +
                "      println(\"I am getting called with the value \"+input)BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "The above code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREI am getting called with the value 10BREAKHERE" +
                "I am getting called with the value 10.0BREAKHERE" +
                "genericsExample@28d93b30BREAKHERE" +
                "genericsExample@1b6d3586RESULTENDHERE")

        insertTopic(15, "Delegation", "H1HEREDelegationH1ENDHEREKotlin supports “delegation” design pattern by introducing a new keyword “by”. Using this keyword or delegation methodology, Kotlin allows the derived class to access all the implemented public methods of an interface through a specific object. The following example demonstrates how this happens in Kotlin.BREAKHERE" +
                "CODEHEREinterface Base {BREAKHERE" +
                "   fun printMe() //abstract methodBREAKHERE" +
                "}BREAKHERE" +
                "class BaseImpl(val x: Int) : Base {BREAKHERE" +
                "   override fun printMe() { println(x) }   //implementation of the methodBREAKHERE" +
                "}BREAKHERE" +
                "class Derived(b: Base) : Base by b  // delegating the public method on the object bBREAKHERE" +
                "BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val b = BaseImpl(10)BREAKHERE" +
                "   Derived(b).printMe() // prints 10 :: accessing the printMe() method BREAKHERE" +
                "}CODEENDHERE" +
                "In the example, we have one interface “Base” with its abstract method named “printme()”. In the BaseImpl class, we are implementing this “printme()” and later from another class we are using this implementation using “by” keyword.BREAKHERE" +
                "BREAKHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHERE10RESULTENDHERE" +
                "H2HEREProperty DelegationH2ENDHERE" +
                "In the previous section, we have learned about the delegation design pattern using “by” keyword. In this section, we will learn about delegation of properties using some standard methods mentioned in Kotlin library.BREAKHERE" +
                "BREAKHERE" +
                "Delegation means passing the responsibility to another class or method. When a property is already declared in some places, then we should reuse the same code to initialize them. In the following examples, we will use some standard delegation methodology provided by Kotlin and some standard library function while implementing delegation in our examples.BREAKHERE" +
                "BREAKHERE" +
                "BOLDHEREUsing Lazy()BOLDENDHEREBREAKHERE" +
                "Lazy is a lambda function which takes a property as an input and in return gives an instance of Lazy&lt;T&gt;, where &lt;T&gt; is basically the type of the properties it is using. Let us take a look at the following to understand how it works.BREAKHERE" +
                "CODEHEREval myVar: String by lazy {BREAKHERE" +
                "   \"Hello\"BREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   println(myVar +\" My dear friend\")BREAKHERE" +
                "}CODEENDHERE" +
                "In the above piece of code, we are passing a variable “myVar” to the Lazy function, which in return assigns the value to its object and returns the same to the main function. Following is the output in the browser.BREAKHERE" +
                "RESULTHEREHello My dear friendRESULTENDHERE" +
                "BREAKHERE" +
                "BOLDHEREDelegetion.Observable()BOLDENDHEREBREAKHERE" +
                "Observable() takes two arguments to initialize the object and returns the same to the called function. In the following example, we will see how to use Observable() method in order to implement delegation.BREAKHERE" +
                "CODEHEREimport kotlin.properties.DelegatesBREAKHERE" +
                "class User {BREAKHERE" +
                "   var name: String by Delegates.observable(\"Welcome to Kotlearn\") {BREAKHERE" +
                "      prop, old, new -&gt;BREAKHERE" +
                "      println(\"\$old -&gt; \$new\")BREAKHERE" +
                "   }BREAKHERE" +
                "}BREAKHERE" +
                "fun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val user = User()BREAKHERE" +
                "   user.name = \"first\"BREAKHERE" +
                "   user.name = \"second\"BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREfirst -&gt; secondRESULTENDHERE" +
                "In general, the syntax is the expression after the “by” keyword is delegated. The get() and set() methods of the variable p will be delegated to its getValue() and setValue() methods defined in the Delegate class.BREAKHERE" +
                "CODEHEREclass Example {BREAKHERE" +
                "   var p: String by Delegate()BREAKHERE" +
                "}CODEENDHERE" +
                "For the above piece of code, following is the delegate class that we need to generate in order to assign the value in the variable p.BREAKHERE" +
                "CODEHEREclass Delegate {BREAKHERE" +
                "   operator fun getValue(thisRef: Any?, property: KProperty&lt;*&gt;): String {BREAKHERE" +
                "      return \"\$thisRef, thank you for delegating '\${property.name}' to me!\"BREAKHERE" +
                "   }BREAKHERE" +
                "   operator fun setValue(thisRef: Any?, property: KProperty&lt;*&gt;, value: String) {BREAKHERE" +
                "      println(\"\$value has been assigned to '\${property.name} in $\thisRef.'\")BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "While reading, getValue() method will be called and while setting the variable setValue() method will be called.")

        insertTopic(16, "Functions", "H1HEREFunctionsH1ENDHEREKotlin is a statically typed language, hence, functions play a great role in it. We are pretty familiar with function, as we are using function throughout the examples. Function is declared with the keyword “fun”. Like any other OOP, it also needs a return type and an option argument list.BREAKHERE" +
                "BREAKHERE" +
                "In the following example, we are defining a function called MyFunction and from the main function we are calling this function and passing some argument.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   println(MyFunction(\"Kotlearn\"))BREAKHERE" +
                "}BREAKHERE" +
                "fun MyFunction(x: String): String {BREAKHERE" +
                "   var c:String  = \"Hey!! Welcome To ---\"BREAKHERE" +
                "   return (c+x)BREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREHey!! Welcome To ---KotlearnRESULTENDHERE" +
                "BREAKHERE" +
                "The function should be declared as follows −BREAKHERE" +
                "CODEHEREfun &lt;nameOfFunction&gt;(&lt;argument&gt;:&lt;argumentType&gt;):&lt;ReturnType&gt;CODEENDHERE" +
                "Following are some of the different types of function available in Kotlin.BREAKHERE" +
                "BREAKHERE" +
                "Lambda FunctionBREAKHERE" +
                "Lambda is a high level function that drastically reduces the boiler plate code while declaring a function and defining the same. Kotlin allows you to define your own lambda. In Kotlin, you can declare your lambda and pass that lambda to a function.BREAKHERE" +
                "BREAKHERE" +
                "Take a look at the following example.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val mylambda :(String)-&gt;Unit  = {s:String-&gt;print(s)}BREAKHERE" +
                "   val v:String = \"Kotlearn\"BREAKHERE" +
                "   mylambda(v)BREAKHERE" +
                "}CODEENDHERE" +
                "In the above code, we have created our own lambda known as “mylambda” and we have passed one variable to this lambda, which is of type String and contains a value “Kotlearn”.BREAKHERE" +
                "BREAKHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREKotlearnRESULTENDHERE" +
                "BREAKHERE" +
                "Inline FunctionBREAKHERE" +
                "The above example shows the basic of the lambda expression that we can use in Kotlin application. Now, we can pass a lambda to another function to get our output which makes the calling function an inline function.BREAKHERE" +
                "BREAKHERE" +
                "Take a look at the following example.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val mylambda:(String)-&gt;Unit  = {s:String-&gt;print(s)}BREAKHERE" +
                "   val v:String = \"Kotlearn\"BREAKHERE" +
                "   myFun(v,mylambda) //passing lambda as a parameter of another function BREAKHERE" +
                "}BREAKHERE" +
                "fun myFun(a :String, action: (String)-&gt;Unit) { //passing lambda BREAKHERE" +
                "   print(\"Heyyy!!!\")BREAKHERE" +
                "   action(a)// call to lambda functionBREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser. Using inline function, we have passed a lambda as a parameter. Any other function can be made an inline function using the “inline” keyword.BREAKHERE" +
                "RESULTHEREHeyyy!!!KotlearnRESULTENDHERE")

        insertTopic(17, "Destructuring Declarations", "H1HEREDestructuring DeclarationsH1ENDHEREKotlin contains many features of other programming languages. It allows you to declare multiple variables at once. This technique is called Destructuring declaration.BREAKHERE" +
                "BREAKHERE" +
                "Following is the basic syntax of the destructuring declaration.BREAKHERE" +
                "CODEHEREval (name, age) = personCODEENDHERE" +
                "In the above syntax, we have created an object and defined all of them together in a single statement. Later, we can use them as follows.BREAKHERE" +
                "CODEHEREprintln(name)BREAKHERE" +
                "println(age)CODEENDHERE" +
                "Now, let us see how we can use the same in our real-life application. Consider the following example where we are creating one Student class with some attributes and later we will be using them to print the object values.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   val s = Student(\"Kotlearn\",\"Kotlin\")BREAKHERE" +
                "   val (name,subject) = sBREAKHERE" +
                "   println(\"You are learning \"+subject+\" from \"+name)BREAKHERE" +
                "}BREAKHERE" +
                "data class Student( val a :String,val b: String ){BREAKHERE" +
                "   var name:String = aBREAKHERE" +
                "   var subject:String = bBREAKHERE" +
                "}CODEENDHERE" +
                "The above piece of code will yield the following output in the browser.BREAKHERE" +
                "RESULTHEREYou are learning Kotlin from KotlearnRESULTENDHERE")

        insertTopic(18, "Exception Handling", "H1HEREException HandlingH1ENDHEREException handling is a very important part of a programming language. This technique restricts our application from generating the wrong output at runtime. In this chapter, we will learn how to handle runtime exception in Kotlin. The exceptions in Kotlin is pretty similar to the exceptions in Java. All the exceptions are descendants of the “Throwable” class. Following example shows how to use exception handling technique in Kotlin.BREAKHERE" +
                "CODEHEREfun main(args: Array&lt;String&gt;) {BREAKHERE" +
                "   try {BREAKHERE" +
                "      val myVar:Int = 12;BREAKHERE" +
                "      val v:String = \"Kotlearn\";BREAKHERE" +
                "      v.toInt();BREAKHERE" +
                "   } catch(e:Exception) {BREAKHERE" +
                "      e.printStackTrace();BREAKHERE" +
                "   } finally {BREAKHERE" +
                "      println(\"Exception Handeling in Kotlin\");BREAKHERE" +
                "   }BREAKHERE" +
                "}CODEENDHERE" +
                "In the above piece of code, we have declared a String and later tied that string into the integer, which is actually a runtime exception. Hence, we will get the following output in the browser.BREAKHERE" +
                "RESULTHEREval myVar:Int = 12;BREAKHERE" +
                "Exception Handeling in KotlinRESULTENDHERE" +
                "BREAKHERE" +
                "Note − Like Java, Kotlin also executes the finally block after executing the catch block.")

    }

    private fun insertTopic(id: Int, topicHeader: String, topicContent: String) {
        val topic = TopicRecord(id, topicHeader, topicContent)
        topicDbHelper.insertTopic(topic)
    }
}
