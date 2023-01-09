package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 큰 수 만들기
public class MakeLargest {
    public static void main(String[] args) {
        // 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

        // k의 수를 지워야 하면, 먼저 뒤 2자리를 제거후, 앞 부분에서 가장 큰 수를 answer에 더해준다.
        // 그리고 k-1 수를 남기는 것으로 위와 동일하게 계속 계산한다.

        System.out.println(solution("1924", 2));     // "94"
        System.out.println(solution("1231234", 3));     // "3234"
        System.out.println(solution("4177252841", 4));     // "775841"
    }

    // https://born2bedeveloper.tistory.com/27
    // 풀이참조
    private static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k;
        int start = 0;

        while(start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(Integer.toString(max));
        }
        return answer.toString();
    }

    private static String trial(String number, int k) {
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