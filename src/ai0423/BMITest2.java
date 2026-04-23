package ai0423;

import java.util.Scanner;

public class BMITest2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);//문자열 입력용

        System.out.print("* 몸무게 입력 (실수값 입력): ");
        double weight = s.nextDouble();

        System.out.print("* 키 입력 (실수값 입력): ");
        double height = s.nextDouble();

        System.out.print("* 성명 입력 : ");
        String name = s1.nextLine();

        double bmi = weight /Math.pow(height/100, 2);
        String result1, result2;

        if(bmi < 18.5){
            result1 = "저";
            result2 = "식단과 운동을 통해 체중을 증량시켜야 합니다. 생명이 위험할 수도 있습니다";
        }
        else if(bmi < 22.9){
            result1 = "정상";
            result2 = "현재 체중을 유지하시길 바랍니다";
        }
        else if(bmi < 24.9){
            result1 = "과";
            result2 = "식단과 운동을 통해 체중을 감량시켜야합니다";
        }
        else if(bmi < 29.9){
            result1 = "비만";
            result2 = "식단과 운동을 통해 체중을 감량시켜야합니다. 성인병을 유발할 수 있습니다";
        }
        else{
            result1 = "고도비만";
            result2 = "전문가의 도움을 받다 식단과 운동을 통해 체중을 감량시켜야합니다. 고혈압, 고지혈증, 당뇨변이 발생될 수 있습니다.";
        }

        System.out.printf("이름: %s, BMI: %.2f, 판정: %s\n설명: %s", name, bmi, result1, result2);

    s.close();
    }
}
