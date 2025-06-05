public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 8, 12, 1 };
        int index = findEquilibriumIndex(nums);
        System.out.println(index);
    }

    private static int findEquilibriumIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums)
            totalSum += num;

        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i]; // 23-3=20, 20-4=16, 16-9=7
            if (totalSum == leftSum)
                return i; // 20!=0 false, 16!=3 false, 7==7 true
            leftSum += nums[i]; // 0+3=3, 3+4=7,
        }

        return -1;
    }
}
