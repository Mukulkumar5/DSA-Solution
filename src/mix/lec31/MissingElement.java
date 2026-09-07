package mix.lec31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElement {
    public static void main(String[] args) {
        //System.out.println(findMissingElement(new int[]{4, 5, 3, 4, 3}));
        System.out.println(findMissingElementWithoutExtraSpace(new int[]{2, 5, 3, 4, 3}));
    }
    // Missing Element between 1...N number only
    private static List<Integer> findMissingElement(int[] num) {
       List<Integer> listOfMissingEle = new ArrayList<>();
        int [] uNum =  new int[num.length];
        for(int i=0;i<num.length;i++){
            int j = num[i];
            if(uNum[j-1]!=num[i]) {
                uNum[j - 1] = num[i];
                num[i] = -num[i];
            }
        }
        for(int k=0;k<uNum.length;k++){
            if(uNum[k]==0){
                listOfMissingEle.add(k+1);
            }
        }
      return listOfMissingEle;
    }

    private static List<Integer> findMissingElementWithoutExtraSpace(int[] num) {
        List<Integer> listOfMissingEle = new ArrayList<>();
        for(int i=0;i<num.length;i++){
           int index = Math.abs(num[i])-1;
           if(num[index]>0){
               num[index] = -num[index];
           }
        }
        for(int k=0;k<num.length;k++){
            if(num[k]>0){
                listOfMissingEle.add(k+1);
            }
        }
        return listOfMissingEle;
    }
}
