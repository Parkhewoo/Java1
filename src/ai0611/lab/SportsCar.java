package ai0611.lab;

public class SportsCar extends Car{
    @Override
    public void upSpeed(int speed) {
        super.upSpeed(speed);
        if(this.speed >= 378){
            this.speed = 378;
        }
    }
}
