package arrays;

import java.util.*;

public class TopKMeans {

    public static void main(String []args){
        String str[] = {"i", "j", "i", "k","ghj", "ghj"};
        System.out.println(topKElements(str, 2));
    }
    public static List<String> topKElements(String []ele, int k){
        Map<String, Integer> fre = new HashMap<>();
        for(String data: ele){
            fre.put(data, fre.getOrDefault(data,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
                if(Objects.equals(fre.get(a), fre.get(b))){
                    return b.compareTo(a);
                }
                return fre.get(a)-fre.get(b);
        });

        for(String str: fre.keySet()){
            pq.offer(str);
            if(pq.size()>k){
                pq.poll();
            }
        }
//        LinkedList<String> listOfTopK = new LinkedList<>();
//        while (!pq.isEmpty()) {
//            listOfTopK.add(pq.poll());
//        }
        return new ArrayList<>(pq);
    }
}
