package ai0604.inheritance;

public class RunRabbit {
    public static void main(String[] args) {
        HouseRabbit hr1 = new HouseRabbit();
        MountainRabbit mr1 = new MountainRabbit();

        hr1.shape= "동그라미";
        hr1.setLocation(30, 50);
        hr1.moveRightTen();
        hr1.printInfo();
        hr1.masterName = "폴리";
        hr1.eatFeed("아주 좋은");

        mr1.shape = "네모";
        mr1.moveLeftTen();
        mr1.moveLeftTen();
        mr1.printInfo();
        mr1.mountain = "남산";
        mr1.eatGrass("토끼");

    }
}
