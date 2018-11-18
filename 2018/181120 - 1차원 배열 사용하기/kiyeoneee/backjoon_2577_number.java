import java.util.Scanner;

public class backjoon_2577_number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a, b, c;

        a = scanner.nextLong();
        b = scanner.nextLong();
        c = scanner.nextLong();

        // 주어지는 수의 범위는 100이상 1000미만 이므로 세 수의 곱은 10억 이상이 될 수 없으므로 long으로 충분
        long result = a * b * c;
        int[] cntAry = new int[10];

        while(result != 0) {
            cntAry[(int)result%10] += 1;
            result /= 10;
        }

        for (int i = 0; i < 10; i++)
            System.out.println(cntAry[i]);
    }

}
