package ai0922;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LAB_SecureTest1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            FileWriter fw = new FileWriter("secure.txt");

            while (true) {
                System.out.print("암호화할 문자열 입력(종료: exit) : ");
                String inStr = sc.nextLine();

                if (inStr.equals("exit")) {
                    break;
                }

                String secure = "";

                for (int i = 0; i < inStr.length(); i++) {
                    secure += (char)(inStr.charAt(i) + 100);
                }

                fw.write(secure + "\n");
            }

            fw.close();
            System.out.println("암호화가 완료되었습니다.");

        } catch (IOException e) {
           throw new RuntimeException();
        }

        sc.close();
    }
}