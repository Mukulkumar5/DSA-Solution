package mix.lec28.hq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionArray {
    public static void main(String[] args) {
        int [] num1 = new int[]{1,2,3,4,5};
        int [] num2 = new int[]{2,3,5,6,7};
        System.out.println(findUnionElement(num1, num2));
    }

    private static Set<Integer> findUnionElement(int[] num1, int[] num2) {
        Set<Integer> setOfEle = new HashSet<>();
        for(int i:num1){
            setOfEle.add(i);
        }
        for(int j: num2){
            setOfEle.add(j);
        }
        return setOfEle;
    }


}
