package programmers.kit.Sort;

import java.util.*;

// 정렬 - H-Index
public class H_Index {
    public static void main(String[] args) {
        //어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
        // 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
        /*
            H는 논문수;
            논문의 인용수가 H보다 많거나 같은 논문개수가 H보다 크면 H 는 True;
            Max H를 구하는 문제입니다.
        */

        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));       // 3
        System.out.println(solution(new int[]{0, 0, 0, 0, 0}));       // 0
        System.out.println(solution(new int[]{2}));                   // 1
    }

    // H보다 많거나 같은 논문개수가 H보다 크면 H 는 True;
    // 정확성 테스트만 있음
    private static int solution(int[] citations) {
        int answer = 0;
        int index = 0;
        Arrays.sort(citations);

        while(index<citations.length) {
            if (citations[index]>=answer) {
                if(citations.length-index<answer){
                    answer--;
                    break;
                }else{
                    answer++;
                }
            }else{
                index++;
                if(index==citations.length) answer--;
            }
        }
        return answer;
    }

    private static int trial(int[] citations) {
        int answer = 0;
        int index = 0;
        Arrays.sort(citations);

        while(index<citations.length) {
            if (citations[index]>=answer) {
                if(citations.length-index-answer==0){
                    break;
                }else{
                    answer++;
                }
            }else{
                index++;

            }
        }
        return answer;
    }
}