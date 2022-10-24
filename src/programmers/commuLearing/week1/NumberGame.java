package programmers.commuLearing.week1;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 100.0 / 100.0
                효율성: 100.0 / 100.0

            정답풀이(teacherSolution_1):
                정확성: 100.0 / 100.0
                효율성: 0.0 / 100.0
                이중루프 개선 필요.

            정답풀이(teacherSolution_2):
                정확성: 100.0 / 100.0
                효율성: 100.0 / 100.0
        */

        // A팀이 카드를 가지고 출전하는 순서대로의 카드값과 B팀이 가진 카드
        // A팀의 카드보다 높은 수의 카드를 B팀에서 제출하는 경우 B팀 승리
        // 총 승리 횟수는? (비기는 경우는 해당안됨.)

        // case1
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        // case2
//        int[] A = {2,2,2,2};
//        int[] B = {1,1,1,1};

        System.out.println( mySolution_1(A, B) );
        System.out.println( teacherSolution_1(A, B) );
        System.out.println( teacherSolution_2(A, B) );
    }

    // 이상하게 intelliJ에서 값이 다르게 나오네..
    private static int teacherSolution_2(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int index = B.length-1;

        int answer = 0;
        for(int i=A.length-1; i>=0; i--){
            if(A[i] < B[index]){
                index--;
                answer++;
            }
        }

        return answer;
    }

    private static int teacherSolution_1(int[] A, int[] B) {
        Arrays.sort(B);

        int answer = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                if(A[i]<B[j]){
                    answer++;
                    B[j] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    private static int mySolution_1(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        //이렇게만 풀이할 경우 승리할 수 있는 값이 있어도 넘어갈 수 있으므로 앞에서부터 비교하고 넘기는 방식으로 사용하자.
        //어차피 정렬 진행을 했으므로 그냥 넘어가는 값은 없다.
        //for(int i=A.length-1; i>=0; i--){
        //    if(B[i]>A[i]) answer++;
        //}

        int a = 0;
        int b = 0;
        for(int i=0; i<A.length; i++){
            if(B[b]>A[a]){ answer++; a++; b++; }
            else if(B[b]==A[a]){ b++; }
            else{ b++; }
        }
        return answer;
    }
}
