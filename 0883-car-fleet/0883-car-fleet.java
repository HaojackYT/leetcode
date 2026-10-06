class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // @niits
        int n = position.length;

        // row[i] = car[i], column[0]: position, column[1]: speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0])); // descending order of position

        Stack<Double> stack = new Stack<>();
        for (int[] car : cars) {
            int current_position = car[0];
            int current_speed = car[1];
            double times = (double) (target - current_position) / current_speed;

            // The current car will not catch up to the fleet in front of it,
            // so it forms a new fleet
            if (stack.isEmpty() || times > stack.peek()) {
                stack.push(times);
            }
        }

        return stack.size();
    }
}

// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n = position.length;

//         // {position, speed}
//         TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//         for (int i = 0; i < n; i++) {
//             treeMap.put(position[i], speed[i]);
//         }

//         int fleets = 0;

//         // Time of the fleet in front of the current car:
//         // latestFleetTime = latestTimeNumerator / latestTimeDenominator
//         // The distance to the target of the fleet in front of the current car
//         long latestFleetDistance = 0;
//         // The speed of the fleet in front of the current car
//         long latestFleetSpeed = 1;

//         boolean hasFleet = false;
//         // The nearest to the farthest car position to the target
//         for (Map.Entry<Integer, Integer> entry : treeMap.descendingMap().entrySet()) {

//             long currentPosition = entry.getKey();
//             long currentSpeed = entry.getValue();

//             long currentDistance = target - currentPosition;

//             // t = s / v
//             // currentTime = currentDistance / currentSpeed
//             // latestFleetTime = latestFleetDistance / latestFleetSpeed
//             // currentTime > latestFleetTime
//             // currentDistance / currentSpeed > latestFleetDistance / latestFleetSpeed
//             // currentDistance * latestFleetSpeed > latestFleetDistance * currentSpeed
//             if (!hasFleet
//                     || currentDistance * latestFleetSpeed > latestFleetDistance * currentSpeed) {

//                 fleets++;

//                 latestFleetDistance = currentDistance;
//                 latestFleetSpeed = currentSpeed;

//                 hasFleet = true;
//             }
//         }

//         return fleets;
//     }
// }