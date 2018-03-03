package com.sangalaxy.basiccypher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        // prompt user to enter rot num
        System.out.print("Enter rot value: ");

        // get their input
        String rot = scanner.next();
        int rotInt = Integer.valueOf(rot);

        // prompt user to select either cypher or decypher
        System.out.print("Cypher (1)  Decypher (2):");

        //get their input
        String cryptType = scanner.next();
        int cryptTypeInt = Integer.valueOf(cryptType);

        // prompt user to enter their message
        System.out.print("Enter message to crypt: ");

        //get their input
        String message = readString();


        //begin cypher conversion
        Cypher1 cypher1 = new Cypher1(rotInt);
        cypher1.crypt(cryptTypeInt, message);
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
