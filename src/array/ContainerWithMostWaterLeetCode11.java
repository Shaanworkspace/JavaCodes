package array;

public class ContainerWithMostWaterLeetCode11 {
    public int maxArea(int[] height) {
        int n  = height.length;
        int left = 0,right = n -1;
        int max = 0;
        while(left < right){
            int area =  Math.min(height[left],height[right]) * (right - left);
            max = Math.max(max, area);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }

    public int maxAreaBrute(int[] height) {
        int max=0;
        for(int i =0;i<height.length;i++){
            for(int j =i+1;j<height.length;j++){
                int area = (j-i)*Math.min(height[i],height[j]);
                if(area>max){
                    max=area;
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        ContainerWithMostWaterLeetCode11 solver = new ContainerWithMostWaterLeetCode11();

        int[] test1 = {1,8,6,2,5,4,8,3,7};
        int[] test2 = {1, 1};
        int[] test3 = {4, 3, 2, 1, 4};
        int[] test4 = {1, 2, 1};

        System.out.println("===== Container With Most Water Tests =====\n");

        printResult(solver, test1, "Test 1: Heights = {1,8,6,2,5,4,8,3,7}", 49);
        printResult(solver, test2, "Test 2: Heights = {1,1}", 1);
        printResult(solver, test3, "Test 3: Heights = {4,3,2,1,4}", 16);
        printResult(solver, test4, "Test 4: Heights = {1,2,1}", 2);
    }

    private static void printResult(ContainerWithMostWaterLeetCode11 solver, int[] heights, String testName, int expected) {
        System.out.println(testName);
        System.out.println("Expected Output : " + expected);
        System.out.println("Brute Force     : " + solver.maxAreaBrute(heights));
        System.out.println("Optimized Two-Pointer : " + solver.maxArea(heights));
        System.out.println("--------------------------------------------\n");
    }

}
