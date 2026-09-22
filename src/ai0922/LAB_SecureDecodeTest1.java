package ai0922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LAB_SecureDecodeTest1 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("secure.txt"));
            FileWriter fw = new FileWriter("decode.txt");

            String str;

            while ((str = br.readLine()) != null) {

                String decode = "";

                for (int i = 0; i < str.length(); i++) {
                    int num = (int) str.charAt(i);
                    num -= 100;      // 해독
                    decode += (char) num;
                }

                fw.write(decode + "\n");
            }

            br.close();
            fw.close();

            System.out.println("암호 해독 완료되었습니다.");

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}