package practice;

import java.util.*;

public class AsyncFreq {
    public static void main(String []args){
        System.out.println(getAscFreq(new String[]{"a", "b", "c","a","a","b"}));
    }

    public static List<String> getAscFreq(String[] s1){
        if(s1==null){
           return null;
        }
        if(s1.length==1){
            return Arrays.asList(s1);
        }
        Map<String, Integer> storeFreq = new HashMap<>();
         for(String ele: s1){
             storeFreq.put(ele, storeFreq.getOrDefault(ele, 0)+1);
         }
       List<String> storeEle = new ArrayList<>(storeFreq.keySet());
         Collections.sort(storeEle,(a,b)->{
             if(Objects.equals(storeFreq.get(a), storeFreq.get(b))){
                 return a.compareTo(b);
             }
             return storeFreq.get(a) - storeFreq.get(b);
         });
         return storeEle;
    }
}
