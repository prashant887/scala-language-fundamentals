Create Scala Class File 
scalac <file>.scala

Scala Compile Phases
scalac -Xshow-phases

          Any
AnyVal               AnyRef(Java.lang.object)
1. Double            List
2. Float             Option

AnyVal : Instance of Anyval are not represnted as objects (prmetive types) 
AnyRef : 

Functions and Methods are not the same in Scala
Functions are Objects 
Methods are instance of class and not Objects 

Methods can be converted to functions 
Methods are associated with Class 

Functions are declared as () , val getCount=()=>{}

Method: def getCount():Int={}

Function :
Complete Standalone Object 
Function class implements traits 
Functions can be stored in val/var  
Objects of Type Function1,Function0 
Invoking a function , Invokes apply Method (executes code inside apply)
Can be anonmyous
Dont take default val

Method:
Part of the class and always associated with class 
Has name , signature and annotation
cannot be stored in variable 
Not Objects,but can be converted to functions 
Invkoing a method invokes code in it 
always needs to have name 
takes defualt val


Function literal in the source code get compiled to a class that is instanced  at run time

Partially Applied  Function:where all the args are not passed that function needs specify some or None

Partial Function creates to only a subset of possible data for which it has been defined , works for certain values passed

First Class Function allows functions to be assigned to variable and execute it

HigherOrder Functions : Takes Functions as input param , functions are first class citizen , even methods can be passed as args 

