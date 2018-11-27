import java.util.Scanner;

/**
 *
 * 경우의 수를 생각하여 재귀함수 호출함
 *
 * 전체 알약이 없는 경우 (반알알약만 있기때문에 hhh...식으로 한가지 경우밖에 안나옴)
 * 알약이 한개인경우 (wh)
 * 반개 알약이 하나도 없는경우
 * 전체 알약과 반개 알약이 한개 이상있는경우
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        do {
            long[][] table = new long[num + 1][num + 1];
            System.out.println(mediCase(num, 0, table)); // 입력받은 수에 대한 결과 처리

            num = scan.nextInt(); // 마지막에 0을 입력받으면 입력 종료
        } while(num != 0);
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