package programmers.kit.Sort;

import java.util.*;

// 정렬 - 가장 큰 수
public class _Largest {
    public static void main(String[] args) {
        // 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

        System.out.println(solution(new int[]{6, 10, 2}));            // "6210"
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));     // "9534330"
        System.out.println(solution(new int[]{0, 0, 34, 5, 9}));      // "953400"
    }

    // 0이 여러개만 있는 경우의 처리
    private static String solution(int[] numbers) {
        String answer = "";
        boolean except = true;
        String[] num = new String[numbers.length];

        for(int i = 0; i < num.length; i++){
            num[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) except = false;
        }

        Arrays.sort(num, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2) {
                return (n2+n1).compareTo(n1+n2);
            }
        });
        for(int i = 0; i < num.length; i++)
            answer += num[i];
        if(except) answer = "0";
        return answer;
    }

    // 시간초과와 정확성 문제발생
    private static String trial(int[] numbers) {
        String answer = "";
        Integer[] arr = new Integer[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = numbers[i];
        }
        Arrays.sort(arr, (x,y)-> Integer.parseInt(String.valueOf(y).substring(0,1)) - Integer.parseInt(String.valueOf(x).substring(0,1)) );

        for(int i=0; i<arr.length; i++){
            int first = arr[i];
            for(int j=i; j<arr.length; j++){
                int second = arr[j];
                if(Integer.parseInt(String.valueOf(first)+String.valueOf(second)) < Integer.parseInt(String.valueOf(second)+String.valueOf(first))){
                    arr[i] = second;
                    arr[j] = first;
                }
            }
            answer+=String.valueOf(arr[i]);
        }

        return answer;
    }
}