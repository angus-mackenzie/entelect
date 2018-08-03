#MCKANG009
#A Simple makefile
#defining the java compiler flag
JCC = javac

#Define a makefile variable for compilation flags
#the -g flag compiles with debugging information
JFLAGS = -g

#typing 'make' will invoke the first target entry in the makefile

default: driver.class MapReader.class

#This lays out the parameters to build a class, lays out the dependency between .class and .java
#Could be streamlined by using other variables and a loop, but 
driver.class: driver.java
	$(JCC) $(JFLAGS) driver.java
MapReader.class: MapReader.java
	$(JCC) $(JFLAGS) MapReader.java

#To clean the directory
clean:
	$(RM) *.class
	$(RM) -rf docs
#To make documentation
docs:
	javadoc -d  docs *.java 