package array;

public class MergeSortedArray {
    public static int[] mergeArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length , n2=nums2.length;
        int i =0 ,j=0,k=0;
        int[] arr = new int[n1+n2];

        while(i<n1 && j<n2){
            if(nums1[i] <= nums2[j])
                arr[k++] = nums1[i++];
            else
                arr[k++] = nums2[j++];
        }

        while(i<n1)
            arr[k++] = nums1[i++];
        while(j<n2)
            arr[k++] = nums2[j++];

        return arr;
    }
    public static void main(String[] args) {
        int[] nums1 = {2,3,4,5,6};
        int[] nums2 = {1,2,3};

        int[] ans = mergeArray(nums1,nums2);
        for(int n : ans){
            System.out.println(n);
        }
    }
}
