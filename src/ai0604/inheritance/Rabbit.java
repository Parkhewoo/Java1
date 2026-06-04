package ai0604.inheritance;

public class Rabbit {
    //  super 클래스의 필드 또는 메소드 옆에 private를 붙이면 sub클래스에서 사용이 제한된다
     String shape;
     int xPos;
     int yPos;

    //JVM은 클래스 내에 생성자가 하나도 없는 경우 기본생성자를 만들어서 사용한다
    //그러나 클래스 내에 생성자가 선언되어있다면 선언된 생성자만 사용할 수 있다
    public Rabbit() {
    }

    public Rabbit(String shape) {
        this.shape = shape;
    }


    //토끼의 좌표값을 설정하는 메소드 구현
    public void setLocation(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    //토끼의 모양, 위치 출력 메소드
    public void printInfo(){
        System.out.printf("%s 모양의 토끼는 (%d, %d) 좌표에 위치하고 있다\n", shape,xPos, yPos);
    }

    // x축으로 10씩 오른쪽으로 이동하는 메소드
    public void moveRightTen(){
        xPos += 10;
    }
    //x축으로 10씩 왼쪽으로 이동하는 메소드
    public void moveLeftTen(){
       xPos -= 10;
    }
}