package mix.lecture32;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(getMaximumSubArray(new int[]{3,-2,-3,-5,3,2,1}));
    }
  // Solved using kaden's algorithm only applicable for contigous array
    private static int getMaximumSubArray(int[] num) {
        int sum = 0;
        int maxSum = 0;

        for(int i=0; i<num.length;i++){
            sum = sum + num[i];
            maxSum = Math.max(sum, maxSum);
            if(sum<0){
                sum = 0;
            }
        }
       return maxSum;
    }
}
