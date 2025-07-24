public class BitonicPoint {
    public static void main(String[] args) {
        int[] arr = {1,4,5,9,14,6,1};
        int result = findBitonicPoint(arr);
        System.out.println(result);
    }

    private static int findBitonicPoint(int[] arr) {
        int left = 0;
        int right = arr.length-1; 

        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return arr[mid]; 
            else if (arr[mid-1]>arr[mid]) right = mid-1;
            else left=mid+1;
        }

        return -1;
    }
}
