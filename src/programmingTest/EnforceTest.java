package programmingTest;

import java.util.Random;
import java.util.Scanner;

public class EnforceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int weaponLevel = 0;
        int maxLevel = 0;
        int gold = 10000;

        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println("      무기 강화 & 거래 시스템");
            System.out.println("=================================");
            System.out.println("현재 무기 : +" + weaponLevel);
            System.out.println("최고 기록 : +" + maxLevel);
            System.out.println("보유 골드 : " + gold + "G");
            System.out.println("---------------------------------");
            System.out.println("1. 강화하기");
            System.out.println("2. 무기 판매");
            System.out.println("3. 상태 확인");
            System.out.println("4. 확률 안내");
            System.out.println("5. 종료");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();

            switch (menu) {

                // =========================
                // 1. 강화
                // =========================
                case 1:

                    int upgradeCost = (weaponLevel + 1) * 500;

                    if (gold < upgradeCost) {
                        System.out.println("\n골드가 부족합니다! (필요 골드: " + upgradeCost + ")");
                        break;
                    }

                    gold -= upgradeCost;

                    int successRate;
                    int destroyRate = 0;

                    if (weaponLevel <= 3) {
                        successRate = 90;
                    } else if (weaponLevel <= 6) {
                        successRate = 70;
                    } else if (weaponLevel <= 9) {
                        successRate = 50;
                    } else {
                        successRate = 30;
                        destroyRate = 20;
                    }

                    int chance = random.nextInt(100) + 1;

                    System.out.println("\n강화 시도 중...");

                    if (chance <= successRate) {

                        weaponLevel++;

                        if (weaponLevel > maxLevel) {
                            maxLevel = weaponLevel;
                        }

                        System.out.println("강화 성공!");
                        System.out.println("현재 무기 : +" + weaponLevel);

                    } else {

                        if (weaponLevel >= 10) {

                            int destroyChance = random.nextInt(100) + 1;

                            if (destroyChance <= destroyRate) {
                                System.out.println(" 무기가 파괴되었습니다...");
                                weaponLevel = 0;
                            } else {
                                System.out.println("강화 실패 (유지)");
                            }

                        } else {
                            System.out.println("강화 실패 (유지)");
                        }
                    }

                    break;

                // =========================
                // 2. 판매
                // =========================
                case 2:

                    if (weaponLevel == 0) {
                        System.out.println("\n판매할 무기가 없습니다.");
                        break;
                    }

                    int sellPrice = weaponLevel * 2000;

                    System.out.println("\n무기를 판매하시겠습니까?");
                    System.out.println("현재 무기 : +" + weaponLevel);
                    System.out.println("판매 가격 : " + sellPrice + "G");
                    System.out.print("1. 판매 / 2. 취소 : ");

                    int sellChoice = sc.nextInt();

                    if (sellChoice == 1) {

                        gold += sellPrice;
                        System.out.println("판매 완료! +" + sellPrice + "G 획득");

                        weaponLevel = 0;

                    } else {
                        System.out.println("판매 취소");
                    }

                    break;

                // =========================
                // 3. 상태 확인
                // =========================
                case 3:

                    System.out.println("\n===== 현재 상태 =====");
                    System.out.println("무기 강화 : +" + weaponLevel);
                    System.out.println("최고 기록 : +" + maxLevel);
                    System.out.println("보유 골드 : " + gold + "G");

                    break;

                // =========================
                // 4. 확률 안내
                // =========================
                case 4:

                    System.out.println("\n===== 강화 확률 =====");
                    System.out.println("+0 ~ +3  : 90%");
                    System.out.println("+4 ~ +6  : 70%");
                    System.out.println("+7 ~ +9  : 50%");
                    System.out.println("+10 이상 : 30%");
                    System.out.println("고강화 실패 시 일부 확률로 파괴 (20%)");

                    break;

                // =========================
                // 5. 종료
                // =========================
                case 5:

                    System.out.println("\n프로그램을 종료합니다.");
                    running = false;
                    break;

                default:

                    System.out.println("\n잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}
