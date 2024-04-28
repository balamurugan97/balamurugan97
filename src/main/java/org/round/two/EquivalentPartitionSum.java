package org.round.two;

import java.util.Scanner;

public class EquivalentPartitionSum {
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int startIndex=0;
        int endIndex = arr.length-1;
        boolean result = checkEquivalentPartitionSum(arr,startIndex,endIndex,0,false);
        System.out.println(result);
    }

    private static boolean checkEquivalentPartitionSum(int[] arr, int startIndex, int endIndex, int sum, boolean b) {
        if(!b){
            int sum1 =0;
            for(int i=startIndex;i<=endIndex;i++){
                sum1 += arr[i];
            }
            b= sum == sum1;
            checkEquivalentPartitionSum(arr,startIndex,endIndex-1,sum1, b);
            checkEquivalentPartitionSum(arr,startIndex+1,endIndex,sum1, b);
            return b;
        } else {
          return true;
        }
    }

}
