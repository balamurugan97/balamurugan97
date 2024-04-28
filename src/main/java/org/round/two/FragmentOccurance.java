package org.round.two;

import java.util.*;

public class FragmentOccurance {
    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        List<String> splitWord1 = splitWord(s1);
        List<String> splitWord2 = splitWord(s2);
        List<String>  splitWord3 = splitWord(s3);
        int match =0;
        List<Map<Integer,Integer>> indexMap = new ArrayList<>();
        for(int i=0;i<splitWord1.size();i++){
            for(int j=0;j<splitWord2.size();j++){
                for(int k=0;k<splitWord3.size();k++){
                    if(match==3){
                        break;
                    }
                    if(splitWord1.get(i).equalsIgnoreCase(splitWord2.get(j)) && splitWord1.get(i).equalsIgnoreCase(splitWord3.get(k))){
                        Map<Integer,Integer> mapI = new HashMap<>();
                        mapI.put(0,i);
                        mapI.put(1,j);
                        mapI.put(2,k);
                        indexMap.add(mapI);
                        match++;
                    } else {
                        match = 0;
                    }
                }
            }
        }
        if(indexMap.size()>0){
            StringBuilder removedFragment = new StringBuilder();
            for(int i=0;i<indexMap.size();i++){
                if(!removedFragment.toString().equals("")){
                    removedFragment.append(" ");
                }
                removedFragment.append(splitWord1.get(indexMap.get(i).get(0) - i));
                splitWord1.remove(indexMap.get(i).get(0) -i);
                splitWord2.remove(indexMap.get(i).get(1) -i);
                splitWord3.remove(indexMap.get(i).get(2) -i);
            }

            System.out.println(splitWord1);
            System.out.println(splitWord2);
            System.out.println(splitWord3);
            System.out.println("Removed fragment = "+removedFragment);
        }

    }

    private static List<String> splitWord(String s1) {
        List<String> words = new ArrayList<>();
        char[] charArr = s1.toCharArray();
        int i=0;
        String word = "";
        for(char c:charArr){
            if(c==' '){
                words.add(word);
                word ="";
            } else {
                word+=c;
            }
            if(i==charArr.length-1){
                words.add(word);
            }
            i++;
        }
        return words;
    }
}
