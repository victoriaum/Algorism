package programmers.kit.ExhaustiveSearch;

import java.util.*;

// 완전검색 - 모의고사
public class MockExam {
    public static void main(String[] args) {
        //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        //1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

        //System.out.println(solution(new int[]{1,2,3,4,5})); // [1]
        //System.out.println(solution(new int[]{1,3,2,4,2})); // [1,2,3]
        System.out.println(solution(new int[]{3,3,2,1,5})); // [3]
        //System.out.println(solution(new int[]{5,5,4,2,3})); // [1,2,3]
    }

    private static List<Integer> solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        Integer[] scores = new Integer[]{0,0,0};
        int one_index = 0, two_index = 0, three_index = 0;

        for(int i: answers){
            if(i==one[one_index]){ scores[0]=scores[0]+1; }
            if(i==two[two_index]){ scores[1]=scores[1]+1; }
            if(i==three[three_index]){ scores[2]=scores[2]+1; }

            one_index = one_index==one.length-1? 0 : one_index+1;
            two_index = two_index==two.length-1? 0 : two_index+1;
            three_index = three_index==three.length-1? 0 : three_index+1;
        }

        Integer[] origin = new Integer[]{scores[0],scores[1],scores[2]};
        Arrays.sort(scores, Collections.reverseOrder());
        int max_score = scores[0];
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<origin.length; i++){
            if(origin[i]==max_score) answer.add(i+1);
        }
        return answer;
    }

    // 작은 수 중에 큰 수, 큰 수 중에 큰 수의 곱
    private static List<Integer> trial(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        Integer[] scores = new Integer[]{0,0,0};
        int one_index = 0, two_index = 0, three_index = 0;

        for(int i: answers){
            if(i==one[one_index]){ scores[0]=scores[0]+1; }
            if(i==two[two_index]){ scores[1]=scores[1]+1; }
            if(i==three[three_index]){ scores[2]=scores[2]+1; }

            one_index = one_index==one.length-1? 0 : one_index+1;
            two_index = two_index==two.length-1? 0 : two_index+1;
            three_index = three_index==three.length-1? 0 : three_index+1;
        }

        Arrays.sort(scores, Collections.reverseOrder());
        int max_score = scores[0];
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<scores.length; i++){
            if(scores[i]==max_score) answer.add(i+1);
        }
        return answer;
    }
}