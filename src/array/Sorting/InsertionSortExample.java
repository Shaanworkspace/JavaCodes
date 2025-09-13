package array.Sorting;

public class InsertionSortExample {
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];        
            int j = i - 1;

            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;       
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = { 22, 5, 11, 32, 120, 68, 70 };
        System.out.println("Before sorting:");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("After sorting:");
        printArray(numbers);
    }
}