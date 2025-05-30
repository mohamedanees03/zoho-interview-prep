public class PalindromeString {
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(findPlaindromeString(str));
    }

    private static boolean findPlaindromeString(String str) {
        if(str.length()==0 || str.length()==1) return true;
        int left = 0;
        int right = str.length()-1;

        while(left<right){
            if(!Character.isAlphabetic(str.charAt(left))) left++;
            else if(!Character.isAlphabetic(str.charAt(right))) right--;
            else if(Character.toLowerCase(str.charAt(left))!=Character.toLowerCase(str.charAt(right))) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
