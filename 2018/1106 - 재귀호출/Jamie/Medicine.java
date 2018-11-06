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

        String input = "";

        System.out.println("Input your numbers : ");
        int num = 0;
        do {
            try {
                String line = scan.nextLine();

                num = Integer.parseInt(line);

                if (num == 0) {
                    continue; // 입력 종료
                } else if (num <= 30 && num >= 1) {
                    int target = Integer.parseInt(line);
                    long[][] table = new long[target + 1][target + 1];
                    System.out.println(mediCase(target, 0, table)); // 입력받은 수에 대한 결과 처리
                } else {
                    throw new Exception("Wrong input"); // 입력 오류 - 제한사항 어김
                }
            } catch (Exception e) {
                System.out.println("ERROR!!! Input numbers : ");
                scan = new Scanner(System.in); // 에러 처리
            }
        } while (num != 0); // 마지막에 0을 입력받으면 입력 종료

    }

    public static long mediCase(int w, int h, long[][] table){
        long result = 0;

        if(table[w][h] == 0){
            if(w != 1 && h == 0){
                result += mediCase(w-1, 1, table); // 반개 알약이 하나도 없는 경우
            } else if(w != 0 && h != 0){
                result += (mediCase(w-1, h+1, table) + mediCase(w, h-1, table)); //전체 알약과 반개알약이 한개이상있는경우
            } else if(w == 0){
                result += 1; // 전체 알약이 없는 경우
            } else if(w == 1 && h == 0){
                result += 1; // 알약 한개인경우
            }
            table[w][h] = result;
        }

        return table[w][h];
    }
}