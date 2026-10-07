package mix.lec38;

public class PeakIndex {
    public static void main(String[] args) {
        System.out.println(getPeakEle(new int[]{1,2,3,4,7,9,8}));
    }

    private static int getPeakEle(int[] ele) {
        int n = ele.length;
        int s = 0;
        int e = n - 2;
        int ans = -1;

        while(s<=e){
            int mid = s + (e - s)/2;
            if(ele[mid]<ele[mid+1]){
                s = mid + 1;
            }else{
                ans = ele[mid];
                e = mid - 1;
            }
        }
        return ans;
    }
}
