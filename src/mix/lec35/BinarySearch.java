package mix.lec35;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int []num = new int[]{1,2,3,4,5};
        int target = 6;
        System.out.println(searchEle(num, target));
    }

    private static int searchEle(int[] num, int target) {
        int start = 0;
        int end = num.length - 1;
        int mid = start + (end-start)/2;

        while (start<=end){
            if(num[mid] == target){
                return mid;
            }else if(target>num[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            mid = start + (end - start)/2;
        }
        return -1;
    }
}
