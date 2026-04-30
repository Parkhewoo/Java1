package ai0430;

import java.util.Scanner;

public class LAB_SetLine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("학생의 수 입력 : ");
        int fact = 1;
        int friends_num = s.nextInt();

        for (int i = 1; i <= friends_num; i++) {
            fact = fact * i;
        }
        System.out.println("학생들을 순서대로 세우는 경우의 수 : " + fact);
        s.close();
    }
}
