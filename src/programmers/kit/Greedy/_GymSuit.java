package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 체육복
public class _GymSuit {
    public static void main(String[] args) {
        // 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
        // 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
        // (단서 조건 유의하기)
        // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
        // 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
        // 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다. -> 내가 여벌 옷을 가지고 왔어도 내가 입을 수는 없다.


        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));     // 정답: 5
        System.out.println(solution(3, new int[]{3}, new int[]{1}));           // 정답: 2
        System.out.println(solution(3, new int[]{1,2}, new int[]{2,3}));       // 정답: 2
        System.out.println(solution(7, new int[]{1,2}, new int[]{7}));         // 정답: 5
        System.out.println(solution(6, new int[]{4,2}, new int[]{3,5}));       // 정답: 6
        System.out.println(solution(3, new int[]{1,2}, new int[]{2,3}));       // 정답: 2
        System.out.println(solution(7, new int[]{2,4,7}, new int[]{1,3,5}));   // 정답: 6
        System.out.println(solution(7, new int[]{2,4}, new int[]{2,4}));       // 정답: 7
        System.out.println(trial4(8, new int[] { 2, 4, 5, 7 }, new int[] { 1, 3, 6, 8 }));       // 정답: 8
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i < lost.length; i++) {
            for(int j=0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }
        for (int i=0; i < lost.length; i++) {
            for (int j=0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1) {
                    count++;
                    reserve[j] = -1;
                    break;

                }
            }
        }
        return n - lost.length + count;
    }

    // 3,5,7,8 테스트케이스 실패
    private static int trial4(int n, int[] lost, int[] reserve) {
        List<Integer> list_lost = new ArrayList<>();
        List<Integer> list_reserve = new ArrayList<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i: lost){
            list_lost.add(i);
        }
        for(int i: reserve){
            if(list_lost.contains(i)){
                list_lost.remove(list_lost.indexOf(i));
            }else{
                list_reserve.add(i);
            }
        }

        int i;
        boolean b = true;
        while(b){
            if(!list_lost.isEmpty() && !list_reserve.isEmpty()){
                i = list_reserve.get(0);
                if(list_lost.contains(i-1)){
                    list_lost.remove(list_lost.indexOf(i-1));
                    list_reserve.remove(list_reserve.indexOf(i));
                }else if(list_lost.contains(i+1)){
                    list_lost.remove(list_lost.indexOf(i+1));
                    list_reserve.remove(list_reserve.indexOf(i));
                }else{
                    b=false;
                }
            }else{
                b=false;
            }
        }

        int answer = n - list_lost.size();
        if(answer>n) answer = n;
        return answer;
    }

    private static int trial3(int n, int[] lost, int[] reserve) {
        List<Integer> list_lost = new ArrayList<>();
        List<Integer> list_reserve = new ArrayList<>();

        for(int i: lost){
            list_lost.add(i);
        }
        for(int i: reserve){
            list_reserve.add(i);
        }

        for(int i: reserve){
            if(list_lost.contains(i-1)){
                list_lost.remove(list_lost.indexOf(i-1));
                list_reserve.remove(list_reserve.indexOf(i));
            }else if(list_lost.contains(i+1)){
                list_lost.remove(list_lost.indexOf(i+1));
                list_reserve.remove(list_reserve.indexOf(i));
            }else{
                list_reserve.remove(list_reserve.indexOf(i));
            }
        }

        int answer = n - list_lost.size() + list_reserve.size();
        if(answer>n) answer = n;
        return answer;
    }

    private static int trial2(int n, int[] lost, int[] reserve) {
        List<Integer> list_lost = new ArrayList<>();
        List<Integer> list_reserve = new ArrayList<>();

        for(int i: lost){
            list_lost.add(i);
        }
        for(int i: reserve){
            list_reserve.add(i);
        }

        for(int i: lost){
            if(list_reserve.contains(i)){
                list_lost.remove(list_lost.indexOf(i));
                list_reserve.remove(list_reserve.indexOf(i));
            }
        }

        int answer = n - list_lost.size() + list_reserve.size();
        if(answer>n) answer = n;
        return answer;
    }

    private static int trial(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length + reserve.length;
        if(answer>n) answer = n;
        return answer;
    }
}
