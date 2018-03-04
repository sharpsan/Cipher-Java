package com.sangalaxy.basiccipher;

import java.util.Scanner;

public class Main {

    private static int rotHistory;

    public static void main(String[] args)  {
        //init vars
        initRotHistory(args);

        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        // prompt user to enter rot num
        System.out.print("Enter rot value" + showRotHistoryHint(rotHistory) + ": ");
        // get their input
        int rot = scanner.nextInt();
        rotHistory = rot; //update history

        // prompt user to select either cipher or decipher
        System.out.print("Cipher(1)  Decipher(2): ");
        //get their input
        int cryptType = scanner.nextInt();

        // prompt user to enter their message
        System.out.print("Enter message to crypt: ");
        //get their input
        String message = readString();

        //begin cipher conversion
        RotCipher rotCipher = new RotCipher(rot);
        rotCipher.crypt(cryptType, message);

        // prompt user to run again
        System.out.print("\nRun again?  Yes(y)  No(n): ");
        //get their input
        String runAgain = scanner.next();
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
