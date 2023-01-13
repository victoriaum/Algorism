package programmers.kit.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 완전검색 - 소수 찾기
public class FindDecimals {
    public static void main(String[] args) {
        //각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

        System.out.println(solution("17"));  // 3
        System.out.println(solution("011")); // 2
    }

    /*
    function getAllCombination(arr, str) {
        if(arr.length) {
            for(let i=0; i <arr.length; i++) {
                let tmp = [...arr];
                tmp.splice(i,1);
                getAllCombination(tmp, str + arr[i]);
            }
        }
        if(str > 0) answer.add(Number(str));
    }
    */

    private static int solution(String numbers) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // 만들 수 있는 숫자조합
        char[] arr = numbers.toCharArray();
        for(char c : arr){
            list.add(String.valueOf(c));
        }

        for(int i=2; i<10; i++){
            if(n/i==0) break;
            if(i==9) answer++;
        }

        return answer;
    }
}