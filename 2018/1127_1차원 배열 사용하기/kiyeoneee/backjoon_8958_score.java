import java.util.Scanner;

public class backjoon_8958 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNum = scanner.nextInt();
        while (caseNum-- != 0) {
            int result = 0, score = 0;
            String getStr = scanner.next();
            for(char c : getStr.toCharArray()) {
                if (c == 'O') {
                    ++score;
                    result += score;
                } else if (score != 0) {
                    score = 0;
                }
            }

            System.out.println(result);
        }
    }
}
