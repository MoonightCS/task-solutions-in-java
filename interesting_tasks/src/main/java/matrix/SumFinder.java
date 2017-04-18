package matrix;

/*
Given an unsorted array of integers, find a pair with given sum in it.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SumFinder {


    public static void findPair(int arr[], int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                System.out.printf("Pair is %d and %d", sum - arr[i], arr[i]);
                return;
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println("pair doesn't exist in this array");
    }

    public static void main(String[] args) {
        int n = 50;
        int arr[] = new int[n];
        int sum = 10;
        fillArray(n, arr);
        findPair(arr, sum);
    }

    private static void fillArray(int n, int[] arr) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt() % 50;
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }


}
