# Project Courrier

Authors : Théophile COSSE and Florian COVEY

## The Project 
Courrier is a software written in JAVA that emulate letter sending and letterbox.

### UML Diagram
![Image](COURRIER/uml.jpg)

## How To
### Installation
1. Install maven, the method will depend on your distribution

For Debian/Ubuntu

```
# apt install maven
```

2. Get the project

```
$ git clone git@gitlab-etu.fil.univ-lille1.fr:cosse/covey-cosse-coo-projet-courrier.git
```

3. Make the executable

```
$ mvn package
```
4. Execute the jar file

```
$ java -jar ./COURRIER/target/*.jar
```

### Generate Javadoc
```
$ mvn javadoc:javadoc
```
The Javadoc generated can be found in /COURRIER/target/docs/index.html

### Key aspect of the project

* To keep traces of every letter send and their content we chose to make the add the method getDescription() which return a string
describing the content. 

* We had to face some difficulties with the creation of InstrumentedLetter class (used to test the triggering of the action()), but after realizing we were writing the same code as LetterDecorator we decided to used this class to create the instrumentedLetter instead of using the proxy design patter to do the same thing.

* Using the default parameters for the Fool Letters given by the subject, the program was sometime stuck in a endless loop. But we quickly discovered that's because by sending 10 letters and with a probability of 15% to answer, there was always one or more inhabitant answering the lettter.

