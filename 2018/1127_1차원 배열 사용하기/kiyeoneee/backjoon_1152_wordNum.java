import java.util.Scanner;

public class backjoon_1152_wordNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        이 부분이 오답률을 높인 부분인 듯
        문제의 입력 조건 : 단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.
        문자열의 앞과 뒤에 공백이 있을 때 split을 하면 맨 앞에 단어 하나가 더 있다고 생각하게 됨
        * */
        String str = scanner.nextLine().trim();
        System.out.println(str.length() > 0 ? str.split(" ").length : 0);  // 문자열의 길이가 0일때 split을 하면 1사이즈의 배열이 반환됨
    }
}
