package array.HardLeetCode;

public class medianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        for(int n : arr){
            System.out.println(n);
        }

        if(arr.length == 0 ) return 0.0;

        if(arr.length % 2 == 0){

            return ((double) (arr[arr.length / 2] + (arr[(arr.length / 2) - 1])) /2);
        }
        else {
            return arr[(int)Math.floor((double) arr.length /2)];
        }

    }


    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr2 = {3,4};

        double v = findMedianSortedArrays(arr,arr2);

        System.out.println(v);

    }
}
