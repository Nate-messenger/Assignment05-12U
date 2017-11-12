/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nate
 */
public class w$w {

    private char[] stack;

    public boolean inLang(String word) {
//turn the word into lower case to prevent errors
        word = word.toLowerCase();

        stack = new char[word.length() + 1];
        //populate the array with the  characters from the word
        int pos = 0;
        for (int i = stack.length - 1; i > 0; i--) {
            stack[pos] = word.charAt(i - 1);
            pos++;

        }
//check if the middle 
        if (stack[stack.length / 2 - 1] != '$') {
            return false;
        }
        //go throught the array and check for the first letter to be the last letter and so on
        int p = 0;
        int o = stack.length - 2;
        while (stack[o] != '$' && stack[p] != '$') {
            if (stack[p] == stack[o]) {
                p++;
                o--;
            } else {
                return false;
            }
        }
        return true;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        w$w w = new w$w();
        String word = "Bananas$sananab";
        String word2 = "racecar$racecar";
        String word3 = "butts$sttub";
        String word4 = "jdrh$gddg";
        
        if (w.inLang(word)) {
            System.out.println(word + " is in the language");
        } else {
            System.out.println(word + " is not in the language");
        }
        if (w.inLang(word2)) {
            System.out.println(word2 + " is in the language");
        } else {
            System.out.println(word2 + " is not in the language");
        }
        if (w.inLang(word3)) {
            System.out.println(word3 + " is in the language");
        } else {
            System.out.println(word3 + " is not in the language");
        }
        if (w.inLang(word4)) {
            System.out.println(word4 + " is in the language");
        } else {
            System.out.println(word4 + " is not in the language");
        }
    }

}
