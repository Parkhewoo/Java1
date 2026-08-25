package ai0825;

import java.util.Random;

public class LABRandomWiseSaying {
    public static void main(String[] args) {
        String[] wiseSay = {"삶이 있는 한 희망은 있다. — 키케로",
                "인생은 속도가 아니라 방향이다. — 괴테",
                "피할 수 없으면 즐겨라. — 로버트 엘리엇",
                "인생은 자전거를 타는 것과 같다. 균형을 잡으려면 움직여야 한다. — 알베르트 아인슈타인",
                "서두르지 말자, 그러나 쉬지도 말자. — 괴테",
                "절대 포기하지 말라. 포기하는 그 순간이 붕괴되는 순간이다. — 윈스턴 처칠",
                "큰 목표를 이루고 싶으면 허락을 구하지 마라. — 미상",
                "내 가 오르는 길이 아무리 험난할지라도 이 길이 내 길임을 믿고 나아가라. — 미상",
                "천재란 자신에게 주어진 일을 하는 재능 있는 사람일 뿐이다. — 랄프 왈도 에머슨",
                "오늘 할 수 있는 일을 내일로 미루지 마라. — 벤자민 프랭클린"};

        Random random = new Random();
        int randomIndex = random.nextInt(wiseSay.length);
        System.out.println("오늘의 명언: " + wiseSay[randomIndex]);
    }
}
