package Backjoon.dfs_bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 거침없이 추천 시리즈 DFS/BFS
public class dfs_bfs {
    // 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    // 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
    // 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

        /*
            예제1

            4 5 1
            1 2
            1 3
            1 4
            2 4
            3 4

            출력
            1 2 4 3
            1 2 3 4
        */

        /*
            예제2

            5 5 3
            5 4
            5 2
            1 2
            3 4
            3 1

            출력
            3 1 2 5 4
            3 1 4 2 5
        */

    /*
        예제3

        1000 1 1000
        999 1000

        출력
        1000 999
        1000 999
    */

    static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int[][] arr;
    private static int n, m, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());    // 노드 수
        m = Integer.parseInt(st.nextToken());    // 간선 수
        v = Integer.parseInt(st.nextToken());    // 시작 노드

        visited = new boolean[n+1];     // 방문여부 체크
        arr = new int[n+1][n+1];        // dfs_matrix

        for(int i=0; i<m; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs_matrix(v);
        sb.append("\n");
        //bfs(v);
    }

    public static void dfs_matrix(int start) {
        visited[start] = true;
        sb.append(start+" ");

        for(int i=1; i<=n; i++){
            if(!visited[start] && arr[start][i]==1){
                dfs_matrix(i);
            }
        }
    }
}