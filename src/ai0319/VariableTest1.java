package ai0319;

public class VariableTest1 {
    public static void main(String[] args) {
        int num1 = 100;
        int num2 = 200;
        int result = num1 + num2;

        System.out.println(result + "\n");
        System.out.printf("%d + %d = %d\n", num1, num2, result);
        System.out.print("print()메소드는 줄바꿈을 하지 않는다\n\n");
        System.out.print("print()메소드는 줄바꿈을 하지 않는다");

        System.out.println();

        int a = 100;
        System.out.printf("int a = %d이다", a);
    }
}
