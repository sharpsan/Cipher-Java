package com.sangalaxy.basiccipher;

import java.util.HashMap;

public class RotCipher {

    private final HashMap<String, Integer> letterNumHashMap;
    private final HashMap<Integer, String> numLetterHashMap;
    private final int rot;

    public RotCipher(int rot) {
        this.letterNumHashMap = buildLetterNumHashMap();
        this.numLetterHashMap = buildNumLetterHashMap();
        this.rot = rot;
    }

    public String crypt(int cryptType, String input) {
        String output = "";
        String inputToLowercase = input.toLowerCase();
        char[] characters = inputToLowercase.toCharArray();
        System.out.println("=====================");
        System.out.println("       RESULTS       ");
        System.out.println("=====================");
        System.out.println("------ verbose ------");
        System.out.println(" ORIGINAL | CIPHER'D");
        System.out.print("");
        for(char character: characters) {
            String characterString = String.valueOf(character);
            if(!characterString.equals(" ") && !characterString.equals("")) {
                String cipheredChar = "";
                if(cryptType == Constants.ROT_UP) {
                    cipheredChar = rotChar(characterString, Constants.ROT_UP);
                } else if(cryptType == Constants.ROT_DOWN) {
                    cipheredChar = rotChar(characterString, Constants.ROT_DOWN);
                }

                System.out.println("        " + character + " | " +  cipheredChar + "        ");
                output += cipheredChar;
            } else {
                output += character;
                System.out.println("          |");
            }
        }

        System.out.println("------ complete cipher'd message ------");
        System.out.println("---> " + output);
        return output;
    }

    private String rotChar(String character, int direction) {
        String output;
        int letterNum = letterNumHashMap.get(String.valueOf(character));

        //get index of new letter
        int cipherNum = (direction == Constants.ROT_UP) ? letterNum + rot : letterNum - rot; //if direction is up, increase by rot, otherwise decrease
        //fix if letter wraps around
        if(cipherNum > Constants.ALPHABET_SIZE) {
            cipherNum = cipherNum - Constants.ALPHABET_SIZE;
        } else if(cipherNum < 1) {
            cipherNum = Constants.ALPHABET_SIZE + cipherNum;
        }

        String cipherNumLetter = numLetterHashMap.get(cipherNum);
        output = cipherNumLetter;
        return output;
    }

    private HashMap<String, Integer> buildLetterNumHashMap() {
        HashMap<String, Integer> letterNumHashMap = new HashMap<>();

        //assign letters to numbers
        letterNumHashMap.put("a", 1);
        letterNumHashMap.put("b", 2);
        letterNumHashMap.put("c", 3);
        letterNumHashMap.put("d", 4);
        letterNumHashMap.put("e", 5);
        letterNumHashMap.put("f", 6);
        letterNumHashMap.put("g", 7);
        letterNumHashMap.put("h", 8);
        letterNumHashMap.put("i", 9);
        letterNumHashMap.put("j", 10);
        letterNumHashMap.put("k", 11);
        letterNumHashMap.put("l", 12);
        letterNumHashMap.put("m", 13);
        letterNumHashMap.put("n", 14);
        letterNumHashMap.put("o", 15);
        letterNumHashMap.put("p", 16);
        letterNumHashMap.put("q", 17);
        letterNumHashMap.put("r", 18);
        letterNumHashMap.put("s", 19);
        letterNumHashMap.put("t", 20);
        letterNumHashMap.put("u", 21);
        letterNumHashMap.put("v", 22);
        letterNumHashMap.put("w", 23);
        letterNumHashMap.put("x", 24);
        letterNumHashMap.put("y", 25);
        letterNumHashMap.put("z", 26);

        return letterNumHashMap;
    }

    private HashMap<Integer, String> buildNumLetterHashMap() {
        HashMap<Integer, String> numLetterHashMap = new HashMap<>();

        //assign numbers to letters
        numLetterHashMap.put(1, "a");
        numLetterHashMap.put(2, "b");
        numLetterHashMap.put(3, "c");
        numLetterHashMap.put(4, "d");
        numLetterHashMap.put(5, "e");
        numLetterHashMap.put(6, "f");
        numLetterHashMap.put(7, "g");
        numLetterHashMap.put(8, "h");
        numLetterHashMap.put(9, "i");
        numLetterHashMap.put(10, "j");
        numLetterHashMap.put(11, "k");
        numLetterHashMap.put(12, "l");
        numLetterHashMap.put(13, "m");
        numLetterHashMap.put(14, "n");
        numLetterHashMap.put(15, "o");
        numLetterHashMap.put(16, "p");
        numLetterHashMap.put(17, "q");
        numLetterHashMap.put(18, "r");
        numLetterHashMap.put(19, "s");
        numLetterHashMap.put(20, "t");
        numLetterHashMap.put(21, "u");
        numLetterHashMap.put(22, "v");
        numLetterHashMap.put(23, "w");
        numLetterHashMap.put(24, "x");
        numLetterHashMap.put(25, "y");
        numLetterHashMap.put(26, "z");

        return numLetterHashMap;
    }

}
