package ai0514;

public class GuGuDan02 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d X %d = %d\t", j, i, i * j);
            }
            System.out.println();
        }
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d X %d = %d\n", i, j, i * j);
            }
        }
    }
}
