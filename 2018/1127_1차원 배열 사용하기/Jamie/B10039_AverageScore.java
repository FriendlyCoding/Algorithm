import java.util.Scanner;

public class B10039_AverageScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] student = new int[5];
        student[0] = scan.nextInt();
        student[1] = scan.nextInt();
        student[2] = scan.nextInt();
        student[3] = scan.nextInt();
        student[4] = scan.nextInt();

        int sum = 0;
        for(int i=0; i<student.length; i++){
            if(student[i] < 40){
                student[i] = 40;
            }
            sum += student[i];
        }

        System.out.println(sum/5);
    }
}