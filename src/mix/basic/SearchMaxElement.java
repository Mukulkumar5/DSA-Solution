package mix.basic;

public class SearchMaxElement {
    public static void main(String[] args) {
        System.out.println(maxEle(new int[]{5,2,3,9}));
    }
// get max ele from array
    public static int maxEle(int []ele){
        int k= ele[0];
        for (int j : ele) {
            if (j > k) {
                k = j;
            }
        }
        return k;
    }
}
