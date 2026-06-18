package ai0618;

public class MRL implements Car, Cannon{
    @Override
    public void fire() {
        System.out.println("포탄을 발사한다");
    }

    @Override
    public void move() {
        System.out.println("k239가 이동한다.");
    }
}
