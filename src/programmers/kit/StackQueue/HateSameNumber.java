package programmers.kit.StackQueue;

import java.util.*;

// 스택/큐 - 같은 숫자는 싫어
public class HateSameNumber {
    public static void main(String[] args) {
        // 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

        int[] arr = {1,1,3,3,0,1,1};
        //int[] arr = {4,4,4,3,3};

        System.out.println(solution(arr));  // 통과
        System.out.println(trial(arr));  // 정확성 통과, 효율성 시간초과
    }

    private static List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(list.size()==0) list.add(arr[i]);
            else{
                if(list.get(list.size()-1)!=arr[i]){ list.add(arr[i]); }
            }
        }
        return list;
    }

    private static int[] trial(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i: arr){
            if(stack.size()==0) stack.push(i);
            else{
                if(stack.peek()!=i) stack.push(i);
            }
        }

        int[] answer = new int[stack.size()];
        for(int i=0; i<stack.size(); i++){
            answer[i]=(int)stack.toArray()[i];
        }

        return answer;
    }
}
