package ai0423;

import java.util.Calendar;
import java.util.Scanner;

public class LAB_EnteranceStatus {
    public static void main(String[] args) {
        System.out.println("========PC방 출입 가능 상태 확인 프로그램 ===================");
        Scanner s = new Scanner(System.in);
        System.out.print("*출생년도 입력: ");
        int birthYear = s.nextInt();

        //나이 계산
        Calendar calendar = Calendar.getInstance();
        int age = calendar.get(Calendar.YEAR) - birthYear;
        String result = "";

        if(age >= 19)
            result="가능";
        else
            result="불가능";
        System.out.println("당신의 나이는 만" + age + "살이므로 오후 10시 이후 PC방 사용이 " + result + " 합니다");

        s.close();
    }
}
