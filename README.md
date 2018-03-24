# Groovy Fundamentals Tutorial
###### Prepared by: Misha Milovidov

In this tutorial, we will explore the fundamentals of the Groovy language. First we will have a breif introduction to Groovy as well as why and when it is used. Then we will talk about how to install Groovy our local machines. Finally we will look at Groovy's syntax and wrap things up by using the OpenWeatherMap API to create a small project in Groovy. Below you will find a link to the video that goes through this tutorial as well as the presentation that is used in the video.

* [YouTube Video]()
* [Google Slides Presentation](https://docs.google.com/presentation/d/1j4Hr1s1tiIp_5uhqayRYYyn9ZgHoBjKzS4CUhSkmG_o/edit?usp=sharing) 

## Java and the JVM

Java has been around since 1995 and has been used in a variety of environments and on a variety of devices; we see Java in enterprise server-side architectures all the way down to mobile devices. Java has been slow to evolve over the years, which has led to the developing of new languages written for the JVM as well as languages being ported over to run on the JVM. Some examples of languages that have been ported over to the JVM are jThon and jRuby, which are versions of Python and Ruby. Some examples of languages written specifically for the JVM are Scala, Clojure, and our very own Groovy.

Below is a breif diagram of the Java Development Kit distributed by Oracle.

![Image of JDK](//is542.construo.us/images/jdk.png)

These alternative JVM languages still compile down to JVM bytecode and eventually to machine code so that the instructions can be executed on the host machine.

## Groovy

Now let's take a look at Groovy itself. Here are some characteristics of Groovy:

* Dynamic Language
* Runs natively in the JVM
* Supports functional programming
* Excellent support for processing XML and JSON
* Great support in existing Java IDEs

Let's now compare Groovy and Java:

| ![Image of Groovy Logo](//is542.construo.us/images/groovy.png) | ![Image of Java Logo](//is542.construo.us/images/java.png)|
|---|---|
|Dynamic Language (typing constraints at run time)|Static Language (typing constraints at compile time)|
|Strongly Typed|Strongly Typed|
|Automatically Generates Getters and Setters|Provide Getters and Setters|
|Main Method Not Required to Execute|Main Method Required to Execute|
|Syntactic Sugar|   |

##### Why Groovy?
* Easy Transition with Experience in Java (familiar, Java-like syntax)
* Existing Java Libraries
* Fits well in the Java Object-Oriented Model
* Introduces Functional Programming on the JVM

##### When to Use Groovy:
* Web Development (Grails)
* Unit Tests
* Integration Tests
* Scripting

## Installing Groovy

As a prequisite, be sure that you have Java install on your machine and that the JAVA_HOME is set in your path. Instructions on how to install Java can be found here: https://www.java.com/en/download/help/download_options.xml.

All of the instructions for how to install Groovy can be found at the Groovy website: http://groovy-lang.org/install.html. I will cover the basic steps for OSX/Unix and Windows systems below.

#### OSX/Unix:

Probably the most simple way to install Groovy on an OSX/Unix system is to use SDKMAN (which stands for "The Software Development Kit Manager"; for more information, check out http://sdkman.io/index.html). 

Run the following commands to install SDKMAN and Groovy:

```bash
$ curl -s "https://get.sdkman.io" | bash
```

NOTE: You may need to install a few other things on your machine to be able to run the previous command. When I tried it the first time, I had to install the unzip and zip packages.


```bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
```

```bash
$ sdk install groovy
```

#### Windows:

If you are on a windows system, there is a Groovy Windows Installer that you can use and that can be found here: http://groovy-lang.org/download.html.

Again, you will need to make sure your ```JAVA_HOME``` environment variable is set and is pointed to your JDK for the Groovy installation to be successful.

## Groovy Basics

#### Groovy Shell:

Let's first start exploring Groovy by using the Groovy shell. Once you have Groovy installed, you can launch the Groovy shell by running the following command:

```bash
$ groovysh
```

After running that command you should see something like this:

```bash
Mar 23, 2018 12:56:49 AM java.util.prefs.FileSystemPreferences$1 run   
INFO: Created user preferences directory.                              
Groovy Shell (2.4.14, JVM: 1.8.0_152)                                  
Type ':help' or ':h' for help.     
---------------------------------------------------------------------- 
groovy:000>
```

As you can see, on my machine, I have Java 8 installed and I am running the latest stable version of Groovy at this time which is 2.4.14.

The Groovy shell allows us to test out Groovy code without having to use an IDE; we can type Groovy code and it will be executed in the shell.

Go ahead and try the following in the shell:

```bash
Mar 23, 2018 12:56:49 AM java.util.prefs.FileSystemPreferences$1 run   
INFO: Created user preferences directory.                              
Groovy Shell (2.4.14, JVM: 1.8.0_152)                                  
Type ':help' or ':h' for help.     
---------------------------------------------------------------------- 
groovy:000> 500+12
===> 512
groovy:000> println "This Groovy tutorial is so groovy."
This Groovy tutorial is so groovy.
===> null
groovy:000> 500 / 5
===> 100
groovy:000> println "The current time is: " + new Date()
The current time is: Fri Mar 23 01:12:50 UTC 2018
===> null
groovy:000> 
```

As you would expect, Groovy has access to all of Java's libraries so we can use ```new Date()```. We could also use other things like the ```toUpperCase()``` and ```replaceAll()``` methods on the Java string class.

#### Groovy Script:

Now that we have been able to play around in the Groovy shell a little bit, let's move on to writing our first Groovy script. You can find the materials for this section in the ```groovy-script/``` directory of this repository.

We will first create a file called: ```script.groovy```. In the file, lets write the following code:

```groovy
println "Hello World"

```

Similar to Java, we need to go to the directory where our file is and invoke the Groovy compiler with our ```script.groovy``` file as an argument by running the following:

```bash
$ groovyc script.groovy
```

Now we will have a ```script.class``` file in that directory.

```bash
$ ls
script.class  script.groovy
```

Now we can invoke the Groovy runtime on the class we just created and it will return our ```Hello World!``` message:

```bash
$ groovy script
Hello World!
$
```

The Groovy runtime will bring in a lot of commonly used packages straight into your class path and right into scope which is nice because then you don't have to worry about importing them! To illustrate this, let's go back to our ```script.groovy``` file and add another line of code.

```groovy
println "Hello World!"

Currency curr = Currency.getInstance("EUR");
String curCode = curr.getCurrencyCode();

println curCode
```

Now lets invoke the class and see what we get back:

```bash
$ groovy script
Hello World!         
EUR    
$
```

You'll notice that in our script, we were able to create a variable ``curr``` of type ```Currency`` and call the ```getCurrencyCode()``` method from the ```Java.util`` package without having to import it.

Another nice thing about Groovy is that we can skip the compile step altogether. Let's go and delete our class file and just run the ```groovy``` command against the ```script.groovy``` file. We should get the same result as before!

```bash
$ rm script.class
$ ls
script.groovy
$ groovy script.groovy
Hello World!         
EUR  
$
```

## Groovy Syntax

##### Print Line Statement

From out previous examples, you probably have noticed how easy and readable it is to print the console with Groovy. Let's do this in a new file called ```println.groovy``` found in the ```groovy-syntax/``` directory.

```groovy
// println.groovy

println 'This tutorial is great!'
```

You'll notice that there are no classes, imports, or even a main method. We also don't need a semicolon or parentheses around the string for the ```println``` method.

When we invoke the Groovy runtime on this file, we see the expected output:

```bash
$ groovy println.groovy
This tutorial is great!
$
```

##### Collections and Ranges

Lets create a collection of the names of some of the professors in th BYU Information Systems Department and iterate over each of them, printing a message to the console each time.

```groovy
// collections.groovy

def professors = [
    "Dr. Merservy",
    "Dr. Dean",
    "Dr. Keith",
    "Dr. Liddle",
    "Dr. B. Anderson",
    "Dr. G. Anderson",
    "Dr. Allen",
    "Dr. Gaskin",
    "Dr. Vance"
]

for (professor in professors) {
    def greetingText = " is the best!"
    
    println "$professor" + "$greetingText"
}
```

You'll notice that in Groovy you don't have to declare variable types because it is a dynamic language. Groovy also allows us to have a readable for loop by using the iterator variable ```professor```. You will also notice two "G Strings" where we have ```"$professor"``` and ```"$greetingText"```. G strings allow us to inject variables and other Groovy code into strings.

When we invoke the Groovy runtime on this file, we see the expected output:

```bash
$ groovy collections.groovy
Dr. Merservy is the best!           
Dr. Dean is the best!               
Dr. Keith is the best!              
Dr. Liddle is the best!             
Dr. B. Anderson is the best!        
Dr. G. Anderson is the best!        
Dr. Allen is the best!              
Dr. Gaskin is the best!             
Dr. Vance is the best!
$
```

Let's do something similar to our collection example. In Groovy, we can define ranges without having to explicitly define each value in the range. Check out the example below:

```groovy
// ranges.groovy

def numbers = 2..13

for (number in numbers) {
    println number
}
```

When we invoke the Groovy runtime on this file, we see the expected output:

```bash
$ groovy collections.groovy
2
3
4
5
6
7
8
9
10
11
12
13
$
```

#### Closures

One great feature in Groovy is the use of closures. Closures are basically variables that are set to a function call. The closure is defined immediately, but isn't executed until it is called.

Check out the simple closure example below:

```groovy
// closures.groovy

def myFirstClosure = { println 'This tutorial keeps getting better!' }

for (i in 1..10) {
    myFirstClosure()
}
```

When we invoke the Groovy runtime on this file, we see the expected output:

```bash
$ groovy closures.groovy
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better! 
This tutorial keeps getting better!
$
```

#### Other syntax

For more on Groovy syntax, check out the syntax section of the Groovy website: http://groovy-lang.org/syntax.html.

## Project

To wrap up this tutorial, let's do a mini project together where we will use the https://openweathermap.org API to get the current weather for various zip codes. You can find the files for the project in the ```groovy-project/``` directory. Let's see if we can use some of the cool Groovy syntax we have learned!

For simplicity, let's just take an input of one to many zip codes in the terminal and return the current weather for each of those zip codes by printing them out to the terminal.

If you would like to follow along, go ahead and go to https://openweathermap.org and sign up to get an API Key. It will take about 10 minutes for you API Key to be activated once it is created and calling the API won't work until the key is activated.

Let's take a look at the code in our ```project.groovy``` file to see how great Groovy is!

```groovy
// project.groovy

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')

import static groovyx.net.http.ContentType.TEXT

def host = 'http://api.openweathermap.org'
def path = 'data/2.5/weather'
def zipCodes = ['84062','81001','90210'] 
def apiKey = 'c07c1b72ab12ab07a08c159e2794df8a'
def units = 'imperial'

for (zipCode in zipCodes) {
    def httpRequest = "${host}/${path}?zip=${zipCode}&appid=${apiKey}&units=${units}"
    def client = new groovyx.net.http.HTTPBuilder(httpRequest)
        client.setHeaders(Accept: 'application/json')
    def json = client.get(contentType: TEXT)
    def response = new groovy.json.JsonSlurper().parse(json) 
    
    println ''
    println 'City:      ' + response.name
    println 'Temp(F):   ' + response.main.temp
    println ''
}
```

When we invoke the Groovy runtime on this file, we see the expected output:

```bash
$ groovy project.groovy

City:      Provo                    
Temp(F):   53.26                    


City:      Pueblo                   
Temp(F):   60.21                    


City:      Beverly Hills            
Temp(F):   60.91   

$
```

## Conclusion

This tutorial is just the beginning of what you can do with Groovy and its applications. If you would like to take a deeper dive into the language or learn more, here are some resources that are good to know about:

* Official Groovy website: http://groovy-lang.org/index.html
    * Here you will find the official documentation for Groovy and more information about the Groovy ecosystem.
* Groovy style guide: http://groovy-lang.org/style-guide.html
* Online courses/tutorials:
    * The Complete Apache Groovy Developer Course: https://www.udemy.com/apache-groovy/?couponCode=LEARN_GROOVY
    * Groovy Fundamentals: https://app.pluralsight.com/library/courses/groovy-fundamentals/table-of-contents
* Books
    * Learning Groovy: https://www.apress.com/us/book/9781484221167
    * Programming Groovy 2: https://pragprog.com/book/vslg2/programming-groovy-2