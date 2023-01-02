package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 구명보트
public class _LifeBoat {
    public static void main(String[] args) {
        // 사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
        // 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
        // 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));         // 3
        System.out.println(solution(new int[]{70, 80, 50}, 100));             // 3
        System.out.println(solution(new int[]{40, 50, 150, 160}, 200));       // 2
        System.out.println(solution(new int[]{100,500,500,900,950}, 1000));   // 3
    }

    // *** 효율적인 풀이
    private static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

    // 효율성 실패 시간초과
    private static int trial2(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<people.length; i++){
            list.add(people[i]);
        }
        Collections.sort(list);

        int sum = 0;
        while(list.size()!=0){
            if(sum<limit){
                sum += list.get(0);
                list.remove(0);
                if(list.size()!=0){
                    for(int i=list.size()-1; i>=0; i--){
                        if(sum+list.get(i)<=limit){
                            sum+=list.get(i);
                            list.remove(i);
                            break;
                        }else{ continue; }
                    }
                }
            }
            answer++;
            sum = 0;
        }

        return answer;
    }

    // 바로 뒤, 맨 뒤만 비교하지 말아야 하는 경우의 수가 발생
    private static int trial(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<people.length; i++){
            list.add(people[i]);
        }
        Collections.sort(list);

        int sum = 0;
        while(list.size()!=0){
            if(sum<limit){
                sum += list.get(0);
                list.remove(0);
                if(list.size()!=0 && sum+list.get(list.size()-1)<=limit){
                    sum+=list.get(list.size()-1);
                    list.remove(list.size()-1);
                }else if(list.size()!=0 && sum+list.get(0)<=limit){
                    sum+=list.get(0);
                    list.remove(0);
                }
            }
            answer++;
            sum = 0;
        }

        return answer;
    }
}