package programmers.commuLearing.week1;

import java.util.Arrays;

public class BikeFactory {
    public static void main(String[] args){
        /*
            1번째 제출풀이(mySolution_1):
                정확성: 7.1 / 100.0
                효율성: 0.0 / 100.0

            정답풀이(teacherSolution_1):
                정확성: 100.0 / 100.0
                효율성: 100.0 / 100.0

        */

        // cost는 {비용구간, 비용}으로 되어져 있는 배열로, case1을 기준으로 보면, 0~50대의 자전거를 생산하는 비용은 10원씩이다.
        // order는 {기한(월), 필요생산량}으로 case1을 기준으로 보면, 3개월 내 50대의 자전거 생산이 필요하다.
        // order 배열이 정렬되어 있지 않다는 점에 주의하자.

        // case1
        int[][] cost = {{0, 10}, {50, 20}, {100, 30}, {200, 40}};
        int[][] order = {{3, 50}, {7, 200}, {8, 200}};

        // case2
//        int[][] cost = {{0, 10}, {50, 20}};
//        int[][] order = {{3, 100}, {4, 200}};

        System.out.println( mySolution_1(cost, order) );
        System.out.println( teacherSolution_1(cost, order) );
    }

    private static int teacherSolution_1(int[][] cost, int[][] order){
        int answer = 0;

        int maxMonth = 0;
        for (int[] o : order) maxMonth = Math.max(maxMonth, o[0]);

        // 주문 정렬
        int[] monthlyOrder = new int[maxMonth];
        int need = 0;
        int made = 0;
        for (int[] o : order) {
            // order 배열이 정렬되어 있지 않음에 주의하세요.
            monthlyOrder[o[0] - 1] += o[1]; // 월을 index로 사용하기 위해 -1을 해줍니다
            need += o[1];
        }

        for (int i = 0; i < cost.length - 1; i++) {
            if (need == 0 || made >= need) break;

            int price = cost[i][1];
            int limit = cost[i + 1][0] - cost[i][0];
            int rest = 0;

            for (int j = 0; j < maxMonth; j++) {
                if (need == 0 || made >= need) break;

                int making = Math.min(limit, need - made);

                answer += making * price;
                made += making;
                need -= monthlyOrder[j];

                if (monthlyOrder[j] == 0) continue; // 납품을 안해도 됩니다.

                int delivery = Math.min(made, monthlyOrder[j]);

                // 납품할때가 되면 만들어놓은 것에서 빼줍니다.
                made -= delivery;
                monthlyOrder[j] -= delivery;
                rest += monthlyOrder[j]; // 납품하고도 남은것은 다음구간에서 만들어야 합니다.
            }

            need = rest;
            made = 0;
        }

        // 나머지 것들은 최종구간의 가격을 적용합니다.
        answer += need * cost[cost.length - 1][1];
        return answer;
    }


    private static int mySolution_1(int[][] cost, int[][] order) {
        int answer = 0;
        int index = 0;
        int remain = 0;
        int month = 0;

        for(int i=0; i<order.length; i++){
            remain = remain + order[i][1];
            if(i==0) month = order[i][0];
            else month = order[i][0] - order[i-1][0] + month;

            if(remain/(cost[index+1][0]-cost[index][0]) - month > 0){
                answer += order[i][1] * cost[index][1];
                remain = remain - month*(cost[index+1][0]-cost[index][0]);
                // 다음 가격으로 정산 필요
                index++;
                answer += remain * cost[index][1];
            } else {
                answer += order[i][1] * cost[index][1];
                month = month - remain/(cost[index+1][0]-cost[index][0]);
                index = 0;
                remain = 0;
            }
        }

        return answer;
    }
}
