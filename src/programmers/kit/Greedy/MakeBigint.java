package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 큰 수 만들기
public class MakeBigint {
    public static void main(String[] args) {
        // 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

        System.out.println(solution("1924",2));            // "94"
        System.out.println(solution("1231234",3));         // "3234"
        System.out.println(solution("4177252841",4));      // "775841"
    }

    private static String solution(String number, int k) {
        String target = "";
        List<String> list = new ArrayList<>();
        char[] arr = number.toCharArray();

        for(int i=0; i<arr.length; i++){
            list.add(String.valueOf(arr[i]));
        }

        for(int i=1; i<10; i++){
            target = String.valueOf(i);
            while(list.indexOf(target)!=-1 && k!=0){
                list.remove(list.indexOf(target));
                k--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }
}