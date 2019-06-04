public class Content {
    public String title;
    public String[] content;
    public Content(){
        title = new String ("******************************************************************\n"+
                "*   Do you want to learn Java?\n" +
                "*   Please follow my steps\n"+
                "*   Click Start button to see contents\n"+
                "*   Click previous button to review the previous one\n"+
                "*   Click next button to see the next one\n"+
                "*   Practice your Java programmings on the right\n"+
                "*   Note that please DO NOT change class names\n"+
                "*   Click run to see the actual program results after compilation and running\n"+
                "******************************************************************\n"
        );

        content=new String[]{
                "0.Java backgrounds\n" + "Java was developed by Sun Microsystems in May 1995, a general name for Java OOP" +
                        "(an object-oriented programming language) and the Java platform.\n"+
                "Java was developed by James Gosling and his colleagues, and it came out officially in 1995.\n"
                 +"It's a simple, object-oriented , class-based, strong, general-purpose computer programming language.\n",

                "1.The very first Java program\n"+
                "public class HelloWorld {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        System.out.println(\"Hello World\");\n" +
                        "    }\n" +
                        "}",

                "2.Decision making in Java\n"+
                "Java has two main decision making structures：\n"
                        +"if statements\n"
                        +"switch statements\n"
                        +"if(boolean expression)\n" +
                        "{\n" +
                        "   //If the boolean is evaluated true,the rest of codes go here.\n" +
                        "}\n"
                        +"if(boolean expression){\n" +
                        "   //If the boolean expression is true.\n" +
                        "}else{\n" +
                        "   //If the boolean expression is false.\n" +
                        "}\n"
                        +"if(boolean expression 1){\n" +
                        "   //If the boolean expression 1 is true, the rest of codes go here\n" +
                        "}else if(boolean expression 2){\n" +
                        "   //If the boolean expression 2 is true, the rest of codes go here\n" +
                        "}else if(boolean expression 3){\n" +
                        "   //If the boolean expression 3 is true, the rest of codes go here\n" +
                        "}else {\n" +
                        "   //If none of the boolean expressions is true,the rest of codes go here\n" +
                        "}\n"
                        +"switch(expression){\n" +
                        "    case value :\n" +
                        "       //statements\n" +
                        "       break; //optional\n" +
                        "    case value :\n" +
                        "       //statements\n" +
                        "       break; //optional\n" +
                        "    //You can have as many cases as you want\n" +
                        "    default : //optional\n" +
                        "       //statements\n" +
                        "}\n",

                "3.Loops in Java"+
                "There are three main loops in Java:\n"+
                        "while loops\n"+
                        "do…while loops\n"+
                        "for loops\n\n"+
                        "while( boolean expression) {\n" +
                        "  //repeated codes\n" +
                        "}\n"+
                        "do {\n" +
                        "       //statements\n" +
                        "}while(boolean expression);\n"+
                        "for(initialize; test; update) {\n" +
                        "    //statements\n" +
                        "}\n",

                "4.Define and use methods in Java"+
                "Method in Java is a collection of codes to achieve a purpose \n"+
                        "Methods are combined procedures to solve problems.\n"+
                        "Methods exist in classes or objects\n"+
                        "Methods are created in programs and can be used in other circumstances\n"+
                        "some advantages of methods\n"+
                        "1. Make codes short and easy to follow.\n"+
                        "2. Make codes easily to maintain.\n"+
                        "3. Make codes development more efficient.\n"+
                        "4. Make codes reusable.\n"+
                        "Define a method\n"+
                        "modifier return_type method_name(parameter_type parameter_name){\n" +
                        "    ...\n" +
                        "    Method body\n" +
                        "    ...\n" +
                        "    return return_value;\n" +
                        "}\n",

                "5.Inheritance in Java:\n","Inheritance is the fundamental of OOP in Java,because it allows to create class hierarchy.\n" +
                "Inheritance is subclass inheriting fields and methods from parentClass,allowing subclass objects (instances) to have fields and methods of parentClass.\n",

                "6.Inheritance format:\n","class parentClass{\n" +
                "}\n" +
                " \n" +
                "class subclass extends parentClass {\n" +
                "}\n",

                "7.Inheritance keywords:\n"+
                 "Inheritance can be done using  keywords extends and implements.\n" +
                        "All the classes belong to java.lang.Object, when a class does not have\n" +
                        "the two keywords, it inherits object by default（It's in the java.lang package),\n" +
                        "therefore,we do not need to import anything.",

                "8.Java polymorphism:\n"+"Polymorphism is the ability of an object to take on many forms.\n",

                "9.Objects in Java:\n"+"If we want to know what an object is,take a look around the real world.\n" +
                        "We can find many objects in daily life, cars, people,etc. and all of the objects have their own properties and actions.\n" +
                "Let's take an example of a dog,it has properties (fields)of :name,kind,color,actions of (methods) barking,running etc.\n" +
                "You can find a lot in common between real world objects and objects in Java.\n" +
                "Objects in Java also have properties and actions.Properties are called attributes and actions are manifested as methods.\n" +
                "In software development, methods are used to change attributes within the objects.Objects calling each other is also achieved through methods.",

                "5.Create objects\n"+"Objects are created from classes.In Java, we use the keyword new to create an object,the following steps are shown:\n" +
                "Declaration: Decalre an object, including object's name and object's type.\n" +
                "Instantiation: Use the keyword new to create an object.\n" +
                "Initialization: When creating objects using new, Java will automatically invoke the constructor to initialize."

        };
    }

}
