package ai0430;

public class ForTest2 {
    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {
            System.out.print(i + "\t");

            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
