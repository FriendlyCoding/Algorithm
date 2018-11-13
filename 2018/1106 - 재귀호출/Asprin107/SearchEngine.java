import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception{
        char pageNm;
        String originData[];
        String initData[];
        String testData[];
        String data = "";

        // 데이터 입력 (타이핑)
        Scanner scan = new Scanner(System.in);
        while(true) {
            String temp = scan.nextLine();
            if(temp.length()==1 && !(temp.charAt(0) >= '0' && temp.charAt(0)<='9')) {
                data += (temp + "\n");
                break;
            } else {
                data += (temp + "\n");
            }
        }

        // 데이터 초기화
        originData = data.split("\n");

        // 확인하려는 페이지 이름
        pageNm = originData[originData.length-1].charAt(0);

        // 기본 정보 개수
        int initDataSize = 0;
        for(int i=1 ; i<originData.length-1 ; i++) {
            initDataSize += Integer.parseInt(originData[i].charAt(2) + "");
        }

        // 기본 정보 생성 (initData)
        initData = new String[initDataSize];
        int idx = 0;
        for(int i=1 ; i<originData.length-1 ; i++) {
            String temp2[] = originData[i].split(" ");
            for(int j=2 ; j<temp2.length ; j++) {
                initData[idx++] = temp2[0] + temp2[j];
            }
        }

        // 테스트 정보 초기화
        testData = initData;

        String[] links = pageLink(testData, 0, initData, pageNm);
        System.out.println(links.length+1);
    }


    public static String[] pageLink(String[] testData, int idx, String[] initData, char pageNm) {
        String[] result = testData;
        if (idx>=testData.length) {
            return result;
        }
        if(testData[idx].charAt(0) == pageNm) {
            if(++idx > result.length) {
                return result;
            } else {
                return pageLink(result, idx, initData, pageNm);
            }
        } else {
            String addElement[];
            String temp = "";
            for(int i=0 ; i<initData.length ; i++) {
                if(initData[i].charAt(1)==testData[idx].charAt(0)) {
                    temp += ("" + initData[i].charAt(0) + testData[idx]) + "\n";
                }
            }
            addElement = temp.split("\n");
            int newSize = testData.length+addElement.length-1;
            result = new String[newSize];
            int rIdx = 0;
            for(int i=0 ; i<testData.length ; i++) {
                if(i != idx) {
                    result[rIdx++] = testData[i];
                }
            }
            for(int i=0 ; i<addElement.length ; i++) {
                result[rIdx++] = addElement[i];
            }

            return pageLink(result, idx, initData, pageNm);
        }
    }
}
