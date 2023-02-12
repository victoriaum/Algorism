package programmers.test;

import java.util.*;

public class Lotto {
    public static void main(String[] args) {
        // 구매한 사람 수에는 아직 내가 없고,
        // 당첨가능 수량보다 구매자 수가 적을 경우 당첨확률은 무조건 100이 된다.

        //System.out.println(solution(new int[][]{{100,100,500}, {1000,1000,100}}));    //2
        //System.out.println(solution(new int[][]{{10,19,800}, {20,39,200}, {100,199,500}})); //1
        System.out.println(solution(new int[][]{{50,1,50}, {100,199,100}, {1,1,500}})); //1
    }

    // 합계: 100.0 / 100.0
    private static int solution(int[][] lotteries) {
        int answer=0, money=0;
        List<Double> percentage = new ArrayList<>();
        List<Double> sorted_percentage = new ArrayList<>();

        for(int[] lotto:lotteries){
            if(lotto[0]>=lotto[1]+1){
                percentage.add(100.0);
                sorted_percentage.add(100.0);
            }else{
                percentage.add(100.0*lotto[0]/(lotto[1]+1));
                sorted_percentage.add(100.0*lotto[0]/(lotto[1]+1));
            }
        }
        sorted_percentage.sort(Comparator.reverseOrder());

        Double maxPercentage = sorted_percentage.get(0);
        for(int i=0; i<percentage.size(); i++){
            if(maxPercentage.equals(percentage.get(i))){
                if(money<lotteries[i][2]){
                    money = lotteries[i][2];
                    answer = i+1;
                }
            }
        }
        return answer;
    }

    // 합계: 78.6 / 100.0
    /*private static int solution(int[][] lotteries) {
        int answer=0, money=0;
        List<Double> percentage = new ArrayList<>();
        List<Double> sorted_percentage = new ArrayList<>();

        for(int[] lotto:lotteries){
            percentage.add(100.0*lotto[0]/(lotto[1]+1));
            sorted_percentage.add(100.0*lotto[0]/(lotto[1]+1));
        }
        sorted_percentage.sort(Comparator.reverseOrder());

        Double maxPercentage = sorted_percentage.get(0);
        for(int i=0; i<percentage.size(); i++){
            if(maxPercentage.equals(percentage.get(i))){
                if(money<lotteries[i][2]){
                    money = lotteries[i][2];
                    answer = i+1;
                }
            }
        }
        return answer;
    }*/
}