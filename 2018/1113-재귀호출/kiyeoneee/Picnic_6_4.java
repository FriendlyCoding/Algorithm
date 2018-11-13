import java.util.Scanner;

public class Picnic_6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc, student, friendPair;

        tc = scanner.nextInt();

        while(tc-- != 0) {
            int[][] relationship = new int[10][10];  // 친구 관계를 확인하기 위한 2차원 배열
            student = scanner.nextInt();
            friendPair = scanner.nextInt();

            int s1, s2;
            while(friendPair-- != 0) {
                s1 = scanner.nextInt();
                s2 = scanner.nextInt();

                relationship[s1][s2] = 1;
                relationship[s2][s1] = 1;
            }

            System.out.println(makeFriendPair(student, new int[10], relationship));
        }

    }

    public static int makeFriendPair(int sn, int[] getPair, int[][] relationship) {  // param (전체 학생 수, 짝꿍 존재 여부, 친구관계)
        int i = 0, result = 0;
        for (; i <= sn; i++) {
            if ( i == sn) return 1;  // 모두 짝꿍을 찾은 경우 더이상 짝꿍을 만들 수 없음

            if (getPair[i] == 0) {  // 짝꿍이 없는 학생을 찾으면 친구들 중에 짝꿍이 없는 친구를 짝꿍만들어줘야 함
                break;
            }
        }

        for (int j = i + 1; j < sn; j++) {
            if (getPair[j] == 0 && relationship[i][j] == 1) {
                getPair[j] = getPair[i] = 1;  // 짝꿍을 만들어 주었으므로 짝꿍이 있다고 1로 체크해 주어야 함
                result += makeFriendPair(sn, getPair, relationship);
                getPair[j] = getPair[i] = 0;  // 다른 친구와 짝꿍일 때의 조합도 확인해야 하므로 다시 0으로 체크
            }
        }

        return result;
    }

}
