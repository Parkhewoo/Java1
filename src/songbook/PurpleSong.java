package songbook;

// [상속] Song 클래스의 특징을 그대로 물려받음
public class PurpleSong extends Song {

    public PurpleSong(String title, String artist) {
        super(title, artist); // 부모 생성자 호출
    }

    // [오버라이딩] 부모의 showInfo를 퍼플 테마에 맞게 재정의
    @Override
    public void showInfo() {
        System.out.println(" [추천 노래] " + getTitle() + " - " + getArtist());
    }
}