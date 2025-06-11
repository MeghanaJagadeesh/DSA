package org.topics.sorting;

public class Solution {
    public int palindromePairs(String[] input1, int input2) {
        int count = 0;

        for (int i = 0; i < input2; i++) {
            for (int j = i + 1; j < input2; j++) {
                String combined1 = input1[i] + input1[j];
                String combined2 = input1[j] + input1[i];

                if (canFormPalindrome(combined1)) {
                    count++;
                } else if (canFormPalindrome(combined2)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean canFormPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public String validotp(String input1) {
        int num = Integer.parseInt(input1);
        int count = 0;

        for (int i = 1; i <= num; i++) {
            String s = Integer.toString(i);

            // Condition 1: Even number of digits
            if (s.length() % 2 != 0) continue;

            // Condition 2: No leading zeros
            if (s.charAt(0) == '0') continue;

            // Condition 3: First half == second half
            int half = s.length() / 2;
            String first = s.substring(0, half);
            String second = s.substring(half);

            if (first.equals(second)) {
                count++;
            }
        }

        return String.valueOf(count);
    }
}
