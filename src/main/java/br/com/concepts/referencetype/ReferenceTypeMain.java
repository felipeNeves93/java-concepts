package br.com.concepts.referencetype;

import java.util.Arrays;

public class ReferenceTypeMain {

    public static void main(String... args) {

        /* Here we are creating two primitive variables (Value Type).
           A single space im memory is alocated to store the value.
           In line 12, 'anotherIntValue' creates a copy of the value,
           working independently.
         */
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue); // 10
        System.out.println("anotherIntValue = " + anotherIntValue); //10

        anotherIntValue++;

        // As you can see, the anotherIntValue works independently from myIntValue
        System.out.println("myIntValue = " + myIntValue); // 10
        System.out.println("anotherIntValue = " + anotherIntValue); // 11

        // Here we are creating an array. Arrays are refence types, i.e. hold a reference in memory
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray)); // [0,0,0,0,0]
        System.out.println("anotherArray = " + Arrays.toString(anotherArray)); // [0,0,0,0,0]

        anotherArray[0] = 1;

        // Both first values are going to change here, because we've changed the original
        // value that both variables reference.
        System.out.println("myIntArray = " + Arrays.toString(myIntArray)); // [1,0,0,0,0]
        System.out.println("anotherArray = " + Arrays.toString(anotherArray)); // [1,0,0,0,0]

    }
}
