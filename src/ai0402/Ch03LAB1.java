package ai0402;

import java.util.Scanner;

public class Ch03LAB1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double lb = 0.453592;
        double kg = 2.20462;
        double result = 0;

        System.out.print("파운드(lb)를 입력하세요: ");
        int input1 = s.nextInt();
        result = input1 * lb;
        System.out.printf("%.1f파운드(lb)는 %.3f킬로그램(kg)입니다.\n", (double) input1, result);

        System.out.print("킬로그램(kg)을 입력하세요: ");
        int input2 = s.nextInt();
        result = input2 * kg;
        System.out.printf("%.1f킬로그램(kg)은 %.3f파운드(lb)입니다.\n", (double) input2, result);

        s.close();
    }
}
