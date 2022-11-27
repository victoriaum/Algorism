package programmers.kit.Hash;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// 해시 - 전화번호 목록
public class PhoneNumberList {
    public static void main(String[] args) {
        // 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
        // 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

        //String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"119", "114", "112", "123223123", "1231231234"};

        //System.out.println(phone_book==phone_book);
        //System.out.println(Arrays.toString(phone_book));

        System.out.println(solution(phone_book));    // 통과
        //System.out.println(trial4(phone_book));    // 테스트 13 > 실패 (0.18ms, 73.8MB), 효율성 통과
        //System.out.println(trial3(phone_book));    // 테스트 13 > 실패 (0.18ms, 73.8MB), 효율성 통과
        //System.out.println(trial2(phone_book));    // 정확성 실패, 효율성 시간초과
        //System.out.println(trial(phone_book));     // 정확성 통과, 효율성 런타임에러

    }

    // 출력물이 너무 많은 경우, 효율성테스트 실패가 될 수 있음에 유의
    private static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){
            if (phone_book[i+1].indexOf(phone_book[i])==0) { answer = false; break; }
        }

        return answer;
    }

    private static boolean trial4(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));

        for(int i=0; i<phone_book.length-1; i++){
            System.out.println(phone_book[i+1].indexOf(phone_book[i]));
            if (phone_book[i+1].indexOf(phone_book[i])!=-1) { answer = false; break; }  // 비교대상 변경
        }

        return answer;
    }

    private static boolean trial3(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){
            String str = phone_book[i+1].replace(phone_book[i], "");
            if (!str.equals(phone_book[i+1])) { answer = false; break; }
        }

        return answer;
    }

    private static boolean trial2(String[] phone_book) {
        boolean answer = true;

        for(int i=0; i<phone_book.length; i++){
            String check  = phone_book[i];
            phone_book[i] = "";
            String str = Arrays.toString(phone_book);
            String new_str = str.replace(check, "");
            if (!str.equals(new_str)) { answer = false; break;}
        }

        return answer;
    }

    private static boolean trial(String[] phone_book) {
        boolean answer = true;

        out:
        for(int i=0; i< phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                int cnt = 0;
                if(phone_book[i].length()==phone_book[j].length()){
                    if(phone_book[i].equals(phone_book[j])){
                        cnt++;
                        if(cnt>0){ answer = false; break out; }
                    }
                }else{
                    if(phone_book[i].equals(phone_book[j].substring(0,phone_book[i].length()))){
                        cnt++;
                        if(cnt>0){ answer = false; break out; }
                    }
                }
            }
        }

        Arrays.sort(phone_book);
        for(String str : phone_book){

        }

        return answer;
    }
}
