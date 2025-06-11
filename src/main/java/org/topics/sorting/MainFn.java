package org.topics.sorting;

public class MainFn {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        String[] input1 = {"aab", "abc", "bbb", "cc"};
//        int input2 = 4;
        String[] input1 = {"ac", "bb", "dd"};
        int input2 = 3;

        int result = sol.palindromePairs(input1, input2);
        String result2=sol.validotp("33");
        System.out.println("otp "+result2);
        System.out.println("Output: " + result);  // Output: 3
    }
}

