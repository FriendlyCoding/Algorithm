import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] result = input.trim().split(" ");
        System.out.println(result.length == 1 && result[0].equals("") ? 0 : result.length);
    }
}