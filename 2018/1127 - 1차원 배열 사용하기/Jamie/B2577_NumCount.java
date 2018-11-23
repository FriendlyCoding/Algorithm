import java.util.Scanner;

public class B2577_NumCount {
    public static void main(String[] args) {
        String[] ascending = {"1","2","3","4","5","6","7","8"};
        String[] descending = {"8","7","6","5","4","3","2","1"};

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        String[] input = line.split(" ");

        int type = 0;

        for(int i=0; i<input.length; i++){
            if(input[i].equals(ascending[i])){
                if(type != 0 && type != 1){
                    type = 3;
                    break;
                }
                type = 1;
            } else if(input[i].equals(descending[i])){
                if(type != 0 && type != 2){
                    type = 3;
                    break;
                }
                type = 2;
            } else {
                type = 3;
                break;
            }
        }

        switch (type){
            case 1: System.out.println("ascending"); break;
            case 2: System.out.println("descending"); break;
            default: System.out.println("mixed"); break;
        }

    }
}