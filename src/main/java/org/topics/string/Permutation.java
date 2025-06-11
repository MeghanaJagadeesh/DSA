package org.topics.string;

public class Permutation {
    public static void main(String[] args) {
        String s="abc";
        permutation(s.toCharArray(), 0);
    }

    private static void permutation(char[] arr, int fi) {
        if(fi==arr.length){
            System.out.println(arr);
            return;
        }
        for(int i=fi; i<arr.length; i++){
            swap(arr,i,fi);
            permutation(arr,fi+1);
            swap(arr,i,fi);
        }
    }

    static void swap(char[] arr, int i, int fi){
        char temp=arr[i];
        arr[i]=arr[fi];
        arr[fi]=temp;
    }
}
