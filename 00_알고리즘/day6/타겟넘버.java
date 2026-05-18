class Solution {
    public int solution(int[] numbers, int target) {
        return backtrack(numbers, target, 0, 0);
    }

    int backtrack(int[] numbers, int target, int sum, int i) {
        if(i == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        int count = 0;
        count += backtrack(numbers, target, sum + numbers[i], i + 1);
        count += backtrack(numbers, target, sum - numbers[i], i + 1);
        return count;
    }
}