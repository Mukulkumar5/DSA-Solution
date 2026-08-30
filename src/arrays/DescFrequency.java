package arrays;

import java.util.*;

public class DescFrequency {
    public static void main(String []args){

        System.out.println(getAscFrequency(new String[]{"a", "b", "c","a","b"}));
    }

    public static List<String> getAscFrequency(String[] ele){

        Map<String, Integer> eleFreq = new HashMap<>();

        if(ele==null || ele.length==0){
            return null;
        }
        for(String e: ele){
            eleFreq.put(e, eleFreq.getOrDefault(e, 0)+1);
        }
        List<String> listOfChar = new ArrayList<>(eleFreq.keySet());
        Collections.sort(listOfChar, (a,b)->{
            if(eleFreq.get(a)
                    == eleFreq.get(b)){

                return a.compareTo(b);// alabhabetically ascending
            }
            return eleFreq.get(b) - eleFreq.get(a);
        });
        return  listOfChar;
    }

}
