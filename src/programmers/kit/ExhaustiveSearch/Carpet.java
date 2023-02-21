package programmers.kit.ExhaustiveSearch;

// 완전검색 - 카펫
public class Carpet {
    public static void main(String[] args) {
        // 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다

        System.out.println(solution(10,2));    // [4,3]
        System.out.println(solution(8,1));     // [3,3]
        System.out.println(solution(24,24));   // [8,6]
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int w = (brown + yellow) / 3;
        int h = 3;

        while(w >= h) {
            if(w*h == brown + yellow && 2*(w + h) == (brown + 4)) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
            h++;
            w = (brown + yellow) / h;
        }

        return answer;
    }

    // 합계: 30.8 / 100.0
    private static int[] trial(int brown, int yellow) {
        int[] answer = new int[2];

        // (x+y)*2=brown-4;
        // x*y=brown+yellow;

        int y = Integer.parseInt(String.valueOf(Math.round(Math.sqrt(brown/2+yellow+2))));
        int x = (brown+yellow)/y;
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}