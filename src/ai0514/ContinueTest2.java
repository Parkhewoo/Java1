package ai0514;

public class ContinueTest2 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i < 101; i++) {

            if(i % 2 != 0)
                continue;
            sum += i;
        }
        System.out.println("1~100까지의 (짝수의 합계): " + sum);
    }
}
