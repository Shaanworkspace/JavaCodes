package array;

import java.util.Arrays;

public class SearchInRotatedSortedArrayLeetcode33 {
    public static int search(int[] arr, int target) {
        //find the pivot
        int pivot = findPivot(arr);

        //now array is divided into two parts (0... pivot -1) another  is (pivot .... n-1)
        //so we need to decide
        int left,right;
        if(target >= arr[pivot] && target <= arr[arr.length-1] ) {
            left=pivot;
            right=arr.length-1;
        } else {
            left=0;
            right=pivot-1;
        }
        while(left<=right) {
            int mid = left+(right-left)/2;
            if(target == arr[mid]) {
               return mid;
            }
            else if(target > arr[mid]) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return -1;
    }
    private static int findPivot(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){ //?
            int mid =  left + (right - left) / 2;

            if(arr[mid]>arr[right]){
                left = mid + 1;
            } else if(arr[mid]<arr[right]){
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int target = 0;
        System.out.println(search(arr,target));
    }
}
