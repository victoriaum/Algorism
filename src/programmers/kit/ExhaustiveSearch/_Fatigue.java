package programmers.kit.ExhaustiveSearch;

import java.util.*;

// 완전검색 - 피로도
// DFS 풀이가 더 적합하므로 일단 패스
public class _Fatigue {
    public static void main(String[] args) {
        // "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다.
        // 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.
        // 최대로 돌 수 있는 던전의 수?
        // 단, 각 던전은 한 번씩 가능, "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.

        int[][] dungeons = new int[][]{{80,20}, {50,40}, {30,10}};
        System.out.println(solution(80,dungeons));    // 3
    }

    private static int solution(int k, int[][] dungeons) {
        int answer = 0;
        Arrays.sort(dungeons, Comparator.comparingInt((int[] o) -> o[0]).reversed());
        for(int[] arr: dungeons){
            if(arr[0]<=k){
                k = k-arr[1];
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}