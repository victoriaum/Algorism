package programmers.kit.Hash;

import java.util.*;
import java.util.stream.*;

// 해시 - 폰켓몬
public class Phoneketmon {
    public static void main(String[] args) {
        // 주어진 짝수개의 nums에서 절반을 뽑았을 때의 종류의 최대값
        // 3,1,2,3인 경우 2개를 뽑아서 가장 많은 종류가 나온 경우의 종류의 수는 2이다.

        int[] nums = {3,1,2,3};
        //int[] nums = {3,3,3,2,2,4};

        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int cnt = nums.length/2;
        if(cnt>=set.size()){answer = set.size(); }
        else{answer = cnt; }

        return answer;
    }
}
