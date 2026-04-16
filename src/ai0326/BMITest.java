package ai0326;

import java.util.Scanner;

public class BMITest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요: ");
        String name = s1.nextLine();
        System.out.print("키를 입력하세요:");
        double height = s.nextDouble();
        System.out.print("몸무게를 입력하세요:");
        double weight = s.nextDouble();

        double bmi = weight / Math.pow(height/100, 2); //((height /100) *(height /100));

//        System.out.printf("당신의 bmi지수는 %.2f입니다", bmi);
        System.out.printf("* %s님의 BMI 지수 결과: %.2f kg/㎡", name ,bmi);

        s.close();
        s1.close();
    }
}
