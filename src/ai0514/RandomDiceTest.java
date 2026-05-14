package ai0514;

import java.util.Random;

public class RandomDiceTest {
    public static void main(String[] args) {
        Random r = new Random();

        int count = 0;
        while(true){
          int  dice1 = r.nextInt(6) + 1;
          int  dice2 = r.nextInt(6) + 1;
          int  dice3 = r.nextInt(6) + 1;
          count++;
            if(dice1 == dice2 && dice2 == dice3){
                System.out.println("3개의 주사위는 모두 " + dice1+ "입니다.");
                System.out.println("총 같은 횟수가 나오게끔 돌린 횟수는 "+ count + "회 입니다");
                break;
            }

        }

    }
}
