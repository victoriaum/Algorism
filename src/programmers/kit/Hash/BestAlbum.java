package programmers.kit.Hash;

import java.util.*;
import java.util.stream.*;

// 해시 - 베스트앨범
public class BestAlbum {
    public static void main(String[] args) {
        // 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
        // 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
        // 장르별 2개씩, 없으면 1개만

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }

    private static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Set<String> set = Arrays.stream(genres).collect(Collectors.toSet());
        Map<String, Integer> total = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            total.put(genres[i], total.getOrDefault(plays[i],0)+plays[i]);
            if(i==set.size()){ break; }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(total.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedTotal = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedTotal.put(entry.getKey(), entry.getValue());
        }





        return answer;
    }
}
