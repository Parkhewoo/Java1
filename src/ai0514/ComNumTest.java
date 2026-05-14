package ai0514;

import java.util.Random;
import java.util.Scanner;

public class ComNumTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();


        int count = 1;
        while(true){
            int comNum = r.nextInt(5)+1;
            System.out.print("게임 " + count + "회: 컴퓨터가 생각한 숫자는 무엇일까요? ");
            int humNum = s.nextInt();
            count++;
            if(comNum == humNum) {
                System.out.println("축하합니다. 맞히셨어요");
                break;
            }
            else
                System.out.println("아까워요 "+comNum + "이었는데, 다시 도전해보세요");
        }
        System.out.println("게임을 마칩니다");
        s.close();
    }
}
