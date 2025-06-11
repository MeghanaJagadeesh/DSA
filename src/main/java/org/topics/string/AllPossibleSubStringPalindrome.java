package org.topics.string;
//print all possible palindrome substrings of a given string

public class AllPossibleSubStringPalindrome {
    public static void main(String[] args) {
        String s = "Z";
        findAllSubString(s);
    }

    private static void findAllSubString(String s) {
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            //why we call this twice, few palindromes will be in odd numbers example "racecar" → center is 'e'
            // few palindrome has even length example "anna" → center is between the two 'n's ("nn")
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
    }

    private static void palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) {
                System.out.println(s.substring(left, right + 1));
            }
            left--;
            right++;
        }
    }
}
