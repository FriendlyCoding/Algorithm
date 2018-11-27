package backjoon;

import java.util.Scanner;


/*
*  재귀 - 알약 문제
*  반 조각이라면 그 약을 먹고 -> h로 표시, 아니라면 반을 쪼개서 한 조각을 먹고 -> w로 표시, 다른 조각은 다시 병에 넣는다.
*  => 이 부분에서 추론가능한 것은 알약이 한조각짜리가 한개만 남겨져 있는 경우, 반조각 짜리만 남아있는 경우는 이후에 문자열이 한가지 종류만 나오게 된다.
*  => 이외의 경우는 한조각 짜리가 한개 줄어들고 반조각이 한개 늘어 났을 때의 경우의 수 + 반조각이 한개 줄어들었을 때의 경우의 수
* */
public class backjoon_4811_Medicine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int phill = scanner.nextInt();

        while(phill != 0) {
            long result = eatPhillCase(phill, 0, new long[phill * 2 + 1][phill * 2 + 1]);
            System.out.println(result);

            phill = scanner.nextInt();
        }

    }

    protected static long eatPhillCase(int f, int h, long[][] phillCase) {
        if ((f == 0) || (h == 0 && f == 1)) {  // 한조각짜리가 한개만 남았을 경우 & 반조각 짜리만 남았을 경우 문자열이 한 종류밖에 나올 수 없음
            phillCase[f][h] = 1;  // 경우의 수는 1개
            return 1;
        } else if ( h < 0 ) {  // 반개짜리 알약이 음수가 되는 경우에 대한 처리가 없어서 런타임 에러가 났었음
            return 0;  // 경우의 수가 없음으로 리턴되어야 함
        }

        if (phillCase[f][h] == 0) {  // 이외의 경우들에 대한 처리
            phillCase[f][h] = eatPhillCase(f - 1, h + 1, phillCase) + eatPhillCase(f, h - 1, phillCase);
        }

        return phillCase[f][h];
    }
}
