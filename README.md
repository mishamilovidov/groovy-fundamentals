# Groovy Fundamentals Tutorial
###### Prepared by: Misha Milovidov

In this tutorial, we will explore the fundamentals of the Groovy language. First I will give a brief background of Groovy, as well as why and when it is use. Then I will talk about how to install Groovy on you machine. Finally we will look at Gro0vy's  syntax and perform a few programming tasks. Below are a link to a video that goes through this tutorial as well as the presentation that is used in the video.

* [YouTube Video]()
* [Google Slides Presentation](https://docs.google.com/presentation/d/1j4Hr1s1tiIp_5uhqayRYYyn9ZgHoBjKzS4CUhSkmG_o/edit?usp=sharing) 

## Java and the JVM

## Groovy

## Installing Groovy

As a prequisite, be sure that you have Java install on your machine and that the JAVA_HOME is set in your path. Instructions on how to install Java can be found here: https://www.java.com/en/download/help/download_options.xml.

All of the instructions for how to install Groovy can be found at the Groovy website: http://groovy-lang.org/install.html. I will cover the basic steps for OSX/Unix and Windows systems below.

#### OSX/Unix:

Probably the most simple way to install Groovy on an OSX/Unix system is to use SDKMAN (which stands for "The Software Development Kit Manager"; for more information, check out http://sdkman.io/index.html). 

Run the following commands to install SDKMAN and Groovy:

```bash
$ curl -s "https://get.sdkman.io" | bash
```

NOTE: You may need to install a few other things on your machine to be able to run the previous command. When I tried it the first time, I had to install the 


```bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
```

```bash
$ sdk install groovy
```

#### Windows:

If you are on a windows system, there is a Groovy Windows Installer that you can use and that can be found here: http://groovy-lang.org/download.html.

Again, you will need to make sure your ```JAVA_HOME``` environment variable is set and is pointed to your JDK for the Groovy installation to be successful.

## Getting Started With Groovy
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

## Syntax

## Project

To wrap up this tutorial, let's do a mini project together where we will use the https://openweathermap.org API to get the current weather for various zip codes. You can find the files for the project in the ```groovy-project/``` directory. Let's see if we can use some of the cool Groovy syntax we have learned!

For simplicity, let's just take an input of one to many zip codes in the terminal and return the current weather for each of those zip codes by printing them out to the terminal.

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