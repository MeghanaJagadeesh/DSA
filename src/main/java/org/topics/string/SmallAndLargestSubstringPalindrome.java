package org.topics.string;

//smallest and largest substring palindrome
public class SmallAndLargestSubstringPalindrome {
    static String smallest = null, largest = "";

    public static void main(String[] args) {
        java.lang.String s = "racecarannakayak";
        checkPalindrome(s);
    }

    static void checkPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
        System.out.println("Smallest Palindrome: " + smallest);
        System.out.println("Largest Palindrome: " + largest);
    }

   static void palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            String palindrome = s.substring(left, right + 1);
            if (smallest == null || palindrome.length() < smallest.length()) {
                smallest = palindrome;
            }
            if (largest.length() < palindrome.length()) {
                largest = palindrome;
            }
            left--;
            right++;
        }
    }
}
