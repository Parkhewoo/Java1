package ai0409;

import java.util.Scanner;

public class Credit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("===과목 성적 평균 ===");
        System.out.println("* 성적 입력값은 0~4.5이하의 값을 입력하세요.");
        System.out.print("프로그래밍언어실습(3)입력:");
        double score1 = s.nextDouble();
        System.out.print("웹프로그래밍기초(3) 입력:");
        double score2 = s.nextDouble();
        System.out.print("프롬프트엔지니어링(2) 입력:");
        double score3 = s.nextDouble();
        double avg = (score1 * 3 + score2 *3 + score3 * 2) / (3 + 3 + 2);

        System.out.printf("3과목 평균: %.2f\n", avg);

        s.close();
    }
}
