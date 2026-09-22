package ai0922;

import java.io.*;

public class FileCopyTest1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("myData2.txt"));
            FileWriter fw = new FileWriter("newFile.txt");
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
                fw.write(line);
                fw.write("\n");
            }
            System.out.println("myData2.txt file이 newFile.txt로 복사됨");
            br.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}