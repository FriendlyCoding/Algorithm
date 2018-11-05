import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 입력된 값 input을 맵에 담고 직접적으로 링크가 연결된 사이트들에서 가리키는 웹사이들 리스트에서 제거
 *
 * 함수 하나 만들어서 맵과 타겟사이트값을 파라미터로 받아서
 *
 * 경우의 수에 따라 분기 및 재귀호출
 *
 * 하지만 런타임 오류
 *
 */
public class Search {
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

        for(int i=0; i<webs.length; i++){
            String[] list = webs[i].split(" ");

            for(int j=2; j<list.length; j++){
                String a = list[j];
                String b = map.get(a);
                if(b != null){
                    if(b.contains(a)){
                        map.put(a, b.replace(" " + a,""));
                        String c = b.split(" ")[0];
                        map.put(c, map.get(c).replace(" " + list[0],""));
                    }
                }
            }
        }

        // 웹사이트 이름 길이제한 50 추가해야함

        System.out.println(calGrade(map, web));

    }

    public static int calGrade(Map<String,String> map, String target){
        int result = 0;

        String web = map.get(target);

        if(web == null){
            return 1; // web으로 오는 링크가 없을때 기본 점수 1점
        }

        String[] list = web.split(" ");

        if(target.equals(list[0]) || list.length == 2) {
            result += 1; // 자기 자신이 타겟일때 기본점수 1점 || 서로링크 없앤 사이트에서 오는 링크가 없어졌을 때
        }

        int type = 0;

        for(int i=2; i<list.length; i++){
            if(list[i].equals(target)){
                type = 1;
            }
        }

        if(type == 0){
            for(int i=2; i<list.length; i++){
                result += calGrade(map,list[i]);
            }
        }

        return result;
    }
}
