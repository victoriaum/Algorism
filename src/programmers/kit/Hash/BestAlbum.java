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

        System.out.println(solution(genres, plays));   // 성공, 차리리 변수를 더 쓰더라도 반복문을 줄이자..
        System.out.println(trial(genres, plays));      // 정확성 실패(런타임 에러)
    }

    // 다른 사람 풀이 참조
    private static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 개수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
        for(int i = 0; i < plays.length; i++) {
            if(!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1)));

        for(String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());

            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));

            answer.add(genre_key.get(0));
            if(genre_key.size() > 1)
                answer.add(genre_key.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static List<Integer> trial(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> total = new HashMap<>();

        Set<String> set = Arrays.stream(genres).collect(Collectors.toSet());
        for(int i=0; i<genres.length; i++){
            total.put(genres[i], total.getOrDefault(plays[i],0)+plays[i]);
            if(i==set.size()){ break; }
        }

        List<String> total_genres = new ArrayList<>();
        for(String genre : set){
            if(total_genres.size()!=0 && total.get(total_genres.get(0)) < total.get(genre)){
                total_genres.add(0, genre);
            }else{
                total_genres.add(genre);
            }
        }

        List<Integer> temp;
        int cnt;
        Map<Integer, Integer> tempMap = new HashMap<>();

        for(int i=0; i<total_genres.size(); i++){
            temp = new ArrayList<>();
            cnt = 0;
            for(int j=0; j<plays.length; j++){
                if(total_genres.get(i).equals(genres[j])) {
                    temp.add(plays[j]);
                    cnt++;
                    if (tempMap.get(plays[j]) == null) tempMap.put(plays[j], j);
                }
            }
            Collections.sort(temp, Collections.reverseOrder());
            answer.add(tempMap.get(temp.get(0)));
            answer.add(tempMap.get(temp.get(1)));
        }

        return answer;
    }
}
