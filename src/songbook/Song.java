package songbook;

public class Song implements ISong {
    private String title;
    private String artist;


    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }

    // [인터페이스 메서드 구현]
    @Override
    public void showInfo() {
        System.out.println("[곡] " + title + " - " + artist);
    }
}
