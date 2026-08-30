package mix.lec30.practice;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        System.out.println(getFirstRepeatingElement(new int[]{10,2,5,4,3,6,5,2}));
    }

    private static Integer getFirstRepeatingElement(int[] num) {
        Map<Integer, Integer> mapOfEle = new HashMap<>();
        for(int i=0; i<num.length;i++){
           mapOfEle.put(num[i],mapOfEle.getOrDefault(num[i], 0)+1);
        }

       for(int k: num){
           if(mapOfEle.get(k)>1){
               return k;
           }
       }
       return null;
    }
}
