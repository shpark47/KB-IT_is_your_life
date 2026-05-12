import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = speeds.length;
        Queue<Integer> q = new ArrayDeque();
        for(int i = 0; i < len; i++) {
            int num = (int) (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] == 0) {
                q.offer(num);
            } else {
                q.offer(num + 1);
            }
        }

        int now = q.poll();
        int count = 1;
        List<Integer> list = new ArrayList();
        while(!q.isEmpty()) {
            if(now >= q.peek()) {
                count++;
                q.poll();
            } else {
                list.add(count);
                now = q.poll();
                count = 1;
            }
        }
        list.add(count);
        return list.stream().mapToInt(i -> i).toArray();
    }
}