package mix.lec29.practice;

public class UniqueElement {
    public static void main(String[] args) {
        System.out.println(findUniqueNumber(new int[]{1,5,2,1,5,3,3}));
    }

    private static int findUniqueNumber(int[] num) {
        int xorSum = 0;
        for(int i: num){
            xorSum = xorSum ^ i;
        }
        return xorSum;
    }
}
