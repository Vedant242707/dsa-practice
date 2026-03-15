/*374 - Guess Number Higher or Lower
Difficulty : Easy
Topic : Binary Search
Time : O(log(n))
Space : O(1) */

// Binary search within range [1, n] to find the picked number.
// Use the provided guess(mid) API to know the relation between mid and the target.
// guess(mid) == 0  → correct number found.
// guess(mid) == -1 → mid is higher than the picked number → search left.
// guess(mid) == 1  → mid is lower than the picked number → search right.

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *                0 if num is correct
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int start = 1;
        int end = n;

        while (start <= end) {

            int mid = start + (end - start) / 2; // avoids overflow

            int ans = guess(mid); // API tells relation with target

            if (ans == 0) {
                return mid;        // correct guess

            } else if (ans == -1) {
                end = mid - 1;     // guessed number too high → search left

            } else {
                start = mid + 1;   // guessed number too low → search right
            }
        }

        return -1; // fallback (problem guarantees a valid answer)
    }
}