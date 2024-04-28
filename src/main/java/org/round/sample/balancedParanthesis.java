package org.round.sample;

import java.util.ArrayList;
import java.util.Scanner;

public class balancedParanthesis {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int paranthesisSetCount = s.nextInt();
        ArrayList<String>  paranthesisSet = new ArrayList<>();
        paranthesisSet.add(makeParanthesisSet(paranthesisSetCount));
        paranthesisSet.add(balancedParanthesisM(paranthesisSet.get(0)));
        System.out.println(paranthesisSet);
    }

    private static String balancedParanthesisM(String paranthesisSet) {
        StringBuilder openParanthesis = new StringBuilder();
        StringBuilder closedParanthesis = new StringBuilder();
        for (int i = 0; i < paranthesisSet.length(); i++){
            if (paranthesisSet.charAt(i) == '{') {
                openParanthesis.append("{");
            }
            if(paranthesisSet.charAt(i) == '}') {
                closedParanthesis.append("}");
            }
        }
        return String.valueOf(openParanthesis.append(closedParanthesis));
    }

    private static String makeParanthesisSet(int paranthesisSetCount) {
        StringBuilder paranthesis = new StringBuilder();
        for(int i=1;i<=paranthesisSetCount;i++){
            paranthesis.append("{");
            paranthesis.append("}");
        }
        return String.valueOf(paranthesis);
    }
}
