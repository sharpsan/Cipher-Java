package com.sangalaxy.basiccipher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        // prompt user to enter rot num
        System.out.print("Enter rot value: ");
        // get their input
        int rot = scanner.nextInt();

        // prompt user to select either cipher or decipher
        System.out.print("Cipher(1)  Decipher(2): ");
        //get their input
        int cryptType = scanner.nextInt();

        // prompt user to enter their message
        System.out.print("Enter message to crypt: ");
        //get their input
        String message = readString();

        //begin cipher conversion
        Cipher1 cipher1 = new Cipher1(rot);
        cipher1.crypt(cryptType, message);

        // prompt user to run again
        System.out.print("\nRun again?  Yes(1)  No(2): ");
        //get their input
        int runAgain = scanner.nextInt();
        if(runAgain == 1) {
            System.out.println("\n---------------------");
            main( new String[0]);
        } else {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}