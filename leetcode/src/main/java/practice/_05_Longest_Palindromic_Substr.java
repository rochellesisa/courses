package practice;

public class _05_Longest_Palindromic_Substr {

    public String longestPalindrome(String s) {
        int left = 0, max = 0;
        String palindrome = "";

        while (left < s.length()){
            char leftChar = s.charAt(left);
            int right = s.lastIndexOf(leftChar);

            boolean hasPalindrome = false;
            while (right > 0 && !hasPalindrome){
                if (isPalindrome(s, left, right)){
                    palindrome = getLongerString(s.substring(left, right + 1), palindrome);
                    hasPalindrome = true;
                }
                right = getNextLastIndex(s, leftChar, right);
            }


            left++;
        }

        return !palindrome.isEmpty() ? palindrome : s;
    }

    private int getNextLastIndex(String str, char lookup, int limit){
        int startingPoint = limit - 1;
        while (startingPoint > 0){
            if (str.charAt(startingPoint) == lookup)
                return startingPoint;
            startingPoint--;
        }
        return 0;
    }

    private boolean isPalindrome(String str, int left, int right){
        boolean isPalindrome = true;

        while (left <= right){
            // System.out.println("isPalindrome::: Start Left=" + left + ", Right = " + right);

            if (str.charAt(right) != str.charAt(left)){
                // System.out.println("Not palindrome | left=" + str.charAt(left) + ", right=" + str.charAt(right));
                isPalindrome = false;
                break;
            }

            left++;
            right--;

            // System.out.println("isPalindrome::: End Left=" + left + ", Right = " + right);
        }
        return isPalindrome;
    }

    private String getLongerString(String s1, String s2){
        // System.out.println("Getting longer string between s1=" + s1 + ", s2=" + s2);
        return s1.length() > s2.length() ? s1 : s2;
    }
}