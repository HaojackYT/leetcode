class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n < 3) {
            return 0;
        }

        // 1. Maximum height in the array
        int maxHeight = 0;
        for (int h : height) {
            maxHeight = Math.max(maxHeight, h);
        }

        // 2. Group indices by their height
        List<List<Integer>> levels = new ArrayList<>(maxHeight + 1);

        for (int i = 0; i <= maxHeight; i++) {
            levels.add(null);
        }

        // levels[h] = all indices whose height == h
        for (int i = 0; i < n; i++) {
            int h = height[i];

            // Height 0 is not a wall
            if (h == 0) {
                continue;
            }

            if (levels.get(h) == null) {
                levels.set(h, new ArrayList<>());
            }

            levels.get(h).add(i);
        }

        // 3. Group all indices whose height >= current level
        TreeSet<Integer> walls = new TreeSet<>(); // contains height[index] >= level

        int gapWidth = 0; // of all gaps between walls at the current level
        int water = 0;

        // 4. Interate from highest level to 1

        // Example 1:
        // height = [0,1,0,2,1,0,1,3,2,1,2,1]
        for (int level = maxHeight; level >= 1; level--) {
            // level = 3, currentLevel = levels[3] = {7}
            // level = 2, currentLevel = levels[2] = {3, 8, 10}
            // level = 1, currentLevel = levels[1] = {1, 4, 6, 9, 11}
            List<Integer> currentLevel = levels.get(level);

            if (currentLevel != null) {
                // level = 3, currentLevel = levels[3] = {7}
                // level = 2, currentLevel = levels[2] = {3, 8, 10}
                // level = 1, currentLevel = levels[1] = {1, 4, 6, 9, 11}
                for (int index : currentLevel) {
                    // level = 3, index = 7, left = null, right = null
                    // walls = {7}, gapWidth = 0

                    // level = 2, index = 3, left = null, right = 7
                    // walls = {3, 7}, gapWidth = 3
                    // level = 2, index = 8, left = 7, right = null
                    // walls = {3, 7, 8}, gapWidth = 3
                    // level = 2, index = 10, left = 8, right = null
                    // walls = {3, 7, 8, 10}, gapWidth = 4

                    // level = 1, index = 1, left = null, right = 3
                    // walls = {1, 3, 7, 8, 10}, gapWidth = 5
                    // level = 1, index = 4, left = 3, right = 7

                    // The highest wall < index wall on the left
                    Integer left = walls.lower(index);
                    // The lowest wall > index wall on the right
                    Integer right = walls.higher(index);

                    // Case 1: index wall is inserted between two existing walls
                    if (left != null && right != null) {
                        // level = 1, index = 4, left = 3, right = 7
                        // gapWidth = 5 (current) - 7 - 3 - 1 = 4
                        // gapWidth = 4 (current) + 4 - 3 - 1 = 4
                        // gapWidth = 4 (current) + 7 - 4 - 1 = 6

                        // Remove the index wall from the gap {left, right}
                        gapWidth -= right - left - 1;

                        // Add the left gap {left, index}
                        gapWidth += index - left - 1;

                        // Add the right gap {index, right}
                        gapWidth += right - index - 1;
                    }

                    // Case 2: index wall is on the right of all existing walls
                    else if (left != null) {
                        // level = 2, index = 8, left = 7, right = null
                        // gapWidth = 3 (current) + 8 - 7 - 1 = 3
                        // level = 2, index = 10, left = 8, right = null
                        // gapWidth = 3 (current) + 10 - 8 - 1 = 4

                        // - 1: not include the index wall and left wall
                        // end - start + 1 - 2 = end - start - 1
                        gapWidth += index - left - 1;
                    }

                    // Case 3: index wall is on the left of all existing walls
                    else if (right != null) {
                        // level = 2, index = 3, left = null, right = 7
                        // gapWidth = 0 (current) + 7 - 3 - 1 = 3

                        // level = 1, index = 1, left = null, right = 3
                        // gapWidth = 4 (current) + 3 - 1 - 1 = 5

                        gapWidth += right - index - 1;
                    }

                    walls.add(index);
                }
            }

            water += gapWidth;
        }

        return water;
    }
}