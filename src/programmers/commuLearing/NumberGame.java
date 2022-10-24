package programmers.commuLearing;

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

        // d는 부서별로 신청한 예산, budget은 전체 예산
        // 여기서 예산 중 최대 몇 개의 부서를 지원 가능한지 도출

        // case1
        int[] A = {5,1,3,7};
        int[] B = {8,2,6,2};

        // case2
//        int[] A = {2,2,2,2};
//        int[] B = {1,1,1,1};

        System.out.println( mySolution_1(A, B) );
        System.out.println( teacherSolution_1(A, B) );
        System.out.println( teacherSolution_2(A, B) );
    }

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
