package array;

public class MergeSortedArray88 {
    static void rightShift(int[] num, int idx, int size, int ele) {
        for (int i = size-1; i >= idx; i--) {
            num[i+1] = num[i];
        }
        num[idx] = ele;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int b = 0; // Pointer for nums2
        int currentSize = m; // Tracks current size of nums1

        for (int a = 0; a < currentSize && b < n; a++) {
            if (nums1[a] > nums2[b]) {
                rightShift(nums1, a, currentSize, nums2[b]);
                currentSize++;
                b++;
                a++; // Skip the element we just inserted
            }
            else if (nums1[a] == nums2[b]) {
                rightShift(nums1, a+1, currentSize, nums2[b]);
                currentSize++;
                b++;
                a++; // Skip the element we just inserted
            }
        }

        // Copy remaining elements from nums2
        while (b < n) {
            nums1[currentSize++] = nums2[b++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {2};
        int n = 1;
        merge(nums1, m, nums2, n);
        for (int n1 : nums1) {
            System.out.print(n1 + " ");
        }
    }
}