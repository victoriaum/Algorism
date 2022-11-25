package programmers.kit.Hash;

import java.util.*;
import java.util.stream.*;

// 해시 - 위장
public class Disguise {
    public static void main(String[] args) {
        // 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        //String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes));     // 통과, Collection 답안참조
        //System.out.println(trial(clothes));      // 완성하지 못함
    }

    private static int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> total = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            total.put(clothes[i][1],total.getOrDefault(clothes[i][1],1)+1);
        }
        Collection<Integer> test = total.values();
        answer = test.stream().reduce(1, (a, b) -> a*b) - 1;    // reduce 초기값이 0이므로 1로 설정
        return answer;
    }

    private static int trial(String[][] clothes) {
        int answer = 0;

        List<String> typeList = new ArrayList<>();
        List<Integer> cntList = new ArrayList<>();

        // 종류 파악하기
        for(int i=0; i<clothes.length; i++){
            typeList.add(clothes[i][0]);
        }
        Set<String> set_type = new HashSet<>(typeList);

        // 같은 이름을 가진 의상은 존재하지 않습니다. -> 세부종류의 중복은 고려대상이 아니다.
        // 종류별 세부종류 수 파악하기
        for(String str : set_type){
            int cnt = 0;
            for(int i=0; i<clothes.length; i++){
                if(str.equals(clothes[i][1])){
                    cnt++;
                };
            }
            cntList.add(cnt);
        }

        // 조합의 경우 구하기
        for(int i=1; i<set_type.size(); i++){

        }

        return answer;
    }
}
