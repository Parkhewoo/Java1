package ai0514;

import java.util.Scanner;

public class WhileTest02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum;
        int num1, num2;

        while (true){
            System.out.print("첫번째 정수 입력: ");
            num1 = s.nextInt();
            if(num1 == -1)
                break;
            System.out.print("두번째 정수 입력: ");
            num2 = s.nextInt();

            sum = num1 + num2;
            System.out.printf("%d + %d = %d", num1, num2 , sum);


        }
        s.close();
    }
}
