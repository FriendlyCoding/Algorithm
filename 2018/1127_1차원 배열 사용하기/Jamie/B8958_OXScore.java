import java.util.Scanner;

public class B8958_OXScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String count = scan.nextLine();

        for(int i=0; i<Integer.parseInt(count); i++){
            int tempNum = 0;
            int sum = 0;
            String line = scan.nextLine();
            String[] input = line.split("");

            for(int j=0; j<input.length; j++){
                if("O".equals(input[j])){
                    tempNum ++;
                } else {
                    tempNum = 0;
                }
                sum += tempNum;
            }

            System.out.println(sum);
        }
    }
}