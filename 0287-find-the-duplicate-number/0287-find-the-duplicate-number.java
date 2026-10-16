// 1. Intuition
// nums.length = n + 1, element values (nums[i]) are in [1, n] (n different values)
// so there is at least 1 duplicate number in nums

// i    =  0 1 2 3 4  | indexes are in [0, 4]
// nums = [1,3,4,2,2] | elements values are in [1, 4] 
// but elements values are within the range of indexes ([1, 4] is a subset of [0, 4])
// and think of each element value as a pointer
// => each element value points at an index is in [1, 4]
// => nums is a linked list (next(i) = nums[i])

// value = 1
// next = nums[1] = 3
// value = 3
// next = nums[3] = 2
// value = 2
// next = nums[2] = 4
// value = 4
// next = nums[4] = 2
// => indexes in [1, 4] are always going to form a cycle linked list somewhere
// none of the indexes in [1, 4] can point to index 0
// => index 0 is the head of the linked list and not going to be part of the cycle

// [1] -> [3] (nums[1]) -> [2] (nums[3]) -> [4] (nums[2]) <=> [2] (nums[4]) 
// multiple nodes point to the same node (nums[2])
// => that node (nums[2]) is the start of the cycle and the duplicate number in nums

// 2. Floyd's Cycle Detection
class Solution {
    public int findDuplicate(int[] nums) {
        // Index 0 is not part of the cycle
        int slow = nums[0], fast = nums[0];

        // a) Find the intersection point of the 2 pointers
        do {
            slow = nums[slow]; // move once per interation
            fast = nums[nums[fast]]; // move twice per interation
        } while (slow != fast);
        // Left 1 pointer at the intersection point
        // and move the other pointer back to the start

        // b) Find the start of the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            // Both move one step per iteration
            slow = nums[slow];
            fast = nums[fast];
        }
        // The second intersection point is the start of the cycle (duplicate number)
        return slow;
    }
}

// Floyd's Cycle Detection
// The distance of the first intersection point to the second intersection point
// is always the same as the distance from the head of the linked list to
// the second intersection point

// a: distance of the first intersection point to the second intersection point
// x: distance from the head of the linked list to the second intersection point
// c: the length of the cycle
// c - x: distance of the remaining cycle after minus x

// 2 x slow = fast
// 2 x (a + c - x) = a + c + c - x
// 2a + 2c - 2x = a + 2c - x
// a = x