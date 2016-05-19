# Grader app

## The task
Create a simple app that is able to grade a test: for an input test score 
(an integer between 0 and 100) assigns a mark from "F" (lowest) to "A" (highest mark).

The grades it should give:

 - below score 40: F
 - scores from 41 to 50: E
 - scores from 51 to 60: D
 - scores from 61 to 70: C
 - scores from 71 to 80: B
 - from above score 81: A

You should have a test coverage (branch coverage!) of 100%.

There is a skeleton set up already for this (build.sbt, Grader.scala, GraderTest.scala)

_Hint 1_: extend the _Enumeration_ trait to model the grades!
_Hint 2_: use Scala's pattern matching capabilities!


## Technical help

### Compile & test & measure coverage in the console

You should be able to compile the scala codes and run the tests from the console, via SBT.
At first, let's check if we can compile the current codes with SBT:

{{< highlight bash >}}
$ sbt compile
{{< / highlight >}}

Don't go any further before this works! If you have not installed SBT yet, 
then follow the [official guide](http://www.scala-sbt.org/0.13/docs/Setup.html).

Also, test coverage can be measured
with the ["sbt-scoverage" plugin](https://github.com/scoverage/sbt-scoverage).
It's all set up for you (check "build.sbt" and "project/plugins.sbt" files in the repo if you are curious).

This one-liner sbt command compiles the code, runs all the tests and creates a code coverage report:

{{< highlight bash >}}
$ sbt clean "set coverageEnabled := true" test coverage coverageReport
{{< / highlight >}}

The generated reports can be viewed in a browser, at ["target/scala-2.11/scoverage-report/index.html"](file:///home/adri/hub/scala-examples/01_grader_app/target/scala-2.11/scoverage-report/index.html)


### Optional: use Scala-IDE (Eclipse-based) for development

Follow these steps to set it up:
 1. Download the Scala-IDE from [scala-ide.org](http://scala-ide.org/)
 2. Unpack
 3. Start (there is an "eclipse" runnable file after unpacking)
 4. Use the SBT plugin named "sbteclipse-plugin" to generate the Eclipse project file:
    - At first you need to add the following line to the "project/plugins.sbt" file within the sbt project root:
    {{< highlight scala >}}
    addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
    {{< / highlight >}}
    Note: this is already done here! 
    - Then run the following sbt command in the console within the root of the project:
    {{< highlight scala >}}
    $ sbt eclipse 
    {{< / highlight >}}
    Now the plug-in has generate the files needed by Eclipse (".classpath" and ".project").
 5. Create a New project in Eclipse: top left corner, "File" -> "New" -> "Scala project"; then un-tick the "Use default location" ceckbox and click the "Browse" button to navigate to your project root (that's where the .classpath and .project files were generated in the previous step). Other settings are fine, just use the default. Finish.
 6. To test the setup, try opening the test file: src/test/scala/grader/GraderTest.scala , then right click on the editor area, and choose "Run As" -> "ScalaTest .. " option. If Eclipse can not run your one and only test, or if it fails, then it's time to check everything once more...



## In case you're done too early...

### Task extension 1

The App should return with a Scala "None" object instead of a real "Grade" when the score is below 0 or above 100.

So, the None-s and the valid grades it should give can be summed up as:

 - scores below 0 : _None_
 - scores from  0 to  40: F
 - scores from 41 to  50: E
 - scores from 51 to  60: D
 - scores from 61 to  70: C
 - scores from 71 to  80: B
 - scores from 81 to 100: A
 - scores above 100: _None_

### Task extension 2

The App should throw an exception when the score is below 0 or above 100.
You also need to test if a proper exception is thrown!

So, the exceptions and the valid grades it should give can be summed up as:

 - scores below 0 : _exception_
 - scores from  0 to  40: F
 - scores from 41 to  50: E
 - scores from 51 to  60: D
 - scores from 61 to  70: C
 - scores from 71 to  80: B
 - scores from 81 to 100: A
 - scores above 100: _exception_

