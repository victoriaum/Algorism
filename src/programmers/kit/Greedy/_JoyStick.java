package programmers.kit.Greedy;

// 그리디 - 조이스틱
public class _JoyStick {
    public static void main(String[] args) {
        // *** 문제 변경됨 -> 시작위치가 첫번째가 아닐 수 있고, 그리디 문제가 아닙니다.. DFS
        // 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
        // ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
        // 조이스틱은 아래 위로 움직일 수 있고 더 가까운 값을 선택해야 한다.
        // 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
        // 아스키코드표 65 ~ 90

        System.out.println(solution("JEROEN"));     // 56
        System.out.println(solution("JAN"));        // 23
    }

    // https://velog.io/@jeeseob5761/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1
    // 풀이 참조
    private static int solution(String name) {
        int answer = 0;
        int length = name.length();
        int index;
        int move = length - 1;

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }

    private static int trial(String name) {
        int answer = 0, value = 0, value2 = 0;
        char[] array = name.toCharArray();

        for(char c : array){
            value = (int)c-65;
            value2 = 90-(int)c;
            if(value>value2) answer += value2+1;
            else answer += value+1;
        }

        return answer-1;
    }
}