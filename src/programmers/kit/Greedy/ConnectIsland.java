package programmers.kit.Greedy;

import java.util.*;

// 그리디 - 섬 연결하기
public class ConnectIsland {
    public static void main(String[] args) {
        // n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
        // 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
        // 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.

        //int n = 4;
        //int[][] costs = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        //4

        //int n = 7;
        //int[][] costs = new int[][]{{2, 3, 7}, {3, 6, 13}, {3, 5, 23}, {5, 6, 25}, {0, 1, 29}, {1, 5, 34}, {1, 2, 35}, {4, 5, 53}, {0, 4, 75}};
        //159

        int n = 5;
        int[][] costs = new int[][]{{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}};
        //6

        System.out.println(solution(n, costs));
    }

    // https://bangu4.tistory.com/223
    private static int solution(int n, int[][] costs)
    {
        int sum = 0;
        int[] island = new int[n];

        for(int i = 0; i < n; i++)
            island[i] = i;

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for(int i = 0; i < costs.length; i++)
        {
            if(find(island, costs[i][0]) != find(island, costs[i][1]))
            {
                unite(island, costs[i][0], costs[i][1]);
                sum += costs[i][2];
            }
        }

        return sum;
    }

    private static int find(int[] island, int x)
    {
        if(island[x]== x)
            return x;
        return find(island, island[x]);
    }

    private static void unite(int[] island, int x, int y)
    {
        int a = find(island, x);
        int b = find(island, y);
        island[a] = b;
    }








    // 정확성: 62.5
    // 테스트케이스 못 찾음
    private static int trial3(int n, int[][] costs) {
        int answer=0;
        boolean b1, b2;
        String saved = "";
        List<String> passed = new ArrayList<>();
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));

        for(int[] i: costs){
            b1 = saved.indexOf(String.valueOf(i[0]))!=-1;
            b2 = saved.indexOf(String.valueOf(i[1]))!=-1;

            if(!b1&&!b2){
                passed.add(String.valueOf(i[0])+i[1]);
                saved += String.valueOf(i[0])+i[1];
                answer+=i[2];
            }else{
                int index0=-1, index1=-1;
                for(int k=0; k<passed.size(); k++){
                    if(index0==-1 && passed.get(k).indexOf(String.valueOf(i[0]))!=-1) index0 = k;
                    if(index1==-1 && passed.get(k).indexOf(String.valueOf(i[1]))!=-1) index1 = k;
                }
                if(index0==-1 || index1==-1) {   // 둘 다 -1인 경우는 나올 수 없다.
                    int index = index0 == -1 ? index1 : index0;
                    String notSaved = index0 == -1 ? String.valueOf(i[0]) : String.valueOf(i[1]);
                    passed.set(index, passed.get(index)+notSaved);
                    saved += notSaved;
                    answer+=i[2];
                }else{
                    if(index0!=index1){
                        passed.set(index0, passed.get(index0)+passed.get(index1));
                        passed.remove(index1);
                        answer+=i[2];
                    }
                }
            }

        }
        return answer;
    }

    private static int trial2(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        List<String> passed = new ArrayList<>();
        for(int[] i: costs){
            boolean check = false;
            if(passed.size()==0){
                passed.add(String.valueOf(i[0])+i[1]);
                answer+=i[2];
            }else{
                boolean b1 = passed.get(0).indexOf(String.valueOf(i[0]))!=-1;
                boolean b2 = passed.get(0).indexOf(String.valueOf(i[1]))!=-1;

                if(b1&&b2) {
                    continue;
                }else if(!b1&&!b2){
                    passed.add(String.valueOf(i[0])+i[1]);
                    answer+=i[2];
                }else{
                    int notIn = b1==true? i[1] : i[0];
                    for(int j=1; j<passed.size(); j++){
                        if(passed.get(j).indexOf(String.valueOf(notIn))!=-1){
                            passed.set(0, passed.get(0)+passed.get(j));
                            passed.remove(j);
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        passed.set(0, passed.get(0)+notIn);
                    }
                    answer+=i[2];
                }
            }
        }
        return answer;
    }

    private static int trial(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        List<Integer> passed = new ArrayList<>();
        for(int[] i: costs){
            if(!passed.contains(i[0])||!passed.contains(i[1])){
                answer+=i[2];
                if(!passed.contains(i[0])) passed.add(i[0]);
                if(!passed.contains(i[1])) passed.add(i[1]);
            }
            if(passed.size()==n) break;
        }
        return answer;
    }
}