package programmers.commuLearing.week1;

public class MagicElevetor {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 30.8 / 100.0
                이 경우, 낮은 자리수의 값만 가지고 해결했기 때문에 오답이 됐다.
                하나 윗 자리수가 무슨 수이냐에 따라 결과는 달라질 수 있다.

            정답풀이(teacherSolution_1):
                정확성: 100.0 / 100.0
                효율성: 100.0 / 100.0
                재귀문제를 어떻게 접근할지 고민해보기..

        */

        // storey가 주어지면, -100, -10, -1, 1, 10, 100과 같이 10의 정수를 기준으로 움직인다.
        // 해당 storey층에서 0층까지 내려올 수 있는 사용한 정수의 갯수를 구하는 문제!
        // 16층이라면, 10 + 10 - 1 - 1 - 1 - 1 으로 총 6번만에 0층에 도달할 수 있다.

        // case1
        int storey = 2694;  // 찾은 테스트 케이스

        // case2
//        int storey = 2554;

        // case3
//        int storey = 16;

        System.out.println( mySolution_1(storey) );
        System.out.println( teacherSolution_1(storey) );
    }

    private static int teacherSolution_1(int storey) {
        return elevator(storey);
    }

    private static int elevator(int floor) {
        if(floor <= 1) return floor;

        int under10 = floor % 10;
        int rest = floor / 10;

        int c1 = under10 + elevator(rest);
        int c2 = (10 - under10) + elevator(rest + 1);
        return Math.min(c1, c2);
    }


    private static int mySolution_1(int storey) {
        int answer = 0;
        String str = String.valueOf(storey);

        // 뒷 자리수가 5보다 크면 올림 후 차감하는 방법이 더 횟수가 작다.
        // 5라면 동일.
        while(storey!=0){
            int check = (int)(storey % Math.pow(10, 1));
            if(check > 5){
                answer += 10 - check + 1;
            }else{
                answer += check;
            }
            storey = (int) (storey / Math.pow(10, 1));
        }

        return answer;
    }
}
