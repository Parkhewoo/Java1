package ai0604.inheritance;

public class MountainRabbit extends Rabbit{
    String mountain;

    public void eatGrass(String grassType){
        System.out.println(mountain +" 산토끼가 " + grassType + "풀을 먹는다.");
    }
}
