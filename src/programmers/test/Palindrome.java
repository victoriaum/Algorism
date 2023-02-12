package programmers.test;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,0}, {3,1}})); //{0,0}
        //System.out.println(solution(new int[][]{{1,4,3}, {1,2,2}})); //{0,1}
        //System.out.println(solution(new int[][]{{0,2,0,1}, {0,1,0,1}})); //{1,0}
    }



    // 합계: 33.3 / 100.0
    private static int[] solution(int[][] queries) {
        int[] answer = new int[queries.length];
        int mustTrialCnt=0;

        for(int i=0; i<queries.length; i++){
            for(int j=0; j<queries[i].length/2; j++){
                if(queries[i][j]!=queries[i][queries[i].length-1-j]){
                    mustTrialCnt += queries[i][j]<queries[i][queries[i].length-1-j]?
                        queries[i][queries[i].length-1-j]-queries[i][j] : queries[i][j]-queries[i][queries[i].length-1-j];
                }
            }
            answer[i] = mustTrialCnt%2==0? 0 : 1;
            mustTrialCnt=0;
        }
        return answer;
    }

    /*private static int trial = 0;
    private static int[] solution(int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] arr = queries[i];
            while(!isPalindrome(arr)){
                makePalindrome(arr);
            }
            answer[i] = trial%2==0? 0 : 1;
        }

        return answer;
    }

    private static int[] makePalindrome(int[] arr) {
        int checkCnt = arr.length/2;
        for(int i=0; i<checkCnt; i++){
            if(arr[i]!=arr[arr.length-1-i]){
                if(arr[i]<arr[arr.length-1-i]){ arr[arr.length-1-i] = arr[arr.length-1-i] - 1;}
                else{ arr[i] = arr[i] - 1;}
            }
        }
        trial++;
        return arr;
    }

    private static boolean isPalindrome(int[] arr) {
        boolean b = true;
        int checkCnt = arr.length/2;
        for(int i=0; i<checkCnt; i++){
            if(arr[i]!=arr[arr.length-1-i]){ b=false; break; }
        }
        return b;
    }*/
}