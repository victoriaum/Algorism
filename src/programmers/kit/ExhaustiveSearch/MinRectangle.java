package programmers.kit.ExhaustiveSearch;

import java.util.*;

// 완전검색 - 최소직사각형
public class MinRectangle {
    public static void main(String[] args) {
        // 명함의 가로 길이와 세로 길이를 나타냅니다.
        // 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.

        //int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};            // 4000
        //int[][] sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};     // 120
        int[][] sizes = new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};   // 133

        System.out.println(solution(sizes));
    }

    // 작은 수 중에 큰 수, 큰 수 중에 큰 수의 곱
    private static int solution(int[][] sizes) {
        int min=0, max=0, min_compare=0, max_compare=0;

        for(int[] i: sizes){
            min_compare = i[0]>i[1]? i[1] : i[0];
            max_compare = i[0]>i[1]? i[0] : i[1];
            if(min==0 || min<min_compare) min = min_compare;
            if(max==0 || max<max_compare) max = max_compare;
        }

        return min*max;
    }
}