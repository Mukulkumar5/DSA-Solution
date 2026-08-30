package mix.lec30.practice;

public class PivotElement {
    public static void main(String[] args) {
        //Element whose left and right sum are equal
        System.out.println(getEleSumofLeftAndRightEqual(new int[]{10,7,3,7}));
    }

    private static Integer getEleSumofLeftAndRightEqual(int[] num) {
        int [] rightAr = new int[num.length];
        int [] leftAr = new int[num.length];
        leftAr[0] = num[0];
        rightAr[num.length-1] = num[num.length-1];
        for(int i=1,j=num.length-2;i<num.length&& j>=0;i++,j--){
             leftAr[i] = leftAr[i-1] + num[i];
             rightAr[j] = rightAr[j+1] + num[j];
        }
        for(int i=0;i<num.length;i++){
            if(leftAr[i]==rightAr[i]){
                return num[i];
            }
        }
        return null;
    }
}
