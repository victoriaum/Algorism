package programmers.kit.ExhaustiveSearch;

import java.util.*;

// 완전검색 - 소수 찾기
public class _FindDecimals {
    public static void main(String[] args) {
        //각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

        System.out.println(solution("17"));  // 3
        System.out.println(solution("011")); // 2
    }

    private static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<Integer>();
        permutation("", numbers, set);

        Iterator<Integer> it = set.iterator();
        int count=0;
        while(it.hasNext()) {
            int a = it.next();
            if(isPrime(a))
                count++;
        }
        return count;
    }

    private static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }

    }

    private static boolean isPrime(Integer a) {
        if(a==0 || a==1) {
            return false;
        }
        else {
            for(int i=2;i<=Math.sqrt(a);i++)
                if(a%i==0)   return false;
        }
        return true;
    }




    // 가능한 모든 수의 조합을 구하는 방법?
    private static int trial(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            if(isDecimal(arr[i])) answer++;
        }

        return answer;
    }

    private static boolean isDecimal(int num) {
        boolean b = true;
        if(num==1) return false;
        for(int i=0; i<10; i++){
            if(num>i && num%i==0){
                b=false;
            }
        }
        return b;
    }

}