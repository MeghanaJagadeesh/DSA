package org.topics.string;

public class LongestPalindrome {

    //Method 1
    public static void main(String[] args) {
        String s = "racecarannakayak";
        String largest = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = palindrome(s, i, i);
            if (oddPalindrome.length() > largest.length()) {
                largest = oddPalindrome;
            }
            String evenPalindrome = palindrome(s, i, i + 1);
            if (evenPalindrome.length() > largest.length()) {
                largest = oddPalindrome;
            }
        }
        System.out.println(largest);
    }

    private static String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    //    Method 2
    public static String findLongestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // Odd-length palindromes
            int len2 = expandFromCenter(s, i, i + 1);   // Even-length palindromes
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;  // Update start index
                end = i + len / 2;          // Update end index
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
}
