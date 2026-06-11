package ai0611.lab;

public class Car {
    // 상속관계에 있는 subClass(자식클래스)만 접근이 가능하다
    protected int speed;

    public void upSpeed(int speed){
        this.speed += speed;
    }

    public int getSpeed(){
        return speed;
    }
}
