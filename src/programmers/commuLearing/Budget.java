package programmers.commuLearing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Budget {
    public static void main(String[] args){
        /*
            1번째 제출풀이(firstSolution):

        */

        // numbers 대상이 되는 숫자들로 만들 수 있는 가장 큰 수를 나타내는 문자열 구하기

        // case1
        int[] numbers = {6,10,2};

        // case2
//        int[] numbers = {0,0,0};

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
