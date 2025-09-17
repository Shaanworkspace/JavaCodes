package array;

public class ContainerWithMostWaterLeetCode11 {
    public int maxArea(int[] height) {
        int n  = height.length;
        int max = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(height[i]<=height[j]){
                    int expression = height[i]*Math.abs(j-i);
                    if(expression>max){
                        max = expression;
                    }
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWaterLeetCode11 solver = new ContainerWithMostWaterLeetCode11();

        int[] test1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Test1: " + solver.maxArea(test1)); // Expected: 49

        int[] test2 = {1, 1};
        System.out.println("Test2: " + solver.maxArea(test2)); // Expected: 1

        int[] test3 = {4, 3, 2, 1, 4};
        System.out.println("Test3: " + solver.maxArea(test3)); // Expected: 16

        int[] test4 = {1, 2, 1};
        System.out.println("Test4: " + solver.maxArea(test4)); // Expected: 2
    }

}
