import java.util.Scanner;

public class B2577_NumCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();

        int ABC = A*B*C;

        int[] result = new int[10];

        while(ABC > 0){
            int num = ABC % 10;

            result[num] ++;

            ABC = ABC / 10;
        }

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}