package programmers.commuLearing.week1;

import java.util.Arrays;

public class FactoryManaging {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 50.0 / 50.0
                효율성: 0.0 / 50.0 -> 효율성이 낮은 코드다. 시간초과로 실패 발생.

            2번째 제출풀이(mySolution_2):
                정확성: 50.0 / 50.0
                효율성: 0.0 / 50.0 -> 효율성이 낮은 코드다. 시간초과로 실패 발생.
                정답 근처라고 생각되는 시간을 미리 설정한 이후 루프를 돌렸지만 이것도 효율성 측면에서 도움이 되지 않았다.
                while과 for문의 이중반복을 해결해야 할 것 같다.

            정답풀이(teacherSolution_1):
                정확성: 100.0 / 100.0
                효율성: 100.0 / 100.0
                메소드 나눠서 정리하는 습관 기르기.

        */

        // goal이 목표 생산량이다. durations는 각 인부가 하나의 인형을 생산하는데 소요되는 시간(초)이다.
        // 최소 시간동안 가장 적게 생산한 사람보다 초과 생산을 한 사람에게 인센티브(10,000원)을 제공한다
        // 총 인센티브는?

        // case1
        int goal = 43;
        int[] durations = {5,3,7,6,4};

        System.out.println( mySolution_1(goal, durations) );
        System.out.println( mySolution_2(goal, durations) );
        System.out.println( teacherSolution_1(goal, durations) );
    }

    private static long teacherSolution_1(int goal, int[] durations) {
        int maxDuration = 0; // 가장 오래 걸리는 시간
        for (int d : durations) maxDuration = Math.max(maxDuration, d);

        long hours = finishHours(goal, durations, maxDuration);
        return calcPay(hours, durations, maxDuration);
    }

    private static long finishHours(int goal, int[] durations, int maxDuration) {
        long min = 0;
        // 최대로 걸리는 시간은 모든 작업자가 가장 오래 걸리는 시간만큼 작업하는 경우
        // 목표량을 작업자 수로 나누면 소수점 버림이 생기니까 1을 더해 넉넉한 최대값을 만들어 줌
        long max = maxDuration * (goal / durations.length + 1L);

        while (min < max) {
            long mid = (min + max) / 2;

            int count = 0;
            for (int d : durations) count += mid / d;

            if (count < goal) min = mid + 1;
            else max = mid;
        }

        return max;
    }

    private static long calcPay(long hours, int[] durations, int maxDuration) {
        // 가장 적은 인형의 개수는 작업시간이 가장 오래 걸리는 작업자가 만든 경우
        long minCount = hours / maxDuration;

        long incentive = 0;
        for (int d : durations) {
            incentive += hours / d - minCount;
        }
        return incentive * 10_000L; // 개 당 10,000원;
    }

    private static long mySolution_2(int goal, int[] durations) {
        long answer = 0;
        int time = 0;
        int cnt = 0;

        Arrays.sort(durations);
        time = goal/durations.length*durations[0];

        while(true){
            time++;
            for(int i=0; i<durations.length; i++){
                cnt += time/durations[i];
            }
            if(goal<=cnt) break;
            else cnt = 0;
        }

        int min = time/durations[durations.length-1];

        for(int i=0; i<durations.length; i++){
            answer += time/durations[i];
        }

        return (answer-durations.length*min)*10000;
    }

    private static long mySolution_1(int goal, int[] durations) {
        long answer = 0;
        int time = 0;
        int cnt = 0;
        int[] product = new int[durations.length];

        while(true){
            time++;
            for(int i=0; i<durations.length; i++){
                cnt += time/durations[i];
            }
            if(goal<=cnt) break;
            else cnt = 0;
        }

        for(int i=0; i<durations.length; i++){
            product[i] = time/durations[i];
        }

        Arrays.sort(product);

        for(int i=0; i<product.length; i++){
            answer += product[i] - product[0];
        }

        return answer*10000;
    }
}
