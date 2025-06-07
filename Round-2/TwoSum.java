public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = findTwoSum(nums,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }

    private static int[] findTwoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
