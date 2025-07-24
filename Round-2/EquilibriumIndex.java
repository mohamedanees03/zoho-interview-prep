public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] nums = {3,4,9,6,1};
        int index = findEquilibriumIndex(nums);
        System.out.println(index); 
    }

    private static int findEquilibriumIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums)
            totalSum += num;

        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i]; 
            if (totalSum == leftSum)
                return i; 
            leftSum += nums[i];
        }

        return -1;
    }
}
