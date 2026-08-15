package mix.lec29.practice;

import java.util.Arrays;

public class TwoPointerSorting {
    public static void main(String[] args) {
        int [] num = new int[]{1,0,1,1,0,0,1};
        System.out.println(Arrays.toString(getSortedValue(num)));
    }

    private static int[] getSortedValue(int[] num) {
        int i=0;
        int j= num.length-1;
        while (i <= j) {
            if(num[i]==1 && num[j]==0){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
            if(num[i]==0){
                i++;
            }
            if(num[j]==1){
                j--;
            }

        }
        return num;
    }
}
