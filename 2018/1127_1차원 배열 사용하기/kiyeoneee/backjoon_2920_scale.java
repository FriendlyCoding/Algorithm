package backjoon;

import java.util.Scanner;

public class backjoon_2920_scale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isDsc = false, isAsc = false, isMix = false;
        int tmpPrev = scanner.nextInt();
        int tmp;

        for (int i = 0; i < 7; i++) {
            tmp = scanner.nextInt();

            if (tmpPrev > tmp) {
                isDsc = true;
            } else if (tmpPrev < tmp) {
                isAsc = true;
            }

            if (isDsc && isAsc) break;
            else tmpPrev = tmp;
        }

        if (isDsc && isAsc) {
            System.out.println("mixed");
        } else if(isDsc) {
            System.out.println("descending");
        } else {
            System.out.println("ascending");
        }

    }
}

