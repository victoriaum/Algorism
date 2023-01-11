package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 단속카메라
public class EnforcementCamera {
    public static void main(String[] args) {
        // 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
        // routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
        // 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.

        int[][] routes = new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};  // 2
        //int[][] routes = new int[][]{{0,0}};  // 1
        //int[][] routes = new int[][]{{-2,-1}, {1,2}, {-3,0}};  // 2


        /*print(solution([[-2,-1], [1,2],[-3,0]])) #2
        print(solution([[0,0],])) #1
        print(solution([[0,1], [0,1], [1,2]])) #1
        print(solution([[0,1], [2,3], [4,5], [6,7]])) #4
        print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]])) #2
        print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]])) #2
        print(solution([[-20,15], [-20,-15], [-14,-5], [-18,-13], [-5,-3]])) #2*/

        System.out.println(solution(routes));
    }

    // 다른 사람 풀이
    private static int others(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }

    private static int solution(int[][] routes) {
        int answer = 0, out = 0;
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));

        if(routes.length==1){ return 1; }

        for(int i=0; i<routes.length; i++){
            out = routes[i][1];
            if(i==routes.length-1){
                answer++;
                break;
            }
            for(int j=i+1; j<routes.length; j++){
                if(routes[j][0]>out){
                    answer++;
                    break;
                }else{
                    i++;
                    if(i==routes.length-1){
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    // 합계: 90.0 / 100.0
    private static int trial(int[][] routes) {
        int answer = 0, out = 0;
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));

        for(int i=0; i<routes.length; i++){
            out = routes[i][1];
            for(int j=i+1; j<routes.length; j++){
                if(routes[j][0]>out){
                    answer++;
                    break;
                }else{
                    if(j==routes.length-1) answer++;
                    else i++;
                }
            }
        }

        return answer;
    }
}