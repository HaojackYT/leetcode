class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        if (n == 1) {
            return (piles[0] + h - 1) / h;
        }

        long total = 0;
        int max_eating_speed = -1;
        for (int i = 0; i < n; i++) {
            total += piles[i];
            if (max_eating_speed < piles[i]) {
                max_eating_speed = piles[i];
            }
        }

        int min_eating_speed = Math.max(1, (int) ((total + h - 1) / h));

        int current_eating_hour;
        while (min_eating_speed <= max_eating_speed) {

            int average_eating_speed = (min_eating_speed + max_eating_speed) / 2;

            current_eating_hour = calculateTotalEatingHours(piles, n, average_eating_speed);

            if (current_eating_hour <= h) {
                max_eating_speed = average_eating_speed - 1;
            } else {
                min_eating_speed = average_eating_speed + 1;
            }
        }

        return min_eating_speed;
    }

    public int calculateTotalEatingHours(int[] piles, int n, int eating_speed) {
        int total_eating_hours = 0;

        for (int i = 0; i < n; i++) {
            total_eating_hours += (piles[i] + eating_speed - 1) / eating_speed;
        }

        return total_eating_hours;
    }
}
