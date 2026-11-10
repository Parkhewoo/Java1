package songbook;


public class PeopleSong extends Song {

    public PeopleSong(String title, String artist) {
        super(title, artist); // 부모 생성자 호출
    }


    @Override
    public void showInfo() {
        System.out.println(" [추천곡] " + getTitle() + " - " + getArtist());
    }
}