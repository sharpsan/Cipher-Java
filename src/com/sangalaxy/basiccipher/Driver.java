package com.sangalaxy.basiccipher;

import java.util.Scanner;

public class Driver {

    private static int rotHistory;

    public static void main(String[] args)  {
        //init vars
        initRotHistory(args);
        int rot;               // number of letter rotations user input setting
        int cryptType;         // cipher/decipher user input setting
        String runAgain;       // run again user input setting
        RotCipher rotCipher;   // class object that will do the letter rotating

        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);


        // prompt user to enter rot num
        System.out.print("Enter rot value" + showRotHistoryHint(rotHistory) + ": ");
        // get their input
        rot = scanner.nextInt();
        //validate input - must be 1-25
        while(rot < 1 || rot > 25) {
            System.out.println("Input must be 1-25. Try again.");
            System.out.print("Enter rot value" + showRotHistoryHint(rotHistory) + ": ");
            rot = scanner.nextInt();;
        }
        rotHistory = rot; //update history


        // prompt user to select either cipher or decipher
        System.out.print("Cipher(1)  Decipher(2): ");
        //get their input
        cryptType = scanner.nextInt();
        //validate input - must be either 1 or 2
        while(cryptType < 1 || cryptType > 2) {
            System.out.println("Input must be 1 or 2. Try again.");
            System.out.print("Cipher(1)  Decipher(2): ");
            cryptType = scanner.nextInt();
        }


        // prompt user to enter their message
        System.out.print("Enter message to crypt: ");
        //get their input
        String message = readString();
        //remove non-alphanumeric characters
        message = message.replaceAll("[^a-zA-Z\\s]", "");


        //begin cipher conversion
        rotCipher = new RotCipher(rot);
        rotCipher.crypt(cryptType, message);


        // prompt user to run again
        System.out.print("\nRun again?  Yes(y)  No(n): ");
        //get their input
        runAgain = scanner.next();
        if(yesCmds(runAgain)) {
            System.out.println("\n---------------------");
            main( new String[] {
                    String.valueOf(rotHistory) //pass history
            });
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

    private static boolean yesCmds(String input) {
        boolean result = false; // init as false
        String[] matches = new String[] {
                "y",
                "yes",
                "1",
                "ok"
        };

        for(String match : matches) {
            if(input.contains(match)) {
                result = true;
                break;
            }
        }

        return result;
    }

    private static String showRotHistoryHint(int rotHistory) {
        return (rotHistory > -1) ? " (last rot: " + rotHistory + ")" : "";
    }

    private static void initRotHistory(String[] stringArr) {
        if(stringArr.length > 0) {
            rotHistory = Integer.valueOf(stringArr[0]);
        } else {
            rotHistory = -1;
        }
    }
}
