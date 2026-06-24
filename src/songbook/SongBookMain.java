package songbook;

import java.util.Scanner;

public class SongBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [다형성 & 1차원 배열] 부모 타입의 배열에 자식 객체들을 함께 저장
        Song[] list = new Song[5];
        int count = 0;

        System.out.println("======== DIGITAL PURPLE SONGBOOK ========");

        while (true) {
            System.out.println("\n1.일반곡등록 | 2.추천곡등록 | 3.리스트 | 4.종료");
            System.out.print("선택> ");
            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 4) break;

            if (menu == 1 || menu == 2) {
                if (count >= 5) continue;
                System.out.print("제목: "); String t = sc.nextLine();
                System.out.print("가수: "); String a = sc.nextLine();

                if (menu == 1) list[count++] = new Song(t, a);
                else list[count++] = new PurpleSong(t, a);
                System.out.println("등록되었습니다.");
            } else if (menu == 3) {
                System.out.println("\n--- SONGBOOK LIST ---");
                for (int i = 0; i < count; i++) {
                    list[i].showInfo(); // [다형성] 객체 타입에 맞는 메서드 자동 실행
                }
            }
        }
        sc.close();
    }
}