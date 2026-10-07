package mix.lec37;

public class LowerBound {
    public static void main(String[] args) {
        System.out.println(
                getFirstIndexTargetEle(
                        new int[]{5, 10, 20, 20, 20, 20, 30}, 20
                )
        );

        System.out.println(
                getUpperBondTargetEle(
                        new int[]{5, 10, 20, 20, 20, 20, 30}, 15
                )
        );

        System.out.println(
                getTargetEleOccurences(
                        new int[]{5, 10, 20, 20, 20, 20, 30}, 20
                )
        );
    }

    private static int getTargetEleOccurences(int[] ele, int target) {
        int i = getFirstIndexTargetEle(ele, target);
        int j = getUpperBondTargetEle(ele, target);
        return j-i;
    }

    /*
     * ============================================================
     * LOWER BOUND
     * ============================================================
     *
     * WHAT is Lower Bound?
     * --------------------
     * Lower Bound means:
     *
     * "Find the FIRST index whose value is GREATER THAN
     *  OR EQUAL TO the target."
     *
     * In short:
     *
     *              first index where num[index] >= target
     *
     * Example:
     *
     * Array  : [5, 10, 20, 20, 20, 20, 30]
     * Target : 20
     *
     * Answer = index 2
     *
     * Because index 2 is the FIRST position where value >= 20.
     *
     *
     * HOW do we solve Lower Bound?
     * ----------------------------
     * Since the array is SORTED, we can use Binary Search.
     *
     * 1. Calculate mid.
     *
     * 2. If num[mid] >= target:
     *       mid can be an answer.
     *       But we need the FIRST such position,
     *       so search LEFT.
     *
     *       ans = mid
     *       end = mid - 1
     *
     * 3. If num[mid] < target:
     *       value is too small,
     *       so search RIGHT.
     *
     *       start = mid + 1
     *
     * Final ans = first index where value >= target.
     */
    private static int getFirstIndexTargetEle(int[] num, int target) {

        int start = 0;
        int end = num.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (num[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }


    /*
     * ============================================================
     * UPPER BOUND
     * ============================================================
     *
     * WHAT is Upper Bound?
     * --------------------
     * Upper Bound means:
     *
     * "Find the FIRST index whose value is STRICTLY GREATER
     *  than the target."
     *
     * In short:
     *
     *              first index where num[index] > target
     *
     * Example:
     *
     * Array  : [5, 10, 20, 20, 20, 20, 30]
     * Target : 20
     *
     * Answer = index 6
     *
     * Because 30 is the FIRST value > 20.
     *
     *
     * HOW do we solve Upper Bound?
     * ----------------------------
     * Again, the array is SORTED, so use Binary Search.
     *
     * 1. Calculate mid.
     *
     * 2. If num[mid] > target:
     *       mid can be an answer.
     *       But we need the FIRST such position,
     *       so search LEFT.
     *
     *       ans = mid
     *       end = mid - 1
     *
     * 3. If num[mid] <= target:
     *       value is not greater than target,
     *       so search RIGHT.
     *
     *       start = mid + 1
     *
     * Final ans = first index where value > target.
     */
    private static int getUpperBondTargetEle(int[] num, int target) {

        int start = 0;
        int end = num.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (num[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }
}