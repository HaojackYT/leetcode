class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int answer = -1;
        
        int i = 0;
        int j = n - 1;
        while (i < j) {
            
            int length = j - i;

            int width;
            if (height[i] > height[j]) {
                width = height[j];
            } else {
                width = height[i];
            }

            if (answer < width * length) {
                answer = width * length;
            } else if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return answer;
    }
}