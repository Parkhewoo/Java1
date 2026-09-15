package ai0915;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest2 {
    public static void main(String[] args) {
        try {
//        BufferedReader br = new BufferedReader(new FileReader("D:/FileIOTest/myData1.txt"));
            BufferedReader br = new BufferedReader(new FileReader("myData1.txt"));
            String line = "";
        while (true){
            line = br.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
