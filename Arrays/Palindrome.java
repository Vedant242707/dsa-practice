/*9 — Palindrome Number 
Difficulty : Easy
Topic : Arrays
Time : Olog((n))
Space : O(1) */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;

        }
        int rev = 0;
        while (x > rev) {
            int n = x % 10;
            rev = (rev * 10) + n;
            x /= 10;
        }
        return (x == rev || x == rev / 10);

    }
}