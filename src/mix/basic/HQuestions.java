package mix.basic;

import java.util.*;

public class HQuestions {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAlternateEle(new int[]{1, 2, 3, 4})));
        List<Integer> listOfele1 = new ArrayList<>();
        listOfele1.add(1);
        listOfele1.add(2);
        listOfele1.add(3);
        listOfele1.add(4);

        List<Integer> listOfele2 = new ArrayList<>();
        listOfele2.add(2);
        listOfele2.add(5);
        listOfele2.add(6);
        listOfele2.add(4);
        System.out.println(intersectionEle(listOfele1, listOfele2));
        System.out.println("Extreme Ele" + extremeAlternateEle(listOfele1));
    }
    // change into alternate array
    public static int[] getAlternateEle(int []ele){
        for(int i=0; i<ele.length-1;i= i+2){
            int k = ele[i];
            ele[i] = ele[i+1];
            ele[i+1] = k;
        }
        return ele;
    }

     public static List<Integer> intersectionEle(List<Integer> listOfele1, List<Integer> listOfele2){
        // list contains check on every element
       // listOfele2.stream().filter(listOfele1::contains).toList();

        // set contains works based on hashcode calculation directly goes to bucket where number exist
         Set<Integer> sEle = new HashSet<>(listOfele2);
        return listOfele1.stream().filter(sEle::contains).toList();
    }

    // add element in start from left then second from right. we follow till complete array
    public static List<Integer> extremeAlternateEle(List<Integer> ele){
        int i = 0;
        int j = ele.size()-1;
        List<Integer> uEle = new ArrayList<>();
        while (i!=j && j>=i){
            uEle.add(ele.get(i));
            uEle.add(ele.get(j));
            i++;
            j--;
        }
        if(i==j) {
            uEle.add(ele.get(i));
        }
        return uEle;
    }

}
