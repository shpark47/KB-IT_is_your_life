import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque();
        int len = temperatures.length;
        int[] answer = new int[len];

        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        return answer;
    }
}