package ai0402;

import java.util.Scanner;

public class DriverLicenseTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("시험점수를 입력하세요: ");
        int score = s.nextInt();
        String result = "";//empty String

        if(score >= 70){
            result="합격";

        }
        else {
            result="불합격";

        }
        System.out.printf("%d점이므로 %s입니다", score, result);
        s.close();
    }
}
