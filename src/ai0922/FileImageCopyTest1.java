package ai0922;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//이미지파일과 같은 이진파일은 1byte씩 읽어서 1byte씩 출력해야한다
public class FileImageCopyTest1 {
    public static void main(String[] args) {
        try {
        FileInputStream fIn = new FileInputStream("moon.jpg");
            FileOutputStream fOut = new FileOutputStream("moonCopy.jpg");

            int data;
            while ((data = fIn.read()) != -1){
                fOut.write((byte) data);
            }
            System.out.println("이미지 복사완료");
            fIn.close();
            fOut.close();
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }
}
