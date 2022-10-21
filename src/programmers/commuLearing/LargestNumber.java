package programmers.commuLearing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestNumber {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 93.9/100.0
                에러의 원인? 문제 전제조건을 잘 살피자. if(answer.charAt(0)=='0') return "0";처럼 0,0,0이 주어져서 만들어진 수는 그냥 0으로 return하면 된다.

            정답풀이(teacherSolution_1):
                시간초과 발생. 효율성 체크가 아닌 시간 초과에서 중복 또는 무한 loop에 빠진 경우가 있을 수 있다.
                *** java 라이브러리를 적극 활용하자.

            정답풀이(teacherSolution_2):
                Arrays.sort(arr, new Comparator<String>() { // IDE 자동입력 활용할 것.
                    @Override
                    public int compare(String s1, String s2) {
                        return s2+s1;
                    }
                }
                Lamda 사용하기
                if(answer.startsWith("0")) return "0"; -> 문자열 첫문자 비교시 권장되는 방식!

            정답풀이(teacherSolution_3):
                *** java.lang.* 과 java.util.* 의 사용법을 숙지한다. (Stream)
        */

        // case1
        int[] numbers = {6,10,2};

        System.out.println( mySolution_1(numbers) );
        System.out.println( teacherSolution_1(numbers) );
        System.out.println( teacherSolution_2(numbers) );
        System.out.println( teacherSolution_3(numbers) );
    }

    private static String teacherSolution_3(int[] numbers) {
        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s1+s2).compareTo(s1+s2))
                .collect(Collectors.joining());

        if(answer.startsWith("0")) return "0";
        return answer;
    }

    private static String teacherSolution_2(int[] numbers) {
        // 숫자 -> 문자 -> 내림차순정렬 -> 조합
        String[] strNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNums[i] = "" + numbers[i];
        }

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);    // 오름차순으로 변경
            }
        });

        String answer = "";
        for(String s: strNums){
            answer += s;
        }

        if(answer.startsWith("0")) return "0";
        return answer;
    }

    private static String teacherSolution_1(int[] numbers) {
        // 숫자 -> 문자 -> 내림차순정렬 -> 조합
        String[] strNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNums[i] = "" + numbers[i];
        }

        for(int i=0; i<strNums.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                String s1 = strNums[i];
                String s2 = strNums[j];
                if((s1+s2).compareTo(s2+s1) < 0){
                    strNums[i] = strNums[j];
                    strNums[j] = s1;
                }
            }
        }

        String answer = "";
        for(String s: strNums){
            answer += s;
        }

        if(answer.charAt(0)=='0') return "0";
        return answer;
    }

    private static String mySolution_1(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (a,b) -> {return (a+b).compareTo(b+a);});
        List<String> list = Arrays.asList(strArr);
        Collections.reverse(list);

        for(String str : list){
            answer += str;
        }

        return answer;
    }
}
