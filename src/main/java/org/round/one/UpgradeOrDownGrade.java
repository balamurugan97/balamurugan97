package org.round.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UpgradeOrDownGrade {
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        String version1 = sc.nextLine();
        String version2 = sc.nextLine();
        List<Integer> split1 = splitVersion(version1);
        List<Integer> split2 = splitVersion(version2);
        int maxEle = Math.max(split1.size(), split2.size());
        addPostfix(split1,maxEle);
        addPostfix(split2,maxEle);
        for(int i=0;i<maxEle;i++){
            if (Objects.equals(split1.get(i), split2.get(i))) {
                if (maxEle - 1 == i) {
                    System.out.println("Equal");
                }
            } else if (split1.get(i) > split2.get(i)) {
                System.out.println("Downgraded");
                break;
            } else {
                System.out.println("Upgraded");
                break;
            }
        }
    }

    private static void  addPostfix (List split1,int maxEle){
        if(split1.size()<maxEle){
            for(int i=0;i<maxEle;i++){
                split1.add(0);
            }
        }
    }

    private static List<Integer> splitVersion(String version1) {
        List<Integer> a = new ArrayList<>();
        String intc ="";
        int i=0;
        for(char c:version1.toCharArray()){
            if(c!='.'){
                intc += c;
            } else {
                if(!intc.equals("")){
                    a.add(Integer.parseInt(intc));
                    intc = "";
                }
            }
            if(i==version1.length()-1){
                if(!intc.equals("")){
                    a.add(Integer.parseInt(intc));
                }
            }
            i++;
        }
        return a;
    }

}
