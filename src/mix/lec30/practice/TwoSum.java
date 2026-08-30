package mix.lec30.practice;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoSum(new int[]{2, 7, 3, 4}, 9)));
        System.out.println(getThreeSum(List.of(2, 4, 3, 4,5), 9));

    }

    private static int[] getTwoSum(int[] num, int target) {
        Map<Integer, Integer> mapOfData = new HashMap<>();

        for(int i=0; i<num.length; i++){
            int n = target - num[i];
            if(mapOfData.containsKey(n)){
                return new int[]{mapOfData.get(n), i};
            }
            mapOfData.put(num[i], i);
        }
        return null;
    }
    private static List<List<Integer>> getThreeSum(List<Integer> num, int target) {
       List<Integer> data = new ArrayList<>(num);
       data.sort(Integer::compareTo);
       List<List<Integer>> listsOfData = new ArrayList<>();
        int left = 1;
        int right = data.size()-1;
       for(int i=0; i<data.size()-2; i++){
           List<Integer> getTarget = new ArrayList<>();
           if(i>0 && (data.get(i).equals(data.get(i-1)))){
               continue;
           }

           while(left<right){
               int sum = data.get(i) + data.get(left) + data.get(right);
               int sumL = data.get(i) + data.get(left) + data.get(right-1);
               int sumR = data.get(i) + data.get(left+1) + data.get(right);
               if(sum==target){
                   getTarget.add(data.get(i));
                   getTarget.add(data.get(left));
                   getTarget.add(data.get(right));
                   listsOfData.add(getTarget);
               }
               if(sumL==target){
                   right--;
                   getTarget.add(data.get(i));
                   getTarget.add(data.get(left));
                   getTarget.add(data.get(right));
                   listsOfData.add(getTarget);
               }
               if(sumR==target){
                   left++;
                   getTarget.add(data.get(i));
                   getTarget.add(data.get(left));
                   getTarget.add(data.get(right));
                   listsOfData.add(getTarget);
               }
               left++;
               right--;

               while (left<right){
                   if(data.get(left).equals(data.get(left-1))){
                       left++;
                   }else {
                       break;
                   }
               }

               while (left<right){
                   if(data.get(right).equals(data.get(right + 1))){
                       right--;
                   }else{
                       break;
                   }
               }

           }
       }
        return listsOfData;
    }
}
