package ai0326;

import java.util.Scanner;

public class LAB1 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        System.out.println("## 택배 보내기입니다. 다음을 각각 입력하세요 ##");

        System.out.print("받는 사람 : ");
        String name = s1.nextLine();

        System.out.print("주소 : ");
        String address = s1.nextLine();

        System.out.print("무게(g) : ");
        String g = s2.nextLine();
        int parseG = Integer.parseInt(g);
        int money = parseG * 5;

        System.out.printf("** 받는 사람 ==> %s\n", name);
        System.out.printf("** 주소 ==> %s\n", address);
        System.out.printf("** 배송비 ==> %d원", money);

    }
}
