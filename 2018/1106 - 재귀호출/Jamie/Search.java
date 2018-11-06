import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 입력된 값 input을 맵에 담고 빈스트링 temp와 타겟 웹사이트를 파라미터로 전달
 *
 * 경우의 수에 따라 분기 및 재귀호출
 * temp에 타겟 웹사이트가 있을시 직간접적인 연결이라고 생각함
 *
 * 하지만 런타임 오류
 *
 */
public class Main2 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.print("Input the number of Website : ");

        int size = Integer.parseInt(scan.nextLine());

        if(size >= 50 || size <=1){
            throw new Exception("Error for input"); // 프로그램 종료 (제한 사항 어김)
        }

        String[] webs = new String[size];

        for(int i=0; i<size; i++){
            webs[i] = scan.nextLine();
        }

        String web = scan.nextLine();

        Map<String,String> map = new HashMap<>();

        for(int i=0; i<webs.length; i++){
            map.put(webs[i].split(" ")[0],webs[i]);
        }

        // 웹사이트 이름 길이제한 50 추가해야함

        System.out.println(calGrade(map, web, ""));

    }

    public static int calGrade(Map<String,String> map, String target, String temp){
        int result = 0;

        String web = map.get(target);

        if(web == null){
            return 1; // web으로 오는 링크가 없을때 기본 점수 1점
        }

        // 해당 타겟 웹사이트 행 배열로 분리
        String[] list = web.split(" ");

        if(temp.contains(list[0])){
            String[] webs = temp.split(",");
            for(int i=0; i<webs.length; i++){
                if(webs[i].equals(list[0])){
                    System.out.println(-(webs.length - i -1));
                    return -(webs.length - i -1);
                }
            } // 직간접적인 링크가 있을 경우 그동안 쌓인 1들 -로 반환

        } else {
            temp += list[0]+","; // 직간접적인 링크가 없을 경우 temp 스트링에 타겟 웹사이트 추가
            for(int i=2; i<list.length; i++){
                result += calGrade(map, list[i], temp); // 링크 연결된 사이트들의 링크 연결된 사이트 확인 (말 그지같다..)
            }
        }

        return 1 + result;
    }
}
