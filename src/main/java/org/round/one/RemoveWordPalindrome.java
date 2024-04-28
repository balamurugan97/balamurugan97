package org.round.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveWordPalindrome {
    public static void main(String[] args) {
        String inputSentence;
        List<String> wordArr;
        Scanner sc = new Scanner(System.in);
        inputSentence = sc.nextLine();
        wordArr = splitSentenceIntoWord(inputSentence);
        StringBuilder output =new StringBuilder();
        for(String word: wordArr){
            if(word.length()>1 && !checkWordIsPalindrome(word.toLowerCase())){
                if(output.length()>0){
                    output.append(" ");
                }
                output.append(word);
            }
        }
        System.out.println(output);
    }

    private static boolean checkWordIsPalindrome(String word) {
        boolean isPalindrome = true;
        for(int i=0,j=word.length()-1;i<word.length()/2;i++,j--){
            if(word.charAt(i)!=word.charAt(j)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    private static List<String> splitSentenceIntoWord(String inputSentence) {
        List<String> wordArr = new ArrayList<>();
        char[] senCharArr = inputSentence.toCharArray();
        StringBuilder wordBuilder =new StringBuilder();
        int i=0;
        for(char c :senCharArr){
            if(c==' ' || c=='\n'||c=='\t'){
                wordArr.add(wordBuilder.toString());
                wordBuilder = new StringBuilder();
            } else {
                wordBuilder.append(c);
            }
            if(i == senCharArr.length-1){
                wordArr.add(wordBuilder.toString());
                wordBuilder = new StringBuilder();
            }
            i++;
        }
        return wordArr;
    }
}