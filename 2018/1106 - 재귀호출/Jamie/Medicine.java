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
public class Medicine {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String input = "";

        System.out.println("Input your numbers : ");
        int num = 0;
        do{
            try{
                String line = scan.nextLine();

                num = Integer.parseInt(line);

                if(num == 0){
                    continue; // 입력 종료
                } else if(num <= 30 && num >= 1){
                    input += line + ","; // 입력받은 수를 String으로 연결
                } else {
                    throw new Exception("Wrong input.txt"); // 입력 오류 - 제한사항 어김
                }
            } catch (Exception e){
                System.out.println("ERROR!!! Input numbers : ");
                scan = new Scanner(System.in); // 에러 처리
            }
        } while(num != 0); // 마지막에 0을 입력받으면 입력 종료

        String[] list = input.split(",");

        for(int i=0; i<list.length; i++){
            System.out.println(mediCase(Integer.parseInt(list[i]),0)); // 입력받은 수에 대한 결과 처리
        }
    }

    public static long mediCase(int w, int h){
        long result = 0;

        if(w != 1 && h == 0){
            result += mediCase(w-1, 1); // 반개 알약이 하나도 없는 경우
        } else if(w != 0 && h != 0){
            result += (mediCase(w-1, h+1) + mediCase(w, h-1)); //전체 알약과 반개알약이 한개이상있는경우
        } else if(w == 0){
            result += 1; // 전체 알약이 없는 경우
        } else if(w == 1 && h == 0){
            result += 1; // 알약 한개인경우
        }

        return result;
    }
}