package programmers.kit.ExhaustiveSearch;

import java.util.*;

// 완전검색 - 전력망을 둘로 나누기
public class DivicePowerGrid {
    public static void main(String[] args) {
        // 전력망을 나눠 나눈 전력망 양쪽의 송전탑의 수 차이가 가장 적도록 한다.
        // 나뉜 전력망의 각각의 송전탑 수의 차이를 출력하는 문제

        // 3
        int n = 9;
        int[][] wires = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n,wires));
    }

    private static int solution(int n, int[][] wires) {
        int min = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] arr: wires){
            list.add(arr[0]);
            list.add(arr[1]);
        }

        for(int i: list){
            if(map.get(i)!=null){ map.put(i, map.get(i)+1); }
            else{ map.put(i, 1); }
        }

        Object[] arr = map.values().toArray();
        Arrays.sort(arr);


        return min;
    }
}