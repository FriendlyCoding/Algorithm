import java.util.*;
import java.util.stream.Collectors;

class MaxNum {
    public String solution(int[] numbers) {
        String answer = "";

        //전부 0
        int sum = 0;
        for(int i=0; i<numbers.length; i++){
            sum += numbers[i];
        }
        if(sum == 0){
            return "0";
        }

        List<String> list = Arrays.stream(numbers)
                .boxed()
                .map(i -> i+"")
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for(int i=0; i<list.size()-1; i++){
            int num1 = Integer.parseInt(list.get(i).concat(list.get(i+1)));
            int num2 = Integer.parseInt(list.get(i+1).concat(list.get(i)));
            if(num1 < num2){
                String temp = list.get(i);
                list.set(i,list.get(i+1));
                list.set(i+1,temp);
                i = 0;
            }
        }

        for(int i=0; i<list.size(); i++){
            answer += list.get(i);
        }

        return answer;
    }
}
