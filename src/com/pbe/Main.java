package com.pbe;

import java.util.Random;

/** Study on Java Enumerations
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// ENUMERATIONS
// *********************
// An enumeration is a list of named constants that define a new data type and its legal values.
// An enumeration object can hold only a value that was declared in the list. No other values are allowed.
// I.e.: an enumeration is a way to explicitly specify the only values that a data type can have.
//
// Enumerations are commonly used to define a set of values that represent a collection of items.
// For example: error codes (success, failed, pending) or a list of states (running, stopped, paused).
//
// Early version of Java used final variables, but enumerations are a a far superior approach.
// A Java enumeration defines a class type, as such greatly expanding the capabilities.
// Enumerations are widely used throughout the Java API library

// Enumerations fundamentals
// An enumeration is created using the enum keyword, followed by one or more enumeration constants.
// An enumeration of error codes: enum ErrorCode { Success, Failed, Pending }
// Each of the constants is implicitly declared as a public, static final member of ErrorCode, declared as type ErrorCode.
//
// Once an enumeration is defined, a variable can be created of that type.
// An enumeration variable can be declared similar as a primitive type. There's no need to instantiate an enum using new.
// For example, to declare sc as a variable of enumeration type ErrorCode: ErrorCode sc
// With sc being of type ErrorCode, the only values it can be assigned or contain are those defined by the enumeration.
// For example: sc = ErrorCode.Success
//
// Two enumeration constants can be compared for equality. For example: if (sc = ErrorCode.Succes) // ...
//
// An enumeration can also be used to control a switch statement.
// All case statements must use constants from the enum used by the switch expression. See example under Main.
// Because the type of the enum is already specified in the switch statement,
// the case statements can use enum constants without being qualified by their enum type name.
//
// When an enum constant is displayed in -for example- a println() statement, its name is the output.

// Values() and valueOf() methods
// All enumerations automatically contain two predefined methods:
// 1. values() - returns an array that contains a list of the enumeration constants
// 2. valueOf() - returns the enumeration constant whose value corresponds to the string passed in str

// Enumeration as class type
// Although not instantiating an enum using new, its similar to a class.
// Enums can be given constructors, instance variables, methods and implement interfaces.
// Each enum constant is an object of its enum type and has its own copy of instance variables that may be defined by the enumeration.
// When an enum has a constructor, it will be called when an enum constant is created.
// An enum can also offer two or more overloaded forms, as any other class.
//
// Two restrictions that apply to enumerations:
// 1. An enumeration can't inherit another class
// 2. An enumeration can't be a superclass. I.e.: it can't be extended.
// Key to remember: each of the enumeration constants is an object of the class in which it is defined.

// Enumerations inherit Enum
// All enumerations automatically inherit java.lang.Enum, which defines several methods. Three of them:
// 1. final int ordinal() - obtains a value that indicates an enumeration constant's position in the list of constants, the 'ordinal value'
// 2. final int compareTo(enum-type e) - to compare the ordinal value of two constants of the same enumeration
// If the invoking constant has an ordinal value less than e's,  a negative value is returned.
// If the two ordinal values are equal, zero is returned.
// If the invoking constant has an ordinal value larger than e's, a positive value is returned.
// 3. equals() - overrides equals() defined by Object and is used to compare for equality an enumeration constant with any other object
// Note: compare two enumeration references for equality by using ==

public class Main {

    // enumeration of error codes
    enum ErrorCode {
        Success, Failed, Pending
    }

    // enumeration of bikes
    enum Bike {
        // Setting constants, including a value
        // Each value will be passed with the constant when the constructor is called and each constant is created
        // I.e. each constant will have it's own copy of price
        Cube(2000), Bianche(3500), Sensa(1500);

        private int price; // Price of each bike

        // Constructor - will be called when an enum of type Bike is created
        Bike(int p) {
            price = p;
        }

        // Getter - can be called for each constant, getting the price of that specific constant
        int getPrice() {
            return price;
        }
    }

    enum Apple {
        Elstar, Junami, Kanzi, GoldenDelicious, Goudreinet;
    }

    public static void main(String[] args) {

        // **********************
        // Example of enumeration fundamentals
        // **********************
        System.out.println("Example of enumeration fundamentals");
        ErrorCode sc; // declaring sc as a variable of enumeration type ErrorCode
        sc = ErrorCode.Success; // assign sc the value Success
        System.out.println("Currently assigned value of sc: " + sc); // output enum value

        sc = ErrorCode.Failed; // assign sc the value Failed
        if (sc == ErrorCode.Success) { // compare enum
            System.out.println("ErrorCode now is Success");
        } else if (sc == ErrorCode.Failed) {
            System.out.println("Errorcode now is Failed");
        } else {
            System.out.println("Some error code");
        }

        // Use of enum to control a switch
        // Note that there is no need to qualify the constants in the case statements with their enum type name!
        // The enum type name is already known by the switch expression.
        switch (sc) {
            case Success:
                System.out.println("Switch: Success \n");
                break;
            case Failed:
                System.out.println("Switch: Failed \n");
                break;
            case Pending:
                System.out.println("Switch: Pending \n");
                break;
        }

        // **********************
        // Example of values() and valueOf() - using previously defined enum (sc)
        // **********************
        System.out.println("Example of enumeration fundamentals");
        System.out.println("All ErrorCode constants: ");
//        ErrorCode all_errorcodes[] = ErrorCode.values(); // set an array with all enum constants, using values()
//        for (ErrorCode x : all_errorcodes)
//            System.out.println(x);
        for (ErrorCode x : ErrorCode.values()) // shorter version, eliminating need for all_errorcodes variable
            System.out.println(x);
        System.out.println();

        sc = ErrorCode.valueOf("Failed"); // using valueOf()
        System.out.println("sc contains: " + sc + "\n");

        // **********************
        // Example of the benefits of enumerations being a class type. Using earlier defined enum Bike.
        // **********************
        System.out.println("Example of benefits of enum being a class type");
        Bike bk; // this calls the constructor of Bike once, for each constant that is specified

        // Display Cube bike price
        System.out.println("Cube bike price: " + Bike.Cube.getPrice() + " EUR \n");

        // Display all bike prices
        System.out.println("All bike prices:");
        for (Bike x : Bike.values())
            System.out.println(x + " costs " + x.getPrice() + " EUR");
        System.out.println();

        // **********************
        // Example demonstration of use of ordinal(), compareTo(), equals()
        // **********************
        System.out.println("Demonstration of ordinal(), compareTo(), equals()");
        Apple ap, ap2, ap3;
        System.out.println("All apple constants and their ordinal values:");
        for (Apple x : Apple.values())
            System.out.println(x + " " + x.ordinal());

        ap = Apple.Junami;
        ap2 = Apple.Kanzi;
        ap3 = Apple.Junami;

        System.out.println();
        if (ap.compareTo(ap2) < 0)
            System.out.println(ap + " comes before " + ap2);
        if (ap.compareTo(ap2) > 0)
            System.out.println(ap2 + " comes before " + ap);
        if (ap.compareTo(ap3) == 0) // compares two enumerations for equality
            System.out.println(ap + " equals " + ap3);

        System.out.println();
        if(ap.equals(ap2))
            System.out.println("Error!");
        if(ap.equals(ap3))
            System.out.println(ap + " equals " + ap3);
        if(ap == ap3) // compares two enumerations for equality
            System.out.println(ap + " == " + ap3);
        System.out.println();

        // **********************
        // Example of a decision maker using enumeration
        // **********************
        System.out.println("Decision maker using enumeration");

        // Create new Question object, which contains enumeration of possible answers
        Question q = new Question();

        // Feed answer with an enum constant as generated/selected by q.ask()
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
        answer(q.ask());
    }

    // **********************
    // Methods used in examples
    // **********************

    // Prints a result depending on the received enum constant
    static void answer(Answer result) {
        switch (result) {
            case NO:
                System.out.println("No");
                break;
            case YES:
                System.out.println("Yes");
                break;
            case MAYBE:
                System.out.println("Maybe");
                break;
            case LATER:
                System.out.println("Later");
                break;
            case SOON:
                System.out.println("Soon");
                break;
            case NEVER:
                System.out.println("Never");
                break;
        }
    }
}