import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "pwwkew";
        int result = lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String str) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        List<Character> list = new ArrayList<>();

        while(end < str.length()){
            if(!list.contains(str.charAt(end))){
                list.add(str.charAt(end));
                end++;
                maxLength = Math.max(list.size(), maxLength);
            }
            else{
                list.remove(Character.valueOf(str.charAt(start)));
                start++;
            }
        }

        return maxLength;
    }
}
