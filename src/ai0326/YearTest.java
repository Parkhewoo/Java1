package ai0326;

import java.util.Calendar;
import java.util.Scanner;

public class YearTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("출생년도를 입력하세요:");

        //현재 년도 구하기
        Calendar calender = Calendar.getInstance();

        int nowYear = calender.get(Calendar.YEAR);

        int birthYear = s.nextInt();
        int age = nowYear - birthYear + 1;

        System.out.println("나이는 " + age + "살 입니다");
        s.close();
    }
}
