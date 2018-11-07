import java.util.Scanner;

/**
 *
 * 경우의 수를 생각하여 재귀함수 호출함
 *
 * 프로세스 실행결과 잘 나오지만 30까지 처리하기에는 오래걸림
 * 17입력시 0.6초 걸리지만 18입력시 2.3초로 시간초과
 *
 * 30은 계속 돌아감. 개선 필요
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 0;

        do {
            num = scan.nextInt();
            long[][] table = new long[num + 1][num + 1];
            System.out.println(mediCase(num, 0, table)); // 입력받은 수에 대한 결과 처리
        } while (num != 0); // 마지막에 0을 입력받으면 입력 종료
    }

    public static long mediCase(int w, int h, long[][] table){
        if(table[w][h] == 0){
            if(w == 0){
                table[w][h] = 1; // 전체 알약이 없는 경우
            } else if(w == 1 && h == 0){
                table[w][h] = 1; // 알약 한개인경우
            } else if(w != 1 && h == 0){
                table[w][h] = mediCase(w-1, 1, table); // 반개 알약이 하나도 없는 경우
            } else {
                table[w][h] = (mediCase(w-1, h+1, table) + mediCase(w, h-1, table)); //전체 알약과 반개알약이 한개이상있는경우
            }
        }

        return table[w][h];
    }
}