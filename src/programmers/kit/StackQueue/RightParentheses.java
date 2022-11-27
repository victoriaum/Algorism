package programmers.kit.StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 스택/큐 - 올바른 괄호
public class RightParentheses {
    public static void main(String[] args) {
        // '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
        // 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

        //String s = "()()";
        //String s = "(())()";
        String s = "()())(()";

        System.out.println(solution(s));  // 통과
        System.out.println(trial2(s));  // 정확성 실패, 효율성 통과
        System.out.println(trial(s));  // "(())()" 인 경우, 실패
    }

    private static boolean solution(String s) {
        char[] arr = s.toCharArray();
        int cnt = 0;

        if(arr[0]!='(' || arr[arr.length-1]!=')'){
            return false;
        }else{
            for(int i=0; i<arr.length; i++){
                if('('==arr[i]) cnt++;
                if(')'==arr[i]) cnt--;
            }
            if(cnt!=0) return false;
        }

        return true;
    }

    private static boolean trial2(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        int cnt = 0;

        if(arr[0]!='(' || arr[arr.length-1]!=')'){
            answer=false;
        }else{
            for(int i=0; i<arr.length; i++){
                if('('==arr[i]) cnt++;
                if(')'==arr[i]) cnt--;
            }
            if(cnt!=0) answer=false;
        }

        return answer;
    }

    private static boolean trial(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(i%2==1 && '('==arr[i]){ answer=false; break; }
            if(i%2==0 && ')'==arr[i]){ answer=false; break; }
        }
        return answer;
    }
}
