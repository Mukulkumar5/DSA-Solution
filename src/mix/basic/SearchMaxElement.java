package mix.basic;

public class SearchMaxElement {
    public static void main(String[] args) {
        System.out.println(maxEle(new int[]{5,2,3,9}));
    }
// get max ele from array
    public static int maxEle(int []ele){
        int k= ele[0];
        for(int i=0; i< ele.length; i++){
            if(ele[i]>k){
                k = ele[i];
            }
        }
        return k;
    }
}
