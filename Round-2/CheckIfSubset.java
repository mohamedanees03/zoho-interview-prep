import java.util.HashSet;
import java.util.Set;

public class CheckIfSubset {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 2, 4, 5 };
        boolean result = isAllElementsPresent(nums1, nums2);
        System.out.println(result);
    }

    private static boolean isAllElementsPresent(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);
        for (int num : nums2) {
            if (!set.contains(num)) return false;
        }
        return true;
    }
}
