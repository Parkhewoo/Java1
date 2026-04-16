package ai0402;

import java.util.Scanner;

public class SimpleCalculatorTest01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("정수1 ==>");
        int num1 = s.nextInt();
        System.out.print("정수2 ==>");
        int num2 = s.nextInt();
        s.nextLine();

        System.out.print("계산방법은?");
        String input = s.nextLine();

        switch (input) {
            case "+" -> System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
            case "-" -> System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
            case "*" -> System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
            case "/" -> System.out.printf("%d ÷ %d = %f\n", num1, num2, (double) num1 / num2);
            case "%" -> System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);
        }
        s.close();
    }
}
