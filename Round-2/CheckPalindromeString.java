import java.util.Scanner;

public class CheckPalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        if (findPalindromeString(inputString))
            System.out.println("The input string is " + inputString + " is Palindorme");
        else
            System.out.println("The input string is " + inputString + " is not a Palindorme");
        sc.close();
    }

    private static boolean findPalindromeString(String inputString) {
        String str = inputString.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = inputString.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
