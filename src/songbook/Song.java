package songbook;

public class Song implements ISong {
    private String title;  // [접근제한] 외부 직접 접근 차단
    private String artist;

    // [생성자] 기초적인 필드 초기화
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    // [인터페이스 메서드 구현]
    @Override
    public void showInfo() {
        System.out.println("[노래] " + title + " - " + artist);
    }
}
