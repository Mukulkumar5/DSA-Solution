package mix.lec29.practice;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int num[] = new int[]{0,1,3,2,5};
        System.out.println(findMissingNumber(num));
    }

    private static int findMissingNumber(int[] num) {
        int xorSum = 0;
        for(int i: num){
            xorSum = xorSum ^ i;
        }
        for(int j=0; j<=num.length; j++){
            xorSum = xorSum ^ j;
        }
     return xorSum;
    }
}
